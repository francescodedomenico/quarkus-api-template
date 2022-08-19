package it.template.exception.throwables;

import it.template.exception.enums.ErrorCode;
import it.template.exception.responses.ExceptionResponse;

public class BadRequestException extends ApiException {
    

    public BadRequestException() {
        super();
        ErrorCode error = ErrorCode.HTTP_400;
        ExceptionResponse response = new ExceptionResponse(error, error.getDescription(), null);
        this.setResponse(response);
    }

    public BadRequestException(String message) {
        super();
        ErrorCode error = ErrorCode.HTTP_400;
        ExceptionResponse response = new ExceptionResponse(error, error.getDescription(), null);
        this.setResponse(response);
        response.setErrorMessage(message);
    }

}
