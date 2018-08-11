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

        username_display = (TextView)findViewById(R.id.username_textview);
        age_display = (TextView)findViewById(R.id.userage_textview);

        username_display.setText(username);
        age_display.setText(String.valueOf(age));

        write_button = (Button) findViewById(R.id.write_button);
        write_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionActivity.this , PictureActivity.class);
                startActivity(intent);
            }
        });


        vocabulary_button = (Button) findViewById(R.id.vocabulary_button);
        vocabulary_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionActivity.this , VocabularyActivity.class);
                startActivity(intent);
            }
        });

        word_button = (Button) findViewById(R.id.word_button);
        word_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionActivity.this , WordActivity.class);
                startActivity(intent);
            }
        });

        grammar_button = (Button) findViewById(R.id.grammar_button);
        grammar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionActivity.this , GrammarActivity.class);
                startActivity(intent);
            }
        });


        listening_comprehension_button = (Button) findViewById(R.id.listening_comprehension_button);
        listening_comprehension_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionActivity.this , ListeningComprehensionActivity.class);
                startActivity(intent);
            }
        });

    }
}
