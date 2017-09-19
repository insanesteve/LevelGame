package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class GeneticallyModifiedBananaPeel extends GamePiece {

	public GeneticallyModifiedBananaPeel(int location) {
		super('w', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		
		if (playerLocation == super.getLocation()) {
			System.out.println("You knew that you should have listened to those GMO studies... you slip on the Genetically Modified Banana Peel and die. ");
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}

}
