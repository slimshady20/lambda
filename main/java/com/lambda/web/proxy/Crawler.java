package com.lambda.web.proxy;

import com.lambda.web.movies.Movie;
import com.lambda.web.movies.MovieRepository;
import com.lambda.web.music.Music;
import com.lambda.web.music.MusicRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
@Service("crawler")  @Lazy
public class Crawler extends Proxy{
    @Autowired Inventory<Music> inventory; //jPA 사용해서 DB에 저장하려고 HASHMAP대신에 이거씀
    @Autowired Box<String> box;
    @Autowired MusicRepository musicRepository;
    public void bugsMusic(){
        inventory.clear();
        try{
            String url = "https://music.bugs.co.kr/chart";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements title = d.select("p.title");
            Elements artist = d.select("p.artist");
            Elements thumbnail = d.select("a.thumbnail");
            Elements album = d.select("a.album");
              Music music = null;
            for(int i=0;i < title.size(); i++){
                music = new Music();
                music.setSeq(string(i+1));
                music.setTitle(title.get(i).text());
                music.setArtists(artist.get(i).text());
                music.setThumbnail(thumbnail.get(i).select("img").attr("src"));
                music.setAlbum(album.get(i).text()) ;
                musicRepository.save(music);
                //inventory.add(map);
            }
        }catch(Exception e){
            print("에러 발생");
        }
        print("******************** 크롤링 결과 *****************\n");
        //inventory.get().forEach(System.out::print);
      //  print(inventory.get().get(0).toString());
      //  return inventory.get();
    }

}
