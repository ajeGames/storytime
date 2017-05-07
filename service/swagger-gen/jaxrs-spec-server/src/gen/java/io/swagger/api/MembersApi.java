package io.swagger.api;

import io.swagger.model.InlineResponse201;
import io.swagger.model.InlineResponse400;
import io.swagger.model.Member;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/members")

@Api(description = "the members API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2017-05-06T21:33:38.812Z")


public class MembersApi  {

    @GET
    @Path("/{memberId}")
    
    
    @ApiOperation(value = "Gets member information", notes = "Gets public member information", response = InlineResponse201.class, tags={ "clubhouse",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Member found", response = InlineResponse201.class),
        @ApiResponse(code = 404, message = "Member not found", response = InlineResponse201.class) })
    public Response getMember(@PathParam("memberId") @ApiParam("ID of the member") String memberId) {
    	return Response.ok().entity("magic!").build();
    }

    @POST
    
    
    
    @ApiOperation(value = "Creates a new member of the Clubhouse.", notes = "", response = InlineResponse201.class, tags={ "clubhouse" })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Member registered", response = InlineResponse201.class),
        @ApiResponse(code = 400, message = "Registration failure", response = InlineResponse201.class) })
    public Response registerMember(Member member) {
    	return Response.ok().entity("magic!").build();
    }
}

