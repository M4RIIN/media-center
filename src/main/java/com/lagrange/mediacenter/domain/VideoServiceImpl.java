package com.lagrange.mediacenter.domain;

import com.lagrange.mediacenter.Exceptions.VideoAlreadyExistsException;
import com.lagrange.mediacenter.Exceptions.VideoNotFoundException;
import com.lagrange.mediacenter.bdd.entities.Video;
import com.lagrange.mediacenter.bdd.repositories.VideoRepository;
import com.lagrange.mediacenter.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {
    private VideoRepository repo;

    @Override
    public Video getVideo(String name) {
        if(!repo.existsByName(name)){
            throw new VideoNotFoundException();
        }
        return repo.findByName(name);
    }

    @Override
    public List<String> getAllVideoNames() {
        return repo.getAllEntryNames();
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(repo.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(name, "path");
        repo.save(newVid);
    }
}