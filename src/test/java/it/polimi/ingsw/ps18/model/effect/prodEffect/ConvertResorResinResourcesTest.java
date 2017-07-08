/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.prodEffect;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class ConvertResorResinResourcesTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		
		ConvertResorResinResources tester = new ConvertResorResinResources();
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
	
	@Test
	public void testWoodorRockChoice() {
		
		ConvertResorResinResources tester = new ConvertResorResinResources();
		PBoard player = new PBoard();
		MainController mcontroller = new MainController();
		PBoardView pb = new PBoardView(mcontroller );
		player.setpBoardView(pb );
		int wood = 1;
		int rock = 7;
		int coin = 7;
		int servant = 7;
		int fp = 7;
		int mp = 7;
		int vp = 7;
		Stats resources = new Stats(wood, rock, coin, servant, fp, mp, vp);
		player.setResources(resources );
		
		tester.setQuantity(6);
		tester.WoodorRockChoice(player, new GameLogic());
		Stats ris = tester.getCost();
		
		assertEquals(6, ris.getRock());
		
		wood = 7;
		rock = 1;
		resources = new Stats(wood, rock, coin, servant, fp, mp, vp);
		player.setResources(resources );
		
		tester.WoodorRockChoice(player, new GameLogic());
		ris = tester.getCost();
		
		assertEquals(6, ris.getWood());
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#continueEffect(int, it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testContinueEffect() {
		
		ConvertResorResinResources tester = new ConvertResorResinResources();
	
		PBoard player = new PBoard();
		Stats cost = new Stats(0,0,0,0,0,0,0);
		tester.setCost(cost);
		int index = 1;
		int quantity = 5;
		tester.setQuantity(quantity );
		
		tester.continueEffect(index , player, new GameLogic());
		
		assertEquals(quantity, tester.getCost().getWood());
		

		index=2;
		tester.continueEffect(index , player, new GameLogic());
		assertEquals(quantity, tester.getCost().getRock());
		
	}


	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		ConvertResorResinResources tester = new ConvertResorResinResources();
		int quantity = 1;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#setStats(long, org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetStats() {	
		
		ConvertResorResinResources tester = new ConvertResorResinResources();

		long woodr = 2;
		long rockr = 4;
		long coinr = 6;
		long servantr = 8;
		long fpr = 10;
		long mpr = 12;
		long vpr = 14;

		JSONArray reward = new JSONArray();
		reward.add(woodr);
		reward.add(rockr);
		reward.add(coinr);
		reward.add(servantr);
		reward.add(fpr);
		reward.add(mpr);
		reward.add(vpr);
		
		long quantity = 3;
		tester.setStats(quantity , reward);

		long ris = tester.getQuantity();
		long ris8 = tester.getReward().getWood();
		long ris9 = tester.getReward().getRock();
		long ris10 = tester.getReward().getCoin();
		long ris11 = tester.getReward().getServants();
		long ris12 = tester.getReward().getFP();
		long ris13 = tester.getReward().getMP();
		long ris14 = tester.getReward().getVP();
		
		
		assertEquals(quantity, ris);
		assertEquals(woodr, ris8);
		assertEquals(rockr, ris9);
		assertEquals(coinr, ris10);
		assertEquals(servantr, ris11);
		assertEquals(fpr, ris14);
		assertEquals(mpr, ris13);
		assertEquals(vpr, ris12);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#toString()}.
	 */
	@Test
	public void testToString() {
		
		ConvertResorResinResources tester = new ConvertResorResinResources();
		tester.setQuantity(5);
		tester.setReward(new Stats(2,5,4,7,5,7,4));
		
		String ris = tester.toString();
		
		assertEquals("Pay 5Wood or Rock\nto gain:\n -----------------\nWood: 2\nRock: 5\nCoin: 4\nServant: 7\nFP: 5\nMP: 7\nVP: 4\n-----------------\n", ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#getReward()}.
	 */
	@Test
	public void testGetReward() {
		ConvertResorResinResources tester = new ConvertResorResinResources();
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
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#setReward(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testSetReward() {
		
		ConvertResorResinResources tester = new ConvertResorResinResources();
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
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		
		ConvertResorResinResources tester = new ConvertResorResinResources();
		int quantity = 1;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#getName()}.
	 */
	@Test
	public void testGetName() {
		
		ConvertResorResinResources tester = new ConvertResorResinResources();
		String name = tester.getName();
		
		assertEquals("Convert WR in Resources", name);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#getCost()}.
	 */
	@Test
	public void testGetCost() {
		
		ConvertResorResinResources tester = new ConvertResorResinResources();
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
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources#setCost(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testSetCost() {
		
		ConvertResorResinResources tester = new ConvertResorResinResources();
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

}
