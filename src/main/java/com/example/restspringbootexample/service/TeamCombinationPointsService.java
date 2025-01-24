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
                new Player("Kerr", 80), //1
                new Player("Manenti", 54),  //2
                new Player("Phillipe", 100), //3
                new Player("Hatzoglou", 70),    //4
                new Player("Henriques", 135),    //5
                new Player("Jordan", 101),   //6
                new Player("Wade", 135), //7
                new Player("Nikhil", 184),    //8
                new Player("Ellis", 101),   //9
                new Player("Jack", 245),  //10
                new Player("Perry", 58),    //11
                new Player("Tim", 147),  //12
                new Player("Jewell", 78), //13
                new Player("Meredith", 135),    //14
                new Player("Chohan", 60),    //15
                new Player("Gannon", 45),  //16
                new Player("Shaw", 28),    //17
                new Player("Mcdermott", 147),  //18
                new Player("Owen", 78), //19
                new Player("Patterson", 55),    //20
                new Player("Silk", 101),    //21
                new Player("Dwarshuis", 135)     //22
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