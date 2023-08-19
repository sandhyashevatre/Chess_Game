package Chess_Game;


public class Square {
	private Piece piece;
	private int x;
	private int y;
	
	public Square(int x, int y, Piece piece) {
		this.x = x;
		this.y = y;
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
}