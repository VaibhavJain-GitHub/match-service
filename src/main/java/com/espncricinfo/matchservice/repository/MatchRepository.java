package com.espncricinfo.matchservice.repository;

import com.espncricinfo.matchservice.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}