package org.acme.services;

import org.acme.domain.Greeting;

public interface GreetingService {

    Greeting get();

    Greeting get(String name);
}
