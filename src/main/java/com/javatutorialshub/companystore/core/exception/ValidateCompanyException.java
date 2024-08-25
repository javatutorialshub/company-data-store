package com.javatutorialshub.companystore.core.exception;

public class ValidateCompanyException extends Exception {
    public ValidateCompanyException() {
    }

    public ValidateCompanyException(String message) {
        super(message);
    }

    public ValidateCompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateCompanyException(Throwable cause) {
        super(cause);
    }

    public ValidateCompanyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
