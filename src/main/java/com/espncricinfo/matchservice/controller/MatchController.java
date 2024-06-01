package com.espncricinfo.matchservice.controller;

import com.espncricinfo.matchservice.model.Match;
import com.espncricinfo.matchservice.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Match Controller", description = "CRUD operations for Matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Operation(summary = "Get all matches")
    @GetMapping("/")
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @Operation(summary = "Get match by ID")
    @GetMapping("/{matchId}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long matchId) {
        Match match = matchService.getMatchById(matchId);
        return match != null ? ResponseEntity.ok(match) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new match")
    @PostMapping("/")
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match createdMatch = matchService.createMatch(match);
        return ResponseEntity.status(201).body(createdMatch);
    }

    @Operation(summary = "Update match")
    @PutMapping("/{matchId}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long matchId, @RequestBody Match matchDetails) {
        Match updatedMatch = matchService.updateMatch(matchId, matchDetails);
        return updatedMatch != null ? ResponseEntity.ok(updatedMatch) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete match")
    @DeleteMapping("/{matchId}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long matchId) {
        boolean isDeleted = matchService.deleteMatch(matchId);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
