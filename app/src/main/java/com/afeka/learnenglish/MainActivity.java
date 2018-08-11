package com.afeka.learnenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String username;
    int age;
    EditText name_input;
    EditText age_input;
    Button button_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name_input = (EditText)findViewById(R.id.txt_name);
        age_input = (EditText)findViewById(R.id.txt_age);
        button_go = (Button)findViewById(R.id.btn_go);

        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                username = name_input.getText().toString();
                age = Integer.valueOf(age_input.getText().toString());
*/
                Intent intent = new Intent(MainActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });
    }
}
