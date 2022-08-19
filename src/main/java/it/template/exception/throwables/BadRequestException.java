package it.template.exception.throwables;

import java.util.Objects;

import io.netty.handler.codec.http.HttpResponseStatus;
import it.template.exception.enums.ErrorCode;
import it.template.exception.responses.ExceptionResponse;

public class BadRequestException extends ApiException {
    HttpResponseStatus status;
    

    public BadRequestException() {
        super();
        ErrorCode error = ErrorCode.HTTP_400;
        ExceptionResponse response = new ExceptionResponse(error, error.getDescription(), null);
        this.setResponse(response);
        this.status = HttpResponseStatus.BAD_REQUEST;
    }

    public BadRequestException(String message) {
        super();
        ErrorCode error = ErrorCode.HTTP_400;
        ExceptionResponse response = new ExceptionResponse(error, error.getDescription(), null);
        this.setResponse(response);
        this.status = HttpResponseStatus.BAD_REQUEST;
        this.setExceptionMessage(message);
    }

    public HttpResponseStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpResponseStatus status) {
        this.status = status;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public void setExceptionMessage(String message) {
        this.exceptionMessage = message;
    }

    public BadRequestException status(HttpResponseStatus status) {
        setStatus(status);
        return this;
    }

    public BadRequestException message(String message) {
        setExceptionMessage(message);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BadRequestException)) {
            return false;
        }
        BadRequestException badRequestException = (BadRequestException) o;
        return Objects.equals(status, badRequestException.status)
                && Objects.equals(exceptionMessage, badRequestException.exceptionMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, exceptionMessage);
    }

    @Override
    public String toString() {
        return "{" +
                " status='" + getStatus() + "'" +
                ", message='" + getExceptionMessage() + "'" +
                "}";
    }

}
