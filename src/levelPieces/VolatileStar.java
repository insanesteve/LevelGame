package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class VolatileStar  extends GamePiece implements Drawable{

	public VolatileStar(int location) {
		super('*', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		
		if (playerLocation == super.getLocation()) {
			System.out.println("Oh no it's a volatile star and its really hot and ouch it hit you ouch burns ow");
			return InteractionResult.HIT;
		} 
		return InteractionResult.NONE;
	}

}
