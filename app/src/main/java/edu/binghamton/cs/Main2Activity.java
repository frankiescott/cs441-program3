package edu.binghamton.cs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

        ImageView image = findViewById(R.id.imageView);
        if (c >= 0 && c < 10) {
            //snow
            image.setImageResource(R.drawable.snow);
        }
        else if (c >= 10 && c < 18) {
            //fall
            image.setImageResource(R.drawable.fall);
        }
        else if (c >= 18 && c < 27) {
            //spring
            image.setImageResource(R.drawable.spring);
        }
        else if (c >= 27 && c < 41) {
            //beach
            image.setImageResource(R.drawable.beach);
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
                intent.putExtra("c", c);
                startActivity(intent);
            }
        });

    }
}
