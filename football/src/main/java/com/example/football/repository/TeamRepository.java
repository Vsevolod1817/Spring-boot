package com.example.football.repository;

import com.example.football.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    // Дополнительные методы, если необходимо
}
