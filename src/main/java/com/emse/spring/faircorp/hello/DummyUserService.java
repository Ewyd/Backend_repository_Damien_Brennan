package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DummyUserService implements UserService {

    @Autowired
    public DummyUserService(GreetingService greetingservice) {
        this.greetingservice = greetingservice;
    }

    private GreetingService greetingservice;

    public void greetAll() {

        Arrays.asList("Elodie","Charles").forEach(name -> greetingservice.greet(name));
    }
}
