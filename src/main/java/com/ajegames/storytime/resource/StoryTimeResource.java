package com.ajegames.storytime.resource;

import com.ajegames.storytime.model.CatalogController;
import com.ajegames.storytime.view.StorySummary;
import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * This is for...
 */
@Path("/storytime")
@Produces(MediaType.APPLICATION_JSON)
public class StoryTimeResource {

    private static Logger LOG = LoggerFactory.getLogger(StoryTimeResource.class);

    @GET
    public String ping() {
        return "{ message: pong }";
    }

    /**
     * Provide summary information for all stories that match given criteria.  For now, returns all stories.
     *
     * @return java.util.List containing search results
     */
    @GET
    @Timed
    @Path("stories")
    public List<StorySummary> findStories() {
        /*
         * TODO: introduce criteria to refine search
         */
        LOG.info("Find stories: all");
        return new CatalogController().getAllStories();
    }
}
