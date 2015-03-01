package com.ajegames.storytime.resource;

import com.ajegames.storytime.data.StoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/storytime/story")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StoryResource {

    private static Logger LOG = LoggerFactory.getLogger(StoryResource.class);


}
