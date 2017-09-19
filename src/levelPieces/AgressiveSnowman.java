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
			if (super.getLocation() < pieces.length - 2) {
				//if an entity is to the right of the snowman when attempting to move right, don't move
				if (pieces[super.getLocation() + 1] != null || (playerLocation == super.getLocation() +1)){
					return;
				}
					
				//set the new location and swap it in the array
				swap(pieces, 1);
				super.setLocation(super.getLocation() + 1);
				}
			}
		//move left
		else {
			if (super.getLocation() > 0) {
			//same structure applies here as above
			if (pieces[super.getLocation() - 1] != null || (playerLocation == super.getLocation() - 1)){ 
				return;
			}
			
			swap(pieces, -1);
			super.setLocation(super.getLocation() - 1);
			
			}		
		}
	}
	
		@Override
		public InteractionResult interact(Drawable[] pieces, int playerLocation) {
			//if the player is one square away from the snowman, he will throw a snowball
			if (Math.abs(playerLocation - super.getLocation()) == 1) {
				System.out.println("The rather agressive snowman throws an agressive snowball at you... agressively");
				return InteractionResult.HIT;
			}
		return InteractionResult.NONE;
	}

		@Override
		//this function moves the character one space left or right in the array, as denoted by the changeMove argument
		public void swap(Drawable[] pieces, int changeMove) {
			pieces[super.getLocation() + changeMove] = pieces[super.getLocation()];
			pieces[super.getLocation()] = null;
		}
}
