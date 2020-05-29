package com.lambda.web.music;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MusicDTO {
    private String seq,  title,  artists,  thumbnail,  album;
    // 마이바티스 이용할떄
}
