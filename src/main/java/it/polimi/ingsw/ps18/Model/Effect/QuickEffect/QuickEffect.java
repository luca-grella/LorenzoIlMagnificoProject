package it.polimi.ingsw.ps18.model.effect.quickEffect;

import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public interface QuickEffect {
	
	public void activate(PBoard player);
	
	public void setQuantity(int quantity);

}
