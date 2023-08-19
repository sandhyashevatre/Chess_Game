package Chess_Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessPersistence {
	private String fileName;
	private static final String SPACE = " ";
	private static final String HYPEN = "-";
	
	public ChessPersistence(String fileName) {
		this.fileName = fileName;
	}
	
	public List<List<String>> getMoves() {
		List<List<String>> moves = new ArrayList<List<String>>();
		try {
			Path path = Paths.get(fileName);
			List<String> lines = Files.readAllLines(path); 
			List<String> startMoves = new ArrayList<>();
			List<String> endMoves = new ArrayList<>();
			int index = 0;
			for (String line : lines) {
				index++;
				String[] currentMoves = line.replace(HYPEN, SPACE).split(SPACE);
				if (currentMoves.length != 4) {
					throw new InvalidMoveException("not a valid move at line number " + index);
				}
				
				startMoves.addAll(Arrays.asList(currentMoves[0],currentMoves[2])); //even are start squares of both players
				endMoves.addAll(Arrays.asList(currentMoves[1],currentMoves[3])); //odd are end squares of both players
				
			}
			moves.add(startMoves);
			moves.add(endMoves);
			
		} catch(IOException | InvalidMoveException e) {
			e.printStackTrace();
		}
		return moves;
	}
	
	public static List<Integer> convertToPos(String moveStr) {
		List<Integer> move = new ArrayList<>();
		move.add(8 - Integer.valueOf(moveStr.substring(1)));
		move.add(moveStr.charAt(0) - 'a');
		return move;
	}
	
}