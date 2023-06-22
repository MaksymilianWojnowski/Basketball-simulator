package org.example;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.io.File;

/**
 * Main class
 */
public class Main {

    /**
     * Class that displays user interface
     */
    static class Menu{

        /**
         * logs all teams to the console
         * @param teams ArrayList of all teams
         */
        public static void showTeams(ArrayList<Team> teams){
            int i=1;
            for( Team team : teams){

                System.out.println(i + ". " + team.getName());
                i=i+1;
            }

        }

        /**
         * logs all players of a certain team
         * @param team team object
         */
        public static void  showPlayers(Team team){
            int i=1;
            System.out.println("Lp" + ". " + "Imie" + "  " + "Nazwisko" + "  " + "Punkty" + "  " +  "Asysty" + "  " + "Bloki" + "  " + "Przechwyty");
            for(Team.Player player : team.players){
                System.out.println(i + ". " + player.getName() + "  " + player.getLastName() + "  " + player.getPoints() + "  " +  player.getAssists() + "  " + player.getBlocks() + "  " + player.getSteals());
                i++;
            }

        }

        /**
         * logs all player stats
         * @param player player object
         */
        public static void showPlayer(Team.Player player){
            System.out.println(player.getName() + "  " + player.getLastName() );
            System.out.println("1. Punkty: " + player.getPoints() );
            System.out.println("2. Asysty: " + player.getAssists());
            System.out.println("3. Bloki: " + player.getBlocks());
            System.out.println("4. Przechwyty: " + player.getSteals());
        }



    }


    /**
     * main function
     * @param args String[] args
     */
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

        String celticsFile = "D:\\Codeacademy\\Programowanie Obiektowe\\data\\celtics.txt";
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

        String lakersFile = "D:\\Codeacademy\\Programowanie Obiektowe\\data\\lakers.txt";
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

        String heatFile = "D:\\Codeacademy\\Programowanie Obiektowe\\data\\heat.txt";
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

        String nuggetsFile = "D:\\Codeacademy\\Programowanie Obiektowe\\data\\nuggets.txt";
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


        // Excel
        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.writer(teamsCopy,teams);


    }
}

/**
 * Class that writes post simulation statistics to an .xls file
 */
class ExcelWriter {
    /**
     * Constructor
     */
    public ExcelWriter(){

    }

    /**
     * Creates .xls file with post simulation statistics
     * @param teams ArrayList of all teams that lost during simulation
     * @param teamscopy ArrayList of all teams
     */
    public void writer(ArrayList<Team> teams,ArrayList<Team> teamscopy) {
        for(Team team:teamscopy){
            if(teams.contains(team)){}
            else{
                teams.add(team);
            }
        }
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("daneprojekt.xls"));
            WritableSheet sheet1 = workbook.createSheet("Drużyny",0);
            WritableSheet sheet2 = workbook.createSheet("Zawodnicy", 1);

            String[] tabela={"Nazwa druzyny","Wygrane","Porażki","Punkty zdobyty","Punkty stracone","Punkty zdobyte na mecz","Punkty stracone na mecz"};
            String[] tabela2={"Imię","Nazwisko","Punkty","Asysty","Bloki","Przechwyty"};
            for(int i=0;i<7;i++){
                Label label=new Label(i,0,tabela[i]);
                sheet1.addCell(label);
            }
            int i=1;//nazwa
            for(Team team:teams){
                Label label1=new Label(0,i,team.getName());
                sheet1.addCell(label1);
                i++;
            }
            i=1;//wygrane
            for(Team team:teams){
                Label label1=new Label(1,i,Integer.toString(team.getWins()));
                sheet1.addCell(label1);
                i++;
            }
            i=1;//porazki
            for(Team team:teams){
                Label label1=new Label(2,i,Integer.toString(team.getLosses()));
                sheet1.addCell(label1);
                i++;
            }
            i=1;//pktzdobyte
            for(Team team:teams){
                Label label1=new Label(3,i,Double.toString(team.getPointsScoredTotal()));
                sheet1.addCell(label1);
                i++;
            }
            i=1;//pktstracone
            for(Team team:teams){
                Label label1=new Label(4,i,Double.toString(team.getPointsLostTotal()));
                sheet1.addCell(label1);
                i++;
            }
            i=1;//pktzdonamecz
            for(Team team:teams){
                Label label1=new Label(5,i,Double.toString(team.getPointsScoredPerGame()));
                sheet1.addCell(label1);
                i++;
            }
            i=1;//pktstrnamecz
            for(Team team:teams){
                Label label1=new Label(6,i,Double.toString(team.getPointsLostPerGame()));
                sheet1.addCell(label1);
                i++;
            }

