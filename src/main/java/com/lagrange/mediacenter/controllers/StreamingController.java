package com.lagrange.mediacenter.controllers;

import com.lagrange.mediacenter.bdd.entities.Video;
import com.lagrange.mediacenter.bdd.repositories.VideoRepository;
import com.lagrange.mediacenter.domain.StreamingService;
import com.lagrange.mediacenter.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class StreamingController {

    private final VideoService service;

    @GetMapping("video/exist")
    public boolean exist(@RequestParam String title){
        return service.exist(title);
    }

    @GetMapping("video/names")
    public List<String> getAllNames(){
        return service.getAllVideoNames();
    }

    @GetMapping("video")
    public List<Video> getAll(){
        return service.getAll();
    }
    @GetMapping(value = "video/{id}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String id) throws IOException {
        return service.getVideo(id);
    }

}
