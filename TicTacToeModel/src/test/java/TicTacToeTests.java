import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTests {

    TicTacToeGame ticTacToeGame;

    @BeforeEach
    public void setUpTests(){
        ticTacToeGame = new TicTacToeGame();
    }

    @Test
    public void testSimpleGame() {
        assertFalse(ticTacToeGame.isGameOver());
        assertNull(ticTacToeGame.getBoard().getBoard()[0]);

        assertTrue(ticTacToeGame.makeMove(new Move(0), GamePiece.O));
        assertFalse(ticTacToeGame.makeMove(new Move(0), GamePiece.O));
        assertTrue(ticTacToeGame.makeMove(new Move(1), GamePiece.O));

        assertFalse(ticTacToeGame.isGameOver());
        assertTrue(ticTacToeGame.makeMove(new Move(2), GamePiece.O));
        ticTacToeGame.printString();
        assertTrue(ticTacToeGame.isGameOver());
        assertEquals(GamePiece.O, ticTacToeGame.whoWon());
    }

    @Test
    public void testTwoPlayerGame() {
        assertTrue(ticTacToeGame.makeMove(new Move(0), GamePiece.O));
        assertFalse(ticTacToeGame.makeMove(new Move(0), GamePiece.X));
        assertTrue(ticTacToeGame.makeMove(new Move(1), GamePiece.X));

        assertFalse(ticTacToeGame.isGameOver());
        assertTrue(ticTacToeGame.makeMove(new Move(2), GamePiece.O));
        assertTrue(ticTacToeGame.makeMove(new Move(7), GamePiece.X));


        assertTrue(ticTacToeGame.makeMove(new Move(6), GamePiece.O));
        assertTrue(ticTacToeGame.makeMove(new Move(4), GamePiece.X));

        assertTrue(ticTacToeGame.isGameOver());
        assertEquals(GamePiece.X, ticTacToeGame.whoWon());
        ticTacToeGame.printString();
    }

    @Test
    public void testTie() {
        assertTrue(ticTacToeGame.makeMove(new Move(0), GamePiece.O));
        assertTrue(ticTacToeGame.makeMove(new Move(1), GamePiece.X));

        assertFalse(ticTacToeGame.isGameOver());
        assertTrue(ticTacToeGame.makeMove(new Move(2), GamePiece.O));
        assertTrue(ticTacToeGame.makeMove(new Move(3), GamePiece.X));
        assertTrue(ticTacToeGame.makeMove(new Move(5), GamePiece.X));


        assertTrue(ticTacToeGame.makeMove(new Move(4), GamePiece.O));
        assertTrue(ticTacToeGame.makeMove(new Move(6), GamePiece.X));
        assertTrue(ticTacToeGame.makeMove(new Move(8), GamePiece.X));
        assertTrue(ticTacToeGame.makeMove(new Move(7), GamePiece.O));
        assertTrue(ticTacToeGame.isGameOver());
        assertNull(ticTacToeGame.whoWon());
        ticTacToeGame.printString();
    }


}
