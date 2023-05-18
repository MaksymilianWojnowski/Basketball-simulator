package org.example;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;


public class Main {

    class Menu{

        void showTeams(){

        }

        void showPlayers(Team team){

        }



    }

    public static void main(String[] args) {


        // Menu




    }
}


 class Team{


    // Variables
    private String name;
    private Integer wins;
    private Integer losses;
    private Integer gamesPlayed;
    private Integer pointsScoredTotal;
    private Integer pointsLostTotal;
    private Double pointsScoredPerGame;
    private Double pointsLostPerGame;
    private Double netDifference;
    private Double offensiveRating;
    private Double defensiveRating;
    public HashMap<String, Player> players = new HashMap<String, Player>();


     public Team(){
         this.name = "";
         this.wins = -1;
         this.losses = -1;
         this.gamesPlayed = -1;
         this.pointsScoredTotal = -1;
         this.pointsLostTotal = -1;
         this.pointsScoredPerGame = -1.0;
         this.pointsLostPerGame = -1.0;
         this.netDifference = -1.0;
         this.offensiveRating = -1.0;
         this.defensiveRating = -1.0;
     }
     public Team(String name){
         this.name = name;
         this.wins = 0;
         this.losses = 0;
     }


    // Methods used to calculate offensive and defensive potential of certain teams

    public void calculateOffensiveRating(){
        this.offensiveRating = 0.1; //placeholder value

    }
    public void calculateDefensiveRating(){
        this.defensiveRating = 0.1; //placeholder value

    }

    public void calculateGamesPlayed(){
        this.gamesPlayed = this.losses + this.wins;
    }

    public void calculateNetDifference(){
        this.netDifference = Math.abs(this.offensiveRating - this.defensiveRating);
    }

    public void calculatePointsScoredPerGame(){
        this.pointsScoredPerGame = Double.valueOf(this.pointsScoredTotal) / Double.valueOf(this.gamesPlayed);
    }

    public void calculatePointsLostPerGame(){
        this.pointsLostPerGame = Double.valueOf(this.pointsLostTotal) / Double.valueOf(this.gamesPlayed);
    }

    // Methods to increment values

    public void addWin() {
        this.wins = this.wins + 1;
    }

    public void addLoss() {
        this.losses = this.losses + 1;
    }

    public void addPlayer(String key, Player player){
        this.players.put(key, player);
    }

    public void addPointsScoredTotal(Integer points){
        this.pointsScoredTotal = this.pointsScoredTotal + points;
    }

    public void addPointsLostTotal(Integer points){
        this.pointsLostTotal = this.pointsLostTotal + points;
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

    public Double getOffensiveRating(){
        return this.offensiveRating;
    }

    public Double getDefensiveRating(){
        return this.defensiveRating;
    }

    public Double getNetDifference(){
        return this.netDifference;
    }


     class StatsReader{
         public void Read(String fileName){

         }
     }


     class Player{

         // Variables
         String name;
         String lastName;
         Double points;
         Double assists;
         Double blocks;
         Double steals;




         // Constructors

         public Player(){
             this.name = "";
             this.lastName = "";
             this.points = -1.0;
             this.assists = -1.0;
             this.blocks = -1.0;
             this.steals = -1.0;

         }
         public Player(String name, String lastName, Double points, Double assists, Double blocks, Double steals){
             this.name = name;
             this.lastName = lastName;
             this.points = points;
             this.assists = assists;
             this.blocks = blocks;
             this.steals = steals;

         }




         // Setters

         public void setName(String name){
             this.name = name;
         }

         public void setLastName(String lastName){
             this.lastName = lastName;
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


         // Getters

         public String getName(){
             return this.name;
         }

         public String getLastName(){
             return this.lastName;
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



         class Superstar extends Player {

             Double roleModifier = 1.25;
             public Superstar(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier){
                 super(name, lastName, points, assists, blocks, steals);
                 this.roleModifier = roleModifier;
             }

             public void setRoleModifier(Double roleModifier){
                 this.roleModifier = roleModifier;
             }

             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }

         class Star extends Player {

             Double roleModifier = 1.1;
             public Star(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier){
                 super(name, lastName, points, assists, blocks, steals);
                 this.roleModifier = roleModifier;
             }

             public void setRoleModifier(Double roleModifier){
                 this.roleModifier = roleModifier;
             }

             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }

         class Starter extends Player {

             Double roleModifier = 1.0;
             public Starter(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier){
                 super(name, lastName, points, assists, blocks, steals);
                 this.roleModifier = roleModifier;
             }

             public void setRoleModifier(Double roleModifier){
                 this.roleModifier = roleModifier;
             }

             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }

         class RolePlayer extends Player {

             Double roleModifier = 1.0;
             public RolePlayer(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier){
                 super(name, lastName, points, assists, blocks, steals);
                 this.roleModifier = roleModifier;
             }

             public void setRoleModifier(Double roleModifier){
                 this.roleModifier = roleModifier;
             }

             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }
         class SixthMan extends Player {

             Double roleModifier = 0.9;
             public SixthMan(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier){
                 super(name, lastName, points, assists, blocks, steals);
                 this.roleModifier = roleModifier;
             }

             public void setRoleModifier(Double roleModifier){
                 this.roleModifier = roleModifier;
             }

             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }

         class BenchPlayer extends  Player{
             Double roleModifier = 0.8;
             public BenchPlayer(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier){
                 super(name, lastName, points, assists, blocks, steals);
                 this.roleModifier = roleModifier;
             }

             public void setRoleModifier(Double roleModifier){
                 this.roleModifier = roleModifier;
             }

             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }


     }


 }



 class Tournament{

    private Integer round;

    // Teams draw
    public ArrayList<Team> Draw(){
        ArrayList<Team> draw = new ArrayList<Team>();

        return draw;
    }


     class GameSimulator{

         public Double firstTeamRandomMultiplier;
         public Double secondTeamRandomMultiplier;

         public Integer firstTeamPointsScored;
         public Integer secondTeamPointsScored;
         public void calculateFirstTeamRandomMultiplier(){
             Random random = new Random();
             this.firstTeamRandomMultiplier = 0.8 + (1.1 - 0.8) * random.nextDouble();

         };
         public void calculateSecondTeamRandomMultiplier(){
             Random random = new Random();
             secondTeamRandomMultiplier = 0.8 + (1.1 - 0.8) * random.nextDouble();

         };

         public Integer getFirstTeamPointsScored(){
             return this.firstTeamPointsScored;
         }

         public Integer getSecondTeamPointsScored(){
             return this.secondTeamPointsScored;
         }

         public boolean getWinner(Team One, Team Two){
             boolean winner=true;
             // Conditional
             return winner;
         }



     }

}




