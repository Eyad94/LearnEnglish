package com.afeka.learnenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {

    Button basis_button;
    Button advanced_a_button;
    Button advanced_b_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);


        basis_button = (Button) findViewById(R.id.button_basis);
        advanced_a_button = (Button) findViewById(R.id.advanced_a);
        advanced_b_button = (Button) findViewById(R.id.advanced_b);


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
