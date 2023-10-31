package com.pizzeria.springdatajpa.service.exception;

/**
 *
 * @author edwin
 */
public class EmailApiException extends RuntimeException {

    public EmailApiException() {
        super("Error sending email");
    }
    
}