            //players stats
            for(i=1;i<=6;i++){
                Label label=new Label(i,0,tabela2[i-1]);
                sheet2.addCell(label);
            }
            int a=1,c=2,d=2,e=2,f=2,g=2,h=2;
            for(Team team:teams){
                Label teamname=new Label(0,a,team.getName());
                sheet2.addCell(teamname);
                for(Team.Player player: team.players){
                    Label label=new Label(1,c, player.getName());
                    sheet2.addCell(label);
                    c++;
                }
                for(Team.Player player: team.players){
                    Label label=new Label(2,d, player.getLastName());
                    sheet2.addCell(label);
                    d++;
                }
                for(Team.Player player: team.players){
                    Label label=new Label(3,e, Double.toString(player.getPointsScoredTotal()));
                    sheet2.addCell(label);
                    e++;
                }
                for(Team.Player player: team.players){
                    Label label=new Label(4,f, Double.toString(player.getAssistsMadeTotal()));
                    sheet2.addCell(label);
                    f++;
                }
                for(Team.Player player: team.players){
                    Label label=new Label(5,g, Double.toString(player.getBlocksMadeTotal()));
                    sheet2.addCell(label);
                    g++;
                }
                for(Team.Player player: team.players){
                    Label label=new Label(6,h, Double.toString(player.getStealsMadeTotal()));
                    sheet2.addCell(label);
                    h++;
                }
                a+=9;
                c+=2;
                d+=2;
                e+=2;
                f+=2;
                g+=2;
                h+=2;
            }


            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    /**
     * Constructor
     * @param name teams name
     */
    public Team(String name){
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.pointsScoredTotal = 0;
        this.pointsLostTotal = 0;
    }

    /**
     * Calculates how many games did team play
     */
    public void calculateGamesPlayed(){
        this.gamesPlayed = this.losses + this.wins;
    }

    /**
     * Calculates how many points did team score
     */
    public void calculatePointsScoredPerGame(){
        calculateGamesPlayed();
        this.pointsScoredPerGame = Double.valueOf(this.pointsScoredTotal) / Double.valueOf(this.gamesPlayed);
    }

    /**
     * Calculates how many points did team lost
     */
    public void calculatePointsLostPerGame(){
        calculateGamesPlayed();
        this.pointsLostPerGame = Double.valueOf(this.pointsLostTotal) / Double.valueOf(this.gamesPlayed);
    }

    // Methods to increment values

    /**
     * Adds one win to team win counter
     */
    public void addWin() {
        this.wins = this.wins + 1;
    }

    /**
     * Adds one lose to team losses counter
     */
    public void addLoss() {
        this.losses = this.losses + 1;
    }

    /**
     * Adds player to team ArrayList of all players
     * @param player player object
     */
    public void addPlayer(Player player){
        this.players.add(player);
    }

    /**
     * Adds points scored in a game to teams total points scored counter
     * @param points amount of points scored
     */
    public void addPointsScoredTotal(Double points){
        this.pointsScoredTotal = this.pointsScoredTotal + points;
    }

    /**
     * Adds points lost in a game to teams total points lost counter
     * @param points amount of points lost
     */
    public void addPointsLostTotal(Double points){
        this.pointsLostTotal = this.pointsLostTotal + points;
    }

    // Getters

