package edu.binghamton.cs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer f = 32;
    Integer c = 0;

    //we need these otherwise we enter an endless loop that crashes the app because both edit text fields update each other's values
    boolean isChangingFahrenheit = false;
    boolean isChangingCelsius = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize handlers for widgets
        final EditText fahrenheitText = findViewById(R.id.fahrenheit);
        final EditText celsiusText = findViewById(R.id.celsius);
        final SeekBar seekbar = findViewById(R.id.slider);

        //used if coming from 2nd activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            c = extras.getInt("c");
            f = ctof(c);
            seekbar.setProgress(c);
        }

        //apply values to text fields
        fahrenheitText.setText(f.toString());
        celsiusText.setText(c.toString());

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Integer progress = seekBar.getProgress();
                celsiusText.setText(progress.toString());

                //update internal attribute
                c = progress;
            }
        });

        fahrenheitText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //user updates fahrenheit value so celsius has to be set
                if (s.length() > 0 && isChangingCelsius == false) {
                    isChangingFahrenheit = true;
                    Integer val = Integer.parseInt(s.toString());
                    Integer convertedVal = ftoc(val);
                    celsiusText.setText(convertedVal.toString());
                    seekbar.setProgress(convertedVal);

                    //update internal attribute
                    c = convertedVal;
                }
                isChangingFahrenheit = false;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        celsiusText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //user updates celsius value so fahrenheit has to be set
                if (s.length() > 0 && isChangingFahrenheit == false) {
                    isChangingCelsius = true;
                    Integer val = Integer.parseInt(s.toString());
                    Integer convertedVal = ctof(val);
                    fahrenheitText.setText(convertedVal.toString());
                    seekbar.setProgress(val);

                    //update internal attribute
                    f = convertedVal;
                }
                isChangingCelsius = false;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        configureVacationButton();
        configureResetButton();
    }

    public void configureVacationButton() {
        Button nextButton = findViewById(R.id.vacation);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //pass celsius value to next activity
                intent.putExtra("c", c);
                startActivity(intent);
            }
        });
    }

    public void configureResetButton() {
        Button nextButton = findViewById(R.id.reset);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f = 32;
                c = 0;
                final EditText fahrenheitText = findViewById(R.id.fahrenheit);
                final EditText celsiusText = findViewById(R.id.celsius);
                fahrenheitText.setText(f.toString());
                celsiusText.setText(c.toString());
            }
        });
    }


    public Integer ftoc(Integer n) {
        return Math.round(((n - 32) * (5F/9F)));
    }

    public Integer ctof(Integer n) {
        return Math.round((n * (9F/5F)) + 32);
    }
}
