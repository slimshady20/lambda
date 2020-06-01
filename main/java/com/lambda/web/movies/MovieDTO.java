package com.lambda.web.movies;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Component
public class MovieDTO {
    private String movieSeq,title,rank,gap,rankDate;

    public String getMovieSeq() {
        return movieSeq;
    }

    public void setMovieSeq(String movieSeq) {
        this.movieSeq = movieSeq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieSeq='" + movieSeq + '\'' +
                ", title='" + title + '\'' +
                ", rank='" + rank + '\'' +
                ", gap='" + gap + '\'' +
                ", rankDate='" + rankDate + '\'' +
                '}';
    }
}
