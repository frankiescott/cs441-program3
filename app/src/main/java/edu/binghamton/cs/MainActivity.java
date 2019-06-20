package edu.binghamton.cs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int fahrenheit;
    int celsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize default values
        fahrenheit = 32;
        celsius = 0;

        //initialize edit text handlers
        EditText fahrenheit = findViewById(R.id.fahrenheit);
        EditText celsius = findViewById(R.id.celsius);

        //apply default values to text fields
        fahrenheit.setText(fahrenheit.toString());
        celsius.setText(celsius.toString());
    }

    public int ftoc(int n) {
        return (int) (n - 32) * (5/9);
    }

    public int ctof(int n) {
        return n * (9/5) + 32;
    }
}
