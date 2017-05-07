package io.swagger.api;

import io.swagger.model.InlineResponse200;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/status")

@Api(description = "the status API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2017-05-06T21:33:38.812Z")


public class StatusApi  {

    @GET
    
    
    
    @ApiOperation(value = "", notes = "Gets information about the status of the StoryTime service.", response = InlineResponse200.class, tags={ "admin" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = InlineResponse200.class) })
    public Response getStatus() {
    	return Response.ok().entity("magic!").build();
    }
}

