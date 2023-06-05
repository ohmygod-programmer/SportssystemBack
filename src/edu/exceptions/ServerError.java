package edu.exceptions;

public class ServerError extends Throwable{
    private Integer errorCode;
    public ServerError(String str){super(str);}

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
