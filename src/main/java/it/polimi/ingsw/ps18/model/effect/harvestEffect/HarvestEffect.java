package it.polimi.ingsw.ps18.model.effect.harvestEffect;

import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public interface HarvestEffect {
	
    public void activate(PBoard player);
	
	public void setQuantity(int quantity);

}
