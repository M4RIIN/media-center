package com.lagrange.mediacenter.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.*;

@Service
public class StreamingService {

    private static final String FORMAT = "classpath:videos/%s.mp4";

    @Value( "${mediapath.url}" )
    private String mediaPath;

    public Mono<Resource> getVideo(String title) throws IOException {
        //return Mono.fromSupplier(() -> this.resourceLoader.getResource(String.format(FORMAT, title)));
        File fle =  new File(mediaPath + "futurama.mp4");
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

}