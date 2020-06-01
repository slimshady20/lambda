package com.lambda.web.movies;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.proxy.Crawler;
import com.lambda.web.proxy.ISupplier;
import com.lambda.web.proxy.MovieCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieInitializer implements ApplicationRunner { //DB에 안들어갈때 해결법
    @Autowired MovieMapper movieMapper;//DB에있는거 가져와야하니까
    @Autowired MovieCrawler movieCrawler;
    @Override
    public void run(ApplicationArguments args) throws Exception {
       // ISupplier<Integer> s =() -> movieMapper.count();  리턴타입 count 는 int니까
        ISupplier<Integer> s = movieMapper :: count;
        // int i = s.get();
        if(s.get() == 0) movieCrawler.movie();  // 한줄이면 {} 생략 가능.
    }
}
// 이거하는이유 크롤링하려고 DB에 아무것도 없을 때
// count 가져올때 파라미터, 리턴값이 있는지 생각해라. SUpplier써야함