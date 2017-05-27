package it.polimi.ingsw.ps18.model.effect.generaleffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins;
import it.polimi.ingsw.ps18.model.gameLogic.Dice;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;
import it.polimi.ingsw.ps18.model.personalBoard.resources.Stats;

public class addCoinsTest {
	Random rand  = new Random();
	int a = rand.nextInt(1000);
	int b = rand.nextInt(1000);

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
		if(ris2!=ris + tester.getQuantity()){
			fail("Activate non funziona");
		}
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
