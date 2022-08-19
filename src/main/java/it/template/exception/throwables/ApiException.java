package it.template.exception.throwables;

import java.util.Objects;

import it.template.exception.responses.ExceptionResponse;

public class ApiException extends RuntimeException{
    ExceptionResponse response;
    String exceptionMessage;
    Exception originalException;

    public ApiException() {
    }

    public ApiException(ExceptionResponse response, Exception originalException) {
        this.response = response;
        this.originalException = originalException;
    }

    public ExceptionResponse getResponse() {
        return this.response;
    }

    public void setResponse(ExceptionResponse response) {
        this.response = response;
    }

    public Exception getOriginalException() {
        return this.originalException;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }

    public void setOriginalException(Exception originalException) {
        this.originalException = originalException;
    }

    public ApiException response(ExceptionResponse response) {
        setResponse(response);
        return this;
    }

    public ApiException originalException(Exception originalException) {
        setOriginalException(originalException);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ApiException)) {
            return false;
        }
        ApiException apiException = (ApiException) o;
        return Objects.equals(response, apiException.response) && Objects.equals(originalException, apiException.originalException);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, originalException);
    }

    @Override
    public String toString() {
        return "{" +
            " response='" + getResponse() + "'" +
            ", originalException='" + getOriginalException() + "'" +
            "}";
    }

}
