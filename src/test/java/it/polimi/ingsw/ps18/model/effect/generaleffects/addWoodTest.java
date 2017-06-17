package it.polimi.ingsw.ps18.model.effect.generaleffects;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addWood;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class addWoodTest {
	Random rand  = new Random();
	int a = rand.nextInt(1000);
	int b = rand.nextInt(1000);
	
	/**
	 * Generate a player and test the function of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.add#activate(PBoard)}
	 */
	@Test
	public void testActivate() {
		addWood tester = new addWood();
		tester.setQuantity(b);
		List<Dice> dices = new ArrayList<>(1);
		dices.add(new Dice(0));
		PBoard player = new PBoard(a, dices);
		Stats stats = player.getResources();
		int ris = stats.getWood();
		tester.activate(player, new GameLogic());
		int ris2 = stats.getWood();
		if(ris2!=ris + tester.getQuantity()){
			fail("Activate non funziona");
		}
	}

	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addWood#getQuantity()}
	 */
	@Test
	public void testGetQuantity() {
		addWood tester = new addWood();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}
	}

	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addWood#setQuantity()}
	 */
	@Test
	public void testSetQuantity() {
		addWood tester = new addWood();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella setQuantity");
		}
	}

}
