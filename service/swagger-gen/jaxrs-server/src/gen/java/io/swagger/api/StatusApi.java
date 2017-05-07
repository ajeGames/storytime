package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.StatusApiService;
import io.swagger.api.factories.StatusApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.InlineResponse200;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/status")


@io.swagger.annotations.Api(description = "the status API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T21:27:25.790Z")
public class StatusApi  {
   private final StatusApiService delegate = StatusApiServiceFactory.getStatusApi();

    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets information about the status of the StoryTime service.", response = InlineResponse200.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = InlineResponse200.class) })
    public Response getStatus(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStatus(securityContext);
    }
}
