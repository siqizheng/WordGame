package com.example.qiqit.wordgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.*;

public class MovingChar {
    static  ArrayList<SingleChar> myWord = new ArrayList<>();
    int width = 800;
    int height = 600;
    public MovingChar(){

    }
    public void createWord(String question){
        Random rand = new Random();   // for random number generator

        myWord.clear();

        for(int i=0; i<question.length(); i++){
            SingleChar c = new SingleChar();

            c.s= Character.toString(question.charAt(i));
            c.x = rand.nextInt(width);
            c.y = rand.nextInt(height);
            c.size = rand.nextInt(30)+30;
            c.speedX = rand.nextInt(5)+1;
            c.speedY = rand.nextInt(5)+1;

            myWord.add(c);
        }
    }

    public void paint() {



        for (int i = 0; i < myWord.size(); i++){

           Canvas c=new Canvas();
           Paint p=new Paint();
           p.setColor(Color.GREEN);

            myWord.get(i).x += myWord.get(i).speedX;
            if (myWord.get(i).x > width) {myWord.get(i).speedX=myWord.get(i).speedX*-1;}
            if (myWord.get(i).x < 0) {myWord.get(i).speedX=myWord.get(i).speedX*-1;}

            myWord.get(i).y += myWord.get(i).speedY;
            if (myWord.get(i).y > height) {myWord.get(i).speedY=myWord.get(i).speedY*-1;}
            if (myWord.get(i).y < 0) {myWord.get(i).speedY=myWord.get(i).speedY*-1;}

           c.drawText(myWord.get(i).s,myWord.get(i).x, myWord.get(i).y,p);

        }

        try{
            Thread.sleep(10);
        } catch (Exception exc){}


    }

}
