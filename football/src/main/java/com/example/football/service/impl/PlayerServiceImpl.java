package com.example.football.service.impl;

import com.example.football.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @PostConstruct
    public void initializeTestData() {
        Player player1 = new Player();
        player1.setFirstName("John");
        player1.setLastName("Doe");
        player1.setDateOfBirth(LocalDate.of(1990, 5, 15));
        player1.setTeam("TeamA");
        player1.setExperience(5);
        player1.setSalary(50000);

        playerRepository.save(player1);

        // Добавьте дополнительные данные, если необходимо
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Long id, Player updatedPlayer) {
        Player existingPlayer = playerRepository.findById(id).orElse(null);

        if (existingPlayer != null) {
            existingPlayer.setFirstName(updatedPlayer.getFirstName());
            existingPlayer.setLastName(updatedPlayer.getLastName());
            existingPlayer.setMiddleName(updatedPlayer.getMiddleName());
            existingPlayer.setDateOfBirth(updatedPlayer.getDateOfBirth());
            existingPlayer.setTeam(updatedPlayer.getTeam());
            existingPlayer.setExperience(updatedPlayer.getExperience());
            existingPlayer.setSalary(updatedPlayer.getSalary());

            // Вы можете добавить другие поля для обновления, если необходимо

            return playerRepository.save(existingPlayer);
        } else {
            // Обработка случая, когда игрок с указанным ID не найден
            return null;
        }
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
