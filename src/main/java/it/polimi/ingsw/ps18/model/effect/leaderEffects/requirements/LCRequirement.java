package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public interface LCRequirement {
	
	public boolean checkRequirement(PBoard player);
	
	public String toString();

}
