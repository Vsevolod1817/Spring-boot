package com.example.football.service.impl;

import com.example.football.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.PostConstruct;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @PostConstruct
    public void initializeTestData() {
        Team teamA = new Team();
        teamA.setName("TeamA");

        Team teamB = new Team();
        teamB.setName("TeamB");

        teamRepository.save(teamA);
        teamRepository.save(teamB);

        // Добавьте дополнительные данные, если необходимо
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Long id, Team updatedTeam) {
        Team existingTeam = teamRepository.findById(id).orElse(null);

        if (existingTeam != null) {
            existingTeam.setName(updatedTeam.getName());

            // Вы можете добавить другие поля для обновления, если необходимо

            return teamRepository.save(existingTeam);
        } else {
            // Обработка случая, когда команда с указанным ID не найдена
            return null;
        }
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
