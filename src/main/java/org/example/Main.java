package org.example;

import java.util.HashMap;
import java.util.ArrayList;





public class Main {
    public class Team{

        // Zebrane dane podczas symulacji


        String name;
        Integer wins;
        Integer losses;
        Integer gamesPlayed;
        Double PointsScoredTotal;

        Double PointsLostTotal;
        Double PointsScoredPerGame;
        Double PointsLostPerGame;
        Double NetDifference;

        Double OffensiveRating;

        Double DeffensiveRating;
        HashMap<String, Player> players = new HashMap<String, Player>();


        // Wyliczone na podstawie statystyk zawodnikow
        public Double calculateOffensiveRating(){
            Double ortg=0.1;
            return ortg;
        }

        public Double calculateDefensiveRating(){
            Double drtg=0.1;
            return drtg;
        }

        public String getName() {
            return name;
        }


        public int getWins() {
            return wins;
        }


        public void addWin() {
            wins = wins + 1;
        }

        public int getLosses() {
            return losses;
        }

        public void addLoss() {
            losses = losses + 1;
        }






    }

    public class Player{
        String name;
        String lastName;
        Double points;
        Double assists;
        Double blocks;
        Double steals;
        Double xFactor;
        String role;



        // konstruktory

        public Player(String name, String lastName, Double points, Double assists, Double blocks, Double steals){

        }


        public String getName(){
            return name;
        }

        public String getLastName(){
            return lastName;
        }
        public String getRole(){
            return role;
        }

        public Double getPoints(){
            return points;
        }

        public Double getAssists(){
            return assists;
        }

        public Double getBlocks(){
            return blocks;
        }

        public Double getSteals(){
            return steals;
        }

        public Double getxFactor(){
            return xFactor;
        }


    }



    public class Tournament{

        public ArrayList<Team> Draw(){
            ArrayList<Team> draw = new ArrayList<Team>();
            // Losowanie kolejnosci kto z kim gra
            return draw;
        }



    }
    public class GameSimulator{

        // Wyliczone od 0.9 do 1.1 * offensive rating i defensive rating
        Double FirstTeamRandomMultiplier;
        Double SecondTeamRandomMultiplier;


        public boolean CalculateWinner(Team One, Team Two){
            boolean winner=true;
            // if ktory zdeterminuje kto wygral
            return winner;
        }



    }



    public static void main(String[] args) {


        // Menu




    }
}