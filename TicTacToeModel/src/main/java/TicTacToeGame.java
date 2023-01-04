import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    private final GamePiece[] gameBoard;

    private final List<Move> movesX;
    private final List<Move> movesO;

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
        movesX = new ArrayList<>();
        movesO = new ArrayList<>();
    }


    /**
     * Returns the gameBoard
     * @return a 9 element array containing current
     */
    public GamePiece[] getBoard() {
        return gameBoard.clone();
    }



    public boolean makeMove(Move move, GamePiece turn) {
        if(gameBoard[move.rowNum * 3 + move.colNum] != null){
            return false;
        }
        gameBoard[move.rowNum * 3 + move.colNum] = turn;
        if(turn == GamePiece.O) {
            movesO.add(move);
        } else {
            movesX.add(move);
        }
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
        return checkDiagonal() || checkVertical() || checkHorizontal();
    }

    /**
     * Finds out who has won the game
     * @return X if the game has been won by X, O if has been won by O, null
     * if there is a tie
     */

    public GamePiece whoWon(){
        if(isBoardFull()) {

        }

    }

    private boolean didTheyWin(GamePiece gamePiece) {

    }





    private boolean isBoardFull() {
        for(GamePiece value: gameBoard) {
            if(value == null) {
                return false;
            }
        }
        return true;
    }



    private boolean checkHorizontal() {
        for(int starter = 0; starter < 3; starter++) {
            if (checkEquals(starter * 3, starter * 3 + 1, starter * 3 + 2)) {
                return true;
            }
        }
        return false;
    }



    private boolean checkVertical() {
        for(int starter = 0; starter < 3; starter++) {
            if (checkEquals(starter, starter + 3, starter + 6)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal() {
        if (checkEquals(0, 4, 8)) {
            return true;
        }
        if (checkEquals(2, 4, 6)) {
            return true;
        }

        return false;
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
            return gameBoard.equals(((TicTacToeGame) other).getBoard());
        }
        return false;
    }









}
