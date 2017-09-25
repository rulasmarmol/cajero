package com.amk.test.cajero.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AppExceptionMapper implements ExceptionMapper<AppException> {

  @Override
  public Response toResponse(AppException ex) {
    System.out.println(ex);
    return Response.status(ex.getStatus())
        .entity(new ErrorMessage(ex))
        .type(MediaType.APPLICATION_JSON).
        build();
  }

}
