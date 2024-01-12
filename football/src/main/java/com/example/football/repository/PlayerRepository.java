package com.example.football.repository;

import com.example.football.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Дополнительные методы, если необходимо
}
