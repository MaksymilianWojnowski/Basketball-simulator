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


       // System.out.println(teamsCopy.get(0).getName() + " " + teamsCopy.get(1).getName() + " " + teamsCopy.get(2).getName());
        tournament.showStats(teams);
        tournament.showStats(teamsCopy);

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
    public ArrayList<Player> players = new ArrayList<>();


     public Team(String name){
         this.name = name;
         this.wins = 0;
         this.losses = 0;
         this.pointsScoredTotal = 0;
         this.pointsLostTotal = 0;
     }


    // Methods used to calculate offensive and defensive potential of certain teams

    public void calculateOffensiveRating(){
        this.offensiveRating = 0.0;

        for( Player player : players){
            offensiveRating = offensiveRating + player.getPoints()  + player.getAssists()/2;
        }

    }
    public void calculateDefensiveRating(){
        this.defensiveRating = 0.0;
        for( Player player : players){
            defensiveRating = defensiveRating + (player.getSteals() + player.getBlocks())*2.2;
        }

    }

    public void calculateGamesPlayed(){
        this.gamesPlayed = this.losses + this.wins;
    }

    public void calculateNetDifference(){
         calculateDefensiveRating();
         calculateOffensiveRating();
        this.netDifference = this.offensiveRating + this.defensiveRating;
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

    public void setLosses(int l){
        this.losses = l;
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

    public int getPointsScoredTotal() {return this.pointsScoredTotal;}
    public int getPointsLostTotal() {return this.pointsLostTotal;}
    public double getPointsScoredPerGame(){
         calculatePointsScoredPerGame();
         return pointsScoredPerGame;
    }
    public double getPointsLostPerGame(){
         calculatePointsLostPerGame();
         return pointsLostPerGame;
    }


    public Double getOffensiveRating(){
         calculateOffensiveRating();
         return this.offensiveRating;
    }

    public Double getDefensiveRating(){
         calculateDefensiveRating();
         return this.defensiveRating;
    }

    public Double getNetDifference(){
         calculateNetDifference();
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



         // Constructors

         public Player(){
             this.name = "";
             this.lastName = "";
             this.points = -1.0;
             this.assists = -1.0;
             this.blocks = -1.0;
             this.steals = -1.0;

         }
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
             public Superstar(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
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
             public Star(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
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
             public Starter(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
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
             public RolePlayer(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
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
             public SixthMan(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
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
             public BenchPlayer(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                 super(name, lastName, points, assists, blocks, steals, role);
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

    private Integer round = 1;

    // Teams draw
    public void draw(ArrayList<Team> teams){
        Collections.shuffle(teams);
        System.out.println("------------------------------");
        System.out.println("Runda " + round);
        if(round==1){
            System.out.println(teams.get(0).getName() + " vs " + teams.get(1).getName());
            System.out.println(teams.get(2).getName() + " vs " + teams.get(3).getName());
        }
        if(round==2){
            System.out.println(teams.get(0).getName() + " vs " + teams.get(1).getName());
        }
    }

    public void removeLosers(ArrayList<Team> teams){
        teams.removeIf(team -> (team.getWins() %4 != 0));
        teams.removeIf(team -> (team.getWins() == 0));
     }
    public void addLosers(ArrayList<Team> teams, ArrayList<Team> teamsCopy){
        for(Team team : teams){
            if(team.getWins() %4 != 0 ||  team.getWins() == 0){
                teamsCopy.add(team);
            }
        }
    }

    public void showStats(ArrayList<Team> teams){
        for(Team team : teams){
            System.out.println(team.getName() + " Wygrane: " + team.getWins() + " Porazki: " + team.getLosses() + " Punkty zdobyte: " + team.getPointsScoredTotal() + " Punkty stracone: " + team.getPointsLostTotal()  + " Punkty zdobyte na mecz: " + team.getPointsScoredPerGame() + " Punkty stracone na mecz: "+ team.getPointsLostPerGame());
        }
    }
     public void increaseRound(){
        round+=1;
     }
    static class Series{

        public Integer firstTeamWins = 0;
        public Integer secondTeamWins = 0;
        public boolean winner;
        public void simulateSeries(Team One, Team Two){

            GameSimulator gameSimulator = new GameSimulator();

            for(int i=0;i<7;i++){
                if(gameSimulator.getWinner(One, Two)){
                    this.firstTeamWins+=1;
                    if(firstTeamWins == 4){
                        winner=true;
                        break;
                    }
                }
                else{
                    this.secondTeamWins+=1;
                    if(secondTeamWins == 4){
                        winner=false;
                        break;
                    }
                }
            }

        }

        public void showScores(Team One, Team Two){
            System.out.println(One.getName() + " " + firstTeamWins + " : " + secondTeamWins + " " + Two.getName());

        }

        public boolean getWinner(){
            return winner;
        }

    }


     static class GameSimulator{
         public Double firstTeamRandomMultiplier;
         public Double secondTeamRandomMultiplier;
         public Integer firstTeamPointsScored;
         public Integer secondTeamPointsScored;
         public void calculateFirstTeamRandomMultiplier(){
             Random random = new Random();
             firstTeamRandomMultiplier = 0.95 + (1.05 - 0.95) * random.nextDouble();

         }

         public void calculateSecondTeamRandomMultiplier(){
             Random random = new Random();
             secondTeamRandomMultiplier = 0.95 + (1.05 - 0.95) * random.nextDouble();

         }

         public Integer getFirstTeamPointsScored(){
             return firstTeamPointsScored;
         }

         public Integer getSecondTeamPointsScored(){
             return secondTeamPointsScored;
         }

         public boolean getWinner(Team One, Team Two){
             boolean winner=true;

             calculateFirstTeamRandomMultiplier();
             calculateSecondTeamRandomMultiplier();


             One.calculateOffensiveRating();
             One.calculateNetDifference();
             One.calculateNetDifference();


             Two.calculateOffensiveRating();
             Two.calculateDefensiveRating();
             Two.calculateNetDifference();



             firstTeamPointsScored = (int) Math.ceil(One.getNetDifference()  * firstTeamRandomMultiplier - Two.getDefensiveRating());
             secondTeamPointsScored = (int) Math.ceil(Two.getNetDifference() * secondTeamRandomMultiplier - One.getDefensiveRating());
             One.addPointsScoredTotal(firstTeamPointsScored);
             One.addPointsLostTotal(secondTeamPointsScored);
             Two.addPointsScoredTotal(secondTeamPointsScored);
             Two.addPointsLostTotal(firstTeamPointsScored);




             // Conditional

             if(firstTeamPointsScored > secondTeamPointsScored )
             {
                 One.addWin();
                 Two.addLoss();
                 System.out.println(getFirstTeamPointsScored() + " : " + getSecondTeamPointsScored());
                 return winner;

             }


             if(firstTeamPointsScored.equals(secondTeamPointsScored)){
                 Random random = new Random();
                 int randomInt = random.nextInt(100) + 1;
                 if(randomInt % 2 == 0){
                     One.addWin();
                     Two.addLoss();
                     winner = true;
                     System.out.println(getFirstTeamPointsScored() + " : " + getSecondTeamPointsScored());
                     return winner;
                 }
                 else{
                     One.addLoss();
                     Two.addWin();
                     winner = false;
                     System.out.println(getFirstTeamPointsScored() + " : " + getSecondTeamPointsScored());
                     return winner;
                 }
             }


             if(firstTeamPointsScored < secondTeamPointsScored)
             {
                 One.addLoss();
                 Two.addWin();
                 winner = false;
                 System.out.println(getFirstTeamPointsScored() + " : " + getSecondTeamPointsScored());
                 return winner;
             }


             return winner;
         }



     }

}




