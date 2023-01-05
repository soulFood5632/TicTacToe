import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Computer {
    private final GameHistory database;
    private final int[] record;




    public Computer(int randomness){
        record = new int[]{0, 0, 0};
        database = new GameHistory(randomness);
    }

    public Computer(GameHistory gameHistory) {
        record = new int[]{0, 0, 0};
        database = gameHistory;

    }

    public String getData() {
        return database.saveData();
    }



    public int[] getRecord() {
        return record.clone();
    }

    public double getWinPct(){
        return (double) record[0] / Arrays.stream(record).sum();
    }

    public void doMove(TicTacToeGame game, GamePiece player){
        Move move = database.getBestMove(game.getBoard());
        game.makeMove(move, player);
    }

    public void addToDatabase(Map<Board, Move> moveMap, int winVal){
        if (winVal == 4) {
            record[0] += 1;
        } else if (winVal == 1) {
            record[1] += 1;
        } else {
            record[2] += 1;
        }
        database.addHistory(moveMap, winVal);
    }

    public static void playGames(Computer computer1, Computer computer2){
        TicTacToeGame game = new TicTacToeGame();
        while(true){
            computer1.doMove(game, GamePiece.X);
            if(game.isGameOver()){
                break;
            }
            computer2.doMove(game, GamePiece.O);
            if(game.isGameOver()){
                break;
            }
        }

        GamePiece result = game.whoWon();

        int computer1WinVal;
        int computer2WinVal;

        if (result == null){
            computer1WinVal = 1;
            computer2WinVal = 1;
        } else if (result == GamePiece.O){
            computer1WinVal = -1;
            computer2WinVal = 4;
        } else {
            computer1WinVal = 4;
            computer2WinVal = -1;
        }

        computer1.addToDatabase(game.getMoves(GamePiece.X), computer1WinVal);
        computer2.addToDatabase(game.getMoves(GamePiece.O), computer2WinVal);
    }

    public static void playGamesAndPrint(Computer computer1, Computer computer2){
        TicTacToeGame game = new TicTacToeGame();
        while(true){
            computer1.doMove(game, GamePiece.X);
            game.printString();
            if(game.isGameOver()){
                break;
            }
            computer2.doMove(game, GamePiece.O);
            game.printString();
            if(game.isGameOver()){
                break;
            }
        }

        GamePiece result = game.whoWon();

        int computer1WinVal;
        int computer2WinVal;

        if (result == null){
            computer1WinVal = 1;
            computer2WinVal = 1;
        } else if (result == GamePiece.O){
            computer1WinVal = -1;
            computer2WinVal = 4;
        } else {
            computer1WinVal = 4;
            computer2WinVal = -1;
        }

        computer1.addToDatabase(game.getMoves(GamePiece.X), computer1WinVal);
        computer2.addToDatabase(game.getMoves(GamePiece.O), computer2WinVal);
    }
}
