package com.lambda.web.movies;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name="movie")
@Getter
@Setter
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

    public Long getMovieSeq() {
        return movieSeq;
    }

    public void setMovieSeq(Long movieSeq) {
        this.movieSeq = movieSeq;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGap() {
        return gap;
    }

    public void setGap(String gap) {
        this.gap = gap;
    }

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }
}
