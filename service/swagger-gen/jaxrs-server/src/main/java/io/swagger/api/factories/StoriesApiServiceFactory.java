package io.swagger.api.factories;

import io.swagger.api.StoriesApiService;
import io.swagger.api.impl.StoriesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T21:27:25.790Z")
public class StoriesApiServiceFactory {
    private final static StoriesApiService service = new StoriesApiServiceImpl();

    public static StoriesApiService getStoriesApi() {
        return service;
    }
}
