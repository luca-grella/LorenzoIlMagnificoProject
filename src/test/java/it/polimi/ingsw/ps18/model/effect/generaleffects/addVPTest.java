package it.polimi.ingsw.ps18.model.effect.generaleffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addVP;
import it.polimi.ingsw.ps18.model.gameLogic.Dice;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;
import it.polimi.ingsw.ps18.model.personalBoard.resources.Stats;

public class addVPTest {
	Random rand  = new Random();
	int a = rand.nextInt(1000);
	int b = rand.nextInt(1000);
	
	/**
	 * Generate a player and test the function of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addVP#activate(PBoard)}
	 */
	@Test
	public void testActivate() {
		addVP tester = new addVP();
		tester.setQuantity(b);
		List<Dice> dices = new ArrayList<>(1);
		dices.add(new Dice(0));
		PBoard player = new PBoard(a, dices, null);
		Stats stats = player.getStats();
		int ris = stats.getVP();
		tester.activate(player);
		int ris2 = stats.getVP();
		if(ris2!=ris + tester.getQuantity()){
			fail("Activate non funziona");
		}
	}

	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addVP#getQuantity()}
	 */
	@Test
	public void testGetQuantity() {
		addVP tester = new addVP();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}
	}

	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addVP#setQuantity()}
	 */
	@Test
	public void testSetQuantity() {
		addVP tester = new addVP();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella setQuantity");
		}
	}
}
