package com.example.qiqit.wordgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class WordGuess extends AppCompatActivity {
    private Words w=new Words();
    static String quest;
    static String answer;
    static double start_time;
    static double end_time;
    static double total_time;
    static double best_score;
    static boolean isSet;
    static boolean canPrint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_guess);
        TextView question=findViewById(R.id.tvQuestion);
        quest=w.getNextWord();
        question.setText(quest);
        answer=w.getNextAnswer(quest);
        start_time=System.currentTimeMillis();
    }

    public void onClickSubmit(View view){
        end_time=System.currentTimeMillis();
        EditText messageView=findViewById(R.id.editTextAnswer);
        String messageText=messageView.getText().toString();
        total_time=end_time-start_time;
        if(!isSet){
            best_score=total_time;
            isSet=true;
        }
        if(best_score>total_time){
            best_score=total_time;
        }
        if(messageText.equalsIgnoreCase(answer)) {
            canPrint=true;
            Intent intent = new Intent(this, Result.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, Failure.class);
            startActivity(intent);
        }



    }

}
