package it.polimi.ingsw.ps18;

import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;

public class Test {

	public static void main(String[] args) {
		GameLogic game = new GameLogic(1);
		
		
		game.setup();
		game.gameFlow();

	}

}
