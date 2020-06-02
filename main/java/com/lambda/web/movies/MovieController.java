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
        if(searchWord.equals("")){
            pxy.print("검색어가 없음");
        }else{
            pxy.print("검색어가 " + searchWord);
        }

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
     //   pxy.print(l.get(0).toString());
            box.clear();
        box.put("pager" , pager);
        box.put("list",list);
        return box.get();
        }
}
