package com.example.restspringbootexample.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamCombinationPointsService {

    static class Player {
        String name;
        int points;

        Player(String name, int points) {
            this.name = name;
            this.points = points;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", points=" + points +
                    '}';
        }
    }
    List<String[]> allConfigurations = new ArrayList<>();

    public String generateCombinations() {
        // Define 22 players with points
        List<Player> players = Arrays.asList(
                new Player("Behrendroff", 515), new Player("Scott", 105), new Player("Morris", 389),
                new Player("Connolly", 579), new Player("Agar", 343), new Player("Fanning", 78),
                new Player("Hardie", 315), new Player("Baardman", 56), new Player("Carey", 53),
                new Player("Dogget", 180), new Player("Matthew", 478), new Player("Ross", 391),
                new Player("Darcy", 417), new Player("Turner", 386), new Player("Hobson", 253),
                new Player("Ram", 100), new Player("Shyam", 101), new Player("Dheeraj", 102),
                new Player("kumar", 103), new Player("mayne", 104), new Player("banti", 105),
                new Player("alice", 106)
        );

        // Sort players by points in descending order
        players.sort(Comparator.comparingInt(player -> -player.points));
        players.stream().forEach(System.out::println);

        // Select any number of players out of 22 players, (Currently I am taking all 22 players)
        List<Player> topPlayers = players.subList(0, 22);
        System.out.println("#####################################");
        topPlayers.stream().forEach(System.out::println);

        // Generate all combinations of 11 players out of 22 players

        int sno = 1;
        for (Player captain : topPlayers) {
            for (Player viceCaptain : topPlayers) {
                if (!captain.equals(viceCaptain)) {
                    List<Player> remainingPlayers = new ArrayList<>(topPlayers);
                    remainingPlayers.remove(captain);
                    remainingPlayers.remove(viceCaptain);

                    int totalPoints = topPlayers.stream().mapToInt(player -> player.points).sum();

                    allConfigurations.add(new String[]{
                            String.valueOf(sno++),
                            captain.name,
                            viceCaptain.name,
                            remainingPlayers.get(0).name,
                            remainingPlayers.get(1).name,
                            remainingPlayers.get(2).name,
                            remainingPlayers.get(3).name,
                            remainingPlayers.get(4).name,
                            remainingPlayers.get(5).name,
                            remainingPlayers.get(6).name,
                            remainingPlayers.get(7).name,
                            remainingPlayers.get(8).name,
                            totalPoints + ""
                    });
                }
            }
        }

        // Write to Excel
        return writeToExcel(allConfigurations, "TopTeamCombinations.xlsx");
    }

    public String searchTeam(String captain, String viceCaptain, List<String> playerNames) {
        for (String[] team : allConfigurations) {
            String serialNumber = team[0]; // Get SNo
            String teamCaptain = team[1];
            String teamViceCaptain = team[2];

            // Check if captain and vice-captain match
            if (teamCaptain.equalsIgnoreCase(captain) && teamViceCaptain.equalsIgnoreCase(viceCaptain)) {
                List<String> teamPlayers = new ArrayList<>(List.of(team));
                teamPlayers.remove(0); // Remove SNo
                String totalPoints = teamPlayers.remove(teamPlayers.size() - 1); // Remove total points
                teamPlayers.remove(0); // Remove captain
                teamPlayers.remove(0); // Remove vice-captain

                // Check if all provided player names match the team players
                if (playerNames == null || teamPlayers.containsAll(playerNames)) {
                    return "Team found at SNo: " + serialNumber + "\n" +
                            "Details: Captain: " + teamCaptain + ", Vice-Captain: " + teamViceCaptain + ", Players: " + teamPlayers + "\n" +
                            "Total Points: " + totalPoints;
                }
            }
        }
        return "No matching team found!";
    }

    private String writeToExcel(List<String[]> data, String fileName) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Combinations");

            // Create header row
            String[] headers = {"SNo", "Captain", "ViceCaptain", "Player3", "Player4", "Player5", "Player6",
                    "Player7", "Player8", "Player9", "Player10", "Player11", "Total Points"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Add data rows
            int rowIndex = 1;
            for (String[] row : data) {
                Row excelRow = sheet.createRow(rowIndex++);
                for (int i = 0; i < row.length; i++) {
                    excelRow.createCell(i).setCellValue(row[i]);
                }
            }

            // Save Excel file
            String filePath = System.getProperty("user.dir") + "/" + fileName;
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
            return filePath;

        } catch (IOException e) {
            e.printStackTrace();
            return "Error while writing to Excel file.";
        }
    }
}