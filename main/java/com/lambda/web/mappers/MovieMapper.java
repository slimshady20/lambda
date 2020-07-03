package com.lambda.web.mappers;

import com.lambda.web.movies.MovieDTO;
import com.lambda.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieMapper {
   // public int insertMovie(MovieDTO movie);
    public void insertMovie(MovieDTO movie);
    public void updateMovie(MovieDTO movie);
    public void deleteMovie(MovieDTO movie);
    public int count();
    public List<MovieDTO> selectMovies(Pager pager);
    public MovieDTO selectMovie(String movieSEq); //movieSeq value로 해도됨 MovieMappper랑 비교하면서 쓰는것임
    //not found, mapper 어쩌구저쩌구 뜨면 여기나 MoiveMapper.xml에서 문제가 있는것

}
