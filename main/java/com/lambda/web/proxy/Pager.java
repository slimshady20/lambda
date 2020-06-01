package com.lambda.web.proxy;

import com.lambda.web.mappers.MovieMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Component
public class Pager {
    @Autowired MovieMapper movieMapper;
   private int rowCount,rowStart,rowEnd,
        pageCount,pageSize,pageStart,pageEnd,nowPage,
    blockCount,blockSize,prevBlock, nextBlock, nowBlock;
   public void paging(){
       rowCount = movieMapper.count();
       rowStart = nowPage * pageSize; // 0
       rowEnd = (nowPage != (pageCount -1)) ? rowStart + ( pageSize-1): rowCount-1; // 4 0부터 시작하니 pagecount -1 해서 하나씩 낮춰줘야함 nowPage가 index
       pageCount = (rowCount % pageSize != 0) ? rowCount / pageSize+1 : rowCount / pageSize; // 10
     //  pageSize =5;
       pageStart = nowBlock * blockSize;
       pageEnd = (nowBlock != blockCount -1)? pageStart + ( blockSize - 1 ) : pageCount-1;
    //   nowPage = 1;
       blockCount = (pageCount % blockSize) != 0 ? pageCount / blockSize +1 : pageCount / blockSize;
    //   blockSize = 5;
       prevBlock = pageStart - blockSize;
       nextBlock = pageStart + blockSize;
       nowBlock= nowPage / blockSize;
   }

    public MovieMapper getMovieMapper() {
        return movieMapper;
    }

    public void setMovieMapper(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getRowStart() {
        return rowStart;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public void setRowEnd(int rowEnd) {
        this.rowEnd = rowEnd;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public int getPrevBlock() {
        return prevBlock;
    }

    public void setPrevBlock(int prevBlock) {
        this.prevBlock = prevBlock;
    }

    public int getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(int nextBlock) {
        this.nextBlock = nextBlock;
    }

    public int getNowBlock() {
        return nowBlock;
    }

    public void setNowBlock(int nowBlock) {
        this.nowBlock = nowBlock;
    }
}
