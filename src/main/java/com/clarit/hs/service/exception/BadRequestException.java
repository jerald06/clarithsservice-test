package com.clarit.hs.service.exception;


public class BadRequestException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;
    private String details;

    /**
     * @param message
     *
     */
    public BadRequestException(String message, String details, Throwable e) {
        super(e);
        this.message = message;
        this.details = details;
    }

    public BadRequestException(String message) {
        this.message = message;

    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
