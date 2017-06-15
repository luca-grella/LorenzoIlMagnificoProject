package it.polimi.ingsw.ps18.model.cards;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class BlueC extends Cards {

	public BlueC(String string) {
		
	}

	@Override
	public boolean hasHarvest() {
		return false;
	}

	@Override
	public boolean hasProduction() {
		return false;
	}

	@Override
	public boolean hasFinal() {
		return false;
	}

	@Override
	public void activateSecondaryEffect(PBoard player, int actionValue) {
	}

	@Override
	public String toString(int count) {
		return null;
	}
	
	@Override
	public String toString() {
		return null;
	}

}
