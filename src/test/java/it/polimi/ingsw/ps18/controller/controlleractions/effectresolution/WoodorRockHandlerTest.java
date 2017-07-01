/**
 * 
 */
package it.polimi.ingsw.ps18.controller.controlleractions.effectresolution;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class WoodorRockHandlerTest {
	

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.WoodorRockHandler#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		
		WoodorRockHandler tester = new WoodorRockHandler();
		tester.setIndex(1);
		GameLogic game = new GameLogic();
		GeneralEffect ongoingEffect = new ConvertResorResinResources();
		int woodorock = 34;
		ongoingEffect.setQuantity(woodorock );
		game.setOngoingEffect(ongoingEffect );
		PBoard turnplayer = new PBoard();
		turnplayer.setPlayercol(1);
		Stats resources = new Stats(4,4,4,4,4,4,4);
		turnplayer.setResources(resources);
		game.setCurrentPlayer(turnplayer);
		tester.act(game);

		int ris = ((ConvertResorResinResources) ongoingEffect).getCost().getWood();
		 
		assertEquals(woodorock, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.WoodorRockHandler#setIndex(int)}.
	 */
	@Test
	public void testSetIndex() {
		WoodorRockHandler tester = new WoodorRockHandler();
		int index=1;
		tester.setIndex(index);
		int ris = tester.getIndex();
		
		assertEquals(index, ris);
		
	}

}
