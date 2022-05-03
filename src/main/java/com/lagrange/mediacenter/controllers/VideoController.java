package com.lagrange.mediacenter.controllers;

import com.lagrange.mediacenter.services.VideoService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("video")
@AllArgsConstructor
public class VideoController {
    private VideoService videoService;

    // Each parameter annotated with @RequestParam corresponds to a form field where the String argument is the name of the field
    @PostMapping()
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws IOException {
        videoService.saveVideo(file, name);
        return ResponseEntity.ok("Video saved successfully.");
    }

    // {name} is a path variable in the url. It is extracted as the String parameter annotated with @PathVariable


    @GetMapping()
    public ResponseEntity<List<String>> getAllVideoNames(){
        return ResponseEntity
                .ok(videoService.getAllVideoNames());
    }

}
