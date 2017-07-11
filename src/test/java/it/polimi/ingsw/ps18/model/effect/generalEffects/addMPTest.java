package it.polimi.ingsw.ps18.model.effect.generalEffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addMP;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;


/**
 * The Class addMPTest.
 */
public class addMPTest {
	
	/**
	 * The rand.
	 */
	Random rand  = new Random();
	
	/**
	 * The a.
	 */
	int a = rand.nextInt(1000);
	
	/**
	 * The b.
	 */
	int b = rand.nextInt(1000);
	
	/**
	 * Generate a player and test the function of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addMP#activate(PBoard)}
	 */
	@Test
	public void testActivate() {
		addMP tester = new addMP();
		tester.setQuantity(b);
		List<Dice> dices = new ArrayList<>(1);
		dices.add(new Dice(0));
		PBoard player = new PBoard(a, dices);
		Stats stats = player.getResources();
		int ris = stats.getMP();
		tester.activate(player, new GameLogic());
		int ris2 = stats.getMP();
		if(ris2!=ris + tester.getQuantity()){
			fail("Activate non funziona");
		}
	}

	/**
	 * Test get quantity.
	 */
	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addMP#getQuantity()}
	 */
	@Test
	public void testGetQuantity() {
		addMP tester = new addMP();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}
	}

	/**
	 * Test set quantity.
	 */
	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addMP#setQuantity()}
	 */
	@Test
	public void testSetQuantity() {
		addMP tester = new addMP();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella setQuantity");
		}
	}
	
	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() {
		addMP tester = new addMP();
		String ris = tester.getName();
		assertEquals("Military Point", ris);
	}

}
