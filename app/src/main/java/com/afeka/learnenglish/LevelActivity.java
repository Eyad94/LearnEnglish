package com.afeka.learnenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity {

    String username;
    int points;
    TextView username_textView;
    TextView points_textView;

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
        points = extras.getInt("EXTRA_POINTS");

        username_textView = findViewById(R.id.username_lev_textview);
        points_textView = findViewById(R.id.points_lev_textView);

        username_textView.setText(username);
        points_textView.setText(String.valueOf(points));

        button_beginners = findViewById(R.id.button_beginners);
        button_basis = findViewById(R.id.button_basis);
        button_advanced = findViewById(R.id.button_advanced);


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
        extras.putInt("EXTRA_POINTS", points);
        OptionActivity_intent.putExtras(extras);

        startActivity(OptionActivity_intent);
    }
}
