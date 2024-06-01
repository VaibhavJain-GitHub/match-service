package com.espncricinfo.matchservice.service;

import com.espncricinfo.matchservice.model.Match;
import com.espncricinfo.matchservice.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long matchId) {
        Optional<Match> match = matchRepository.findById(matchId);
        return match.orElse(null);
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Long matchId, Match matchDetails) {
        if (matchRepository.existsById(matchId)) {
            matchDetails.setId(matchId);
            return matchRepository.save(matchDetails);
        }
        return null;
    }

    public boolean deleteMatch(Long matchId) {
        if (matchRepository.existsById(matchId)) {
            matchRepository.deleteById(matchId);
            return true;
        }
        return false;
    }
}
