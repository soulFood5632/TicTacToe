import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;

public class Main {

    public static int playAgainst(Computer computer) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean doesUserStart;

        if(Math.random() > 0.5){
            System.out.println("You will start");
            doesUserStart = true;
        } else {
            System.out.println("Computer will start");
            doesUserStart = false;
        }
        TicTacToeGame game = new TicTacToeGame();
        if (doesUserStart) {
            while(true){
                System.out.println("Please enter your move and press enter");
                Move move = new Move(Integer.parseInt(br.readLine()));
                game.makeMove(move, GamePiece.X);
                game.printString();
                if(game.isGameOver()){
                    break;
                }
                computer.doMove(game, GamePiece.O);
                game.printString();
                if(game.isGameOver()){
                    break;
                }
            }
        } else {
            while(true){
                computer.doMove(game, GamePiece.O);
                game.printString();
                if(game.isGameOver()){
                    break;
                }
                System.out.println("Please enter your move and press enter");
                Move move = new Move(Integer.parseInt(br.readLine()));
                game.makeMove(move, GamePiece.X);
                game.printString();
                if(game.isGameOver()){
                    break;
                }

            }

        }

        if(game.whoWon() == GamePiece.X){
            System.out.println("Great win");
            return 1;
        } else if(game.whoWon() == GamePiece.O){
            System.out.println("Oh Boy, You are a Loser");
            return -1;
        } else {
            System.out.println("Until next time");
            return 0;
        }


    }

    public static void main(String[] args) throws IOException {

//        String computer1Info = Files.readString(Path.of("computer1.txt"));
//        String computer2Info = Files.readString(Path.of("computer2.txt"));
//
//        Computer computer1 = new Computer(new GameHistory(100000000, computer1Info));



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean playAgain = true;
//
        Computer computer1 = new Computer(50);
        Computer computer2 = new Computer(50);
        for(int i = 0; i < 5000000; i++) {
            Computer.playGames(computer1, computer2);
            Computer.playGames(computer2, computer1);
            if(i % 10000 == 0){
                System.out.println("Computer 1 " + i + " " + computer1.getWinPct());
                System.out.println("Computer 2 " + i + " " +  computer2.getWinPct());
            }
        }

        PrintStream out1 = new PrintStream(new FileOutputStream("computer1.txt"));
        PrintStream out2 = new PrintStream(new FileOutputStream("computer2.txt"));


        out1.print(computer1.getData());

        out1.close();

        out2.print(computer1.getData());

        out2.close();











        int[] record = {0, 0, 0};

        while(playAgain) {
            int result = Main.playAgainst(computer1);
            if (result == 1){
                record[0] += 1;
            } else if (result == 0){
                record[1] += 1;
            } else {
                record[2] += 1;
            }
            System.out.println("Do you want to play again (T to continue, any other key to exit)");
            if(br.readLine().equals("T")) {
                playAgain = true;
            } else {
                playAgain = false;
            }

        }

        System.out.println("Your final record is: \n" + record[0] + " Wins, "
                + record[1] + " ties, and " + record[2] + " losses");




    }
}
