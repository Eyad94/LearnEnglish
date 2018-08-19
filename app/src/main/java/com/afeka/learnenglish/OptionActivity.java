package com.afeka.learnenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OptionActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String username;
    TextView username_textView;

    TextView points_textView;
    int points;

    Button write_button;
    Button vocabulary_button;
    Button word_button;
    Button grammar_button;

    String level_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);


        //getting extras
        Bundle extras = getIntent().getExtras();
        level_name = extras.getString("EXTRA_LEVEL");

        //getting user info from sharedPreferences
        sharedPreferences = getSharedPreferences("UserInfo", 0);
        username = sharedPreferences.getString("USERNAME", "");
        points = sharedPreferences.getInt("POINTS",0);

        //initializing components
        username_textView = findViewById(R.id.username_opt_textview);
        points_textView = findViewById(R.id.points_opt_textView);
        username_textView.setText(username);
        points_textView.setText(String.valueOf(points));
        write_button = findViewById(R.id.picture_button);
        write_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent write_intent = new Intent(OptionActivity.this, PictureActivity.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_LEVEL",level_name);
                write_intent.putExtras(extras);
                startActivity(write_intent);
            }
        });


        vocabulary_button = findViewById(R.id.vocabulary_button);
        vocabulary_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vocablary_intent = new Intent(OptionActivity.this, VocabularyActivity.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_LEVEL",level_name);
                vocablary_intent.putExtras(extras);
                startActivity(vocablary_intent);
            }
        });

        word_button = findViewById(R.id.word_button);
        word_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent word_intent = new Intent(OptionActivity.this, WordActivity.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_LEVEL",level_name);
                word_intent.putExtras(extras);
                startActivity(word_intent);
            }
        });

        grammar_button = findViewById(R.id.grammar_button);
        grammar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent grammar_intent = new Intent(OptionActivity.this, GrammarActivity.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_LEVEL",level_name);
                grammar_intent.putExtras(extras);
                startActivity(grammar_intent);
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        points = sharedPreferences.getInt("POINTS",0);
        points_textView.setText(String.valueOf(points));
    }

}
