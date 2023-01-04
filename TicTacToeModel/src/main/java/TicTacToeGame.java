import java.util.*;

public class TicTacToeGame {
    private final GamePiece[] gameBoard;
    private final Map<GamePiece[], Move> movesX;
    private final Map<GamePiece[], Move> movesO;

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



    /**
     * Starts a new game with an emptyBoard
     */
    public TicTacToeGame() {
        gameBoard = new GamePiece[9];
        movesX = new HashMap<>();
        movesO = new HashMap<>();
    }


    /**
     * Returns the gameBoard
     * @return a 9 element array containing current
     */
    public GamePiece[] getBoard() {
        return gameBoard.clone();
    }


    /**
     * Makes a move on this game.
     * @param move the new position to add. Requires it is a valid move.
     * @param turn the player who is making the move
     * @return true if valid, false if invalid
     */
    public boolean makeMove(Move move, GamePiece turn) {
        if(turn == GamePiece.O) {
            movesO.put(gameBoard.clone(), move);
        } else {
            movesX.put(gameBoard.clone(), move);
        }
        if(gameBoard[move.rowNum * 3 + move.colNum] != null){
            return false;
        }
        gameBoard[move.rowNum * 3 + move.colNum] = turn;

        return true;
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
            if(checkEquals(values.get(0), values.get(1), values.get(2))){
                return true;
            }
        }
        return false;
    }

    /**
     * Finds out who has won the game
     *
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
    public boolean equals(Object other) {
        if (other instanceof TicTacToeGame) {
            return Arrays.equals(gameBoard, ((TicTacToeGame) other).getBoard());
        }
        return false;
    }









}
