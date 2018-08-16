package com.afeka.learnenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity {

    String username;
    //int age;
    TextView username_display;
    TextView age_display;

    Button button_basis;
    Button button_beginners;
    Button button_advanced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //getting extras
        Bundle extras = getIntent().getExtras();
        username = extras.getString("EXTRA_USERNAME");
       // age = Integer.valueOf(extras.getString("EXTRA_AGE"));

        username_display = (TextView)findViewById(R.id.username_textview);
       // age_display = (TextView)findViewById(R.id.userage_textview);

        username_display.setText(username);
        //age_display.setText(String.valueOf(age));

        button_beginners = (Button) findViewById(R.id.button_beginners);
        button_basis = (Button) findViewById(R.id.button_basis);
        button_advanced = (Button) findViewById(R.id.button_advanced);


        button_basis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_level_click();
            }
        });

        button_beginners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_level_click();
            }
        });

        button_advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_level_click();
            }
        });


    }

    private void button_level_click(){
        Intent OptionActivity_intent = new Intent(LevelActivity.this , OptionActivity.class);

        Bundle extras = new Bundle();
        extras.putString("EXTRA_USERNAME",username);
        //extras.putString("EXTRA_AGE",String.valueOf(age));
        OptionActivity_intent.putExtras(extras);

        startActivity(OptionActivity_intent);
    }
}
