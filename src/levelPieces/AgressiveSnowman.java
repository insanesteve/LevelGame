package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

import java.util.Random;

public class AgressiveSnowman extends GamePiece implements Moveable, Drawable {
	
	static Random rand = new Random();

	public AgressiveSnowman(int location) {
		super('8', location);
	}

	@Override
	public void move(Drawable[] pieces, int playerLocation) {
		int randInt = rand.nextInt(2);
		//move right
		if (randInt == 0) {
			if (playerLocation == super.getLocation() + 1) return;
			
				if (super.getLocation() != pieces.length - 1) {
					super.setLocation(super.getLocation() + 1);
					swap(pieces, 1);
				}
		}
		//move left
		else {
			if (playerLocation == super.getLocation() - 1) return;
			
			if (super.getLocation() != 0) {
				super.setLocation(super.getLocation() - 2);
				swap(pieces, -1);
			}
		}
	}
	
		@Override
		public InteractionResult interact(Drawable[] pieces, int playerLocation) {
			
			if (Math.abs(playerLocation - super.getLocation()) == 1) {
				System.out.println("The rather agressive snowman throws an agressive snowball at you... agressively");
				return InteractionResult.HIT;
			}
		return InteractionResult.NONE;
	}

		@Override
		public void swap(Drawable[] pieces, int changeMove) {
			Drawable temp = pieces[super.getLocation()];
			pieces[super.getLocation()] = pieces[super.getLocation() + changeMove];
			pieces[super.getLocation() + changeMove] = temp;
		}
}
