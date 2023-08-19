package Chess_Game;

public class Board {
	private Square[][] board;
	private static final int ROWS = 8;
	private static final int COLUMNS = 8;
	
	
	public Board() {
		board = new Square[ROWS][COLUMNS];
		initialize();
	}
	
	public void initialize() {
		// top black pieces row 0 , 1
		
		for (int i = 0; i < COLUMNS; i++) {
			board[1][i] = new Square(1, i, new Pawn(Type.PAWN,false)); // black piece
			board[6][i] = new Square(6, i, new Pawn(Type.PAWN,true)); // white piece
		}
		
		// black queen, king
		board[0][3] = new Square(0, 3, new Queen(Type.QUEEN, false));
		board[0][4] = new Square(0, 4, new King(Type.KING,false)); 
		
		// white queen, king
		board[7][3] = new Square(7, 3, new Queen(Type.QUEEN,true));
		board[7][4] = new Square(7, 4, new King(Type.KING,true));

		// black rooks
		board[0][0] = new Square(0, 0, new Rook(Type.ROOK, false));
		board[0][7] = new Square(0, 7, new Rook(Type.ROOK, false));
		
		//white rooks
		board[7][0] = new Square(7, 0, new Rook(Type.ROOK,true));
		board[7][7] = new Square(7, 7, new Rook(Type.ROOK, true));
		
		// black knights
		board[0][1] = new Square(0, 1, new Knight(Type.KNIGHT,false));
		board[0][6] = new Square(0, 6, new Knight(Type.KNIGHT,false));
		
		// white knights
		board[7][1] = new Square(7, 1, new Knight(Type.KNIGHT,true));
		board[7][6] = new Square(7, 6, new Knight(Type.KNIGHT,true));
		
		// black bishops
		board[0][2] = new Square(0, 2, new Bishop(Type.BISHOP, false));
		board[0][5] = new Square(0, 5, new Bishop(Type.BISHOP, false));
		
		// white bishops
		board[7][2] = new Square(7, 2, new Bishop(Type.BISHOP, true));
		board[7][5] = new Square(7, 5, new Bishop(Type.BISHOP, true));
		
		for (int i = 2; i < ROWS - 2; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				board[i][j] = new Square(i, j, null);
			}
		}
		
	}
	public Square getSquare(int x, int y) {
		return board[x][y];
	}
	public void clearSquare(int x, int y) {
		board[x][y] = new Square(x, y, null);
	}
	
	public void setSquare(int x, int y, Piece piece) {
		board[x][y] = new Square(x, y, piece);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ROWS; i++) {
//			sb.append(ROWS - i + " ");
			for (int j = 0; j < COLUMNS; j++) {
				if (board[i][j].getPiece() != null) sb.append(board[i][j].getPiece());
				else sb.append("____");
				if (j < COLUMNS - 1) sb.append('|');
			}
			sb.append("\n");
		}
//		for (int i = 0; i < COLUMNS; i++) {
//			sb.append(String.format("    %s", (char) ('a' + i) ));
//		}
		return sb.toString();
	}

}
