/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.prodEffect;

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
public class HashMapPETest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.HashMapPE#HashMapPE()}.
	 */
	@Test
	public void testHashMapPE() {
		
		String name = "AddServant";
		
		HashMapPE tester = new HashMapPE();
		ProductionEffect ris = tester.geteffect(name);
		ris.setQuantity(2);
		
		
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources);
		ris.activate(player , new GameLogic());
		
		assertEquals(2, player.getResources().getServants());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.HashMapPE#geteffect(java.lang.String)}.
	 */
	@Test
	public void testGeteffect() {
		
		String name = "AddWood";
		
		HashMapPE tester = new HashMapPE();
		ProductionEffect ris = tester.geteffect(name);
		ris.setQuantity(5);
		
		
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources);
		ris.activate(player , new GameLogic());
		
		assertEquals(5, player.getResources().getWood());
		
	}

}
