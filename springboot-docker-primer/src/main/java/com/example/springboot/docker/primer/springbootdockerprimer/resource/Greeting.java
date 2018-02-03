package com.example.springboot.docker.primer.springbootdockerprimer.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/docker/greeting")
public class Greeting {

    private static final String MESSAGE = "<HTML><BODY></BR></BR><H3 style=\"font-size:40px;\">Hello folks,</H3>" +
            "<H3 style=\"font-size:40px;\">Dockerising springboot application is pretty cool !! </H3></BODY></HTML>";

    @GetMapping
    public String getGreeting() {

        return MESSAGE;
    }
}
