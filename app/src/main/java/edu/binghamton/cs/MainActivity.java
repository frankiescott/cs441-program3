package edu.binghamton.cs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    final Integer f = 32;
    final Integer c = 0;

    //we need these otherwise we enter an endless loop that crashes the app because both edit text fields update each other's values
    boolean isChangingFahrenheit = false;
    boolean isChangingCelsius = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize edit text handlers
        final EditText fahrenheitText = findViewById(R.id.fahrenheit);
        final EditText celsiusText = findViewById(R.id.celsius);

        //apply default values to text fields
        fahrenheitText.setText(f.toString());
        celsiusText.setText(c.toString());

        final SeekBar seekbar = findViewById(R.id.slider);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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
                }
                isChangingCelsius = false;
            }

            @Override
            public void afterTextChanged(Editable s) {

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
