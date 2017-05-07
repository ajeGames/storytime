package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.StoriesApiService;
import io.swagger.api.factories.StoriesApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Chapter;
import io.swagger.model.Chapter1;
import io.swagger.model.Chapter2;
import io.swagger.model.InlineResponse2001;
import io.swagger.model.InlineResponse2011;
import io.swagger.model.InlineResponse400;
import io.swagger.model.Story;
import io.swagger.model.Story1;

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

@Path("/stories")


@io.swagger.annotations.Api(description = "the stories API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T21:27:25.790Z")
public class StoriesApi  {
   private final StoriesApiService delegate = StoriesApiServiceFactory.getStoriesApi();

    @POST
    @Path("/{storyId}/chapters")
    
    
    @io.swagger.annotations.ApiOperation(value = "Creates new chapter with given information.", notes = "Creates a chapter with the information provided, assigning a chapter ID.", response = InlineResponse2001.class, tags={ "storytime", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Chapter created", response = InlineResponse2001.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2001.class) })
    public Response createChapter(@ApiParam(value = "key of story to add chapter to",required=true) @PathParam("storyId") String storyId
,@ApiParam(value = "Chapter information" ,required=true) Chapter chapter
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createChapter(storyId,chapter,securityContext);
    }
    @POST
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Creates new story with given information.", notes = "Creates a story with the information provided, assigning a unique key.", response = InlineResponse2011.class, tags={ "storytime", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Story created", response = InlineResponse2011.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2011.class) })
    public Response createStory(@ApiParam(value = "Story summary" ,required=true) Story story
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createStory(story,securityContext);
    }
    @GET
    @Path("/{storyId}/chapters/{chapterId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Retrieves chapter with given ID of story with given key.", notes = "Retrieves chapter with given ID of story with given key.", response = InlineResponse2001.class, tags={ "storytime", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Chapter found", response = InlineResponse2001.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Chapter not found", response = InlineResponse2001.class) })
    public Response getChapter(@ApiParam(value = "unique key of story to retrieve",required=true) @PathParam("storyId") String storyId
,@ApiParam(value = "chapter ID",required=true) @PathParam("chapterId") String chapterId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getChapter(storyId,chapterId,securityContext);
    }
    @GET
    @Path("/{storyId}/chapters")
    
    
    @io.swagger.annotations.ApiOperation(value = "Gets all of the chapter of given story", notes = "Gets every chapter of given story.", response = InlineResponse2001.class, responseContainer = "List", tags={ "storytime", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Chapter details", response = InlineResponse2001.class, responseContainer = "List") })
    public Response getChapters(@ApiParam(value = "key of story to add chapter to",required=true) @PathParam("storyId") String storyId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getChapters(storyId,securityContext);
    }
    @GET
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Gets all of the story summaries", notes = "Gets every story summary. Results might be truncated for paging.", response = InlineResponse2011.class, responseContainer = "List", tags={ "storytime", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Story summaries", response = InlineResponse2011.class, responseContainer = "List") })
    public Response getStorySummaries(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStorySummaries(securityContext);
    }
    @GET
    @Path("/{storyId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Returns story summary for given key", notes = "Returns the summary of the story indentified by key.", response = InlineResponse2011.class, tags={ "storytime", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Story found", response = InlineResponse2011.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Story not found", response = InlineResponse2011.class) })
    public Response getStorySummary(@ApiParam(value = "unique key of story to retrieve",required=true) @PathParam("storyId") String storyId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStorySummary(storyId,securityContext);
    }
    @PATCH
    @Path("/{storyId}/chapters/{chapterId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Replaces a portion of the chapter", notes = "Replaces a portion of the chapter -- the prose, the signpost, etc. without touching the rest", response = InlineResponse2001.class, tags={ "storytime", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 202, message = "Chapter patched", response = InlineResponse2001.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2001.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Story or chapter not found", response = InlineResponse2001.class) })
    public Response patchChapter(@ApiParam(value = "unique key of story to update",required=true) @PathParam("storyId") String storyId
,@ApiParam(value = "chapter ID",required=true) @PathParam("chapterId") String chapterId
,@ApiParam(value = "Chapter information" ,required=true) Chapter2 chapter
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.patchChapter(storyId,chapterId,chapter,securityContext);
    }
    @PUT
    @Path("/{storyId}/chapters/{chapterId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Updates chapter with given information.", notes = "Updates the given chapter of given story.", response = InlineResponse2001.class, tags={ "storytime", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 202, message = "Chapter updated", response = InlineResponse2001.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2001.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Story or chapter not found", response = InlineResponse2001.class) })
    public Response updateChapter(@ApiParam(value = "unique key of story to update",required=true) @PathParam("storyId") String storyId
,@ApiParam(value = "chapter ID",required=true) @PathParam("chapterId") String chapterId
,@ApiParam(value = "Chapter information" ,required=true) Chapter1 chapter
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateChapter(storyId,chapterId,chapter,securityContext);
    }
    @PUT
    @Path("/{storyId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Updates a story summary with given information.", notes = "Creates a story with the information provided, assigning a unique key.", response = InlineResponse2011.class, tags={ "storytime", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Story summary updated", response = InlineResponse2011.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2011.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Story not found", response = InlineResponse2011.class) })
    public Response updateStorySummary(@ApiParam(value = "unique key of story to update",required=true) @PathParam("storyId") String storyId
,@ApiParam(value = "Story summary" ,required=true) Story1 story
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateStorySummary(storyId,story,securityContext);
    }
}
