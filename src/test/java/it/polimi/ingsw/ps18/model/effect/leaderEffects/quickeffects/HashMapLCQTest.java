/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class HashMapLCQTest.
 *
 * @author luca-grella
 */
public class HashMapLCQTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.HashMapLCQ#HashMapLCQ()}.
	 */
	@Test
	public void testHashMapLCQ() {
		
		String name = "AddResources";
		
		HashMapLCQ tester = new HashMapLCQ();
	
		LCQuickEffect ris = tester.getLCQuickEffect(name);
	
		JSONArray tobeadded = new JSONArray();
		long a = 1;
		long b = 1;
		long c = 1;
		long d = 1;
		long e = 1;
		long f = 1;
		long g = 1;
		tobeadded.add(a);
		tobeadded.add(b);
		tobeadded.add(c);
		tobeadded.add(d);
		tobeadded.add(e);
		tobeadded.add(f);
		tobeadded.add(g);
		((AddResources) ris).setParam(tobeadded );
		
		PBoard player = new PBoard();
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		player.setpBoardView(pb );

		Stats resources = new Stats(1,2,3,4,5,6,7);
		player.setResources(resources);
		
		ris.activate(player , new GameLogic());
		
		Stats ris2 = player.getResources();
		
		assertEquals(a+1,ris2.getWood());
		assertEquals(b+2,ris2.getRock());
		assertEquals(c+3,ris2.getCoin());
		assertEquals(d+4,ris2.getServants());
		assertEquals(e+5,ris2.getFP());
		assertEquals(f+6,ris2.getMP());
		assertEquals(g+7,ris2.getVP());
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.HashMapLCQ#getLCQuickEffect(java.lang.String)}.
	 */
	@Test
	public void testGetLCQuickEffect() {
		
		HashMapLCQ tester = new HashMapLCQ();
		String name = "AddPC";
		LCQuickEffect ris = tester.getLCQuickEffect(name);
		((GeneralEffect) ris).setQuantity(2);
		PBoard player = new PBoard();
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		player.setpBoardView(pb );
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources );
//		ris.activate(player , new GameLogic());
		assertEquals(0, player.getResources().getWood());
		
	}

}