    /**
     * Gets team's name
     * @return team's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets team's wins
     * @return team's win
     */
    public int getWins() {
        return this.wins;
    }

    /**
     * Gets team's losses
     * @return team's losses
     */
    public int getLosses() {
        return this.losses;
    }

    /**
     * Gets team's points scored total
     * @return team's points scored total
     */
    public double getPointsScoredTotal() {return this.pointsScoredTotal;}

    /**
     * Gets team's points lost total
     * @return team's points lost total
     */
    public double getPointsLostTotal() {return this.pointsLostTotal;}

    /**
     * Gets team's points scored per game
     * @return team's points scored per game
     */
    public double getPointsScoredPerGame(){
        calculatePointsScoredPerGame();
        return pointsScoredPerGame;
    }

    /**
     * Gets team's points lost per game
     * @return team's points lost per game
     */
    public double getPointsLostPerGame(){
        calculatePointsLostPerGame();
        return pointsLostPerGame;
    }

    /**
     * Class that reads players statistics from a .txt file
     */
    static class StatsReader{

        String[] array;

        /**
         * Constructor
         */
        public StatsReader() {}

        /**
         * Reads team's player's statistics from a .txt file
         * @param n amount of lines in a file
         * @param fileName file's name
         */
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

        /**
         * Return player's role  from a .txt file
         * @return player's role
         */
        public String role() {
            return this.array[0];
        }

        /**
         * Returns player's name from a .txt file
         * @return player's name
         */
        public String name() {
            return this.array[1];
        }

        /**
         * Returns player's last name from a .txt file
         * @return player's last name
         */
        public String lastName() {
            return this.array[2];
        }

        /**
         * Returns player's points scored per game from a .txt file
         * @return player's points scored per game
         */
        public Double points() {
            return Double.parseDouble(this.array[3]);
        }

        /**
         * Returns player's assists made per game from a .txt file
         * @return player's assists made per game
         */
        public Double assists() {
            return Double.parseDouble(this.array[4]);
        }

        /**
         * Returns player's blocks made per game from a .txt file
         * @return player's blocks made per game
         */
        public Double blocks() {
            return Double.parseDouble(this.array[5]);
        }

        /**
         * Returns player's steals made per game from a .txt file
         * @return player's steals made per game
         */
        public Double steal() {
            return Double.parseDouble(this.array[6]);
        }



    }

    /**
     * Class that represents player
     */
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

        /**
         * Constructor
         * @param name player's name
         * @param lastName player's last name
         * @param points player's points scored per game
         * @param assists player's assists made per game
         * @param blocks player's blocks made per game
         * @param steals player's steals made per game
         * @param role  player's role
         */
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

        /**
         * Sets player's points scored per game
         * @param points points scored per game
         */
        public void setPoints(Double points){
            this.points = points;
        }

        /**
         * Sets player's assists made per game
         * @param assists assists made per game
         */
        public void setAssists(Double assists){
            this.assists = assists;
        }

        /**
         * Sets player's blocks made per game
         * @param blocks blocks made per game
         */
        public void setBlocks(Double blocks){
            this.blocks = blocks;
        }

        /**
         * Sets player's steals made per game
         * @param steals
         */
        public void setSteals(Double steals){
            this.steals = steals;
        }


        // Getters

        /**
         * Gets player's name
         * @return player's name
         */
        public String getName(){
            return this.name;
        }

        /**
         * Gets player's last name
         * @return player's last name
         */
        public String getLastName(){
            return this.lastName;
        }

        /**
         * Gets player's points scored per game
         * @return player's points scored per game
         */
        public Double getPoints(){
            return this.points;
        }

        /**
         * Gets player's assists made per game
         * @return assists made per game
         */
        public Double getAssists(){
            return this.assists;
        }

        /**
         * Gets player's blocks made per game
         * @return player's blocks made per game
         */
        public Double getBlocks(){
            return this.blocks;
        }

