package Chess_Game;


public class Queen extends Piece{
	public Queen(Type type,boolean white) {
		super(type,white);
	}
	
	@Override
	public boolean canMove(Board board, Square start, Square end) {
		int xDiff = Math.abs(start.getX() - end.getX());
		int yDiff = Math.abs(start.getY() - end.getY());
		if (xDiff == yDiff || start.getX() == end.getX() || start.getY() == end.getY()) {
			return isPathClear(board, start, end);
		}
		return false;
	}
}
