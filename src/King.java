package Chess_Game;

public class King {
	public King(Type type, boolean white) {
		super(type,white);
	}
	
	@Override
	public boolean canMove(Board board,Square start, Square end) {
		int xDiff = Math.abs(start.getX() - end.getX());
		int yDiff = Math.abs(start.getY() - end.getY());
		
		return xDiff + yDiff == 1 && end.getPiece() == null;
		
	}

}
