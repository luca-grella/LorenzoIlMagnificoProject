/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.harvestEffect;

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
public class HashMapHETest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE#HashMapHE()}.
	 */
	@Test
	public void testHashMapHE() {
		String name = "AddServant";
		
		HashMapHE tester = new HashMapHE();
		HarvestEffect ris = tester.geteffect(name);
		ris.setQuantity(8);
		
		
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources);
		ris.activate(player , new GameLogic());
		
		assertEquals(8, player.getResources().getServants());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE#geteffect(java.lang.String)}.
	 */
	@Test
	public void testGeteffect() {
		
		String name = "AddWood";
		
		HashMapHE tester = new HashMapHE();
		HarvestEffect ris = tester.geteffect(name);
		ris.setQuantity(1);
		
		
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources);
		ris.activate(player , new GameLogic());
		
		assertEquals(1, player.getResources().getWood());
		
	}

}
