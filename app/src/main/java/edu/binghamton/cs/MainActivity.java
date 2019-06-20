package edu.binghamton.cs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize edit text handlers
        EditText fahrenheit = findViewById(R.id.fahrenheit);
        EditText celsius = findViewById(R.id.celsius);

        //supply default values
        fahrenheit.setText("32");
        celsius.setText("0");
    }

    public int ftc(int n) {
        return (int) (n - 32) * (5/9);
    }

    public int ctof(int n) {
        return n * (9/5) + 32;
    }
}
