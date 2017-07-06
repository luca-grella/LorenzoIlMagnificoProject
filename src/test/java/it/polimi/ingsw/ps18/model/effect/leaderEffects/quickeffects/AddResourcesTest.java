/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class AddResourcesTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.AddResources#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		
		AddResources tester = new AddResources();
		
		
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
		tester.setParam(tobeadded );
		
		PBoard player = new PBoard();
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		player.setpBoardView(pb );

		Stats resources = new Stats(1,2,3,4,5,6,7);
		player.setResources(resources);
		
		tester.activate(player , new GameLogic());
		
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
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.AddResources#setParam(org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetParam() {
		AddResources tester = new AddResources();
		
		
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
		tester.setParam(tobeadded );
		
		PBoard player = new PBoard();
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		player.setpBoardView(pb );

		Stats resources = new Stats(1,2,3,4,5,6,7);
		player.setResources(resources);
		
		tester.activate(player , new GameLogic());
		
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
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.AddResources#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

}
