/**
 * {user} create at 7:33:33 PM
 */
package com.clarit.hs.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Not Found Exception for all type of resource not found
 * Created by mnachiappan on Jan 8, 2023.
 *
 */

public class ItemNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String message;
    private String details;

    /**
     * @param message
     *
     */
    public ItemNotFoundException(String message, String details, Throwable e) {
        super(e);
        this.message = message;
        this.details = details;
    }

    public ItemNotFoundException(String message, String details) {
        this.message = message;
        this.details = details;
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
