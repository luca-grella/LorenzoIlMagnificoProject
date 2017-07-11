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
 * The Class ConvertinResourcesTest.
 *
 * @author luca-grella
 */
public class ConvertinResourcesTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		
		ConvertinResources tester = new ConvertinResources();
		PBoard player = new PBoard();
		MainController mcontroller = new MainController();
		PBoardView pb = new PBoardView(mcontroller );
		player.setpBoardView(pb );
		int wood = 2;
		int rock = 3;
		int coin = 2;
		int servant = 1;
		int fp = 0;
		int mp = 4;
		int vp = 0;
		Stats resources = new Stats(wood, rock, coin, servant, fp, mp, vp);
		player.setResources(resources );
		Stats prova = player.generateExcommMalus();
		
		Stats cost = new Stats(1,1,1,1,1,1,1);
		tester.setCost(cost );
		int quantity = 2;
		tester.setQuantity(quantity);
		Stats reward = new Stats(2,2,2,2,2,2,2);
		tester.setReward(reward );
		
		tester.activate(player, new GameLogic());
		Stats ris = player.getResources();
		
		assertEquals(wood+2, ris.getWood());
		assertEquals(rock+2, ris.getRock());
		assertEquals(coin+2, ris.getCoin());
		assertEquals(servant+2, ris.getServants());
		assertEquals(fp+2, ris.getFP());
		assertEquals(mp+2, ris.getMP());
		assertEquals(vp+2, ris.getVP());
		
				
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		ConvertinResources tester = new ConvertinResources();
		int quantity = 2;
		tester.setQuantity(quantity);
		
		assertEquals(quantity,2);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources#setStats(org.json.simple.JSONArray, org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetStats() {
		
		ConvertinResources tester = new ConvertinResources();
		long wood = 1;
		long rock = 2;
		long coin = 3;
		long servant = 4;
		long fp = 5;
		long mp = 6;
		long vp = 7;
		long woodr = 2;
		long rockr = 4;
		long coinr = 6;
		long servantr = 8;
		long fpr = 10;
		long mpr = 12;
		long vpr = 14;
		JSONArray cost = new JSONArray();
		cost.add(wood);
		cost.add(rock);
		cost.add(coin);
		cost.add(servant);
		cost.add(fp);
		cost.add(mp);
		cost.add(vp);
		JSONArray reward = new JSONArray();
		reward.add(woodr);
		reward.add(rockr);
		reward.add(coinr);
		reward.add(servantr);
		reward.add(fpr);
		reward.add(mpr);
		reward.add(vpr);
		tester.setStats(cost, reward);
		
		long ris = tester.getCost().getWood();
		long ris2 = tester.getCost().getRock();
		long ris3 = tester.getCost().getCoin();
		long ris4 = tester.getCost().getServants();
		long ris5 = tester.getCost().getFP();
		long ris6 = tester.getCost().getMP();
		long ris7 = tester.getCost().getVP();
		
		long ris8 = tester.getReward().getWood();
		long ris9 = tester.getReward().getRock();
		long ris10 = tester.getReward().getCoin();
		long ris11 = tester.getReward().getServants();
		long ris12 = tester.getReward().getFP();
		long ris13 = tester.getReward().getMP();
		long ris14 = tester.getReward().getVP();
		
		assertEquals(wood, ris);
		assertEquals(rock, ris2);
		assertEquals(coin, ris3);
		assertEquals(servant, ris4);
		assertEquals(fp, ris7);
		assertEquals(mp, ris6);
		assertEquals(vp, ris5);
		assertEquals(woodr, ris8);
		assertEquals(rockr, ris9);
		assertEquals(coinr, ris10);
		assertEquals(servantr, ris11);
		assertEquals(fpr, ris14);
		assertEquals(mpr, ris13);
		assertEquals(vpr, ris12);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources#toString()}.
	 */
	@Test
	public void testToString() {
		
		ConvertinResources tester = new ConvertinResources();
		Stats stats = new Stats(4,6,2,5,8,6,4);
		tester.setCost(stats);
		tester.setReward(stats);
		
		
		String ris = tester.toString();
		
		assertEquals("Pay:\n-----------------\nWood: 4\nRock: 6\nCoin: 2\nServant: 5\nFP: 8\nMP: 6\nVP: 4\n-----------------\nto gain:\n -----------------\nWood: 4\nRock: 6\nCoin: 2\nServant: 5\nFP: 8\nMP: 6\nVP: 4\n-----------------\n", ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources#getCost()}.
	 */
	@Test
	public void testGetCost() {
		
		ConvertinResources tester = new ConvertinResources();
		int wood = 1;
		int rock = 2;
		int coin = 3;
		int servant = 4;
		int fp = 5;
		int mp = 6;
		int vp = 7;

		Stats cost = new Stats(wood, rock, coin, servant, fp, mp, vp);

		tester.setCost(cost);
		
		int ris = tester.getCost().getWood();
		int ris2 = tester.getCost().getRock();
		int ris3 = tester.getCost().getCoin();
		int ris4 = tester.getCost().getServants();
		int ris5 = tester.getCost().getFP();
		int ris6 = tester.getCost().getMP();
		int ris7 = tester.getCost().getVP();
		
		assertEquals(wood, ris);
		assertEquals(rock, ris2);
		assertEquals(coin, ris3);
		assertEquals(servant, ris4);
		assertEquals(fp, ris5);
		assertEquals(mp, ris6);
		assertEquals(vp, ris7);

		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources#setCost(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testSetCost() {
		
		ConvertinResources tester = new ConvertinResources();
		int wood = 5;
		int rock = 2;
		int coin = 2;
		int servant = 1;
		int fp = 5;
		int mp = 7;
		int vp = 7;

		Stats cost = new Stats(wood, rock, coin, servant, fp, mp, vp);

		tester.setCost(cost);
		
		int ris = tester.getCost().getWood();
		int ris2 = tester.getCost().getRock();
		int ris3 = tester.getCost().getCoin();
		int ris4 = tester.getCost().getServants();
		int ris5 = tester.getCost().getFP();
		int ris6 = tester.getCost().getMP();
		int ris7 = tester.getCost().getVP();
		
		assertEquals(wood, ris);
		assertEquals(rock, ris2);
		assertEquals(coin, ris3);
		assertEquals(servant, ris4);
		assertEquals(fp, ris5);
		assertEquals(mp, ris6);
		assertEquals(vp, ris7);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources#getReward()}.
	 */
	@Test
	public void testGetReward() {
		ConvertinResources tester = new ConvertinResources();
		int wood = 5;
		int rock = 2;
		int coin = 2;
		int servant = 1;
		int fp = 5;
		int mp = 7;
		int vp = 7;

		Stats reward = new Stats(wood, rock, coin, servant, fp, mp, vp);

		tester.setReward(reward);
		
		int ris = tester.getReward().getWood();
		int ris2 = tester.getReward().getRock();
		int ris3 = tester.getReward().getCoin();
		int ris4 = tester.getReward().getServants();
		int ris5 = tester.getReward().getFP();
		int ris6 = tester.getReward().getMP();
		int ris7 = tester.getReward().getVP();
		
		assertEquals(wood, ris);
		assertEquals(rock, ris2);
		assertEquals(coin, ris3);
		assertEquals(servant, ris4);
		assertEquals(fp, ris5);
		assertEquals(mp, ris6);
		assertEquals(vp, ris7);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources#setReward(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testSetReward() {
		
		ConvertinResources tester = new ConvertinResources();
		int wood = 5;
		int rock = 2;
		int coin = 2;
		int servant = 1;
		int fp = 5;
		int mp = 7;
		int vp = 7;

		Stats reward = new Stats(wood, rock, coin, servant, fp, mp, vp);

		tester.setReward(reward);
		
		int ris = tester.getReward().getWood();
		int ris2 = tester.getReward().getRock();
		int ris3 = tester.getReward().getCoin();
		int ris4 = tester.getReward().getServants();
		int ris5 = tester.getReward().getFP();
		int ris6 = tester.getReward().getMP();
		int ris7 = tester.getReward().getVP();
		
		assertEquals(wood, ris);
		assertEquals(rock, ris2);
		assertEquals(coin, ris3);
		assertEquals(servant, ris4);
		assertEquals(fp, ris5);
		assertEquals(mp, ris6);
		assertEquals(vp, ris7);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources#getName()}.
	 */
	@Test
	public void testGetName() {
		
		ConvertinResources tester = new ConvertinResources();
		String name = tester.getName();
		
		assertEquals("Convert in Resources", name);
		
	}

}
