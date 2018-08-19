package com.afeka.learnenglish;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do this after 1000ms=1sec
                Intent HomeActivity_intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(HomeActivity_intent);
                MainActivity.this.finish();
            }
        }, 3000);


    }
}
