package com.java10x.elifoot.repository;

import com.java10x.elifoot.entity.Player;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    //    @EntityGraph()
    List<Player> findByClubId(Long clubId);

}
