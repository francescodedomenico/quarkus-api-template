package it.template.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import it.template.exception.enums.ErrorCode;
import it.template.exception.responses.ExceptionResponse;
import it.template.exception.throwables.ApiException;

@Provider
public class ExceptionHandler
        implements ExceptionMapper<ApiException> {

    @Override
    public Response toResponse(ApiException e) {

        switch (e.getResponse().getErrorCode()) {
            case HTTP_400: {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(new ExceptionResponse(e.getResponse().getErrorCode(), e.getResponse().getErrorMessage(),
                                null))
                        .build();
            }
            default: {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ExceptionResponse(ErrorCode.HTTP_500, "", e.getOriginalException()))
                        .build();
            }
        }
    }
}