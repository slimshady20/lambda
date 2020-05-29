package com.lambda.web.soccer;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity @Lazy // Entity class 라고 부름 ORM O= class R= entity M가 entity,class 연결
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PlayerNO;
   @NotNull
   @Column(length = 10) private String playerId;
   @NotNull @Column(length = 20) private String playerName;
    @Column(length = 40) private String ePlayerName;
    @Column(length = 30) private String nickName;
    @Column(length = 10) private String joinYyyy;
    @Column(length = 10) private String position;
    @Column(length = 30) private String backNo;
    @Column(length = 20) private String nation;
    @Column(length = 20) private String birthDate;
    @Column(length = 10) private String solar;
    @Column(length = 30) private String height;
    @Column(length = 30) private String weight;
    public Player(){}
    @Builder
    public Player(String playerId,String playerName,String ePlayerName,String nickName,
                  String joinYyyy,String position,String backNo, String nation,String birthDate,String solar,
                  String height,String weight){
                this.playerId =playerId;
                this.playerName =playerName;
                this.ePlayerName =ePlayerName;
                this.nickName =nickName;
                this.joinYyyy =joinYyyy;
                this.position =position;
                this.backNo =backNo;
                this.nation =nation;
                this.birthDate =birthDate;
                this.solar =solar;
                this.height =height;
                this.weight =weight;

    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="team_id")
    private Team teamOfPlayer;

    public Long getPlayerNO() {
        return PlayerNO;
    }

    public void setPlayerNO(Long playerNO) {
        PlayerNO = playerNO;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getePlayerName() {
        return ePlayerName;
    }

    public void setePlayerName(String ePlayerName) {
        this.ePlayerName = ePlayerName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getJoinYyyy() {
        return joinYyyy;
    }

    public void setJoinYyyy(String joinYyyy) {
        this.joinYyyy = joinYyyy;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSolar() {
        return solar;
    }

    public void setSolar(String solar) {
        this.solar = solar;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Team getTeamOfPlayer() {
        return teamOfPlayer;
    }

    public void setTeamOfPlayer(Team teamOfPlayer) {
        this.teamOfPlayer = teamOfPlayer;
    }

    @Override
    public String toString() {
        return "Player{" +
                "PlayerNO=" + PlayerNO +
                ", playerId='" + playerId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", ePlayerName='" + ePlayerName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", joinYyyy='" + joinYyyy + '\'' +
                ", position='" + position + '\'' +
                ", backNo='" + backNo + '\'' +
                ", nation='" + nation + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", solar='" + solar + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", teamOfPlayer=" + teamOfPlayer +
                '}';
    }
}


