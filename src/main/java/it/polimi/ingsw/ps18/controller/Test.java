package it.polimi.ingsw.ps18.controller;
import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class Test {
	private static List<PBoard> players = new ArrayList<>();
	private static int nplayer = 2;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		for(int i=0; i<nplayer; i++){
			players.add(new PBoard(i));
		}
		MainController prova = new MainController(nplayer,players);
	}

}