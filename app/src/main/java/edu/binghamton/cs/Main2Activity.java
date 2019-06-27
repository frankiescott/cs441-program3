package edu.binghamton.cs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Integer c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            c = extras.getInt("c");
            TextView currentTemp = findViewById(R.id.currenttemp);
            currentTemp.setText("The current temperature is " + c + " degrees celsius");
        }

        if (c >= 0 && c < 10) {
            //snow
        }
        else if (c >= 10 && c < 18) {
            //fall
        }
        else if (c >= 18 && c < 27) {
            //spring
        }
        else if (c >= 27 && c < 41) {
            //beach
        }
        else {
            //way too hot
        }


        configureBackButton();
    }

    public void configureBackButton() {
        Button backButton = findViewById(R.id.backbutton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
