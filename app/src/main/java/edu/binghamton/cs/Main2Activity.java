package edu.binghamton.cs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Integer c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int c = extras.getInt("c");
            TextView currentTemp = findViewById(R.id.currenttemp);
            currentTemp.setText("The current temperature is " + c + " degrees celsius");
        }
    }
}
