package com.example.camel.demo.camelDemo.controller;

/**
 * Authur : sujitagarwal
 * Created: 31/12/18.
 */
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelController {
    @Autowired
    ProducerTemplate producerTemplate;
    @RequestMapping(value = "/HelloCamel")
    public String startCamel() {
        producerTemplate.sendBody("direct:firstRoute", "Calling via Spring Boot Rest Controller");
        return "Calling via Apache Camel Rest Controller using Spring Boot";
    }
}