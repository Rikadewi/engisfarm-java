package model;

public class EngiException extends Throwable{
    private String message;
    public EngiException(String s) {
        message = s;
    }
    public String getMessage() {
        return message;
    }
}
