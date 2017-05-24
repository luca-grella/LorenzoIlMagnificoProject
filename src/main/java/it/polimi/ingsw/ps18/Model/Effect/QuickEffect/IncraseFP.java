package it.polimi.ingsw.ps18.Model.Effect.QuickEffect;

import it.polimi.ingsw.ps18.Model.PBoard.PBoard;
import it.polimi.ingsw.ps18.Model.PBoard.Resources.Stats;

public class IncraseFP implements QuickEffect {

	@Override
	public void activate(PBoard player) {
		Stats stat = player.getResources();
		stat.addFP(1);
		
	}

}
