package com.example.restspringbootexample.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TeamService {

    private final List<String[]> generatedTeams = new ArrayList<>();

    // provide the players input
    public byte[] generateTeamsExcel() throws IOException {
        // total number of players from both the teams,
        // Max we can take only 15 players, for now I am taking only 11 players
        String[] players = {
                "S Gill",  //1
                "V Kohli",   //2
                "H Pandya", //3
                "R Jadeja",    //4
                "M Shami",    //5
                "B Duckett",     //6
                "H Brook",   //7
                "L Livingstone",    //8
                "B Carse",   //9
                "P Salt", //10
                "J Archer"      //11
        };

        // final team size
        int teamSize = 11;
        List<List<String>> combinations = new ArrayList<>();

        // Step 1: Generate all combinations of 11 players
        generateCombinations(players, teamSize, combinations, new ArrayList<>(), 0);

        // Step 2: Generate all unique teams with captain and vice-captain
        List<String[]> uniqueTeams = new ArrayList<>();
        for (List<String> combination : combinations) {
            List<List<String>> permutations = new ArrayList<>();
            generatePermutations(combination, permutations, new ArrayList<>(), new boolean[combination.size()]);

            for (List<String> permutation : permutations) {
                String captain = permutation.get(0);
                String viceCaptain = permutation.get(1);
                List<String> otherPlayers = new ArrayList<>(combination);
                otherPlayers.remove(captain);
                otherPlayers.remove(viceCaptain);

                uniqueTeams.add(new String[]{
                        captain, viceCaptain, otherPlayers.get(0), otherPlayers.get(1), otherPlayers.get(2), otherPlayers.get(3),
                        otherPlayers.get(4), otherPlayers.get(5), otherPlayers.get(6), otherPlayers.get(7), otherPlayers.get(8)
                });
            }
        }

        // Save generated teams for search functionality
        generatedTeams.clear();
        generatedTeams.addAll(uniqueTeams);

        // Step 3: Write results to an Excel file (in-memory)
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Teams");

        // Header row
        Row header = sheet.createRow(0);
        String[] headers = {"SNo", "Captain", "Vice-Captain", "Player3", "Player4", "Player5", "Player6",
                "Player7", "Player8", "Player9", "Player10", "Player11"};
        for (int i = 0; i < headers.length; i++) {
            header.createCell(i).setCellValue(headers[i]);
        }

        // Add rows for each team
        int rowNum = 1;
        int serialNumber = 1;
        for (String[] team : uniqueTeams) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(serialNumber++); // Add serial number
            for (int i = 0; i < team.length; i++) {
                row.createCell(i + 1).setCellValue(team[i]);
            }
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write Excel to byte array
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return out.toByteArray();
    }

    // Search for a team by captain, vice-captain, and other players, and return the serial number
    public Integer searchTeam(String captain, String viceCaptain, List<String> otherPlayers) {
        for (int i = 0; i < generatedTeams.size(); i++) {
            String[] team = generatedTeams.get(i);
            if (team[0].equals(captain) &&
                    team[1].equals(viceCaptain) &&
                    Arrays.asList(team).subList(2, 11).containsAll(otherPlayers)) {
                return i + 1; // Return the serial number (1-based index)
            }
        }
        return null; // Team not found
    }

    private void generateCombinations(String[] players, int teamSize, List<List<String>> result, List<String> temp, int start) {
        if (temp.size() == teamSize) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < players.length; i++) {
            temp.add(players[i]);
            generateCombinations(players, teamSize, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private void generatePermutations(List<String> team, List<List<String>> permutations, List<String> temp, boolean[] used) {
        if (temp.size() == 2) {
            permutations.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < team.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(team.get(i));
                generatePermutations(team, permutations, temp, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

}
