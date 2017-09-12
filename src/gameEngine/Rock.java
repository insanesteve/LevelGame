package gameEngine;

import levelPieces.GamePiece;

public class Rock extends GamePiece implements Drawable {

	public Rock(int location) {
		super('.', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (playerLocation == super.getLocation()) {
			System.out.println("You tripped on a rock and died. What a loser...");
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
}
