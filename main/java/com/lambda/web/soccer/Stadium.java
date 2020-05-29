package com.lambda.web.soccer;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="stadium")
@Data
public class Stadium {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 자동증가
    private Long stadiumNo;
    @NotNull @Column(length = 10) private String stadium_id;
    @Column(length = 40) private String stadiumName;
    @Column(length = 10) private String hometeamId;
    @Column(length = 30) private String seatCount;
    @Column(length = 60) private String address;
    @Column(length = 10) private String ddd;
    @Column(length = 10) private String tel;

    @Builder
    public Stadium(String stadium_id,String stadiumName,String hometeamId,String seatCount,
                String address,String ddd,String tel){
        this.stadium_id =stadium_id;
        this.stadiumName =stadiumName;
        this.hometeamId =hometeamId;
        this.seatCount =seatCount;
        this.address =address;
        this.ddd =ddd;
        this.tel =tel;
            }
    @OneToMany(mappedBy = "stadiumOfTeam")
    private List<Team> teams;
    @OneToMany(mappedBy = "stadiumOfSchedule")
    private List<Schedule> schedules;

}