        /**
         * Gets player's steals made per game
         * @return player's steals made per game
         */
        public Double getSteals(){
            return this.steals;
        }

        /**
         * Gets player's points scored total
         * @return player's points scored total
         */
        public Double getPointsScoredTotal(){return  pointsScoredTotal;}

        /**
         * Gets player's assists made total
         * @return player's assists made total
         */
        public double getAssistsMadeTotal(){return assistsMadeTotal;}

        /**
         * Gets player's blocks made total
         * @return player's blocks made total
         */
        public double getBlocksMadeTotal(){return blocksMadeTotal;}

        /**
         * Gets player's steals made total
         * @return player's steals made total
         */
        public double getStealsMadeTotal(){return stealsMadeTotal;}

        // Increments

        /**
         * Adds points to player's total points scored counter
         * @param pointsScored points socred in a game
         */
        public void addPoints(Double pointsScored){
            pointsScoredTotal += pointsScored;
        }

        /**
         * Adds assists to player's total points scored counter
         * @param assistsMade assists made in a game
         */
        public void addAssists(double assistsMade){
            assistsMadeTotal+=assistsMade;
        }

        /**
         * Adds blocks to player's total blocks made counter
         * @param blocksMade blocks made in a game
         */
        public void addBlocks(Double blocksMade){
            blocksMadeTotal+=blocksMade;
        }

        /**
         * Adds steals to player's total steals made counter
         * @param stealsMade steals made in a game
         */
        public void addSteals(Double stealsMade){
            stealsMadeTotal+=stealsMade;
        }

        /**
         * Superstar role sub-class
         */
        static class Superstar extends Player {

            Double roleModifier = 1.4;

            /**
             * Constructor
             * @param name superstar's name
             * @param lastName superstar's last name
             * @param points superstar's points scored per game
             * @param assists superstar's assists made per game
             * @param blocks superstar's blocks made per game
             * @param steals superstar's steals made per game
             * @param roleModifier superstar's role modifier
             * @param role superstar's role
             */
            public Superstar(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                super(name, lastName, points, assists, blocks, steals, role);
                this.roleModifier = roleModifier;
            }

            /**
             * Constructor from player object
             * @param player player object
             */
            public Superstar(Player player){
                super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "Superstar");
            }

