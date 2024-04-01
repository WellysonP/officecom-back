package br.com.backend.model.dto;

public class Message {
    private String message;

    private int statusCode;

    public Message() {
    }

    public Message(String message, int statusCode) {
        super();
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode ;
    }
}
