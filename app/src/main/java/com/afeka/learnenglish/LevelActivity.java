package com.afeka.learnenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity {

    String username;
    int age;
    TextView username_display;
    TextView age_display;

    Button basis_button;
    Button advanced_a_button;
    Button advanced_b_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //getting extras
        Bundle extras = getIntent().getExtras();
        username = extras.getString("EXTRA_USERNAME");
        age = Integer.valueOf(extras.getString("EXTRA_AGE"));

        username_display = (TextView)findViewById(R.id.username_textview);
        age_display = (TextView)findViewById(R.id.userage_textview);

        username_display.setText(username);
        age_display.setText(String.valueOf(age));

        advanced_a_button = (Button) findViewById(R.id.button_beginners);
        basis_button = (Button) findViewById(R.id.button_basis);
        advanced_b_button = (Button) findViewById(R.id.button_advanced);


        basis_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelActivity.this , OptionActivity.class);
                startActivity(intent);
            }
        });

        advanced_a_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelActivity.this , OptionActivity.class);
                startActivity(intent);
            }
        });

        advanced_b_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelActivity.this , OptionActivity.class);
                startActivity(intent);
            }
        });


    }
}
