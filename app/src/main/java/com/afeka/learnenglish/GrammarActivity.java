package com.afeka.learnenglish;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GrammarActivity extends AppCompatActivity {


    Button button_grammar1;
    Button button_grammar2;
    Button button_grammar3;

    String button_grammar1_text;
    String button_grammar2_text;
    String button_grammar3_text;

    String uri_grammar1;
    String uri_grammar2;
    String uri_grammar3;

    String username;
    int points;
    TextView username_textView;
    TextView points_textView;
    String level_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);

        //getting extras
        Bundle extras = getIntent().getExtras();
        username = extras.getString("EXTRA_USERNAME");
        points = extras.getInt("EXTRA_POINTS");

        username_textView = findViewById(R.id.username_lev_textview);
        points_textView = findViewById(R.id.points_lev_textView);
        username_textView.setText(username);
        points_textView.setText(String.valueOf(points));

        button_grammar1 = findViewById(R.id.grammar1_button);
        button_grammar2 = findViewById(R.id.grammar2_button);
        button_grammar3 = findViewById(R.id.grammar3_button);

        switch_level_game();

        button_grammar1.setText(button_grammar1_text);
        button_grammar2.setText(button_grammar2_text);
        button_grammar3.setText(button_grammar3_text);


        button_grammar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri_grammar1));
                startActivity(browserIntent);
            }
        });


        button_grammar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri_grammar2));
                startActivity(browserIntent);
            }
        });


        button_grammar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri_grammar3));
                startActivity(browserIntent);
            }
        });
    }


    private void switch_level_game(){
        switch (level_name){
            case "Beginners":
                uri_grammar1 = "https://www.talkenglish.com/grammar/grammar.aspx";
                uri_grammar2 = "https://www.englisch-hilfen.de/en/exercises_list/alle_grammar.htm";
                uri_grammar3 = "https://learnenglish.britishcouncil.org/en/english-grammar";
                button_grammar1_text = "בסיס הדקדוק האנגלי";
                button_grammar2_text = "תרגילי דקדוק באנגלית";
                button_grammar3_text = "לימוד אנגלית";
                break;

            case "Basic":
                uri_grammar1 = "https://www.learnamericanenglishonline.com/Links.html";
                uri_grammar2 = "http://www.english-test.net/toefl/";
                uri_grammar3 = "https://learnenglish.britishcouncil.org/en/english-grammar";
                button_grammar1_text = "בסיס הדקדוק האנגלי";
                button_grammar2_text = "מבחן דקדוק באנגלית";
                button_grammar3_text = "לימוד אנגלית";
                break;

            case "Advanced":
                uri_grammar1 = "http://www.advanced-english-grammar.com/";
                uri_grammar2 = "http://www.bbc.co.uk/learningenglish/english/course/towards-advanced/unit-6/session-1";
                uri_grammar3 = "https://learnenglish.britishcouncil.org/en/english-grammar";
                button_grammar1_text = "דקדוק אנגלית למתקדמים";
                button_grammar2_text = "תרגילי דקדוק באנגלית";
                button_grammar3_text = "לימוד אנגלית";
                break;
        }
    }

}
