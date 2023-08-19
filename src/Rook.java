package Chess_Game;


public class Rook extends Piece {
	public Rook(Type type, boolean white) {
		super(type, white);
	}
	
	@Override
	public boolean canMove(Board board, Square start, Square end) {
		if (start.getX() == end.getX() || start.getY() == end.getY()) {
			return isPathClear(board, start, end);
		}
		return false;
	}

}