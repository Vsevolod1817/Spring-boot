package com.example.football.service;

import com.example.football.entity.Team;
import java.util.List;
public interface TeamService {
    Team getTeamById(Long id);
    Team saveTeam(Team team);
    Team updateTeam(Long id, Team updatedTeam);
    void deleteTeam(Long id);

    List<Team> getAllTeams();
}
