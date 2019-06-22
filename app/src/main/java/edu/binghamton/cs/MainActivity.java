package edu.binghamton.cs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    final Integer f = 32;
    final Integer c = 0;

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

        SeekBar seekbar = findViewById(R.id.slider);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Integer prog = progress;
                celsiusText.setText(prog.toString());
                Integer far = ctof(progress);
                fahrenheitText.setText(far.toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public int ftoc(int n) {
        return (int) ((n - 32) * (5F/9F));
    }

    public int ctof(int n) {
        return (int) (n * (9F/5F)) + 32;
    }
}
