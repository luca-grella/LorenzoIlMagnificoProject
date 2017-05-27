package it.polimi.ingsw.ps18.model.effect.generaleffects;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public class addCoinsTest {
	Random rand  = new Random();
	int a = rand.nextInt(1000);

	@Test
	public void testActivate() {
		addCoins tester = new addCoins();
		PBoard player = new PBoard(a, null);
	}

	@Test
	public void testGetQuantity() {
		addCoins tester = new addCoins();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}
	}

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
