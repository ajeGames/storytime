package io.swagger.api;

import io.swagger.model.Chapter;
import io.swagger.model.Chapter1;
import io.swagger.model.Chapter2;
import io.swagger.model.InlineResponse2001;
import io.swagger.model.InlineResponse2011;
import io.swagger.model.InlineResponse400;
import io.swagger.model.Story;
import io.swagger.model.Story1;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/stories")

@Api(description = "the stories API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2017-05-06T21:33:38.812Z")


public class StoriesApi  {

    @POST
    @Path("/{storyId}/chapters")
    
    
    @ApiOperation(value = "Creates new chapter with given information.", notes = "Creates a chapter with the information provided, assigning a chapter ID.", response = InlineResponse2001.class, tags={ "storytime",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Chapter created", response = InlineResponse2001.class),
        @ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2001.class) })
    public Response createChapter(@PathParam("storyId") @ApiParam("key of story to add chapter to") String storyId,Chapter chapter) {
    	return Response.ok().entity("magic!").build();
    }

    @POST
    
    
    
    @ApiOperation(value = "Creates new story with given information.", notes = "Creates a story with the information provided, assigning a unique key.", response = InlineResponse2011.class, tags={ "storytime",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Story created", response = InlineResponse2011.class),
        @ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2011.class) })
    public Response createStory(Story story) {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{storyId}/chapters/{chapterId}")
    
    
    @ApiOperation(value = "Retrieves chapter with given ID of story with given key.", notes = "Retrieves chapter with given ID of story with given key.", response = InlineResponse2001.class, tags={ "storytime",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Chapter found", response = InlineResponse2001.class),
        @ApiResponse(code = 404, message = "Chapter not found", response = InlineResponse2001.class) })
    public Response getChapter(@PathParam("storyId") @ApiParam("unique key of story to retrieve") String storyId,@PathParam("chapterId") @ApiParam("chapter ID") String chapterId) {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{storyId}/chapters")
    
    
    @ApiOperation(value = "Gets all of the chapter of given story", notes = "Gets every chapter of given story.", response = InlineResponse2001.class, responseContainer = "List", tags={ "storytime",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Chapter details", response = InlineResponse2001.class, responseContainer = "List") })
    public Response getChapters(@PathParam("storyId") @ApiParam("key of story to add chapter to") String storyId) {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    
    
    
    @ApiOperation(value = "Gets all of the story summaries", notes = "Gets every story summary. Results might be truncated for paging.", response = InlineResponse2011.class, responseContainer = "List", tags={ "storytime",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Story summaries", response = InlineResponse2011.class, responseContainer = "List") })
    public Response getStorySummaries() {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{storyId}")
    
    
    @ApiOperation(value = "Returns story summary for given key", notes = "Returns the summary of the story indentified by key.", response = InlineResponse2011.class, tags={ "storytime",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Story found", response = InlineResponse2011.class),
        @ApiResponse(code = 404, message = "Story not found", response = InlineResponse2011.class) })
    public Response getStorySummary(@PathParam("storyId") @ApiParam("unique key of story to retrieve") String storyId) {
    	return Response.ok().entity("magic!").build();
    }

    @PATCH
    @Path("/{storyId}/chapters/{chapterId}")
    
    
    @ApiOperation(value = "Replaces a portion of the chapter", notes = "Replaces a portion of the chapter -- the prose, the signpost, etc. without touching the rest", response = InlineResponse2001.class, tags={ "storytime",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Chapter patched", response = InlineResponse2001.class),
        @ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2001.class),
        @ApiResponse(code = 404, message = "Story or chapter not found", response = InlineResponse2001.class) })
    public Response patchChapter(@PathParam("storyId") @ApiParam("unique key of story to update") String storyId,@PathParam("chapterId") @ApiParam("chapter ID") String chapterId,Chapter2 chapter) {
    	return Response.ok().entity("magic!").build();
    }

    @PUT
    @Path("/{storyId}/chapters/{chapterId}")
    
    
    @ApiOperation(value = "Updates chapter with given information.", notes = "Updates the given chapter of given story.", response = InlineResponse2001.class, tags={ "storytime",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Chapter updated", response = InlineResponse2001.class),
        @ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2001.class),
        @ApiResponse(code = 404, message = "Story or chapter not found", response = InlineResponse2001.class) })
    public Response updateChapter(@PathParam("storyId") @ApiParam("unique key of story to update") String storyId,@PathParam("chapterId") @ApiParam("chapter ID") String chapterId,Chapter1 chapter) {
    	return Response.ok().entity("magic!").build();
    }

    @PUT
    @Path("/{storyId}")
    
    
    @ApiOperation(value = "Updates a story summary with given information.", notes = "Creates a story with the information provided, assigning a unique key.", response = InlineResponse2011.class, tags={ "storytime" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Story summary updated", response = InlineResponse2011.class),
        @ApiResponse(code = 400, message = "Invalid input", response = InlineResponse2011.class),
        @ApiResponse(code = 404, message = "Story not found", response = InlineResponse2011.class) })
    public Response updateStorySummary(@PathParam("storyId") @ApiParam("unique key of story to update") String storyId,Story1 story) {
    	return Response.ok().entity("magic!").build();
    }
}

