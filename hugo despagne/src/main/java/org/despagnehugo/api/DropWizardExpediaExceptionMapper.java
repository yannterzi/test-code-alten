package org.despagnehugo.api;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class DropWizardExpediaExceptionMapper implements ExceptionMapper<DropWizardExpediaException>
{
    public Response toResponse(DropWizardExpediaException exception) {
        return Response.status(exception.getCode())
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
