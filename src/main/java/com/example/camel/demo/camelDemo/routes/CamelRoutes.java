package com.example.camel.demo.camelDemo.routes;

/**
 * Authur : sujitagarwal
 * Created: 31/12/18.
 */

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:firstRoute")
                .log("Camel body: ${body}");
    }
}