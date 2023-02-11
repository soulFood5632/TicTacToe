import java.util.*;

public class TicTacToeGame {
    private final Board gameBoard;
    private final Map<Board, Move> movesX;
    private final Map<Board, Move> movesO;




    /**
     * Starts a new game with an emptyBoard
     */
    public TicTacToeGame() {
        gameBoard = new Board();
        movesX = new HashMap<>();
        movesO = new HashMap<>();
    }


    /**
     * Returns the gameBoard
     * @return a 9 element array containing current
     */
    public Board getBoard() {
        return new Board(gameBoard.getBoard());
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

        return gameBoard.makeMove(move, turn);


    }

    public static List<Move> validMoves(GamePiece[] gameBoard){
        int index = 0;
        List<Move> validMoves = new ArrayList<>();
        for(GamePiece values: gameBoard){
            if (values == null){
                validMoves.add(new Move(index));
            }
            index++;
        }

        return validMoves;
    }

    /**
     * Finds if the game is over
     * @return true if the game is over false otherwise
     */
    public boolean isGameOver() {
        return gameBoard.isGameOver();
    }

    /**
     * Finds out who has won the game
     * - Only be called when the game is complete
     * @return X if the game has been won by X, O if has been won by O, null
     * if there is a tie
     */

    public GamePiece whoWon(){
        return gameBoard.whoWon();
    }

    public Map<Board, Move> getMoves(GamePiece gamePiece) {
        if (gamePiece == GamePiece.X) {
            return new HashMap<>(movesX);
        } else {
            return new HashMap<>(movesO);
        }
    }

    public void printString() {
        gameBoard.printString();


    }











}
