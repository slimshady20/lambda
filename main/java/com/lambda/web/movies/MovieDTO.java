package com.lambda.web.movies;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class MovieDTO {
    private String movieSeq,title,rank,gap,rankDate;
}
