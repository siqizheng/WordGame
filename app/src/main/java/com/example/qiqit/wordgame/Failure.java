package com.example.qiqit.wordgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.qiqit.wordgame.WordGuess.best_score;

public class Failure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure);
    }

    public void onClickBack(View view){
        if(WordGuess.canPrint){
            Toast.makeText(this, "Best score is"+best_score/1000+" sec", Toast.LENGTH_SHORT).show();
        }
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

