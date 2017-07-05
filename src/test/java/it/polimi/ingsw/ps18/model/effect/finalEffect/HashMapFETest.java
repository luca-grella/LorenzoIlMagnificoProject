/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.finalEffect;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class HashMapFETest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.finalEffect.HashMapFE#HashMapFE()}.
	 */
	@Test
	public void testHashMapFE() {
		
		String name = "AddPV";
		
		HashMapFE tester = new HashMapFE();
		FinalEffect ris = tester.geteffect(name);
		ris.setQuantity(10);
		
		
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources);
		ris.activate(player , new GameLogic());
		
		assertEquals(10, player.getResources().getVP());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.finalEffect.HashMapFE#geteffect(java.lang.String)}.
	 */
	@Test
	public void testGeteffect() {
		
		String name = "AddPV";
		
		HashMapFE tester = new HashMapFE();
		FinalEffect ris = tester.geteffect(name);
		ris.setQuantity(10);
		
		
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources);
		ris.activate(player , new GameLogic());
		
		assertEquals(10, player.getResources().getVP());
		
	}

}
