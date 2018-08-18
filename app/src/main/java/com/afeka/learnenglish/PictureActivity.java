package com.afeka.learnenglish;


import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;


public class PictureActivity extends AppCompatActivity {

    DatabaseReference mDatabase;
    ArrayList<String> names_of_pictures = new ArrayList<>();
    ArrayList<String> url_of_pictures = new ArrayList<>();

    TextView points_textView;
    TextView timer_display;
    int points;
    ImageView imageView;

    char button_1;
    char button_2;
    char button_3;
    char button_4;
    char button_5;
    char button_6;
    char button_7;
    char button_8;
    char button_9;
    char button_10;

    String level_name;
    String word_in_txt;
    TextView word_textView;
    String word_of_picture;
    int length_of_word;
    int current_letter = 0;
    int current_question_index = 0;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;

    CountDownTimer countDownTimer;
    int second_per_ques;
    Random rand = new Random();
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        //getting extras
        Bundle extras = getIntent().getExtras();
        points = extras.getInt("EXTRA_POINTS");
        level_name = extras.getString("EXTRA_LEVEL");

        points_textView = findViewById(R.id.points_pic_textView);
        points_textView.setText(String.valueOf(points));

        imageView = findViewById(R.id.image);

        timer_display = findViewById(R.id.timer_pic_textView);
        word_textView = findViewById(R.id.word_in_textView);
        word_in_txt = "";
        word_textView.setText(word_in_txt);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);

        get_pictures_from_server();


        //buttons clicked
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_1, button1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_2, button2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_3, button3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_4, button4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_5, button5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_6, button6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_7, button7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_8, button8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_9, button9);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_10, button10);
            }
        });

    }


    private void check_letter_correct(char letter, Button button){
        if(letter == word_of_picture.charAt(current_letter)){
            word_in_txt += letter;
            word_textView.setText(word_in_txt);
            button.setEnabled(false);
            current_letter++;
            if(current_letter == word_of_picture.length()) {
                points += 5;
                points_textView.setText(String.valueOf(points));
                countDownTimer.cancel();
                new_question();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void fill_letters_in_Buttons(){
        int[] leters_Button = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int index;

        for(int i=0; i<length_of_word; i++) {
            index = rand.nextInt(10);
            while (leters_Button[index] != -1)
                index = rand.nextInt(10);

            leters_Button[index] = index_of_char(word_of_picture.charAt(i));
        }

        for(int i=0; i<leters_Button.length; i++)
            if(leters_Button[i] == -1)
                leters_Button[i] = rand.nextInt(26);

        button_1 = alphabet[leters_Button[0]];
        button_2 = alphabet[leters_Button[1]];
        button_3 = alphabet[leters_Button[2]];
        button_4 = alphabet[leters_Button[3]];
        button_5 = alphabet[leters_Button[4]];
        button_6 = alphabet[leters_Button[5]];
        button_7 = alphabet[leters_Button[6]];
        button_8 = alphabet[leters_Button[7]];
        button_9 = alphabet[leters_Button[8]];
        button_10 = alphabet[leters_Button[9]];

        button1.setText(button_1 + "");
        button2.setText(button_2 + "");
        button3.setText(button_3 + "");
        button4.setText(button_4 + "");
        button5.setText(button_5 + "");
        button6.setText(button_6 + "");
        button7.setText(button_7 + "");
        button8.setText(button_8 + "");
        button9.setText(button_9 + "");
        button10.setText(button_10 + "");
    }


    private int index_of_char(char ch){
        for (int i=0; i<alphabet.length; i++)
            if(ch == alphabet[i])
                return i;
        return -1;
    }


    private void get_pictures_from_server(){
        mDatabase = FirebaseDatabase.getInstance().getReference().child("pictures").child(level_name);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot wordSnapshot : dataSnapshot.getChildren()){
                    String word = wordSnapshot.getKey();
                    String meaning = wordSnapshot.getValue(String.class);
                    names_of_pictures.add(word);
                    url_of_pictures.add(meaning);
                }
                new_question();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void new_question(){
        if(names_of_pictures.size() == 0)
            return;
        if(current_question_index >= names_of_pictures.size())
            current_question_index = 0;

        start_count_down();
        word_in_txt = "";
        word_textView.setText(word_in_txt);
        current_letter = 0;
        set_enable_buttons();

        word_of_picture = names_of_pictures.get(current_question_index);
        length_of_word = word_of_picture.length();
        word_of_picture = word_of_picture.toLowerCase();

        fill_letters_in_Buttons();

        String url = url_of_pictures.get(current_question_index);
        AsyncImageView asyncImageView = new AsyncImageView(imageView);
        asyncImageView.loadUrl(url);

        current_question_index++;
    }


    private void set_enable_buttons(){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        button10.setEnabled(true);
    }


    private void time_per_question(){
        switch (level_name){
            case "Beginners":
                second_per_ques = 15;
                break;
            case "Basic":
                second_per_ques = 10;
                break;
            case "Advanced":
                second_per_ques = 8;
                break;
        }
    }


    //countdown timer
    private void start_count_down(){
        time_per_question();

        countDownTimer = new CountDownTimer(1000 * second_per_ques, 1000) {
            public void onTick(long millisUntilFinished) {
                timer_display.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "You did not make it in time", Toast.LENGTH_LONG).show();
                new_question();
            }
        }.start();
    }

}
