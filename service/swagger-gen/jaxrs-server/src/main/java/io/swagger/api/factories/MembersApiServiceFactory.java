package io.swagger.api.factories;

import io.swagger.api.MembersApiService;
import io.swagger.api.impl.MembersApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T21:27:25.790Z")
public class MembersApiServiceFactory {
    private final static MembersApiService service = new MembersApiServiceImpl();

    public static MembersApiService getMembersApi() {
        return service;
    }
}
