package com.lambda.web.music;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Entity(name="music") @Component
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 자동증가
    private Long musicNo;
    @Column(length = 4) private String seq;
    @Column(length = 200) private String title;
    @Column(length = 200) private String artists;
    @Column(length = 500) private String thumbnail;
    @Column(length = 200) private String album;

    public Music(){}
    @Builder
    public Music(String seq, String title, String artists, String thumbnail, String album) {
        this.seq = seq;
        this.title = title;
        this.artists =artists;
        this.thumbnail = thumbnail;
        this.album = album;
    }

    public Long getMusicNo() {
        return musicNo;
    }

    public void setMusicNo(Long musicNo) {
        this.musicNo = musicNo;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
