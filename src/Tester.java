package Chess_Game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import odometers.ReadingException;

public class Tester {
	private Chess chess;
	
	@BeforeEach
	public void setUp() {
		chess = new Chess();
	}
	
	@Test
	public void testBoard() {
		ChessPersistence persistence = new ChessPersistence("src/chess/pgn.txt");
		chess.applyPersistedMoves(persistence);
		Board finalBoard = chess.getBoard();
		String expectedBoardString = """
R(B)|____|B(B)|Q(B)|K(B)|B(B)|N(B)|R(B)
P(B)|P(B)|P(B)|P(B)|____|P(B)|P(B)|P(B)
____|____|N(B)|____|____|____|____|____
____|____|____|____|P(B)|____|____|____
____|____|____|____|P(W)|____|____|____
____|____|____|____|____|N(W)|____|____
P(W)|P(W)|P(W)|P(W)|____|P(W)|P(W)|P(W)
R(W)|N(W)|B(W)|Q(W)|K(W)|B(W)|____|R(W)
	            """;
		assertEquals(expectedBoardString,finalBoard.toString());
	}
	
	@Test
	public void testInvalidMoveException() throws InvalidMoveException {
		ChessPersistence persistence = new ChessPersistence("src/chess/invalid_pgn.txt");
		chess.applyPersistedMoves(persistence);
		
//        assertThrows(InvalidMoveException.class, () -> {        	
//        	chess.applyPersistedMoves(persistence);
//        });
	}
}