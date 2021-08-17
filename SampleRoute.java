package com.example.camel;


import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

@Component
public class SampleRoute extends RouteBuilder {

            @Override
            public void configure() throws Exception {
                CamelContext context = new DefaultCamelContext();

                restConfiguration()
                        .component("undertow").port("8086")
                        .bindingMode(RestBindingMode.json);

                        onException(JsonParseException.class)
                                .handled(true)
                                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                                .setHeader(Exchange.CONTENT_TYPE, constant("text/plain"))
                                .setBody().constant("Invalid json data");


                rest("/sample")
                        .id("sample-route")
                        .post("/name")
                        .consumes("application/json")
                        .produces("application/json")
                        .type(SampleUser.class)
                        .to("json-validator:myschema.json")
                        .to("direct:hello")
                        .to("SampleTransformer:transform")
                        .route()
                        .bean(SampleUsers.class, "addUser")
                        .endRest();
                        //.to("mock:update");

                from("direct:hello")
                        //.transform().constant("Hello World");
                        .transform().simple("Hello ${in.body.name}");
                from("mock:update")
                        .process(exchange -> {
                            //You can call your service layer
                            exchange.getOut().setBody("Following requests to '/' will return a 200\n");
                        })
                        .endRest();

            }
        }
