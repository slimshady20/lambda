package com.lambda.web.movies;

import com.lambda.web.music.MusicDTO;
import lombok.Data;

import org.springframework.stereotype.Component;
@Data
@Component
public class MovieDTO {
    private String seq,  title,  artists,  thumbnail,  album;
    private MusicDTO ost;
}
