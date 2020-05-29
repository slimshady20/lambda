package com.lambda.web.proxy;

import com.lambda.web.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pager {
    @Autowired MovieMapper movieMapper;
    private int  rowCount,startRow, endRow,
            pageSize, pageCount,startPage,endPage,nowPage,
            blockCount,blockSize, prevBlock, nextBlock, nowBlock;
    private boolean existPrev , existNext;
    private String search;
    public void paging(){
        rowCount = movieMapper.count();
        pageSize= 5;
        pageCount = (rowCount % pageSize) != 0 ? rowCount/pageSize+1: rowCount/pageSize ;
        blockSize = 5;
        //16
        blockCount= (pageCount % blockSize) != 0 ? pageCount/ blockSize+1: pageCount/blockSize;
        nowPage = 1;
        startRow =  (nowPage -1)*pageSize+1;
        endRow = (nowPage==pageCount) ? rowCount : nowPage*pageSize;
        nowBlock = (nowPage / blockSize) != 0 ? nowPage/blockSize+1: nowPage/blockSize;
        startPage = (nowBlock-1)*blockSize+1;
        endPage =(nowBlock==blockCount) ? pageCount : nowPage*blockSize;
        prevBlock= startPage -blockSize;
        nextBlock= startPage + blockSize;
        existPrev= (nowBlock != 1); // true false 생략가능  ? true: false;
        existNext = (nowBlock != blockCount);
    }

}
