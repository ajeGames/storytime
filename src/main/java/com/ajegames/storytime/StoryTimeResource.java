package com.ajegames.storytime;

import com.ajegames.storytime.data.StoryRepository;
import com.ajegames.storytime.model.Story;
import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * This is for...
 */
@Path("/storytime")
@Produces(MediaType.APPLICATION_JSON)
public class StoryTimeResource {

    private static Logger LOG = LoggerFactory.getLogger(StoryTimeResource.class);

    /**
     * Provide summary information for all stories that match given criteria.  For now, returns all stories.
     *
     * @return java.util.List containing search results
     */
    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public List<Story> findStories() {
        /*
         * TODO: make this return actual stories
         * TODO: introduce criteria to refine search
         * TODO: limit results returned -- think through how to cache for incremental fetch?
         */
        LOG.info("Find stories: " + "all");
        List<Story> result = new ArrayList<Story>();
        result.add(Story.createStory("testing", "tester", "this is a test"));
        return result;
    }
}
