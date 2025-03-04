package com.example.restspringbootexample.controller;

import com.example.restspringbootexample.service.TeamCombinationPointsService;
import com.example.restspringbootexample.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/all-teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamCombinationPointsService teamCombinationPointsService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/team-combination-with-points")
    public ResponseEntity<String> generateCombinations() {
        String filePath = teamCombinationPointsService.generateCombinations();
        return ResponseEntity.ok("Excel file generated successfully at: " + filePath);

    }

    @PostMapping("/search-team-with-points")
    public String searchTeam(
            @RequestParam String captain,
            @RequestParam String viceCaptain,
            @RequestBody(required = false) List<String> players
    ) {
        return teamCombinationPointsService.searchTeam(captain, viceCaptain, players);
    }

    @GetMapping("/generate-teams")
    public ResponseEntity<byte[]> generateTeams() {
        try {
            byte[] excelData = teamService.generateTeamsExcel();

            // Prepare HTTP response with the Excel file
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=Unique_Teams.xlsx");

            return new ResponseEntity<>(excelData, headers, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/search-team-number")
    public ResponseEntity<String> searchTeamNumber(
            @RequestParam String captain,
            @RequestParam String viceCaptain,
            @RequestBody List<String> otherPlayers) {
        Integer serialNumber = teamService.searchTeam(captain, viceCaptain, otherPlayers);
        if (serialNumber != null) {
            return ResponseEntity.ok("Team found with SNo: " + serialNumber);
        } else {
            return ResponseEntity.ok("Team not found in the generated combinations.");
        }
    }
}



