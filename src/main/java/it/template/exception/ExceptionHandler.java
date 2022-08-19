package it.template.exception;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import it.template.exception.throwables.ApiException;
import it.template.exception.throwables.BadRequestException;
import it.template.exception.enums.ErrorCode;
import it.template.exception.responses.ExceptionResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler
        implements ExceptionMapper<ApiException> {

    @Override
    public Response toResponse(ApiException e) {

        switch (e.getResponse().getErrorCode()) {
            case HTTP_400: {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(new ExceptionResponse(e.getResponse().getErrorCode(), e.getMessage(), null))
                        .build();
            }
            default:{
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ExceptionResponse(ErrorCode.HTTP_500, "" , e.getOriginalException()))
                        .build();
            }
        }
    }
}