/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.prodEffect;

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
public class ConvertinPCTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinPC#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		
		ConvertinPC tester = new ConvertinPC();
		PBoard player = new PBoard();
		MainController mcontroller = new MainController();
		PBoardView pb = new PBoardView(mcontroller );
		player.setpBoardView(pb );
		tester.activate(player, new GameLogic());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinPC#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		ConvertinPC tester = new ConvertinPC();
		int quantity = 8;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinPC#setStats(org.json.simple.JSONArray, long)}.
	 */
	@Test
	public void testSetStats() {
		
		ConvertinPC tester = new ConvertinPC();
		JSONArray cost = new JSONArray();
		
		long wood = 1;
		long rock = 2;
		long coin = 9;
		long servant = 8;
		long fp = 55;
		long mp = 20;
		long vp = 13;
		
		cost.add(wood);
		cost.add(rock);
		cost.add(coin);
		cost.add(servant);
		cost.add(fp);
		cost.add(mp);
		cost.add(vp);

		
		long quantity = 6;
		tester.setStats(cost, quantity);
		
		assertEquals(quantity, tester.getQuantity());
		
		long woodf = tester.getCost().getWood();
		long rockf = tester.getCost().getRock();
		long coinf = tester.getCost().getCoin();
		long servantf = tester.getCost().getServants();
		long fpf = tester.getCost().getFP();
		long mpf = tester.getCost().getMP();
		long vpf = tester.getCost().getVP();
		
		assertEquals(wood, woodf);
		assertEquals(rock, rockf);
		assertEquals(coin, coinf);
		assertEquals(servant, servantf);
		assertEquals(fp, vpf);
		assertEquals(mp, mpf);
		assertEquals(vp, fpf);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinPC#toString()}.
	 */
	@Test
	public void testToString() {
		
		ConvertinPC tester = new ConvertinPC();
		
		tester.setCost(new Stats(2,6,5,8,7,5,2));
		tester.setQuantity(5);
		
		String ris = tester.toString();
		
		assertEquals("Pay:\n-----------------\nWood: 2\nRock: 6\nCoin: 5\nServant: 8\nFP: 7\nMP: 5\nVP: 2\n-----------------\nto gain 5Privileges", ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinPC#getCost()}.
	 */
	@Test
	public void testGetCost() {
		
		ConvertinPC tester = new ConvertinPC();
		int wood = 1;
		int rock = 2;
		int coin = 9;
		int servant = 8;
		int fp = 60;
		int mp = 20;
		int vp = 13;
		Stats cost = new Stats(wood, rock, coin, servant, fp, mp, vp);
		tester.setCost(cost);
		int woodf = tester.getCost().getWood();
		int rockf = tester.getCost().getRock();
		int coinf = tester.getCost().getCoin();
		int servantf = tester.getCost().getServants();
		int fpf = tester.getCost().getFP();
		int mpf = tester.getCost().getMP();
		int vpf = tester.getCost().getVP();
		
		assertEquals(wood, woodf);
		assertEquals(rock, rockf);
		assertEquals(coin, coinf);
		assertEquals(servant, servantf);
		assertEquals(fp, fpf);
		assertEquals(mp, mpf);
		assertEquals(vp, vpf);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinPC#setCost(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testSetCost() {
		
		ConvertinPC tester = new ConvertinPC();
		int wood = 3;
		int rock = 8;
		int coin = 9;
		int servant = 23;
		int fp = 7;
		int mp = 12;
		int vp = 10;
		Stats cost = new Stats(wood, rock, coin, servant, fp, mp, vp);
		tester.setCost(cost);
		int woodf = tester.getCost().getWood();
		int rockf = tester.getCost().getRock();
		int coinf = tester.getCost().getCoin();
		int servantf = tester.getCost().getServants();
		int fpf = tester.getCost().getFP();
		int mpf = tester.getCost().getMP();
		int vpf = tester.getCost().getVP();
		
		assertEquals(wood, woodf);
		assertEquals(rock, rockf);
		assertEquals(coin, coinf);
		assertEquals(servant, servantf);
		assertEquals(fp, fpf);
		assertEquals(mp, mpf);
		assertEquals(vp, vpf);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinPC#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		
		ConvertinPC tester = new ConvertinPC();
		int quantity = 8;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinPC#getName()}.
	 */
	@Test
	public void testGetName() {
		
		ConvertinPC tester = new ConvertinPC();
		String name = "Convert in PC";
		
		String ris = tester.getName();
		
		assertEquals(name, ris);
		
		
		
	}

}
