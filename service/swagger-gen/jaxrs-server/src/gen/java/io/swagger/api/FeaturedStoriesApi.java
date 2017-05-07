package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.FeaturedStoriesApiService;
import io.swagger.api.factories.FeaturedStoriesApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.InlineResponse2011;
import io.swagger.model.InlineResponse400;
import io.swagger.model.ToAddRemove;

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

@Path("/featuredStories")


@io.swagger.annotations.Api(description = "the featuredStories API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T21:27:25.790Z")
public class FeaturedStoriesApi  {
   private final FeaturedStoriesApiService delegate = FeaturedStoriesApiServiceFactory.getFeaturedStoriesApi();

    @DELETE
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Clears list of featured stories.", notes = "Clears list of featured stories.", response = void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Story created", response = void.class) })
    public Response clearFeaturedStories(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.clearFeaturedStories(securityContext);
    }
    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Gets a list of featured story IDs.", notes = "Gets a list of featured story IDs. Default list is empty.", response = String.class, responseContainer = "List", tags={ "clubhouse", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Story created", response = String.class, responseContainer = "List") })
    public Response getFeaturedStories(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getFeaturedStories(securityContext);
    }
    @PUT
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Adds and removes featured stories.", notes = "Adds and removes featured stories.", response = InlineResponse2011.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Story created", response = InlineResponse2011.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2011.class) })
    public Response updateFeaturedStories(@ApiParam(value = "List of IDs of stories to feature" ) ToAddRemove toAddRemove
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateFeaturedStories(toAddRemove,securityContext);
    }
}
