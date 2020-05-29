package com.lambda.web.soccer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Jpa 방식
public interface PlayerRepository  extends JpaRepository<Player,Long> {

}
