package com.javatutorialshub.companystore.core.feature.update.exception;

public class UpdateCompanyException extends Exception {
    public UpdateCompanyException() {
    }

    public UpdateCompanyException(String message) {
        super(message);
    }

    public UpdateCompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateCompanyException(Throwable cause) {
        super(cause);
    }

    public UpdateCompanyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
