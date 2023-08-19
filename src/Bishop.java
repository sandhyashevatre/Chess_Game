package Chess_Game;

public class Bishop {
	public Bishop(Type type, boolean white) {
		super(type,white);
	}
	
	@Override
	public boolean canMove(Board board, Square start, Square end) {
		int xDiff = Math.abs(start.getX() - end.getX());
		int yDiff = Math.abs(start.getY() - end.getY());
		if (xDiff == yDiff) {
			return isPathClear(board, start, end);
		}
		return false;
	}

}
