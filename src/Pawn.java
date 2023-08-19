package Chess_Game;


public class Pawn extends Piece { //king is subclass of piece
	public Pawn(Type type, boolean white) {
		super(type, white);
	}
	
	@Override
	public boolean canMove(Board board, Square start, Square end) {
		int xDiff = Math.abs(start.getX() - end.getX());
		int yDiff = Math.abs(start.getY() - end.getY());
		
		if (xDiff == 1 && yDiff == 0) {
			return end.getPiece() == null;
		} else if(xDiff == 2 && yDiff == 0 && (this.isWhite() && start.getX() == 6 || !this.isWhite() && start.getX() == 1)) {
			int midX = (start.getX() + end.getX()) / 2;
			return end.getPiece() == null && board.getSquare(midX, start.getY()).getPiece() == null;
		}
		return false;
	}
}
