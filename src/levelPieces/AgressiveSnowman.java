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
		System.out.println("Snowman wants to move!");
		int randInt = rand.nextInt(1);
		//move right
		if (randInt == 0) {
			//if the player to the right of the snowman when attempting to move right, don't move
			if (playerLocation == super.getLocation() + 1){
				System.out.println("Snowman can't move!");
				return;
			}
				//otherwise, if the snowman is not at the end of the board, move one space right
				if (super.getLocation() != pieces.length - 1) {
					//set the new location and swap it in the array
					System.out.println("Snowman moves right!");
					super.setLocation(super.getLocation() + 1);
					swap(pieces, 1);
				}
		}
		//move left
		else {
			//same structure applies here as above
			if (playerLocation == super.getLocation() - 1){ 
				System.out.println("Snowman can't move!");
				return;
			}
			
			if (super.getLocation() != 0) {
				System.out.println("Snowman moves left!");
				super.setLocation(super.getLocation() - 2);
				swap(pieces, -1);
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
			Drawable temp = pieces[super.getLocation()];
			pieces[super.getLocation()] = pieces[super.getLocation() + changeMove];
			pieces[super.getLocation() + changeMove] = temp;
		}
}
