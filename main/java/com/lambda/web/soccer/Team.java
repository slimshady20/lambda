package com.lambda.web.soccer;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="team")
@Data
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 자동증가
    private Long teamNo;
    @NotNull @Column(length = 10) private String team_id;
    @Column(length = 10) private String regionName;
    @Column(length = 40) private String teamName;
    @Column(length = 50) private String eTeamName;
    @Column(length = 10) private String origYyyy;
    @Column(length = 10) private String zipCode1;
    @Column(length = 10) private String zipCode2;
    @Column(length = 80) private String address;
    @Column(length = 10) private String ddd;
    @Column(length = 10) private String tel;
    @Column(length = 50) private String fax;
    @Column(length = 10) private String homepage;
    @Column(length = 10) private String owner;

    @Builder
            public Team(String team_id,String regionName,String teamName,String origYyyy,
                  String zipCode1,String zipCode2,String address, String ddd,String tel,String fax,
                  String homepage,String owner){
        this.team_id =team_id;
        this.regionName =regionName;
        this.teamName =teamName;
        this.origYyyy =origYyyy;
        this.zipCode1 =zipCode1;
        this.zipCode2 =zipCode2;
        this.address =address;
        this.ddd =ddd;
        this.tel =tel;
        this.fax =fax;
        this.homepage =homepage;
        this.owner =owner;

    }
    @OneToMany(mappedBy = "teamOfPlayer")
    private List<Player> players;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id") @NotNull
    private Stadium stadiumOfTeam;
}
