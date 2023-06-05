package edu.exceptions;

public class NotFoundException extends ServerError{

    public NotFoundException(String str){
        super(str);
        super.setErrorCode(404);
    }
}
