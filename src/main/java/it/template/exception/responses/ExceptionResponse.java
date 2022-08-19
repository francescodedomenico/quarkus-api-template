package it.template.exception.responses;

import java.io.Serializable;
import java.util.Objects;

import io.quarkus.runtime.annotations.RegisterForReflection;
import it.template.exception.enums.ErrorCode;

@RegisterForReflection
public class ExceptionResponse implements Serializable {
    ErrorCode errorCode;
    String errorCodeDescription;
    String errorMessage;
    Exception exception;

    public ExceptionResponse() {
    }

    public ExceptionResponse(ErrorCode errorCode, String errorMessage, Exception exception) {
        this.errorCode = errorCode;
        this.errorCodeDescription = errorCode.getDescription();
        this.errorMessage = errorMessage;
        this.exception = exception;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCodeDescription() {
        return this.errorCodeDescription;
    }

    public void setErrorCodeDescription(String errorCodeDescription) {
        this.errorCodeDescription = errorCodeDescription;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Exception getException() {
        return this.exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public ExceptionResponse errorCode(ErrorCode errorCode) {
        setErrorCode(errorCode);
        return this;
    }

    public ExceptionResponse errorMessage(String errorMessage) {
        setErrorMessage(errorMessage);
        return this;
    }

    public ExceptionResponse exception(Exception exception) {
        setException(exception);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ExceptionResponse)) {
            return false;
        }
        ExceptionResponse exceptionResponse = (ExceptionResponse) o;
        return Objects.equals(errorCode, exceptionResponse.errorCode)
                && Objects.equals(errorMessage, exceptionResponse.errorMessage)
                && Objects.equals(exception, exceptionResponse.exception);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, errorMessage, exception);
    }

    @Override
    public String toString() {
        return "{" +
                " errorCode='" + getErrorCode() + "'" +
                ", errorMessage='" + getErrorMessage() + "'" +
                ", exception='" + getException() + "'" +
                "}";
    }

}
