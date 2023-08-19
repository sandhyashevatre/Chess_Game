package Chess_Game;


public abstract class Piece {
	
	private boolean white = false;
	private Type type;
	public Piece(Type type,boolean white) {
		this.white = white;
		this.type = type;
	}
	
	public boolean isWhite() {return white;}
	public abstract boolean canMove(Board board, Square start, Square end); 
	
	public String getType() { return String.valueOf(type.getName()); }
	@Override
	public String toString() {
		return String.format("%s(%s)", this.type.getName(), this.isWhite() ? "W" : "B");
	}
	
	public boolean isPathClear(Board board, Square start, Square end) {
		int startX = start.getX();
		int startY = start.getY();
		
		int endX = end.getX();
		int endY = end.getY();
		
		int xDiff = Integer.compare(endX, startX);
		int yDiff = Integer.compare(endY, startY);
		
		int currentX = startX + xDiff;
		int currentY = startY + yDiff;
		
		while (currentX != endX || currentY != endY) {
			if (board.getSquare(currentX, currentY).getPiece() != null) {
				return false;
			}
			currentX += xDiff;
			currentY += yDiff;
		}
		
		return true;
	}
}
