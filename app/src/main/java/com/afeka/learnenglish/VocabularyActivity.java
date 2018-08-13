package com.afeka.learnenglish;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VocabularyActivity extends AppCompatActivity {

    DatabaseReference mDatabase;
    ArrayList<String> words_list = new ArrayList<>();
    ArrayList<String> meanings_list = new ArrayList<>();


    String word;
    String option_1;
    String option_2;
    String option_3;
    String option_4;

    Button option1_button;
    Button option2_button;
    Button option3_button;
    Button option4_button;

    TextView word_textView;

    int correct_answer_mum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("words");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot wordSnapshot : dataSnapshot.getChildren()){
                    String wordkey = wordSnapshot.getKey();
                    String wordValue = wordSnapshot.getValue(String.class);
                    Toast.makeText(VocabularyActivity.this, wordkey + "  " +wordValue, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



/*
        mDatabase = FirebaseDatabase.getInstance().getReference().child("words");
        mDatabase.child("I am").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(VocabularyActivity.this, value, Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
*/



        word = "rooms";
        option_1 = "בית משפט";
        option_2 = "חדרים";
        option_3 = "ילדים";
        option_4 = "בנות";

        option1_button = (Button)findViewById(R.id.button_option1);
        option2_button = (Button)findViewById(R.id.button_option2);
        option3_button = (Button)findViewById(R.id.button_option3);
        option4_button = (Button)findViewById(R.id.button_option4);
        word_textView = (TextView)findViewById(R.id.word_textView);

        option1_button.setText(option_1);
        option2_button.setText(option_2);
        option3_button.setText(option_3);
        option4_button.setText(option_4);
        word_textView.setText(word);

        correct_answer_mum = 2;


        option1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_answer(1);
            }
        });


        option2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_answer(2);
            }
        });


        option3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_answer(3);
            }
        });


        option4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_answer(4);
            }
        });
    }

    private void check_answer(int num_answer_selected){
        if(num_answer_selected == correct_answer_mum)
            Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Incorrect answer", Toast.LENGTH_SHORT).show();

    }
}
