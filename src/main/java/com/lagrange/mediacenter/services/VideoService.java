package com.lagrange.mediacenter.services;

import com.lagrange.mediacenter.bdd.entities.Video;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    Mono<Resource> getVideo(String title) throws IOException;

    List<String> getAllVideoNames();

    boolean exist(String title);

    List<Video> getAll();
}