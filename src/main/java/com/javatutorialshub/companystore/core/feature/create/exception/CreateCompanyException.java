package com.javatutorialshub.companystore.core.feature.create.exception;

public class CreateCompanyException extends Exception {
    public CreateCompanyException() {
    }

    public CreateCompanyException(String message) {
        super(message);
    }

    public CreateCompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateCompanyException(Throwable cause) {
        super(cause);
    }

    public CreateCompanyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
