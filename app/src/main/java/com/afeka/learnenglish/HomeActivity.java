package com.afeka.learnenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String username;
    EditText username_input;
    Button button_go;
    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //getting user info from sharedPreferences
        sharedPreferences = getSharedPreferences("UserInfo", 0);

        //clear sharedPreferences
       // sharedPreferences.edit().clear().commit();


        //getting user info from sharedPreferences
        username = sharedPreferences.getString("USERNAME", "");
        points = sharedPreferences.getInt("POINTS",0);

        //check user is exists
        if(username.length() > 0){
            Intent LevelActivity_intent = new Intent(this, LevelActivity.class);
            startActivity(LevelActivity_intent);
        }

        //initializing components
        username_input = findViewById(R.id.name_editText);
        button_go = findViewById(R.id.start_button);
        points = 0;
        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_go_clicked();
            }
        });
    }


    private void button_go_clicked(){

        //check user name is not empty
        if (username_input.getText().length() == 0 ) {
            Toast.makeText(this, "please enter name!!", Toast.LENGTH_SHORT).show();
            return;
        }

        //commit user name sharedPreferences
        username = username_input.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USERNAME",username);
        editor.putInt("POINTS",0);
        editor.commit();

        Intent LevelActivity_intent = new Intent(this, LevelActivity.class);
        startActivity(LevelActivity_intent);
    }
}
