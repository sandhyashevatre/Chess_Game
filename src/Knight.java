package Chess_Game;

public class Knight {
	public Knight(Type type,boolean white) {
		super(type, white);
	}
	
	@Override
	public boolean canMove(Board board, Square start, Square end) {
		int xDiff = Math.abs(start.getX() - end.getX());
		int yDiff = Math.abs(start.getY() - end.getY());
		
		return end.getPiece() == null && xDiff * yDiff == 2;
	}
	
}
