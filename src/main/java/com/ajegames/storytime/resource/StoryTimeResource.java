package com.ajegames.storytime.resource;

import com.ajegames.storytime.StoryTimeApplication;
import com.ajegames.storytime.model.StorySummary;
import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/storytime")
@Produces(MediaType.APPLICATION_JSON)
public class StoryTimeResource {

    /*
        TODO: consider security and protections against hackers; e.g., how to handle DDOS attacks
     */

    private static Logger LOG = StoryTimeApplication.KEY_EVENT_LOG;

    @GET
    public String ping() {
        LOG.info("Called ping");
        return "{ \"message\": \"pong\" }";
    }

    /**
     * Provide summary information for all published stories in the catalog.
     *
     * @return java.util.List containing search results
     */
    @GET
    @Timed
    @Path("stories")
    public List<StorySummary> findPublishedStories() {
        /*
         * TODO: introduce criteria to refine search
         */
        LOG.info("Called findPublishedStories");
        return CatalogController.create().getAllStorySummaries();
    }
}
