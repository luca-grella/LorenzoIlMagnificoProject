package it.polimi.ingsw.ps18.model.effect.prodEffect;

import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public interface ProductionEffect {
	
    public void activate(PBoard player);
    
    public void setQuantity(int quantity);

}
