package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

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

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T21:27:25.790Z")
public abstract class StoriesApiService {
    public abstract Response createChapter(String storyId,Chapter chapter,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createStory(Story story,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getChapter(String storyId,String chapterId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getChapters(String storyId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStorySummaries(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStorySummary(String storyId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response patchChapter(String storyId,String chapterId,Chapter2 chapter,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateChapter(String storyId,String chapterId,Chapter1 chapter,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateStorySummary(String storyId,Story1 story,SecurityContext securityContext) throws NotFoundException;
}
