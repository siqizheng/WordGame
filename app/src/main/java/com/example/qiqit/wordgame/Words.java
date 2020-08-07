package com.example.qiqit.wordgame;

import java.io.*;
import java.util.*;

public class Words {
    private static List<String> wordList=new ArrayList<> ();

    private static Map<String,String> wordMap;

    public Words(){

        wordMap=new HashMap<>();
        wordList.add("APPLE");
        wordList.add("PAPAYA");
        wordList.add("BANANA");
        wordList.add("STRAWBERRY");
        wordList.add("GRAPEFRUIT");
        wordList.add("CHERRY");
        wordList.add("APRICOT");
    }


    public String getNextWord(){

        //randomly get a word from the list
        Random rd=new Random();

        int rdNum=rd.nextInt(wordList.size());

        String answer=wordList.get(rdNum);

        List<String> letters=Arrays.asList(answer.split(""));

        Collections.shuffle(letters);

        String question="";

        for(int i=0;i<letters.size();i++) {
            question += letters.get(i);
        }

        if(!wordMap.containsKey(question)) {

            wordMap.put(question,answer);

        }

        return question;

    }

    public String getNextAnswer(String question){
        return wordMap.get(question);
    }
    //test whether the guess is correct or not
    public boolean isCorrect(String guess,String answer) {

        boolean b=false;

        if(guess.equals(answer)) {
            b=true;
        }
        return b;
    }

}
