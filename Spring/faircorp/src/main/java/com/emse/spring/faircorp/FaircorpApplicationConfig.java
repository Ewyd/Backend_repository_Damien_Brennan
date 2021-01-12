package com.emse.spring.faircorp;

import com.emse.spring.faircorp.hello.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// (1)
@Configuration
public class FaircorpApplicationConfig {

    @Autowired
    private GreetingService greetingService;

    // (2)
    @Bean
    public CommandLineRunner greetingCommandLine() { // (3)
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // (4)
            }
        };
    }
}
