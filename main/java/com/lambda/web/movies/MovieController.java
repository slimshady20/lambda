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

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/movie")
public class MovieController extends Proxy {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;// 카운터까지 2개 담으려겨 Object 씀
        @GetMapping("/list/{pageNumber}/{searchWord}")
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
        List<MovieDTO> l = f.apply(pager);
        pxy.print("*******************************");
        for(MovieDTO m : l){ // 향상된 for 문 p 166 for(타입변수명 : 배열또는 컬렉션) {  반복할 문장 }
            pxy.print(m.toString());
        }
     //   pxy.print(l.get(0).toString());
            box.clear();
        box.put("pager" , pager);
        box.put("list",l);
        return box.get();
        }
}
