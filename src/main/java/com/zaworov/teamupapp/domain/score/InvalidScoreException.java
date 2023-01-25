package com.zaworov.teamupapp.domain.score;

public class InvalidScoreException extends Exception{

    public InvalidScoreException(){
        super("Score is not valid");
    }
}