            /**
             * Gets superstar's role modifier
             * @return superstar's role modifier
             */
            public Double getRoleModifier(){
                return this.roleModifier;
            }

        }

        /**
         * Star role subclass
         */
        static class Star extends Player {

            Double roleModifier = 1.25;

            /**
             * Constructor
             * @param name star's name
             * @param lastName star's last name
             * @param points star's points scored per game
             * @param assists star's assists made per game
             * @param blocks star's blocks made per game
             * @param steals star's steals made per game
             * @param roleModifier star's role modifier
             * @param role star's role
             */
            public Star(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                super(name, lastName, points, assists, blocks, steals, role);
                this.roleModifier = roleModifier;
            }

            /**
             * Constructor from player object
             * @param player player object
             */
            public Star(Player player){
                super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "Star");
            }

            /**
             * Gets star's role modifier
             * @return role modifier
             */
            public Double getRoleModifier(){
                return this.roleModifier;
            }

        }

        /**
         * Starer role subclass
         */
        static class Starter extends Player {

            Double roleModifier = 1.15;

            /**
             * Constructor
             * @param name starer's name
             * @param lastName starer's last name
             * @param points starer's points scored per game
             * @param assists starer's assists made per game
             * @param blocks starer's blocks made per game
             * @param steals starer's steals made per game
             * @param roleModifier starer's role modifier
             * @param role starer's role
             */
            public Starter(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                super(name, lastName, points, assists, blocks, steals, role);
                this.roleModifier = roleModifier;
            }

            /**
             * Constructor from player object
             * @param player player object
             */
            public Starter(Player player){
                super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "Starter");
            }

            /**
             * Gets starter's role modifier
             * @return role modifier
             */
            public Double getRoleModifier(){
                return this.roleModifier;
            }

        }

        /**
         * Role player subclass
         */
        static class RolePlayer extends Player {

            Double roleModifier = 1.05;

            /**
             * Constructor
             * @param name role player's name
             * @param lastName role player's last name
             * @param points role player's points scored per game
             * @param assists role player's assists made per game
             * @param blocks role player's blocks made per game
             * @param steals role player's steals made per game
             * @param roleModifier role player's role modifier
             * @param role role player's role
             */
            public RolePlayer(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                super(name, lastName, points, assists, blocks, steals, role);
                this.roleModifier = roleModifier;
            }

            /**
             * Constructor from player object
             * @param player player object
             */
            public RolePlayer(Player player){
                super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "RolePlayer");
            }

            /**
             * Gets role player's role modifier
             * @return role modifier
             */
            public Double getRoleModifier(){
                return this.roleModifier;
            }

        }

        /**
         * Sixth man subclass
         */
        static class SixthMan extends Player {

            Double roleModifier = 0.1;

            /**
             * Constructor
             * @param name sixth man's name
             * @param lastName sixth man's last name
             * @param points sixth man's points scored per game
             * @param assists sixth man's assists made per game
             * @param blocks sixth man's blocks made per game
             * @param steals sixth man's steals made per game
             * @param roleModifier sixth man's role modifier
             * @param role sixth man's role
             */
            public SixthMan(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                super(name, lastName, points, assists, blocks, steals, role);
                this.roleModifier = roleModifier;
            }

            /**
             * Constructor from player object
             * @param player player object
             */
            public SixthMan(Player player){
                super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "SixthMan");
            }

            /**
             * Gets sixth man's  role modifier
             * @return role modifier
             */
            public Double getRoleModifier(){
                return this.roleModifier;
            }

        }

        /**
         * Bench player subclass
         */
        static class BenchPlayer extends  Player{
            Double roleModifier = 0.9;

            /**
             * Constructor
             * @param name bench player's name
             * @param lastName bench player's last name
             * @param points bench player's points scored per game
             * @param assists bench player's assists made per game
             * @param blocks bench player's blocks made per game
             * @param steals bench player's steals made per game
             * @param roleModifier bench player's role modifier
             * @param role bench player's role
             */
            public BenchPlayer(String name, String lastName, Double points, Double assists, Double blocks, Double steals, Double roleModifier, String role){
                super(name, lastName, points, assists, blocks, steals, role);
                this.roleModifier = roleModifier;
            }

            /**
             * Constructor from player object
             * @param player player object
             */
            public BenchPlayer(Player player){
                super(player.getName(), player.getLastName(), player.getPoints(), player.getAssists(), player.getBlocks(), player.getSteals(), "BenchPlayer");
            }

            /**
             * Gets bench player's role modifier
             * @return role modifier
             */
            public Double getRoleModifier(){
                return this.roleModifier;
            }

        }


    }


}


/**
 * Class that represents tournament
 */
class Tournament {

    private Integer round = 1;

    // Teams draw

    /**
     * Draws teams into pairs
     * @param teams ArrayList of all teams
     */
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

    // Removes teams that lost round

    /**
     * Removes teams that lost round
     * @param teams ArrayList of all teams
     */
    public void removeLosers(ArrayList<Team> teams) {
        teams.removeIf(team -> (team.getWins() % 4 != 0));
        teams.removeIf(team -> (team.getWins() == 0));
    }
    // Adds removed teams to the copy array for the post simulation stats

    /**
     * Adds teams that lost round to ArrayList copy
     * @param teams ArrayList of all teams
     * @param teamsCopy Copy of ArrayList of all teams
     */
    public void addLosers(ArrayList<Team> teams, ArrayList<Team> teamsCopy) {
        for (Team team : teams) {
            if (team.getWins() % 4 != 0 || team.getWins() == 0) {
                teamsCopy.add(team);
            }
        }
    }

    // Shows post tournament stats of teams

