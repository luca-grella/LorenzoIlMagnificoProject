package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;


public class PurpleC extends Cards {
	private List<FinalEffect> fineffect = new ArrayList<>();
	
	/**
	 * @return the fineffect
	 */
	public List<FinalEffect> getFineffect() {
		return fineffect;
	}
	/**
	 * @param fineffect the fineffect to set
	 */
	public void setFineffect(List<FinalEffect> fineffect) {
		this.fineffect = fineffect;
	}
	
	

}
