package com.nbavis.nbavisualstats.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Float points,
            @RequestParam(required = false) Float rebounds,
            @RequestParam(required = false) Float assists,
            @RequestParam(required = false) Float threePointPercentage) {
        if (team != null && name != null) {
            return playerService.getPlayersByNameandTeam(name, team);
        } else if (team != null) {
            return playerService.getPlayersByTeam(team);
        } else if (name != null) {
            return playerService.getPlayersByName(name);
        } else if (points != null) {
            return playerService.getPlayersByPoints(points);
        } else if (assists != null) {
            return playerService.getPlayersByAssists(assists);
        } else if (rebounds != null) {
            return playerService.getPlayersByRebounds(rebounds);
        } else if (threePointPercentage != null) {
            return playerService.getPlayersBythreePointPercentage(threePointPercentage);
        } else
            return playerService.getPlayers();
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(player);
        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        }

        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{playerid}")
    public ResponseEntity<Integer> deletePlayer(@PathVariable Integer playerid) {
        playerService.deletePlayer(playerid);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
