package com.afeka.learnenglish;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class WordActivity extends AppCompatActivity {

    TextView points_textView;
    int points;

    Random rand = new Random();
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'};
    String word_in_hebrew;
    String meaning_in_english;
    int length_of_meaning;
    int current_letter = 0;

    char button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8;
    char button_9, button_10, button_11, button_12, button_13, button_14, button_15, button_16;
    char button_17, button_18, button_19, button_20, button_21, button_22, button_23, button_24,button_25;

    Button l_button1, l_button2, l_button3, l_button4, l_button5, l_button6, l_button7, l_button8, l_button9, l_button10;
    Button l_button11, l_button12, l_button13, l_button14, l_button15, l_button16, l_button17, l_button18, l_button19;
    Button l_button20, l_button21, l_button22, l_button23, l_button24, l_button25;

    TextView word_textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);


        //getting extras
        Bundle extras = getIntent().getExtras();
        points = extras.getInt("EXTRA_POINTS");

        points_textView = findViewById(R.id.points_word_textView);
        points_textView.setText(String.valueOf(points));

        word_textView = findViewById(R.id.word_hebrew_txt);
        word_in_hebrew = "כן";
        word_textView.setText(word_in_hebrew);
        meaning_in_english = "yes";
        length_of_meaning = meaning_in_english.length();


        l_button1 = findViewById(R.id.letter_button1);
        l_button2 = findViewById(R.id.letter_button2);
        l_button3 = findViewById(R.id.letter_button3);
        l_button4 = findViewById(R.id.letter_button4);
        l_button5 = findViewById(R.id.letter_button5);
        l_button6 = findViewById(R.id.letter_button6);
        l_button7 = findViewById(R.id.letter_button7);
        l_button8 = findViewById(R.id.letter_button8);
        l_button9 = findViewById(R.id.letter_button9);
        l_button10 = findViewById(R.id.letter_button10);
        l_button11 = findViewById(R.id.letter_button11);
        l_button12 = findViewById(R.id.letter_button12);
        l_button13 = findViewById(R.id.letter_button13);
        l_button14 = findViewById(R.id.letter_button14);
        l_button15 = findViewById(R.id.letter_button15);
        l_button16 = findViewById(R.id.letter_button16);
        l_button17 = findViewById(R.id.letter_button17);
        l_button18 = findViewById(R.id.letter_button18);
        l_button19 = findViewById(R.id.letter_button19);
        l_button20 = findViewById(R.id.letter_button20);
        l_button21 = findViewById(R.id.letter_button21);
        l_button22 = findViewById(R.id.letter_button22);
        l_button23 = findViewById(R.id.letter_button23);
        l_button24 = findViewById(R.id.letter_button24);
        l_button25 = findViewById(R.id.letter_button25);

        fill_letters_in_Buttons();

        //buttons clicked
        l_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_1, l_button1);
            }
        });

        l_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_2, l_button2);
            }
        });

        l_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_3, l_button3);
            }
        });

        l_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_4, l_button4);
            }
        });

        l_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_5, l_button5);
            }
        });

        l_button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_6, l_button6);
            }
        });

        l_button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_7, l_button7);
            }
        });

        l_button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_8, l_button8);
            }
        });

        l_button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_9, l_button9);
            }
        });

        l_button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_10, l_button10);
            }
        });

        l_button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_11, l_button11);
            }
        });

        l_button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_12, l_button12);
            }
        });

        l_button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_13, l_button13);
            }
        });

        l_button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_14, l_button14);
            }
        });

        l_button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_15, l_button15);
            }
        });

        l_button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_16, l_button16);
            }
        });

        l_button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_17, l_button17);
            }
        });

        l_button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_18, l_button18);
            }
        });

        l_button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_19, l_button19);
            }
        });

        l_button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_20, l_button20);
            }
        });

        l_button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_21, l_button21);
            }
        });

        l_button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_22, l_button22);
            }
        });

        l_button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_23, l_button23);
            }
        });

        l_button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_24, l_button24);
            }
        });

        l_button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_letter_correct(button_25, l_button25);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void fill_letters_in_Buttons(){
        int[] leters_Button = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1, -1,-1,-1,-1,-1,};
        int index;

        for(int i=0; i<length_of_meaning; i++) {
            index = rand.nextInt(25);
            while (leters_Button[index] != -1)
                index = rand.nextInt(25);

            leters_Button[index] = index_of_char(meaning_in_english.charAt(i));
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
        button_11 = alphabet[leters_Button[10]];
        button_12 = alphabet[leters_Button[11]];
        button_13 = alphabet[leters_Button[12]];
        button_14 = alphabet[leters_Button[13]];
        button_15 = alphabet[leters_Button[14]];
        button_16 = alphabet[leters_Button[15]];
        button_17 = alphabet[leters_Button[16]];
        button_18 = alphabet[leters_Button[17]];
        button_19 = alphabet[leters_Button[18]];
        button_20 = alphabet[leters_Button[19]];
        button_21 = alphabet[leters_Button[20]];
        button_22 = alphabet[leters_Button[21]];
        button_23 = alphabet[leters_Button[22]];
        button_24 = alphabet[leters_Button[23]];
        button_25 = alphabet[leters_Button[24]];

        l_button1.setText(button_1 + "");
        l_button2.setText(button_2 + "");
        l_button3.setText(button_3 + "");
        l_button4.setText(button_4 + "");
        l_button5.setText(button_5 + "");
        l_button6.setText(button_6 + "");
        l_button7.setText(button_7 + "");
        l_button8.setText(button_8 + "");
        l_button9.setText(button_9 + "");
        l_button10.setText(button_10 + "");
        l_button11.setText(button_11 + "");
        l_button12.setText(button_12 + "");
        l_button13.setText(button_13 + "");
        l_button14.setText(button_14 + "");
        l_button15.setText(button_15 + "");
        l_button16.setText(button_16 + "");
        l_button17.setText(button_17 + "");
        l_button18.setText(button_18 + "");
        l_button19.setText(button_19 + "");
        l_button20.setText(button_20 + "");
        l_button21.setText(button_21 + "");
        l_button22.setText(button_22 + "");
        l_button23.setText(button_23 + "");
        l_button24.setText(button_24 + "");
        l_button25.setText(button_25 + "");
    }

    private int index_of_char(char ch){
        for (int i=0; i<alphabet.length; i++)
            if(ch == alphabet[i])
                return i;
        return -1;
    }

    private void check_letter_correct(char letter, Button button){
        if(letter == meaning_in_english.charAt(current_letter)){
            button.setEnabled(false);
            current_letter++;
            if(current_letter >= meaning_in_english.length()) {
                current_letter = 0;                    //---------------------------------

                points += 10;
                points_textView.setText(String.valueOf(points));
            }
        }
    }
}
