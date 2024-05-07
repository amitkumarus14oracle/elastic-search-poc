package com.restart.graphqldemo.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class QueryController {
    //@SchemaMapping(typeName = "Query", value = "test1")
    @QueryMapping
    public String test() {
        return "Test String A";
    }
}
