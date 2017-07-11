/**
 * 
 */
package it.polimi.ingsw.ps18.controller.controlleractions.effectresolution;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.effect.generalEffects.WoodorRockEffects;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addWoodorRock;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class WoodorRockHandlerTest.
 *
 * @author luca-grella
 */
public class WoodorRockHandlerTest {
	

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.WoodorRockHandler#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
//	@Test
//	public void testAct() {
//		
//		WoodorRockHandler tester = new WoodorRockHandler();
//		tester.setIndex(1);
//		GameLogic game = new GameLogic();
//		PBoard turnplayer = new PBoard();
//		turnplayer.setPlayercol(1);
//		Stats resources = new Stats(4,4,4,4,4,4,4);
//		turnplayer.setResources(resources);
//		game.setCurrentPlayer(turnplayer);
//		GeneralEffect ongoingEffect = new ConvertResorResinResources();
//		int woodorock = 34;
////		ongoingEffect.setQuantity(woodorock);
//		((ConvertResorResinResources) ongoingEffect).setQuantity(woodorock);
//		WoodorRockEffects ongoingWREffect = new addWoodorRock(turnplayer, game);
//		((addWoodorRock) ongoingWREffect).setQuantity(woodorock);
//		game.setOngoingWREffect((WoodorRockEffects) ongoingWREffect);
//		game.setOngoingEffect(ongoingEffect);
//		tester.act(game);
////		tester.setIndex(2);
//		Stats stat = new Stats(((ConvertResorResinResources) ongoingEffect).getQuantity(),0,0,0,0,0,0);
//		((ConvertResorResinResources) ongoingEffect).setCost(stat);
//		int ris1 = ((ConvertResorResinResources) ongoingEffect).getCost().getWood();
//		 
//		assertEquals(woodorock, ris1);
//		
//	}

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
