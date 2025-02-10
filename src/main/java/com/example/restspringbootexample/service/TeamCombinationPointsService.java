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
                new Player("S Yadav", 29), //1
                new Player("B Duckett", 24),  //2
                new Player("P Salt", 27), //3
                new Player("S Samson", 87),    //4
                new Player("A Sharma", 170),    //5
                new Player("J Buttler", 159),   //6
                new Player("A Patel", 126), //7
                new Player("L Livingstone", 47),    //8
                new Player("A Rashid", 78),   //9
                new Player("V Chakravarthy", 173),  //10
                new Player("M Wood", 48),    //11
                new Player("A Singh", 94),  //12
                new Player("J Archer", 115), //13
                new Player("R Bishnoi", 31),    //14
                new Player("B Carse", 149),    //15
                new Player("H Pandya", 98),  //16
                new Player("J Overton", 40),    //17
                new Player("W Sundar", 70),  //18
                new Player("T Verma", 142), //19
                new Player("H Brook", 53),    //20
                new Player("J Smith", 37),    //21
                new Player("D Jurel", 22)     //22
        );

        // Sort 22 players by points in descending order
        players.sort(Comparator.comparingInt(player -> -player.points));
        players.stream().forEach(System.out::println);

        // Select 11 players out of 22 players based on highest points
        List<Player> topPlayers = players.subList(0, 11);
        System.out.println("#####################################");
        topPlayers.stream().forEach(System.out::println);

        // Generate all combinations of 11 players
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