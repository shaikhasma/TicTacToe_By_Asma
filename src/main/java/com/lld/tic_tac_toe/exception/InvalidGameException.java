package com.lld.tic_tac_toe.exception;

public class InvalidGameException extends  Exception{
    public InvalidGameException(String message){
        super(message);
    }
}
