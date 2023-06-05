package edu.exceptions;

public class AlreadyExistException extends ServerError{

    public AlreadyExistException(String str){
        super(str);
        super.setErrorCode(409);
    }
}
