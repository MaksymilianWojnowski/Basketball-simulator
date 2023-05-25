package org.example;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {


     static class Menu{

        public static void showTeams(ArrayList<Team> teams){
            for( Team team : teams){
                int i=1;
                System.out.println(i + ". " + team.getName());
                i=i+1;
            }

        }

        public static void  showPlayers(Team team){
            int i=1;
            for(Team.Player player : team.players){
                System.out.println(i + ". " + player.getName() + "  " + player.getLastName() + "  " + player.getPoints() + "  " +  player.getAssists() + "  " + player.getBlocks() + "  " + player.getSteals());
                i++;
            }

        }


        public static void showPlayer(Team.Player player){
            System.out.println("1. Punkty: " + player.getPoints() );
            System.out.println("2. Asysty: " + player.getAssists());
            System.out.println("3. Bloki: " + player.getBlocks());
            System.out.println("4. Przechwyty: " + player.getSteals());
        }


    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Menu menu = new Menu();
        ArrayList<Team> teams = new ArrayList<Team>();


        Team.StatsReader reader = new Team.StatsReader();

        // Celtics

        Team celtics = new Team("Celtics");
        ArrayList<Team.Player> celticsPlayers = new ArrayList<Team.Player>();
        String celticsFile = "D:\\Codeacademy\\Programowanie Obiektowe\\basketball-simulator\\src\\main\\java\\teams-data\\celtics.txt";
        for(int i=0;i<7;i++){
            reader.read(i,celticsFile);
            if(Objects.equals(reader.role(), "Superstar")){

                Team.Player player = new Team.Player.Superstar(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.2
                );
                celtics.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "Star")){
                Team.Player player = new Team.Player.Star(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.1
                );
                celtics.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "Starter")){
                Team.Player player = new Team.Player.Starter(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.0
                );
                celtics.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "RolePlayer")){
                Team.Player player = new Team.Player.RolePlayer(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.9
                );
                celtics.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "SixthMan")){
                Team.Player player = new Team.Player.SixthMan(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.8
                );
                celtics.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "BenchPlayer")){
                Team.Player player = new Team.Player.BenchPlayer(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.7
                );
                celtics.addPlayer(player);
            }
            System.out.println(celtics.players.get(i).getName());
        }

        teams.add(celtics);










        // Menu
        System.out.println("-------NBA PLAYOFFS SIMULATOR-------");
        System.out.println("Wybierz druzyne ktorej sklad chcesz edytowac.");
        Menu.showTeams(teams);
        int inputContinue = 1;
        while(true){

            if(inputContinue == 1){
                int inputTeam = scan.nextInt() - 1;
                Menu.showPlayers(teams.get(inputTeam));
                int inputPlayer = scan.nextInt() - 1;
                Menu.showPlayer( teams.get(inputTeam).players.get(inputPlayer));
                int inputStat = scan.nextInt();

                if(inputStat == 1){
                    System.out.println("Podaj wartosc punktow zdobywanych na mecz przez tego zawodnika: ");
                    Double inputPoints = Double.parseDouble(scan.next());
                    teams.get(inputTeam).players.get(inputPlayer).setPoints(inputPoints);
                }
                if(inputStat == 2){
                    System.out.println("Podaj wartosc asyst zdobywanych na mecz przez tego zawodnika: ");
                    Double inputAsissts = Double.parseDouble(scan.next());
                    teams.get(inputTeam).players.get(inputPlayer).setAssists(inputAsissts);
                }
                if(inputStat == 3){
                    System.out.println("Podaj wartosc asyst zdobywanych na mecz przez tego zawodnika: ");
                    Double inputBlocks = Double.parseDouble(scan.next());
                    teams.get(inputTeam).players.get(inputPlayer).setBlocks(inputBlocks);
                }
                if(inputStat == 4){
                    System.out.println("Podaj wartosc asyst zdobywanych na mecz przez tego zawodnika: ");
                    Double inputSteals = Double.parseDouble(scan.next());
                    teams.get(inputTeam).players.get(inputPlayer).setSteals(inputSteals);
                }

                Menu.showPlayer(teams.get(inputTeam).players.get(inputPlayer));
            }



            System.out.println("1. Wyswietl druzyny.");
            System.out.println("2. Rozpocznij symulacje.");

            inputContinue = scan.nextInt();


        }




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
    public ArrayList<Player> players = new ArrayList<Player>();


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

    public void addPlayer(Player player){
        this.players.add(player);
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


     static class StatsReader{

             String[] array;

             public StatsReader() {}

             public void read(int n, String fileName) {
                 try {
                     Stream<String> lines = Files.lines(Paths.get(fileName));

                     try {
                         String line = (String)lines.skip((long)n).findFirst().get();
                         this.array = line.split(";");
                     } catch (Throwable var6) {
                         if (lines != null) {
                             try {
                                 lines.close();
                             } catch (Throwable var5) {
                                 var6.addSuppressed(var5);
                             }
                         }

                         throw var6;
                     }

                     if (lines != null) {
                         lines.close();
                     }
                 } catch (IOException var7) {
                     System.out.println(var7);
                 }

             }


            public String role() {
              return this.array[0];
             }
            public String name() {
                 return this.array[1];
             }

             public String lastName() {
                 return this.array[2];
             }

             public Double points() {
                 return Double.parseDouble(this.array[3]);
             }

             public Double blocks() {
                 return Double.parseDouble(this.array[4]);
             }

             public Double assists() {
                 return Double.parseDouble(this.array[5]);
             }

             public Double steal() {
                 return Double.parseDouble(this.array[6]);
             }



     }


     static class Player{

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



          static class Superstar extends Player {

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

         static class Star extends Player {

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

         static class Starter extends Player {

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

         static class RolePlayer extends Player {

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
         static class SixthMan extends Player {

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

         static class BenchPlayer extends  Player{
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

         }

         public void calculateSecondTeamRandomMultiplier(){
             Random random = new Random();
             secondTeamRandomMultiplier = 0.8 + (1.1 - 0.8) * random.nextDouble();

         }

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




