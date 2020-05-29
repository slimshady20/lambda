package com.lambda.web.proxy;

import com.lambda.web.movies.Movie;
import com.lambda.web.movies.MovieRepository;
import com.lambda.web.music.Music;
import com.lambda.web.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProxyController{
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired MovieCrawler movieCrawler;
    @Autowired Proxy pxy;
    @Autowired FileUploader uploader;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieRepository movieRepository;

    @PostMapping("/bugsmusic")
    public HashMap<String,Object> bugsmusic(@RequestBody String searchWord){
        pxy.print("넘어온 키워드: "+searchWord);
        box.clear();
        if(musicRepository.count()== 0) crawler.bugsMusic();
       //     ArrayList<HashMap<String, String>> list = crawler.bugsMusic();
        //  pxy.print("*********");
      //   pxy.print("조회한 수: "+list.size());
        List<Music> list  = musicRepository.findAll();
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }
    @GetMapping("/soccer/{searchWord}")
    public HashMap<String,String> soccer(@PathVariable String searchWord){
        pxy.print("넘어온 키워드"+ searchWord);
        uploader.upload();
        return null;
            }
    @GetMapping("/movie/{searchWord}")
    public HashMap<String,Object> movie(@PathVariable String searchWord){
        pxy.print("px넘어온 키워드:  " + searchWord);
        box.clear();
        movieCrawler.movie();
        List<Movie> list = movieRepository.findAll();
        box.put("list",list);
        box.put("count",list.size());
        return box.get();
    }
}

