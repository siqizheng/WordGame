package com.example.qiqit.wordgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.qiqit.wordgame.WordGuess.best_score;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView time=findViewById(R.id.spendTime);
        String timeView="You spend: "+ WordGuess.total_time/1000+" sec";
        time.setText(timeView);
    }

    public void onClickButtonYes(View view){
        Intent intent = new Intent(this, WordGuess.class);
        startActivity(intent);
    }

    public void onClickButtonNo(View view){
        Toast.makeText(this, "Best score is"+best_score/1000+" sec", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
