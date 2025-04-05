package com.example.demo.helloworld.handler;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component("hello-world")
public class HelloWorldFunction implements Function<String, String> {
    @Override
    public String apply(String s) {
        return "Hello World!";
    }
}
