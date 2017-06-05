package it.polimi.ingsw.ps18.model.effect.generaleffects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins;
import it.polimi.ingsw.ps18.model.gameLogic.Dice;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * 
 * @author Francesco Musio
 *
 */
public class addCoinsTest {
	Random rand  = new Random();
	int a = rand.nextInt(1000);
	int b = rand.nextInt(1000);
	
	/**
	 * Generate a player and test the function of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins#activate(PBoard)}
	 */
	@Test
	public void testActivate() {
		addCoins tester = new addCoins();
		tester.setQuantity(b);
		List<Dice> dices = new ArrayList<>(1);
		dices.add(new Dice(0));
		PBoard player = new PBoard(a, dices);
		Stats stats = player.getStats();
		int ris = stats.getCoin();
		tester.activate(player);
		int ris2 = stats.getCoin();
		assertEquals(ris + tester.getQuantity(), ris2);
	}

	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins#getQuantity()}
	 */
	@Test
	public void testGetQuantity() {
		addCoins tester = new addCoins();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}
	}

	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins#setQuantity()}
	 */
	@Test
	public void testSetQuantity() {
		addCoins tester = new addCoins();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella setQuantity");
		}
	}

}
