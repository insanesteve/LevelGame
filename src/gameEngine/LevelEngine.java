package gameEngine;

import java.util.ArrayList;

import levelPieces.*;

public class LevelEngine {
	
	//found out this isn't needed because it is in GameEngine as public...smh
	//private static final int BOARD_SIZE = 21;
	private String levelString;
	private int playerLoc;
	
	// Each level has a 1D array of pieces that can be drawn
	private Drawable [] pieces = new Drawable[GameEngine.BOARD_SIZE];
	// Only some pieces can move.
	// need to make a new object....fixed original bug here
	private ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();
	// Only game pieces interact
	private ArrayList<GamePiece> interactingPieces = new ArrayList<GamePiece>();

	public void createLevel(int levelNum) {
		switch(levelNum) {
		case 1:
			levelString = "P  8  .. m m . * * mE";
			break;
		case 2:
			levelString = "P. 8  .. m m . * * mE";
			break;
		}
		
		for (int i = 0; i < pieces.length; i++) {
			switch(levelString.charAt(i)) {
				case 'P':
					playerLoc = i;
				case ' ':
					pieces[i] = null;
					break;
				case '*':
					pieces[i] = new VolatileStar(i);
					interactingPieces.add((GamePiece) pieces[i]);
					break;
				case '8':
					pieces[i] = new AgressiveSnowman(i);
					//Easton spelled "aggressive" wrong...
					movingPieces.add((Moveable) pieces[i]);
					interactingPieces.add((GamePiece) pieces[i]);
					break;
				case 'm':
					pieces[i] = new IntrovertedSpider(i);
					movingPieces.add((Moveable) pieces[i]);
					interactingPieces.add((GamePiece) pieces[i]);
					break;
				case '.':
					pieces[i] = new Rock(i);
					break;
				case 'E':
					pieces[i] = new Exit(i);
			}
			
		}
		
	}

	public Drawable[] getPieces() {
		return pieces;
	}

	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		return playerLoc;
	}

}
