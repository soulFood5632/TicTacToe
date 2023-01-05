import com.google.gson.Gson;
import com.google.gson.JsonSerializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class GameHistory {

    private final Map<Board, Map<Move, int[]>> history = new HashMap<>();
    private double randomnessFactor;

    private int moveCounter;

    public GameHistory(double randomnessFactor){
        this.randomnessFactor = randomnessFactor;
        moveCounter = 0;
    }

    public GameHistory(double randomnessFactor, String dataJSON){
        Gson gson = new Gson();
        this.randomnessFactor = randomnessFactor;
        moveCounter = 0;
        gson.fromJson(dataJSON, HashMap.class);
    }

    public String saveData() {
        Gson gson = new Gson();

        JsonSerializer<Board> boardJsonSerializer = new JsonSerializer<Board>(){

        }

        return gson.toJson(history, HashMap.class);
    }

    public void addHistory(Map<Board, Move> moveMap, int winVal) {
        moveMap.forEach((board, move) ->{
            if(history.containsKey(board)){
                if(history.get(board).containsKey(move)){
                    history.get(board).get(move)[0] += winVal;
                    history.get(board).get(move)[1] += 1;
                } else {
                    int[] intArr = {winVal, 1};
                    history.get(board).put(move, intArr);
                }
            } else {
                int[] intArr = {winVal, 1};
                history.put(board, new HashMap<>());
                history.get(board).put(move, intArr);
            }
        });
    }


    /**
     *
     * @param board a valid game board of size 9
     * @return the best move according the this tic tac toe model
     */
    public Move getBestMove(Board board) {
        if(moveCounter++ % randomnessFactor == 0) {
            return getRandomMove(board);
        }
        if(history.containsKey(board)){
            double[] currentMax = {0};
            Move[] currentMove = new Move[1];

            history.get(board).forEach((move, scores) -> {
                if (scores[0] / (double) scores[1] > currentMax[0]){
                    currentMove[0] = move;
                    currentMax[0] = scores[0] /(double) scores[1];
                }
            });

            if (currentMax[0] <= 0.001){
                return getRandomMove(board);
            } else {
                return currentMove[0];
            }
        } else {
            return getRandomMove(board);
        }
    }

    /**
     * Gets a valid random move from a given board
     * @param board a valid game board
     * @return The random valid move
     */

    private static Move getRandomMove(Board board){
        List<Move> moveList = TicTacToeGame.validMoves(board.getBoard());
        int randomSelection = (int) Math.round(Math.random() * (moveList.size() - 1));
        return moveList.get(randomSelection);
    }

}
