package Chess_Game;


public enum Type {
	PAWN('P'),
	ROOK('R'),
	KNIGHT('N'),
	BISHOP('B'),
	QUEEN('Q'),
	KING('K');
	
	private char name;
	
	Type(char name) {
		this.name = name;
	}
	
	public char getName() {
		return this.name;
	}
}