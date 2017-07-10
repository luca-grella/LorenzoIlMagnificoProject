package it.polimi.ingsw.ps18.model.effect.generalEffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.addFP;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

// TODO: Auto-generated Javadoc
/**
 * The Class addFPTest.
 */
public class addFPTest {
    
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
	 * Generate a player and test the function of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addFP#activate(PBoard)}
	 */
	@Test
	public void testActivate() {
		addFP tester = new addFP();
		tester.setQuantity(b);
		List<Dice> dices = new ArrayList<>(1);
		dices.add(new Dice(0));
		PBoard player = new PBoard(a, dices);
		Stats stats = player.getResources();
		int ris = stats.getFP();
		tester.activate(player, new GameLogic());
		int ris2 = stats.getFP();
		if(ris2!=ris + tester.getQuantity()){
			fail("Activate non funziona");
		}
	}

	/**
	 * Test get quantity.
	 */
	/*
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addFP#getQuantity()}
	 */
	@Test
	public void testGetQuantity() {
		addFP tester = new addFP();
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
	 * test of {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addFP#setQuantity()}
	 */
	@Test
	public void testSetQuantity() {
		addFP tester = new addFP();
		tester.setQuantity(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella setQuantity");
		}
	}
	
	/**
	 * tostring
	 */
	@Test
	public void testToString() {
		addFP tester = new addFP();
		int quantity=1;
		tester.setQuantity(quantity);
		String ris = tester.toString();
		assertEquals("add 1 Faith Point", ris);
		
		int quantity2=0;
		tester.setQuantity(quantity2);
		String ris2 = tester.toString();
		assertEquals("add 0 Faith Points", ris2);
		
		int quantity3=-1;
		tester.setQuantity(quantity3);
		String ris3 = tester.toString();
		assertEquals("detract -1 Faith Point", ris3);
		
		int quantity4=-2;
		tester.setQuantity(quantity4);
		String ris4 = tester.toString();
		assertEquals("detract -2 Faith Points", ris4);
		
		
	}
	
	/**
	 * 
	 * get name
	 */
	
	@Test
	public void testGetName() {
		addFP tester = new addFP();
		String ris = tester.getName();
		
		assertEquals("Faith Point", ris);
		
	}
	
}
