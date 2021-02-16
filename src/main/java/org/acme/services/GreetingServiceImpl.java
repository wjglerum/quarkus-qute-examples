package org.acme.services;

import org.acme.domain.Greeting;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingServiceImpl implements GreetingService{

    public Greeting get() {
        return new Greeting("Hello world!");
    }

    public Greeting get(String name) {
        return new Greeting(String.format("Hello %s!", name));
    }
}
