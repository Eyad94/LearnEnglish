package com.afeka.learnenglish;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class PictureActivity extends AppCompatActivity {


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

    String word_in_txt;
    TextView word_textView;
    String word_of_picture;
    int length_of_word;
    int current_letter = 0;

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

    Random rand = new Random();
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);


        imageView = findViewById(R.id.image);
        String url = "https://firebasestorage.googleapis.com/v0/b/learnenglish-9a130.appspot.com" +
                "/o/cat.jpeg?alt=media&token=592363c1-d7df-4435-85b5-f591fb1d906d";
        AsyncImageView asyncImageView = new AsyncImageView(imageView);
        asyncImageView.loadUrl(url);

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


        word_of_picture = "cat";
        length_of_word = word_of_picture.length();
        fill_letters_in_Buttons();

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
            if(current_letter >= word_of_picture.length())
                current_letter = 0;                    //---------------------------------
        }
    }

    private void fill_letters_in_Buttons(){
        int[] leters_Button = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int index, num;

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
}
