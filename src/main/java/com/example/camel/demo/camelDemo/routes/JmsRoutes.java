package com.example.camel.demo.camelDemo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Authur : sujitagarwal
 * Created: 29/03/19.
 */
@Component
public class JmsRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
      /*  from("timer:foo?period=1s").
                setBody(simple("Simple message to queue")).
                log("log the line:: ${body}  ").
                to("activemq:queue:order");*/

        from("activemq:queue:order").
                log("New Message Received::: ${body}").end();



    }
}
