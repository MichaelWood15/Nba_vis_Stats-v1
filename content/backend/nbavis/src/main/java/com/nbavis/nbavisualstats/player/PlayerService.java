package com.nbavis.nbavisualstats.player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByid(Integer id) {
        System.out.println(id);
        return playerRepository.findAll().stream()
                .filter(player -> id.equals(player.getid()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeam(String team) {
        return playerRepository.findAll().stream()
                .filter(player -> team.toLowerCase().contains(player.getTeam().toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String name) {
        String lowerCaseName = name.toLowerCase();

        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(lowerCaseName))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByNameandTeam(String name, String team) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(player.getName().toLowerCase())
                        && player.getTeam().toLowerCase().contains(player.getTeam().toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPoints(float points) {

        return playerRepository.findAll().stream()
                .filter(player -> player.getPpg() > (points))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByAssists(float assists) {

        return playerRepository.findAll().stream()
                .filter(player -> player.getApg() > (assists))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByRebounds(float rebounds) {

        return playerRepository.findAll().stream()
                .filter(player -> player.getRb() > (rebounds))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersBythreePointPercentage(float threepp) {

        return playerRepository.findAll().stream()
                .filter(player -> player.getthreePointerPercentage() > (threepp))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByid(updatedPlayer.getid());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setid(updatedPlayer.getid());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }

        return null; // if nothing found in database
    }

    @Transactional
    public void deletePlayer(Integer playerid) {
        playerRepository.deleteByid(playerid);
    }
}
