package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

import java.util.Random;

public class AgressiveSnowman extends GamePiece implements Moveable, Drawable {
	
	static Random rand = new Random();
	private boolean isAlive;

	public AgressiveSnowman(int location) {
		super('8', location);
		this.isAlive = true;
	}

	@Override
	public void move(Drawable[] pieces, int playerLocation) {
		int randInt = rand.nextInt(2);
		//move right
		if (randInt == 0) {
			if (playerLocation == super.getLocation() + 1) return;
				//move
				super.setLocation(super.getLocation() + 1);
		}
		//move left
		else {
			if (playerLocation == super.getLocation() - 1) return;
			
				super.setLocation(super.getLocation() - 1);
		}
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		
		if (Math.abs(playerLocation - super.getLocation()) == 1) return InteractionResult.HIT;
		else if (playerLocation == super.getLocation()) isAlive = false;
		
		return InteractionResult.NONE;
	}
	
	public boolean isAlive() {
		return isAlive;
	}

}
