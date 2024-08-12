package com.nbavis.nbavisualstats.player;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    void deleteByid(Integer id);

    Optional<Player> findByid(Integer id);
}
