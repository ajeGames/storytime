package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.InlineResponse2011;
import io.swagger.model.InlineResponse400;
import io.swagger.model.ToAddRemove;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T21:27:25.790Z")
public abstract class FeaturedStoriesApiService {
    public abstract Response clearFeaturedStories(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getFeaturedStories(SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateFeaturedStories(ToAddRemove toAddRemove,SecurityContext securityContext) throws NotFoundException;
}
