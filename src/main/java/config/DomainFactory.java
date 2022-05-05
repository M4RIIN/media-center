package config;

import com.lagrange.mediacenter.bdd.repositories.VideoRepository;
import com.lagrange.mediacenter.domain.StreamingService;
import com.lagrange.mediacenter.services.VideoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainFactory {

    @Bean
    public VideoService videoService(VideoRepository videoRepository){
        return new StreamingService(videoRepository);
    }
}
