package com.lagrange.mediacenter.controllers;

import com.lagrange.mediacenter.domain.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@CrossOrigin
public class StreamingController {

    @Autowired
    private StreamingService service;

    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title) throws IOException {
        return service.getVideo(title);
    }

}
