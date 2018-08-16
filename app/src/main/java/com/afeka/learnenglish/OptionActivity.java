package com.afeka.learnenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OptionActivity extends AppCompatActivity {

    String username;
    int age;
    TextView username_display;
    TextView age_display;

    Button write_button;
    Button vocabulary_button;
    Button word_button;
    Button grammar_button;
    Button listening_comprehension_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        //getting extras
        Bundle extras = getIntent().getExtras();
        username = extras.getString("EXTRA_USERNAME");
        age = Integer.valueOf(extras.getString("EXTRA_AGE"));

        username_display = findViewById(R.id.username_textview);
        age_display = findViewById(R.id.userage_textview);

        username_display.setText(username);
        age_display.setText(String.valueOf(age));

        write_button = findViewById(R.id.write_button);
        write_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent write_intent = new Intent(OptionActivity.this, PictureActivity.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_USERNAME",username);
                extras.putString("EXTRA_AGE",String.valueOf(age));
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
                extras.putString("EXTRA_USERNAME",username);
                extras.putString("EXTRA_AGE",String.valueOf(age));
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
                extras.putString("EXTRA_USERNAME",username);
                extras.putString("EXTRA_AGE",String.valueOf(age));
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
                extras.putString("EXTRA_USERNAME",username);
                extras.putString("EXTRA_AGE",String.valueOf(age));
                grammar_intent.putExtras(extras);
                startActivity(grammar_intent);
            }
        });


        listening_comprehension_button = findViewById(R.id.listening_comprehension_button);
        listening_comprehension_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listen_intent = new Intent(OptionActivity.this, ListeningComprehensionActivity.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_USERNAME",username);
                extras.putString("EXTRA_AGE",String.valueOf(age));
                listen_intent.putExtras(extras);
                startActivity(listen_intent);
            }
        });

    }
}
