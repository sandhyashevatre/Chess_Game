package Chess_Game;

import java.util.List;

public class Chess {
	private Board board;

	
	public Chess() {
		board = new Board();
	}
	
	
	public void applyPersistedMoves(ChessPersistence persistence) {
		List<List<String>> moves = persistence.getMoves();
		
		List<String> startMoves = moves.get(0);
		List<String> endMoves = moves.get(1);
		try {
			for (int i = 0; i < 4; i++) {
				String startMove = startMoves.get(i);
	            String endMove = endMoves.get(i);
	            
				List<Integer> currentStart = ChessPersistence.convertToPos(startMove.substring(1));
				List<Integer> currentEnd = ChessPersistence.convertToPos(endMove);
				
				String sourceType = startMove.substring(0,1);
				
				makeMove(currentStart, currentEnd, sourceType);
			}			
		} catch(InvalidMoveException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void makeMove(List<Integer> start, List<Integer> end, String sourceType) throws InvalidMoveException {
		
		Square startSquare = board.getSquare(start.get(0), start.get(1));
		Square endSquare = board.getSquare(end.get(0), end.get(1));
		Piece sourcePiece = startSquare.getPiece();
		
			if (sourcePiece != null && sourcePiece.getType().equalsIgnoreCase(sourceType) && sourcePiece.canMove(board, startSquare, endSquare)) {
				board.setSquare(endSquare.getX(), endSquare.getY(), sourcePiece);
				board.clearSquare(startSquare.getX(), startSquare.getY());
			} else {
				throw new InvalidMoveException("Invalid move for " + sourceType + " from " + start + " to " + end);
			}
			
		
	}
	
	public Board getBoard() {
		return this.board;
	}
}