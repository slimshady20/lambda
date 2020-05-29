package com.lambda.web.proxy;

import com.lambda.web.movies.Movie;
import com.lambda.web.movies.MovieRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service("movieCrawler")  @Lazy
public class MovieCrawler extends Proxy{
    @Autowired Inventory<Movie> inventory;
    @Autowired Box<String> box;
    @Autowired MovieRepository movieRepository;
    public void movie() {
        inventory.clear();
        try {
            String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements title = d.select("div.tit3");
            Elements gap = d.select("td.range.ac");
            Elements rankDate = d.select("p.r_date");
            Movie movie =null;
            for(int i=0; i<title.size();i++){
                movie = new Movie();
                movie.setRank(string(i+1));
                movie.setTitle(title.get(i).text());
                movie.setGap(gap.get(i).text());
                movie.setRankDate(rankDate.get(0).text());
                movieRepository.save(movie);
            }
        } catch (Exception e) {
            print("에러 발생");
        }
        print("***********크롤링 결과 ******\n");

    }
}
