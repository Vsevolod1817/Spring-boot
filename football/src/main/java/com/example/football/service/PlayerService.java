package com.example.football.service;

import com.example.football.entity.Player;
import java.util.List;
public interface PlayerService {
    Player getPlayerById(Long id);
    Player savePlayer(Player player);
    Player updatePlayer(Long id, Player updatedPlayer);
    void deletePlayer(Long id);

    List<Player> getAllPlayers();
}
