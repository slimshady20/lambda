package com.lambda.web.movies;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.proxy.Box;
import com.lambda.web.proxy.IFunction;
import com.lambda.web.proxy.Pager;
import com.lambda.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;// 카운터까지 2개 담으려겨 Object 씀
        @GetMapping("/{searchWord}/{pageNumber}")  //  @GetMapping("/list/{pageNumber}/{searchWord}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                                   @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("null")){  //front단에 null 로 보낸것 movie.vue에
            pxy.print("검색어가 없음");
            pager.setSearchWord(""); // ""그래야 mybatis에서는 null로 먹힘
        }else{
            pxy.print("검색어가 " + searchWord);
            pager.setSearchWord(searchWord);
        }
        pxy.print("넘어온페이지번호"+pageNumber);
        pager.setNowPage(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        IFunction<Pager, List<MovieDTO>> f = p -> movieMapper.selectMovies(p);
        // parameterType = Pager, resultType = MovieDTO in MoiveMapper.xml
        List<MovieDTO> list = f.apply(pager);
        pxy.print("*******************************");
        for(MovieDTO m : list){ // 향상된 for 문 p 166 for(타입변수명 : 배열또는 컬렉션) {  반복할 문장 }
            pxy.print(m.toString());
        }
       // pxy.print(list.get(0).toString());
        box.clear();
        box.put("pager" , pager);
        box.put("list",list);
        return box.get();
        }
        @GetMapping("/{searchWord}")
        public MovieDTO detail(@PathVariable("searchWord") String searchWord){
        pxy.print(movieMapper.selectMovie(searchWord).toString());
            return movieMapper.selectMovie(searchWord);
//
//        @GetMapping("/{searchWord}")
//    public MovieDTO detail(@PathVariable("searchWord") String searchWord){
//            pxy.print("검색어" + searchWord);
//            Function<String,MovieDTO> f = p -> movieMapper.selectMovie(p);
//            MovieDTO findOne = f.apply(searchWord);
//            pxy.print(findOne.toString());
//            box.clear();
//            return f.apply(searchWord);
        }

}
