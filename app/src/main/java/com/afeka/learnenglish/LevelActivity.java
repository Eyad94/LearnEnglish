package com.afeka.learnenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LevelActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String username;
    int points;
    TextView username_textView;
    TextView points_textView;
    String level_name;
    Button button_basis;
    Button button_beginners;
    Button button_advanced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //getting user info from sharedPreferences
        sharedPreferences = getSharedPreferences("UserInfo", 0);
        username = sharedPreferences.getString("USERNAME", "");
        points = sharedPreferences.getInt("POINTS",0);

        //initializing components
        username_textView = findViewById(R.id.username_lev_textview);
        points_textView = findViewById(R.id.points_lev_textView);
        username_textView.setText(username);
        points_textView.setText(String.valueOf(points));
        button_beginners = findViewById(R.id.button_beginners);
        button_basis = findViewById(R.id.button_basis);
        button_advanced = findViewById(R.id.button_advanced);


        //buttons clicked
        button_beginners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level_name = "Beginners";
                button_level_click(level_name);
            }
        });

        button_basis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level_name = "Basic";
                button_level_click(level_name);
            }
        });

        button_advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level_name = "Advanced";
                button_level_click(level_name);
            }
        });

    }


    @Override
    protected void onResume(){
        super.onResume();
        points = sharedPreferences.getInt("POINTS",0);
        points_textView.setText(String.valueOf(points));
    }


    @Override
    public void onBackPressed() {
    }

    //event button clicked
    private void button_level_click(String level){
        Intent OptionActivity_intent = new Intent(LevelActivity.this , OptionActivity.class);

        Bundle extras = new Bundle();
        extras.putString("EXTRA_LEVEL",level);
        OptionActivity_intent.putExtras(extras);
        startActivity(OptionActivity_intent);
    }

}
