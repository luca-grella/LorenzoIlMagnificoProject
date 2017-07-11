/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.quickEffect;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.permeffects.HashMapPermE;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class HashMapQETest.
 *
 * @author luca-grella
 */
public class HashMapQETest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE#HashMapQE()}.
	 */
	@Test
	public void testHashMapQE() {
		
		String name = "AddServant";
		
		HashMapQE tester = new HashMapQE();
		QuickEffect ris = tester.geteffect(name);
		ris.setQuantity(3);
		
		
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources);
		ris.activate(player , new GameLogic());
		
		assertEquals(3, player.getResources().getServants());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE#geteffect(java.lang.String)}.
	 */
	@Test
	public void testGeteffect() {
		
		String name = "AddWood";
		
		HashMapQE tester = new HashMapQE();
		QuickEffect ris = tester.geteffect(name);
		ris.setQuantity(5);
		
		
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources);
		ris.activate(player , new GameLogic());
		
		assertEquals(5, player.getResources().getWood());
		
	}

}
