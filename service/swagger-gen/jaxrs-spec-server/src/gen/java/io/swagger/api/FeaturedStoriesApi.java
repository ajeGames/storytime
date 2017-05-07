package io.swagger.api;

import io.swagger.model.InlineResponse2011;
import io.swagger.model.InlineResponse400;
import io.swagger.model.ToAddRemove;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/featuredStories")

@Api(description = "the featuredStories API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2017-05-06T21:33:38.812Z")


public class FeaturedStoriesApi  {

    @DELETE
    
    
    
    @ApiOperation(value = "Clears list of featured stories.", notes = "Clears list of featured stories.", response = void.class, tags={ "admin",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Story created", response = void.class) })
    public Response clearFeaturedStories() {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    
    
    
    @ApiOperation(value = "Gets a list of featured story IDs.", notes = "Gets a list of featured story IDs. Default list is empty.", response = String.class, responseContainer = "List", tags={ "clubhouse",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Story created", response = String.class, responseContainer = "List") })
    public Response getFeaturedStories() {
    	return Response.ok().entity("magic!").build();
    }

    @PUT
    
    
    
    @ApiOperation(value = "Adds and removes featured stories.", notes = "Adds and removes featured stories.", response = InlineResponse2011.class, tags={ "admin" })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Story created", response = InlineResponse2011.class),
        @ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2011.class) })
    public Response updateFeaturedStories(ToAddRemove toAddRemove) {
    	return Response.ok().entity("magic!").build();
    }
}

