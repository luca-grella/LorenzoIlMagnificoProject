package it.polimi.ingsw.ps18.Controller;

import it.polimi.ingsw.ps18.Model.Cards.*;
import it.polimi.ingsw.ps18.Model.Effect.QuickEffect.HashMapQE;
import it.polimi.ingsw.ps18.Model.PBoard.PBoard;

public class main {

	public static void main(String[] args) {
		PBoard p1 = new PBoard(0);
		HashMapQE.init();
		System.out.println("Creazione Carta");
		Cards card = new GreenC();
		
		p1.printResources();
		p1.addCard(card);
		System.out.println("Post applicazione effetto carta:");
		p1.printResources();

	}

}
