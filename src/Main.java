package Chess_Game;

public class Main {

	public static void main(String args[]) {
		Chess chess = new Chess();
		ChessPersistence persistence = new ChessPersistence("src/chess/pgn.txt"); 
		chess.applyPersistedMoves(persistence);
		
		Board finalBoard = chess.getBoard();
		
		
		System.out.println(finalBoard);
		
	}

}
