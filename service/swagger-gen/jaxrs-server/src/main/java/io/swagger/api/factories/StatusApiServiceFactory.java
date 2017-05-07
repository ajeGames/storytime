package io.swagger.api.factories;

import io.swagger.api.StatusApiService;
import io.swagger.api.impl.StatusApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T21:27:25.790Z")
public class StatusApiServiceFactory {
    private final static StatusApiService service = new StatusApiServiceImpl();

    public static StatusApiService getStatusApi() {
        return service;
    }
}
