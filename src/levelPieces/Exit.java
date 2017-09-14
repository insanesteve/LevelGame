package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Exit extends GamePiece implements Drawable {

	public Exit(int location) {
		super('E', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (playerLocation == super.getLocation()) return InteractionResult.ADVANCE;
		return InteractionResult.NONE;
	}

}