    /**
     * Shows round outcome
     * @param teams ArrayList of all teams
     */
    public void showStats(ArrayList<Team> teams) {
        for (Team team : teams) {
            System.out.println(team.getName() + " Wygrane: " + team.getWins() + " Porazki: " + team.getLosses() + " Punkty zdobyte: " + team.getPointsScoredTotal() + " Punkty stracone: " + team.getPointsLostTotal() + " Punkty zdobyte na mecz: " + team.getPointsScoredPerGame() + " Punkty stracone na mecz: " + team.getPointsLostPerGame());
        }
    }
    // Shows post tournament stats of players

    /**
     * Shows post tournament stats of all players
     * @param teams ArrayList of all teams
     */
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

    // Increments round

    /**
     * Increases round
     */
    public void increaseRound() {
        round += 1;
    }


    /**
     * Class that represents series between two teams
     */
    static class Series {

        public Integer firstTeamWins = 0;
        public Integer secondTeamWins = 0;
        public boolean winner;

        // Simulates series of games between two teams

        /**
         * Simulates series between two teams
         * @param One first team
         * @param Two second team
         */
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

        // Shows series scores

        /**
         * Shows outcome of the series
         * @param One first team
         * @param Two second team
         */
        public void showScores(Team One, Team Two) {
            System.out.println("     Wynik Serii: ");
            System.out.println(One.getName() + " " + firstTeamWins + " : " + secondTeamWins + " " + Two.getName());
        }

        public boolean getWinner() {
            return winner;
        }

    }

    /**
     * Class that simulates single game
     */
    static class GameSimulator {
        public Double firstTeamPointsScored = 0.0;
        public Double secondTeamPointsScored = 0.0;

        // Teams points scored in a game

        /**
         * Gets first team points scored in a game
         * @return
         */
        public Double getFirstTeamPointsScored() {
            return firstTeamPointsScored;
        }

        /**
         * Gets second team points scored in a game
         * @return
         */
        public Double getSecondTeamPointsScored() {
            return secondTeamPointsScored;
        }


        // Class used to display game stats

        /**
         * Class that displays post game statistics
         */
        static class GameScores{
            public ArrayList<String> teamOneScores = new ArrayList<String>();
            public ArrayList<String> teamTwoScores = new ArrayList<String>();

            /**
             * Adds game statistics of first team to the ArrayList of first team scores
             * @param statLine fist team game statistics
             */
            public void addTeamOneStatLine(String statLine){
                teamOneScores.add(statLine);
            }

            /**
             * Adds game statistics of second team to the ArrayList of second team scores
             * @param statLine
             */
            public void addTeamTwoStatLine(String statLine){
                teamTwoScores.add(statLine);
            }

            // Shows teams game stat lines

            /**
             * Shows teams game statistics
             * @param One first team
             * @param Two second team
             */
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

            /**
             * Clears scores ArrayList
             */
            public void clearTeamOneScores(){
                teamOneScores.clear();
            }

            /**
             * Clears scores ArrayList
             */
            public void clearTeamTwoScores(){
                teamTwoScores.clear();
            }

        }

        GameScores gameScore = new GameScores();

        // Calculates teams performances in a game

        /**
         * Calculates teams performance in a game
         * @param One first team
         * @param Two second team
         */
        public void calculateTeamsScores(Team One, Team Two) {

            Double playerLowPerformance = 0.3;



            // Calculating outcome of every one vs one match-up (Superstar vs Superstar, Star vs Star etc.)

            for (int i = 0; i < 7; i++) {
                Random random = new Random();
                String teamOneStatLine = One.players.get(i).getName() + " " + One.players.get(i).getLastName() + " ";
                String teamTwoStatLine = Two.players.get(i).getName() + " " + Two.players.get(i).getLastName() + " ";

                // Performace of players 1vs1

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





            }


        }


        // Gets winner of a game

        /**
         * Gets winner of a game
         * @param One first team
         * @param Two second team
         * @return winner of a game
         */
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

    // Lorem
    // Ipsum
    // dolor sit amet
}