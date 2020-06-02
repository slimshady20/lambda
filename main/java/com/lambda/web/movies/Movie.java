package com.lambda.web.movies;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieSeq;
    @Column(length = 4) private String rank;
    @Column(length = 100) private String title;
    @Column(length = 100) private String gap;
    @Column(length = 50) private String rankDate;


    @Builder
    public Movie(String rank, String gap, String title,String rankDate){
        this.rank = rank;
        this.title= title;
        this.gap= gap;
        this.rankDate= rankDate;
    }
}
