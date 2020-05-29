package com.lambda.web.mappers;

import com.lambda.web.movies.Movie;
import com.lambda.web.movies.MovieDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMapper {
    public void insertMovie();
    public int count();

}
