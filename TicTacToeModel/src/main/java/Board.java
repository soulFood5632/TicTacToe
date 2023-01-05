import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Board implements Cloneable {
    private GamePiece[] gameBoard;

    private final List<List<Integer>> listOfCombos = new ArrayList<>(){
        {
            add(List.of(0, 1, 2));
            add(List.of(0, 4, 8));
            add(List.of(0, 3, 6));
            add(List.of(1, 4, 7));
            add(List.of(2, 5, 8));
            add(List.of(3, 4, 5));
            add(List.of(6, 7, 8));
            add(List.of(2, 4, 6));
        }
    };

    public Board(){
        gameBoard = new GamePiece[9];
    }

    public Board(GamePiece[] gamePieces){
        gameBoard = gamePieces.clone();
    }

    public GamePiece[] getBoard() {
        return gameBoard.clone();
    }

    public Board clone(){
        return new Board(gameBoard);
    }

    /**
     * Finds if the game is over
     * @return true if the game is over false otherwise
     */
    public boolean isGameOver() {
        if(isBoardFull()) {
            return true;
        }
        for(List<Integer> values: listOfCombos){
            if(checkEquals(values.get(0), values.get(1), values.get(2)) && gameBoard[values.get(0)] != null){
                return true;
            }
        }
        return false;
    }

    /**
     * Finds out who has won the game
     * - Only be called when the game is complete
     * @return X if the game has been won by X, O if has been won by O, null
     * if there is a tie
     */

    public GamePiece whoWon(){

        for(List<Integer> values: listOfCombos) {
            if (checkEquals(values.get(0), values.get(1), values.get(2), GamePiece.X)) {
                return GamePiece.X;
            }
            if (checkEquals(values.get(0), values.get(1), values.get(2), GamePiece.O)) {
                return GamePiece.O;
            }
        }

        return null;

    }




    /**
     * Makes a move on this game.
     * @param move the new position to add. Requires it is a valid move.
     * @param turn the player who is making the move
     * @return true if valid, false if invalid
     */
    public boolean makeMove(Move move, GamePiece turn) {
        if(gameBoard[move.number] != null){
            return false;
        }
        gameBoard[move.number] = turn;

        return true;
    }

    private boolean isBoardFull() {
        for(GamePiece value: gameBoard) {
            if(value == null) {
                return false;
            }
        }
        return true;
    }


    private boolean checkEquals(int one, int two, int three) {
        return gameBoard[one] == gameBoard[two] && gameBoard[two] == gameBoard[three];
    }

    private boolean checkEquals(int one, int two, int three, GamePiece gamePiece) {
        return gameBoard[one] == gamePiece && gameBoard[two] == gamePiece && gamePiece == gameBoard[three];
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return Arrays.equals(gameBoard, board1.gameBoard);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(gameBoard);
    }

    public void printString() {
        for(int i = 0; i < 3; i++) {
            System.out.print("[");
            if (gameBoard[i * 3] != null) {
                System.out.print(entryString(gameBoard[i * 3]));
            } else {
                System.out.print(" ");
            }

            if (gameBoard[i * 3 + 1] != null) {
                System.out.print(entryString(gameBoard[i * 3 + 1]));
            } else {
                System.out.print(" ");
            }

            if (gameBoard[i * 3 + 2] != null) {
                System.out.print(entryString(gameBoard[i * 3 + 2]));
            } else {
                System.out.print(" ");
            }
            System.out.print("]\n");

        }


    }

    /**
     * From an entry in the board, get its String Pair
     * @return a string of "X" for x's, "O" for o's
     */
    private String entryString(GamePiece gamePiece){
        if (gamePiece == GamePiece.X){
            return "X";
        } else {
            return "O";
        }
    }
}
