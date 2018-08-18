package com.afeka.learnenglish;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GrammarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);
    }

    public void browser1(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.englisch-hilfen.de/en/exercises_list/alle_grammar.htm"));
        startActivity(browserIntent);
    }

    public void browser2(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uop.edu.jo/download/research/members/oxford_guide_to_english_grammar.pdf"));
        startActivity(browserIntent);
    }

    public void browser3(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.talkenglish.com/grammar/grammar.aspx"));
        startActivity(browserIntent);
    }

    public void browser4(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://learnenglish.britishcouncil.org/en/english-grammar"));
        startActivity(browserIntent);
    }
}
