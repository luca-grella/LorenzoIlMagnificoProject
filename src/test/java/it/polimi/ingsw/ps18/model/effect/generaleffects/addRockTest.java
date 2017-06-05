package it.polimi.ingsw.ps18.model.effect.generaleffects;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addRock;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class addRockTest {
	Random rand  = new Random();
	int a = rand.nextInt(1000);
	int b = rand.nextInt(1000);
	
	/**
	 * Generate a player and test the function of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addRock#activate(PBoard)}
	 */
	@Test
	public void testActivate() {
		addRock tester = new addRock();
		tester.setQuantity(b);
		List<Dice> dices = new ArrayList<>(1);
		dices.add(new Dice(0));
		PBoard player = new PBoard(a, dices);
		Stats stats = player.getStats();
		int ris = stats.getRock();
		tester.activate(player);
		int ris2 = stats.getRock();
		if(ris2!=ris + tester.getQuantity()){
			fail("Activate non funziona");
		}
	}

	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addRock#getQuantity()}
	 */
	@Test
	public void testGetQuantity() {
		addRock tester = new addRock();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}
	}

	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addRock#setQuantity()}
	 */
	@Test
	public void testSetQuantity() {
		addRock tester = new addRock();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella setQuantity");
		}
	}

}
