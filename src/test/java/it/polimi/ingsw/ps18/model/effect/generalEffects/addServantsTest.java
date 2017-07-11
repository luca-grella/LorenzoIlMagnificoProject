package it.polimi.ingsw.ps18.model.effect.generalEffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addServants;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;


/**
 * The Class addServantsTest.
 */
public class addServantsTest {
	
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
	 * Generate a player and test the function of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addServants#activate(PBoard)}
	 */
	@Test
	public void testActivate() {
		addServants tester = new addServants();
		tester.setQuantity(b);
		List<Dice> dices = new ArrayList<>(1);
		dices.add(new Dice(0));
		PBoard player = new PBoard(a, dices);
		Stats stats = player.getResources();
		int ris = stats.getServants();
		tester.activate(player, new GameLogic());
		int ris2 = stats.getServants();
		if(ris2!=ris + tester.getQuantity()){
			fail("Activate non funziona");
		}
	}

	/**
	 * Test get quantity.
	 */
	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addServants#getQuantity()}
	 */
	@Test
	public void testGetQuantity() {
		addServants tester = new addServants();
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
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addServants#setQuantity()}
	 */
	@Test
	public void testSetQuantity() {
		addServants tester = new addServants();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella setQuantity");
		}
	}
	
	@Test
	public void testToString() {
		addServants tester = new addServants();
		tester.setQuantity(1);
		String ris = tester.toString();
		
		assertEquals("add 1 Servant", ris);
		
		addServants tester2 = new addServants();
		tester2.setQuantity(0);
		String ris2 = tester2.toString();
		
		assertEquals("add 0 Servants", ris2);
		
		addServants tester3 = new addServants();
		tester3.setQuantity(-1);
		String ris3 = tester3.toString();
		
		assertEquals("detract -1 Servant", ris3);
		
		addServants tester4 = new addServants();
		tester4.setQuantity(-2);
		String ris4 = tester4.toString();
		
		assertEquals("detract -2 Servants", ris4);
	}
	
	@Test
	public void testGetName() {
		addServants tester = new addServants();
		String ris = tester.getName();
		
	
		}
	}

