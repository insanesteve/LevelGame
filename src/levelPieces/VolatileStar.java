package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class VolatileStar  extends GamePiece implements Drawable{

	public VolatileStar(int location) {
		super('*', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		
		if (playerLocation == super.getLocation()) return InteractionResult.HIT;
		return InteractionResult.NONE;
		
	}

}
