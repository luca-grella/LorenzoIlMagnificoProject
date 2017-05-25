package it.polimi.ingsw.ps18.Controller;

import it.polimi.ingsw.ps18.Model.Cards.*;
import it.polimi.ingsw.ps18.Model.Effect.QuickEffect.HashMapQE;
import it.polimi.ingsw.ps18.Model.GameLogic.GameLogic;
import it.polimi.ingsw.ps18.Model.PBoard.PBoard;

public class main {

	public static void main(String[] args) {
		GameLogic game = new GameLogic(1);
		
		
		game.setup();
		HashMapQE.init();
		game.gameFlow();

	}

}
