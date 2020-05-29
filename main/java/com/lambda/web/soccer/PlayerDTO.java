package com.lambda.web.soccer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class PlayerDTO {
    private String
            playerId,
            playerName,
            ePlayerName,
            nickName,
             joinYyyy,
            position,
            backNo,
             nation,
               birthDate,
               solar,
            height,
               weight;


}
