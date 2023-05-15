package org.example;

import java.util.HashMap;
import java.util.ArrayList;





public class Main {
    public class Team{


        // Variables
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


        // Methods used to calculate offensive and defensive potential of certain teams

        public Double calculateOffensiveRating(){
            Double ortg=0.1; //placeholder value
            return ortg;
        }
        public Double calculateDefensiveRating(){
            Double drtg=0.1; //placeholder value
            return drtg;
        }

        // Setters

        public void setName(String name){
            this.name = name;
        }

        public void setWins(int wins){
            this.wins = wins;
        }

        public void setLosses(int Losses){
            this.losses = losses;
        }
        // Getters
        public String getName() {
            return this.name;
        }
        public int getWins() {
            return this.wins;
        }
        public int getLosses() {
            return this.losses;
        }


        // Incrementers

        public void addWin() {
            wins = wins + 1;
        }

        public void addLoss() {
            losses = losses + 1;
        }






    }

    public class Player{

        // Variables
        String name;
        String lastName;
        Double points;
        Double assists;
        Double blocks;
        Double steals;
        Double xFactor;
        String role;



        // Constructors

        public Player(){
            this.name = "";
            this.lastName = "";
            this.points = -1.0;
            this.assists = -1.0;
            this.blocks = -1.0;
            this.steals = -1.0;
            this.xFactor = -1.0;
            this.role = "";
        }
        public Player(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double xFactor, String role){
            this.name = name;
            this.lastName = lastName;
            this.points = points;
            this.assists = assists;
            this.blocks = blocks;
            this.steals = steals;
            this.xFactor = xFactor;
            this.role = role;
        }



        // Setters

        public void setName(String name){
            this.name = name;
        }

        public void setLastName(String lastName){
            this.lastName = lastName;
        }

        public void setRole(String role){
            this.role = role;
        }

        public void setPoints(Double points){
            this.points = points;
        }

        public void setAssists(Double assists){
            this.assists = assists;
        }

        public void setBlocks(Double blocks){
            this.blocks = blocks;
        }

        public void setSteals(Double steals){
            this.steals = steals;
        }

        public void setXfactor(Double xFactor){
            this.xFactor = xFactor;
        }

        // Getters

        public String getName(){
            return this.name;
        }

        public String getLastName(){
            return this.lastName;
        }
        public String getRole(){
            return this.role;
        }

        public Double getPoints(){
            return this.points;
        }

        public Double getAssists(){
            return this.assists;
        }

        public Double getBlocks(){
            return this.blocks;
        }

        public Double getSteals(){
            return this.steals;
        }

        public Double getxFactor(){
            return this.xFactor;
        }


    }



    public class Tournament{

        // Teams draw
        public ArrayList<Team> Draw(){
            ArrayList<Team> draw = new ArrayList<Team>();

            return draw;
        }



    }
    public class GameSimulator{

        // Wyliczone od 0.9 do 1.1 * offensive rating i defensive rating
        public Double FirstTeamRandomMultiplier(){
            Double multiplier = -1.0;
            return multiplier;
        };
        Double SecondTeamRandomMultiplier(){
            Double multiplier = -1.0;
            return multiplier;
        };


        public boolean getWinner(Team One, Team Two){
            boolean winner=true;
            // Conditional
            return winner;
        }



    }

    public class StatsReader{
            public void Read(){

            }
    }

    public class Menu{

        void showTeams(){

        }

        void showPlayers(Team team){

        }

        void showStats(Player player){

        }

    }
    public static void main(String[] args) {


        // Menu




    }
}