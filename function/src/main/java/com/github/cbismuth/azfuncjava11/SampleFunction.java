package com.github.cbismuth.azfuncjava11;

import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.core.env.Environment;

import java.util.Optional;

public class SampleFunction {

    private static final Environment environment = SpringBeanProvider.getBean(Environment.class);

    @FunctionName("sampleFunction")
    public HttpResponseMessage getSpringProperty(@HttpTrigger(name = "sampleFunctionRequest",
                                                              methods = { HttpMethod.GET },
                                                              route = "property",
                                                              authLevel = AuthorizationLevel.ANONYMOUS) final HttpRequestMessage<Optional<String>> request) {

        return request.createResponseBuilder(HttpStatus.OK)
                      .header("Content-Type", "text/plain")
                      .body(environment.getProperty("foo"))
                      .build();
    }
}
