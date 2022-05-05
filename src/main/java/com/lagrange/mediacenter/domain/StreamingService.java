package com.lagrange.mediacenter.domain;

import com.lagrange.mediacenter.Exceptions.VideoNotFoundException;
import com.lagrange.mediacenter.bdd.entities.Video;
import com.lagrange.mediacenter.bdd.repositories.VideoRepository;
import com.lagrange.mediacenter.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StreamingService implements VideoService {

    private final VideoRepository videoRepository;

    @Value( "${mediapath.url}" )
    private String mediaPath;

    public Mono<Resource> getVideo(String id) throws FileNotFoundException {
        checkIfExist(id);
        Video video = videoRepository.findById(Long.parseLong(id)).get();
        File fle =  new File(mediaPath + video.getPath());
        InputStream is = new FileInputStream(fle);
        return Mono.fromSupplier(() -> {
            try {
                return new ByteArrayResource(is.readAllBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    private void checkIfExist(String id){
        if(!videoRepository.existsById(Long.parseLong(id))){
            throw new VideoNotFoundException();
        }
    }

    @Override
    public List<String> getAllVideoNames() {
        return videoRepository.getAllEntryNames();
    }

    @Override
    public boolean exist(String title) {
        return videoRepository.existsByName(title);
    }

    @Override
    public List<Video> getAll() {
        return videoRepository.findAll();
    }

}