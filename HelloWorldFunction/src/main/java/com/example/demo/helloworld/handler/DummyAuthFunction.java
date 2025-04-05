package com.example.demo.helloworld.handler;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component("auth")
public class DummyAuthFunction implements Function<Map<String, Object>, Map<String, Object>> {
    @Override
    public Map<String, Object> apply(Map<String, Object> event) {
        Map<String, Object> response = new HashMap<>();
        response.put("principalId", "1234");

        Map<String, Object> policyDocument = new HashMap<>();
        policyDocument.put("Version", "2012-10-17");

        Map<String, String> statement = new HashMap<>();
        statement.put("Action", "execute-api:Invoke");
        statement.put("Effect", "Allow");
        statement.put("Resource", (String) event.get("methodArn"));
        policyDocument.put("Statement", Arrays.asList(statement));

        response.put("policyDocument", policyDocument);

        Map<String, String> context = new HashMap<>();
        context.put("now", new Date().toString());
        response.put("context", context);

        return response;
    }
}
