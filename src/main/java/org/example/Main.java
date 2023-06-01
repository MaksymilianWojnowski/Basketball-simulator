package org.example;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {


     static class Menu{

        public static void showTeams(ArrayList<Team> teams){
            int i=1;
            for( Team team : teams){

                System.out.println(i + ". " + team.getName());
                i=i+1;
            }

        }

        public static void  showPlayers(Team team){
            int i=1;
            System.out.println("Lp" + ". " + "Imie" + "  " + "Nazwisko" + "  " + "Punkty" + "  " +  "Asysty" + "  " + "Bloki" + "  " + "Przechwyty");
            for(Team.Player player : team.players){
                System.out.println(i + ". " + player.getName() + "  " + player.getLastName() + "  " + player.getPoints() + "  " +  player.getAssists() + "  " + player.getBlocks() + "  " + player.getSteals());
                i++;
            }

        }


        public static void showPlayer(Team.Player player){
            System.out.println(player.getName() + "  " + player.getLastName() );
            System.out.println("1. Punkty: " + player.getPoints() );
            System.out.println("2. Asysty: " + player.getAssists());
            System.out.println("3. Bloki: " + player.getBlocks());
            System.out.println("4. Przechwyty: " + player.getSteals());
        }



    }



    public static void main(String[] args) {

        // Scanner

        Scanner scan = new Scanner(System.in);

        // Array of all teams

        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<Team> teamsCopy = new ArrayList<>();

        // Teams data import

        Team.StatsReader reader = new Team.StatsReader();

        // Celtics

        Team celtics = new Team("Celtics");

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
                        1.2,
                        "Superstar"
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
                        1.1,
                        "Star"
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
                        1.0,
                        "Starter"
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
                        0.9,
                        "RolePlayer"
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
                        0.8,
                        "SixthMan"
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
                        0.7,
                        "BenchPlayer"
                );
                celtics.addPlayer(player);
            }

        }

        teams.add(celtics);


        // Lakers

        Team lakers = new Team("Lakers");

        String lakersFile = "D:\\Codeacademy\\Programowanie Obiektowe\\basketball-simulator\\src\\main\\java\\teams-data\\lakers.txt";
        for(int i=0;i<7;i++){
            reader.read(i,lakersFile);
            if(Objects.equals(reader.role(), "Superstar")){

                Team.Player player = new Team.Player.Superstar(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.2,
                        "Superstar"
                );
                lakers.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "Star")){
                Team.Player player = new Team.Player.Star(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.1,
                        "Star"
                );
                lakers.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "Starter")){
                Team.Player player = new Team.Player.Starter(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.0,
                        "Starter"
                );
                lakers.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "RolePlayer")){
                Team.Player player = new Team.Player.RolePlayer(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.9,
                        "RolePlayer"
                );
                lakers.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "SixthMan")){
                Team.Player player = new Team.Player.SixthMan(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.8,
                        "SixthMan"
                );
                lakers.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "BenchPlayer")){
                Team.Player player = new Team.Player.BenchPlayer(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.7,
                        "BenchPlayer"
                );
                lakers.addPlayer(player);
            }

        }

        teams.add(lakers);


        // Heat

        Team heat = new Team("Heat");

        String heatFile = "D:\\Codeacademy\\Programowanie Obiektowe\\basketball-simulator\\src\\main\\java\\teams-data\\heat.txt";
        for(int i=0;i<7;i++){
            reader.read(i,heatFile);
            if(Objects.equals(reader.role(), "Superstar")){

                Team.Player player = new Team.Player.Superstar(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.2,
                        "Superstar"
                );
                heat.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "Star")){
                Team.Player player = new Team.Player.Star(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.1,
                        "Star"
                );
                heat.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "Starter")){
                Team.Player player = new Team.Player.Starter(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.0,
                        "Starter"
                );
                heat.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "RolePlayer")){
                Team.Player player = new Team.Player.RolePlayer(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.9,
                        "RolePlayer"
                );
                heat.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "SixthMan")){
                Team.Player player = new Team.Player.SixthMan(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.8,
                        "SixthMan"
                );
                heat.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "BenchPlayer")){
                Team.Player player = new Team.Player.BenchPlayer(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.7,
                        "BenchPlayer"
                );
                heat.addPlayer(player);
            }

        }

        teams.add(heat);


        // Nuggets

        Team nuggets = new Team("Nuggets");

        String nuggetsFile = "D:\\Codeacademy\\Programowanie Obiektowe\\basketball-simulator\\src\\main\\java\\teams-data\\nuggets.txt";
        for(int i=0;i<7;i++){
            reader.read(i,nuggetsFile);
            if(Objects.equals(reader.role(), "Superstar")){

                Team.Player player = new Team.Player.Superstar(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.2,
                        "Superstar"
                );
                nuggets.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "Star")){
                Team.Player player = new Team.Player.Star(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.1,
                        "Star"
                );
                nuggets.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "Starter")){
                Team.Player player = new Team.Player.Starter(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        1.0,
                        "Starter"
                );
                nuggets.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "RolePlayer")){
                Team.Player player = new Team.Player.RolePlayer(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.9,
                        "RolePlayer"
                );
                nuggets.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "SixthMan")){
                Team.Player player = new Team.Player.SixthMan(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.8,
                        "SixthMan"
                );
                nuggets.addPlayer(player);
            }
            if(Objects.equals(reader.role(), "BenchPlayer")){
                Team.Player player = new Team.Player.BenchPlayer(
                        reader.name(),
                        reader.lastName(),
                        reader.points(),
                        reader.assists(),
                        reader.blocks(),
                        reader.steal(),
                        0.7,
                        "BenchPlayer"
                );
                nuggets.addPlayer(player);
            }

        }

        teams.add(nuggets);





        // Menu

        System.out.println("-------NBA PLAYOFFS SIMULATOR-------");
        System.out.println("0. Rozpocznij symulacje.");
        System.out.println("Wybierz druzyne ktorej sklad chcesz edytowac.");


        while(true){

                Menu.showTeams(teams);
                int inputTeam = scan.nextInt() - 1;
                if(inputTeam == -1){
                    break;
                }
                Menu.showPlayers(teams.get(inputTeam));
                System.out.println("Wybierz zawodnika ktorego statystyki chcesz edytowac.");
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



            System.out.println("---------------------");
            System.out.println("1. Wyswietl druzyny.");
            System.out.println("2. Rozpocznij symulacje.");

            int inputContinue = scan.nextInt();
            if(inputContinue != 1){
                break;
            }


        }


        // Tournament simulation

        Tournament tournament = new Tournament();

        tournament.draw(teams);

        // Semifinals simulation

        Tournament.Series semiFinalsOne = new Tournament.Series();
        Tournament.Series semiFinalsTwo = new Tournament.Series();

                // Semifinal One
        semiFinalsOne.simulateSeries(teams.get(0),teams.get(1));
        semiFinalsOne.showScores(teams.get(0),teams.get(1));

                // Semifinal Two
        semiFinalsTwo.simulateSeries(teams.get(2),teams.get(3));
        semiFinalsTwo.showScores(teams.get(2),teams.get(3));


        tournament.increaseRound();
        tournament.addLosers(teams, teamsCopy);
        tournament.removeLosers(teams);
        tournament.draw(teams);

        // Finals simulation

        Tournament.Series finals = new Tournament.Series();

                // Finals
        finals.simulateSeries(teams.get(0), teams.get(1));
        finals.showScores(teams.get(0),teams.get(1));

        tournament.increaseRound();
        tournament.addLosers(teams, teamsCopy);
        tournament.removeLosers(teams);


        // Winner

        System.out.println("------------------------------");
        System.out.println("Zwyciesca zostaja: " + teams.get(0).getName());
        System.out.println("------------------------------");



        tournament.showStats(teams);
        tournament.showStats(teamsCopy);
        tournament.showPlayersStats(teams);
        tournament.showPlayersStats(teamsCopy);


    }
}


 class Team{


    // Variables
    private String name;
    private Integer wins = 0;
    private Integer losses = 0;
    private Integer gamesPlayed = 0;
    private double pointsScoredTotal = 0.0;
    private double pointsLostTotal = 0.0;
    private Double pointsScoredPerGame = 0.0;
    private Double pointsLostPerGame = 0.0;
    public ArrayList<Player> players = new ArrayList<>();


     public Team(String name){
         this.name = name;
         this.wins = 0;
         this.losses = 0;
         this.pointsScoredTotal = 0;
         this.pointsLostTotal = 0;
     }


    public void calculateGamesPlayed(){
         this.gamesPlayed = this.losses + this.wins;
     }
    public void calculatePointsScoredPerGame(){
         calculateGamesPlayed();
         this.pointsScoredPerGame = Double.valueOf(this.pointsScoredTotal) / Double.valueOf(this.gamesPlayed);
    }

    public void calculatePointsLostPerGame(){
        calculateGamesPlayed();
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

    public void addPointsScoredTotal(Double points){
        this.pointsScoredTotal = this.pointsScoredTotal + points;
    }

    public void addPointsLostTotal(Double points){
        this.pointsLostTotal = this.pointsLostTotal + points;
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

    public double getPointsScoredTotal() {return this.pointsScoredTotal;}
    public double getPointsLostTotal() {return this.pointsLostTotal;}
    public double getPointsScoredPerGame(){
         calculatePointsScoredPerGame();
         return pointsScoredPerGame;
    }
    public double getPointsLostPerGame(){
         calculatePointsLostPerGame();
         return pointsLostPerGame;
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

            public Double assists() {
             return Double.parseDouble(this.array[4]);
         }

             public Double blocks() {
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
         String role;
         Double pointsScoredTotal = 0.0;
         double assistsMadeTotal = 0.0;
         double blocksMadeTotal = 0.0;
         double stealsMadeTotal = 0.0;
         double pointsScoredAvg = 0.0;
         double assistsMadeAvg = 0.0;
         double blocksMadeAvg = 0.0;
         double stealsMadeAvg = 0.0;


         // Constructors

         public Player(String name, String lastName, Double points, Double assists, Double blocks, Double steals, String role){
             this.name = name;
             this.lastName = lastName;
             this.points = points;
             this.assists = assists;
             this.blocks = blocks;
             this.steals = steals;
             this.role = role;
         }


         // Setters

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
         public Double getPointsScoredTotal(){return  pointsScoredTotal;}
         public double getAssistsMadeTotal(){return assistsMadeTotal;}
         public double getBlocksMadeTotal(){return blocksMadeTotal;}
         public double getStealsMadeTotal(){return stealsMadeTotal;}
         // Increments

         public void addPoints(Double pointsScored){
             pointsScoredTotal += pointsScored;
         }
         public void addAssists(double assistsMade){
             assistsMadeTotal+=assistsMade;
         }
         public void addBlocks(Double blocksMade){
             blocksMadeTotal+=blocksMade;
         }
         public void addSteals(Double stealsMade){
             stealsMadeTotal+=stealsMade;
         }

         static class Superstar extends Player {

             Double roleModifier = 1.4;
             public Superstar(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
                 this.roleModifier = roleModifier;
             }
             public Superstar(Player player){
                  super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "Superstar");
             }


             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }
         static class Star extends Player {

             Double roleModifier = 1.25;
             public Star(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
                 this.roleModifier = roleModifier;
             }
             public Star(Player player){
                 super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "Star");
             }


             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }
         static class Starter extends Player {

             Double roleModifier = 1.15;
             public Starter(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
                 this.roleModifier = roleModifier;
             }
             public Starter(Player player){
                 super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "Starter");
             }


             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }
         static class RolePlayer extends Player {

             Double roleModifier = 1.05;
             public RolePlayer(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
                 this.roleModifier = roleModifier;
             }
             public RolePlayer(Player player){
                 super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "RolePlayer");
             }

             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }
         static class SixthMan extends Player {

             Double roleModifier = 0.1;
             public SixthMan(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
                 this.roleModifier = roleModifier;
             }
             public SixthMan(Player player){
                 super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "SixthMan");
             }


             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }
         static class BenchPlayer extends  Player{
             Double roleModifier = 0.9;
             public BenchPlayer(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
                 this.roleModifier = roleModifier;
             }
             public BenchPlayer(Player player){
                 super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "BenchPlayer");
             }


             public Double getRoleModifier(){
                 return this.roleModifier;
             }

         }


     }


 }



 class Tournament {

     private Integer round = 1;

     // Teams draw
     public void draw(ArrayList<Team> teams) {
         Collections.shuffle(teams);
         System.out.println("------------------------------");
         System.out.println("Runda " + round);
         if (round == 1) {
             System.out.println(teams.get(0).getName() + " vs " + teams.get(1).getName());
             System.out.println(teams.get(2).getName() + " vs " + teams.get(3).getName());
         }
         if (round == 2) {
             System.out.println(teams.get(0).getName() + " vs " + teams.get(1).getName());
         }
     }

     public void removeLosers(ArrayList<Team> teams) {
         teams.removeIf(team -> (team.getWins() % 4 != 0));
         teams.removeIf(team -> (team.getWins() == 0));
     }

     public void addLosers(ArrayList<Team> teams, ArrayList<Team> teamsCopy) {
         for (Team team : teams) {
             if (team.getWins() % 4 != 0 || team.getWins() == 0) {
                 teamsCopy.add(team);
             }
         }
     }

     public void showStats(ArrayList<Team> teams) {
         for (Team team : teams) {
             System.out.println(team.getName() + " Wygrane: " + team.getWins() + " Porazki: " + team.getLosses() + " Punkty zdobyte: " + team.getPointsScoredTotal() + " Punkty stracone: " + team.getPointsLostTotal() + " Punkty zdobyte na mecz: " + team.getPointsScoredPerGame() + " Punkty stracone na mecz: " + team.getPointsLostPerGame());
         }
     }

     public void showPlayersStats(ArrayList<Team> teams){
         for(Team team : teams){
             System.out.println(" ");
             System.out.println(" ");
             System.out.println(team.getName());
             System.out.println(" ");
             System.out.println("Imie Nazwisko Punkty Asysty Bloki Przechwyty (calkowite)");
             for(Team.Player player : team.players){
                 System.out.println(player.getName() + " " + player.getLastName() + " " + player.getPointsScoredTotal() + " " + player.getAssistsMadeTotal() + " " + player.getBlocksMadeTotal() + " " + player.getStealsMadeTotal());
             }
         }
     }

     public void increaseRound() {
         round += 1;
     }

     static class Series {

         public Integer firstTeamWins = 0;
         public Integer secondTeamWins = 0;
         public boolean winner;

         public void simulateSeries(Team One, Team Two) {
             System.out.println("------------------------------");
             System.out.println("       Seria: ");
             System.out.println(One.getName() + " vs " + Two.getName());
             GameSimulator gameSimulator = new GameSimulator();

             for (int i = 0; i < 7; i++) {
                 if (gameSimulator.getWinner(One, Two)) {
                     this.firstTeamWins += 1;
                     if (firstTeamWins == 4) {
                         winner = true;
                         break;
                     }
                 } else {
                     this.secondTeamWins += 1;
                     if (secondTeamWins == 4) {
                         winner = false;
                         break;
                     }
                 }
             }

         }

         public void showScores(Team One, Team Two) {
             System.out.println("     Wynik Serii: ");
             System.out.println(One.getName() + " " + firstTeamWins + " : " + secondTeamWins + " " + Two.getName());
         }

         public boolean getWinner() {
             return winner;
         }

     }


     static class GameSimulator {
         public Double firstTeamPointsScored = 0.0;
         public Double secondTeamPointsScored = 0.0;

         public Double getFirstTeamPointsScored() {
             return firstTeamPointsScored;
         }

         public Double getSecondTeamPointsScored() {
             return secondTeamPointsScored;
         }


         static class GameScores{
             public ArrayList<String> teamOneScores = new ArrayList<String>();
             public ArrayList<String> teamTwoScores = new ArrayList<String>();

             public void addTeamOneStatLine(String statLine){
                 teamOneScores.add(statLine);
             }
             public void addTeamTwoStatLine(String statLine){
                 teamTwoScores.add(statLine);
             }

             public void showScores(Team One, Team Two){
                 System.out.println(" ");
                 System.out.println(One.getName());
                 System.out.println("Imie Nazwisko Punkty Asysty Bloki Przechwyty");
                 for(String score : teamOneScores){
                     System.out.println(score);
                 }
                 System.out.println(" ");
                 System.out.println(Two.getName());
                 System.out.println("Imie Nazwisko Punkty Asysty Bloki Przechwyty");
                 for(String score : teamTwoScores){
                     System.out.println(score);
                 }
             }

             public void clearTeamOneScores(){
                 teamOneScores.clear();
             }
             public void clearTeamTwoScores(){
                 teamTwoScores.clear();
             }

         }

         GameScores gameScore = new GameScores();

         public void calculateTeamsScores(Team One, Team Two) {

             Double playerLowPerformance = 0.3;



             // Calculating outcome of every one vs one match-up (Superstar vs Superstar, Star vs Star etc.)

             for (int i = 0; i < 7; i++) {
                 Random random = new Random();
                 String teamOneStatLine = One.players.get(i).getName() + " " + One.players.get(i).getLastName() + " ";
                 String teamTwoStatLine = Two.players.get(i).getName() + " " + Two.players.get(i).getLastName() + " ";

                 if (One.players.get(i) instanceof Team.Player.Superstar && Two.players.get(i) instanceof Team.Player.Superstar) {
                     Team.Player.Superstar playerOne = new Team.Player.Superstar(One.players.get(i));
                     Team.Player.Superstar playerTwo = new Team.Player.Superstar(Two.players.get(i));

                     // Range of players modifiers

                     Double rangeMin = (playerOne.getRoleModifier() - playerLowPerformance);
                     Double rangeMax = playerOne.getRoleModifier();

                     // Performance of players

                     Double playerOnePerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
                     Double playerTwoPerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();

                     // Player one defensive outcome

                     Double playerOneShotsBlocked = Math.floor(playerOne.getBlocks() * playerOnePerformance);
                     Double playerOneStealsMade = Math.floor(playerOne.getSteals() * playerOnePerformance);

                     // Player two defensive outcome

                     Double playerTwoShotsBlocked = Math.floor(playerTwo.getBlocks() * playerOnePerformance);
                     Double playerTwoStealsMade = Math.floor(playerTwo.getSteals() * playerOnePerformance);


                     // Player one offensive outcome

                     Double playerOnePointsScored = Math.floor(playerOne.getPoints() * playerOnePerformance - playerTwoShotsBlocked);
                     Double playerOneAssistsMade = Math.floor(playerOne.getAssists() * playerOnePerformance - playerTwoStealsMade);

                     // Player two offensive outcome

                     Double playerTwoPointsScored = Math.floor(playerTwo.getPoints() * playerTwoPerformance - playerOneShotsBlocked);
                     Double playerTwoAssistsMade = Math.floor(playerTwo.getAssists() * playerTwoPerformance - playerOneStealsMade);

                     // Adding points to final score

                     firstTeamPointsScored += playerOnePointsScored;
                     secondTeamPointsScored += playerTwoPointsScored;

                     // Adding points to each players totals

                     One.players.get(i).addPoints(playerOnePointsScored);
                     One.players.get(i).addAssists(playerOneAssistsMade);
                     One.players.get(i).addBlocks(playerOneShotsBlocked);
                     One.players.get(i).addSteals(playerOneStealsMade);

                     Two.players.get(i).addPoints(playerTwoPointsScored);
                     Two.players.get(i).addAssists(playerTwoAssistsMade);
                     Two.players.get(i).addBlocks(playerTwoShotsBlocked);
                     Two.players.get(i).addSteals(playerTwoStealsMade);

                     // Adding stats to display

                     teamOneStatLine += playerOnePointsScored.toString() + " " + playerOneAssistsMade.toString() + " " + playerOneShotsBlocked.toString() + " " + playerOneStealsMade.toString();
                     teamTwoStatLine += playerTwoPointsScored.toString() + " " + playerTwoAssistsMade.toString() + " " + playerTwoShotsBlocked.toString() + " " + playerTwoStealsMade.toString();

                     gameScore.addTeamOneStatLine(teamOneStatLine);
                     gameScore.addTeamTwoStatLine(teamTwoStatLine);

                     // Continue to next match-up
                     continue;
                 }

                 if (One.players.get(i) instanceof Team.Player.Star && Two.players.get(i) instanceof Team.Player.Star) {
                     Team.Player.Star playerOne = new Team.Player.Star(One.players.get(i));
                     Team.Player.Star playerTwo = new Team.Player.Star(Two.players.get(i));

                     // Range of players modifiers

                     Double rangeMin = (playerOne.getRoleModifier() - playerLowPerformance);
                     Double rangeMax = playerOne.getRoleModifier();

                     // Performance of players

                     Double playerOnePerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
                     Double playerTwoPerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();

                     // Player one defensive outcome

                     Double playerOneShotsBlocked = Math.floor(playerOne.getBlocks() * playerOnePerformance);
                     Double playerOneStealsMade = Math.floor(playerOne.getSteals() * playerOnePerformance);

                     // Player two defensive outcome

                     Double playerTwoShotsBlocked = Math.floor(playerTwo.getBlocks() * playerOnePerformance);
                     Double playerTwoStealsMade = Math.floor(playerTwo.getSteals() * playerOnePerformance);


                     // Player one offensive outcome

                     Double playerOnePointsScored = Math.floor(playerOne.getPoints() * playerOnePerformance - playerTwoShotsBlocked);
                     Double playerOneAssistsMade = Math.floor(playerOne.getAssists() * playerOnePerformance - playerTwoStealsMade);

                     // Player two offensive outcome

                     Double playerTwoPointsScored = Math.floor(playerTwo.getPoints() * playerTwoPerformance - playerOneShotsBlocked);
                     Double playerTwoAssistsMade = Math.floor(playerTwo.getAssists() * playerTwoPerformance - playerOneStealsMade);

                     // Adding points to final score

                     firstTeamPointsScored += playerOnePointsScored;
                     secondTeamPointsScored += playerTwoPointsScored;

                     // Adding points to each players totals

                     One.players.get(i).addPoints(playerOnePointsScored);
                     One.players.get(i).addAssists(playerOneAssistsMade);
                     One.players.get(i).addBlocks(playerOneShotsBlocked);
                     One.players.get(i).addSteals(playerOneStealsMade);

                     Two.players.get(i).addPoints(playerTwoPointsScored);
                     Two.players.get(i).addAssists(playerTwoAssistsMade);
                     Two.players.get(i).addBlocks(playerTwoShotsBlocked);
                     Two.players.get(i).addSteals(playerTwoStealsMade);

                     // Adding stats to display

                     teamOneStatLine += playerOnePointsScored.toString() + " " + playerOneAssistsMade.toString() + " " + playerOneShotsBlocked.toString() + " " + playerOneStealsMade.toString();
                     teamTwoStatLine += playerTwoPointsScored.toString() + " " + playerTwoAssistsMade.toString() + " " + playerTwoShotsBlocked.toString() + " " + playerTwoStealsMade.toString();

                     gameScore.addTeamOneStatLine(teamOneStatLine);
                     gameScore.addTeamTwoStatLine(teamTwoStatLine);

                     // Continue to next match-up
                     continue;
                 }

                 if (One.players.get(i) instanceof Team.Player.Starter && Two.players.get(i) instanceof Team.Player.Starter) {
                     Team.Player.Starter playerOne = new Team.Player.Starter(One.players.get(i));
                     Team.Player.Starter playerTwo = new Team.Player.Starter(Two.players.get(i));

                     // Range of players modifiers

                     Double rangeMin = (playerOne.getRoleModifier() - playerLowPerformance);
                     Double rangeMax = playerOne.getRoleModifier();

                     // Performance of players

                     Double playerOnePerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
                     Double playerTwoPerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();

                     // Player one defensive outcome

                     Double playerOneShotsBlocked = Math.floor(playerOne.getBlocks() * playerOnePerformance);
                     Double playerOneStealsMade = Math.floor(playerOne.getSteals() * playerOnePerformance);

                     // Player two defensive outcome

                     Double playerTwoShotsBlocked = Math.floor(playerTwo.getBlocks() * playerOnePerformance);
                     Double playerTwoStealsMade = Math.floor(playerTwo.getSteals() * playerOnePerformance);


                     // Player one offensive outcome

                     Double playerOnePointsScored = Math.floor(playerOne.getPoints() * playerOnePerformance - playerTwoShotsBlocked);
                     Double playerOneAssistsMade = Math.floor(playerOne.getAssists() * playerOnePerformance - playerTwoStealsMade);

                     // Player two offensive outcome

                     Double playerTwoPointsScored = Math.floor(playerTwo.getPoints() * playerTwoPerformance - playerOneShotsBlocked);
                     Double playerTwoAssistsMade = Math.floor(playerTwo.getAssists() * playerTwoPerformance - playerOneStealsMade);

                     // Adding points to final score

                     firstTeamPointsScored += playerOnePointsScored;
                     secondTeamPointsScored += playerTwoPointsScored;

                     // Adding points to each players totals

                     One.players.get(i).addPoints(playerOnePointsScored);
                     One.players.get(i).addAssists(playerOneAssistsMade);
                     One.players.get(i).addBlocks(playerOneShotsBlocked);
                     One.players.get(i).addSteals(playerOneStealsMade);

                     Two.players.get(i).addPoints(playerTwoPointsScored);
                     Two.players.get(i).addAssists(playerTwoAssistsMade);
                     Two.players.get(i).addBlocks(playerTwoShotsBlocked);
                     Two.players.get(i).addSteals(playerTwoStealsMade);

                     // Adding stats to display

                     teamOneStatLine += playerOnePointsScored.toString() + " " + playerOneAssistsMade.toString() + " " + playerOneShotsBlocked.toString() + " " + playerOneStealsMade.toString();
                     teamTwoStatLine += playerTwoPointsScored.toString() + " " + playerTwoAssistsMade.toString() + " " + playerTwoShotsBlocked.toString() + " " + playerTwoStealsMade.toString();

                     gameScore.addTeamOneStatLine(teamOneStatLine);
                     gameScore.addTeamTwoStatLine(teamTwoStatLine);

                     // Continue to next match-up
                     continue;
                 }

                 if (One.players.get(i) instanceof Team.Player.RolePlayer && Two.players.get(i) instanceof Team.Player.RolePlayer) {
                     Team.Player.RolePlayer playerOne = new Team.Player.RolePlayer(One.players.get(i));
                     Team.Player.RolePlayer playerTwo = new Team.Player.RolePlayer(Two.players.get(i));

                     // Range of players modifiers

                     Double rangeMin = (playerOne.getRoleModifier() - playerLowPerformance);
                     Double rangeMax = playerOne.getRoleModifier();

                     // Performance of players

                     Double playerOnePerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
                     Double playerTwoPerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();

                     // Player one defensive outcome

                     Double playerOneShotsBlocked = Math.floor(playerOne.getBlocks() * playerOnePerformance);
                     Double playerOneStealsMade = Math.floor(playerOne.getSteals() * playerOnePerformance);

                     // Player two defensive outcome

                     Double playerTwoShotsBlocked = Math.floor(playerTwo.getBlocks() * playerOnePerformance);
                     Double playerTwoStealsMade = Math.floor(playerTwo.getSteals() * playerOnePerformance);


                     // Player one offensive outcome

                     Double playerOnePointsScored = Math.floor(playerOne.getPoints() * playerOnePerformance - playerTwoShotsBlocked);
                     Double playerOneAssistsMade = Math.floor(playerOne.getAssists() * playerOnePerformance - playerTwoStealsMade);

                     // Player two offensive outcome

                     Double playerTwoPointsScored = Math.floor(playerTwo.getPoints() * playerTwoPerformance - playerOneShotsBlocked);
                     Double playerTwoAssistsMade = Math.floor(playerTwo.getAssists() * playerTwoPerformance - playerOneStealsMade);

                     // Adding points to final score

                     firstTeamPointsScored += playerOnePointsScored;
                     secondTeamPointsScored += playerTwoPointsScored;

                     // Adding points to each players totals

                     One.players.get(i).addPoints(playerOnePointsScored);
                     One.players.get(i).addAssists(playerOneAssistsMade);
                     One.players.get(i).addBlocks(playerOneShotsBlocked);
                     One.players.get(i).addSteals(playerOneStealsMade);

                     Two.players.get(i).addPoints(playerTwoPointsScored);
                     Two.players.get(i).addAssists(playerTwoAssistsMade);
                     Two.players.get(i).addBlocks(playerTwoShotsBlocked);
                     Two.players.get(i).addSteals(playerTwoStealsMade);

                     // Adding stats to display

                     teamOneStatLine += playerOnePointsScored.toString() + " " + playerOneAssistsMade.toString() + " " + playerOneShotsBlocked.toString() + " " + playerOneStealsMade.toString();
                     teamTwoStatLine += playerTwoPointsScored.toString() + " " + playerTwoAssistsMade.toString() + " " + playerTwoShotsBlocked.toString() + " " + playerTwoStealsMade.toString();

                     gameScore.addTeamOneStatLine(teamOneStatLine);
                     gameScore.addTeamTwoStatLine(teamTwoStatLine);

                     // Continue to next match-up
                     continue;
                 }


                 if (One.players.get(i) instanceof Team.Player.SixthMan && Two.players.get(i) instanceof Team.Player.SixthMan) {
                     Team.Player.SixthMan playerOne = new Team.Player.SixthMan(One.players.get(i));
                     Team.Player.SixthMan playerTwo = new Team.Player.SixthMan(Two.players.get(i));

                     // Range of players modifiers

                     Double rangeMin = (playerOne.getRoleModifier() - playerLowPerformance);
                     Double rangeMax = playerOne.getRoleModifier();

                     // Performance of players

                     Double playerOnePerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
                     Double playerTwoPerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();

                     // Player one defensive outcome

                     Double playerOneShotsBlocked = Math.floor(playerOne.getBlocks() * playerOnePerformance);
                     Double playerOneStealsMade = Math.floor(playerOne.getSteals() * playerOnePerformance);

                     // Player two defensive outcome

                     Double playerTwoShotsBlocked = Math.floor(playerTwo.getBlocks() * playerOnePerformance);
                     Double playerTwoStealsMade = Math.floor(playerTwo.getSteals() * playerOnePerformance);


                     // Player one offensive outcome

                     Double playerOnePointsScored = Math.floor(playerOne.getPoints() * playerOnePerformance - playerTwoShotsBlocked);
                     Double playerOneAssistsMade = Math.floor(playerOne.getAssists() * playerOnePerformance - playerTwoStealsMade);

                     // Player two offensive outcome

                     Double playerTwoPointsScored = Math.floor(playerTwo.getPoints() * playerTwoPerformance - playerOneShotsBlocked);
                     Double playerTwoAssistsMade = Math.floor(playerTwo.getAssists() * playerTwoPerformance - playerOneStealsMade);

                     // Adding points to final score

                     firstTeamPointsScored += playerOnePointsScored;
                     secondTeamPointsScored += playerTwoPointsScored;

                     // Adding points to each players totals

                     One.players.get(i).addPoints(playerOnePointsScored);
                     One.players.get(i).addAssists(playerOneAssistsMade);
                     One.players.get(i).addBlocks(playerOneShotsBlocked);
                     One.players.get(i).addSteals(playerOneStealsMade);

                     Two.players.get(i).addPoints(playerTwoPointsScored);
                     Two.players.get(i).addAssists(playerTwoAssistsMade);
                     Two.players.get(i).addBlocks(playerTwoShotsBlocked);
                     Two.players.get(i).addSteals(playerTwoStealsMade);

                     // Adding stats to display

                     teamOneStatLine += playerOnePointsScored.toString() + " " + playerOneAssistsMade.toString() + " " + playerOneShotsBlocked.toString() + " " + playerOneStealsMade.toString();
                     teamTwoStatLine += playerTwoPointsScored.toString() + " " + playerTwoAssistsMade.toString() + " " + playerTwoShotsBlocked.toString() + " " + playerTwoStealsMade.toString();

                     gameScore.addTeamOneStatLine(teamOneStatLine);
                     gameScore.addTeamTwoStatLine(teamTwoStatLine);

                     // Continue to next match-up
                     continue;
                 }


                 if (One.players.get(i) instanceof Team.Player.BenchPlayer && Two.players.get(i) instanceof Team.Player.BenchPlayer) {
                     Team.Player.BenchPlayer playerOne = new Team.Player.BenchPlayer(One.players.get(i));
                     Team.Player.BenchPlayer playerTwo = new Team.Player.BenchPlayer(Two.players.get(i));

                     // Range of players modifiers

                     Double rangeMin = (playerOne.getRoleModifier() - playerLowPerformance);
                     Double rangeMax = playerOne.getRoleModifier();

                     // Performance of players

                     Double playerOnePerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
                     Double playerTwoPerformance = rangeMin + (rangeMax - rangeMin) * random.nextDouble();

                     // Player one defensive outcome

                     Double playerOneShotsBlocked = Math.floor(playerOne.getBlocks() * playerOnePerformance);
                     Double playerOneStealsMade = Math.floor(playerOne.getSteals() * playerOnePerformance);

                     // Player two defensive outcome

                     Double playerTwoShotsBlocked = Math.floor(playerTwo.getBlocks() * playerOnePerformance);
                     Double playerTwoStealsMade = Math.floor(playerTwo.getSteals() * playerOnePerformance);


                     // Player one offensive outcome

                     Double playerOnePointsScored = Math.floor(playerOne.getPoints() * playerOnePerformance - playerTwoShotsBlocked);
                     Double playerOneAssistsMade = Math.floor(playerOne.getAssists() * playerOnePerformance - playerTwoStealsMade);

                     // Player two offensive outcome

                     Double playerTwoPointsScored = Math.floor(playerTwo.getPoints() * playerTwoPerformance - playerOneShotsBlocked);
                     Double playerTwoAssistsMade = Math.floor(playerTwo.getAssists() * playerTwoPerformance - playerOneStealsMade);

                     // Adding points to final score

                     firstTeamPointsScored += playerOnePointsScored;
                     secondTeamPointsScored += playerTwoPointsScored;

                     // Adding points to each players totals

                     One.players.get(i).addPoints(playerOnePointsScored);
                     One.players.get(i).addAssists(playerOneAssistsMade);
                     One.players.get(i).addBlocks(playerOneShotsBlocked);
                     One.players.get(i).addSteals(playerOneStealsMade);

                     Two.players.get(i).addPoints(playerTwoPointsScored);
                     Two.players.get(i).addAssists(playerTwoAssistsMade);
                     Two.players.get(i).addBlocks(playerTwoShotsBlocked);
                     Two.players.get(i).addSteals(playerTwoStealsMade);

                     // Adding stats to display

                     teamOneStatLine += playerOnePointsScored.toString() + " " + playerOneAssistsMade.toString() + " " + playerOneShotsBlocked.toString() + " " + playerOneStealsMade.toString();
                     teamTwoStatLine += playerTwoPointsScored.toString() + " " + playerTwoAssistsMade.toString() + " " + playerTwoShotsBlocked.toString() + " " + playerTwoStealsMade.toString();

                     gameScore.addTeamOneStatLine(teamOneStatLine);
                     gameScore.addTeamTwoStatLine(teamTwoStatLine);

                 }



                 // END OF FOR

             }


         }


         public boolean getWinner(Team One, Team Two) {
             boolean winner = true;

             gameScore.clearTeamOneScores();
             gameScore.clearTeamTwoScores();

             firstTeamPointsScored = 0.0;
             secondTeamPointsScored = 0.0;

             calculateTeamsScores(One, Two);

             One.addPointsScoredTotal(firstTeamPointsScored);
             One.addPointsLostTotal(secondTeamPointsScored);
             Two.addPointsScoredTotal(secondTeamPointsScored);
             Two.addPointsLostTotal(firstTeamPointsScored);




             // Conditional

             if (firstTeamPointsScored > secondTeamPointsScored) {
                 One.addWin();
                 Two.addLoss();
                 System.out.println(" ");
                 System.out.println(" ");
                 System.out.println("       " + getFirstTeamPointsScored() + " : " + getSecondTeamPointsScored());
                 gameScore.showScores(One, Two);
                 return winner;
             }


             if (firstTeamPointsScored.equals(secondTeamPointsScored)) {
                 Random random = new Random();
                 int randomInt = random.nextInt(100) + 1;
                 if (randomInt % 2 == 0) {
                     One.addWin();
                     Two.addLoss();
                     System.out.println(" ");
                     System.out.println(" ");
                     System.out.println("       " + getFirstTeamPointsScored() + " : " + getSecondTeamPointsScored());
                     gameScore.showScores(One, Two);
                 } else {
                     One.addLoss();
                     Two.addWin();
                     winner = false;
                     System.out.println(" ");
                     System.out.println(" ");
                     System.out.println(getFirstTeamPointsScored() + " : " + getSecondTeamPointsScored());
                     gameScore.showScores(One, Two);
                 }
                 return winner;
             }


             One.addLoss();
             Two.addWin();
             System.out.println(" ");
             System.out.println(" ");
             System.out.println("       " + getFirstTeamPointsScored() + " : " + getSecondTeamPointsScored());
             gameScore.showScores(One, Two);
             return false;
         }


     }


 }