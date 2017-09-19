package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class IntrovertedSpider extends GamePiece implements Drawable, Moveable {

	private boolean givenPrize = false;
	
	public IntrovertedSpider(int location) {
		super('m', location);
	}

	@Override
	public void move(Drawable[] pieces, int playerLocation) {
		if (Math.abs(playerLocation - super.getLocation()) > 2) {
			if (playerLocation <= super.getLocation() && super.getLocation() < pieces.length - 2 && pieces[super.getLocation() + 1] == null) {
				swap(pieces, 1);
				super.setLocation(super.getLocation() + 1);
				
			}
			else if (playerLocation > super.getLocation() && super.getLocation() > 0 && pieces[super.getLocation() - 1] == null) {
				swap(pieces, -1);
				super.setLocation(super.getLocation() - 1);
				
			}
		}
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (Math.abs(playerLocation - super.getLocation()) <= 1) {
			System.out.println("The introverted spider assumes the fetal position and wont move or speak to you.");
		}
		if (!givenPrize && Math.abs(playerLocation - super.getLocation()) == 2){
			System.out.println("The introverted spider lets out a small wimper as he reaches a long limb out to you to hand you a present");
			givenPrize = true;
			return InteractionResult.GET_POINT;
		}
		
		return InteractionResult.NONE;
	}

	@Override
	public void swap(Drawable[] pieces, int changeMove) {
		pieces[super.getLocation() + changeMove] = pieces[super.getLocation()];
		pieces[super.getLocation()] = null;
	}

}
