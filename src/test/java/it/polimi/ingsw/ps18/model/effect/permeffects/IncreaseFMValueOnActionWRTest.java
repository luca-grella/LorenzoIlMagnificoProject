/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.permeffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class IncreaseFMValueOnActionWRTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		IncreaseFMValueOnActionWR tester = new IncreaseFMValueOnActionWR();
		tester.setQuantity(1);
		String name = "ciao";
		long quantity = 4;
		JSONArray discounts = new JSONArray();
		long wood = 2;
		discounts.add(wood );
		long rock = 5;
		discounts.add(rock);
		long coin = 1;
		discounts.add(coin);
		long servant = 2;
		discounts.add(servant);
		long vp = 2;
		discounts.add(vp);
		long mp = 8;
		discounts.add(mp);
		long fp = 4;
		discounts.add(fp);
		tester.setParam(name, quantity, discounts);
		PBoard player = new PBoard();
		Stats resources = new Stats(1,1,1,1,1,1,1);
		player.setResources(resources );
		List<Dice> dices = new ArrayList<>();
		List<Cards> BonusTiles = new ArrayList<>();
		List<FMember> fams = new ArrayList<>();
		player.setFams(fams );
		player.completePBoardSetup(dices , new MainController(), BonusTiles );
//		tester.activate(player, new GameLogic());
		int index = 2;
		tester.continueEffect(index , player , new GameLogic());
		
		if (index ==1){
			assertEquals(wood, tester.getChosenDiscount().getWood());
		}
		else {
			assertEquals(rock, tester.getChosenDiscount().getRock());
		};
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR#continueEffect(int, it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testContinueEffect() {
		
		IncreaseFMValueOnActionWR tester = new IncreaseFMValueOnActionWR();
		String name = "ciao";
		long quantity = 4;
		JSONArray discounts = new JSONArray();
		long wood = 2;
		discounts.add(wood );
		long rock = 5;
		discounts.add(rock);
		long coin = 1;
		discounts.add(coin);
		long servant = 2;
		discounts.add(servant);
		long vp = 2;
		discounts.add(vp);
		long mp = 8;
		discounts.add(mp);
		long fp = 4;
		discounts.add(fp);
		tester.setParam(name, quantity, discounts);
		PBoard player = new PBoard();
		int index = 2;
		tester.continueEffect(index , player , new GameLogic());
		Stats ris = tester.getChosenDiscount();
		
		if (index ==1){
			assertEquals(wood, tester.getChosenDiscount().getWood());
		}
		else {
			assertEquals(rock, tester.getChosenDiscount().getRock());
		};
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR#toString()}.
	 */
	@Test
	public void testToString() {
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR#setParam(java.lang.String, long, org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetParam() {
		
		IncreaseFMValueOnActionWR tester = new IncreaseFMValueOnActionWR();
		String name = "ciao";
		long quantity = 4;
		JSONArray discounts = new JSONArray();
		long wood = 2;
		discounts.add(wood );
		long rock = 5;
		discounts.add(rock);
		long coin = 1;
		discounts.add(coin);
		long servant = 2;
		discounts.add(servant);
		long vp = 2;
		discounts.add(vp);
		long mp = 8;
		discounts.add(mp);
		long fp = 4;
		discounts.add(fp);
		tester.setParam(name, quantity, discounts );
		String namef = tester.getName();
		
		assertEquals(name+"WR", tester.getName());
		assertEquals(quantity, tester.getQuantity());
		assertEquals(wood, tester.getDiscounts().getWood());
		assertEquals(rock, tester.getDiscounts().getRock());
		assertEquals(coin, tester.getDiscounts().getCoin());
		assertEquals(servant, tester.getDiscounts().getServants());
		assertEquals(vp, tester.getDiscounts().getVP());
		assertEquals(mp, tester.getDiscounts().getMP());
		assertEquals(fp, tester.getDiscounts().getFP());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		
		IncreaseFMValueOnActionWR tester = new IncreaseFMValueOnActionWR();
		int quantity = 3;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		IncreaseFMValueOnActionWR tester = new IncreaseFMValueOnActionWR();
		int quantity = 4;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR#getName()}.
	 */
	@Test
	public void testGetName() {
		
		IncreaseFMValueOnActionWR tester = new IncreaseFMValueOnActionWR();
		
		String name = "nome";
		long quantity = 4;
		JSONArray discounts = new JSONArray();
		long wood = 2;
		discounts.add(wood );
		long rock = 5;
		discounts.add(rock);
		long coin = 1;
		discounts.add(coin);
		long servant = 2;
		discounts.add(servant);
		long vp = 2;
		discounts.add(vp);
		long mp = 8;
		discounts.add(mp);
		long fp = 4;
		discounts.add(fp);
		tester.setParam(name, quantity, discounts );
		
		String ris = tester.getName();
		
		assertEquals(name+"WR", ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR#getDiscounts()}.
	 */
	@Test
	public void testGetDiscounts() {
		
		IncreaseFMValueOnActionWR tester = new IncreaseFMValueOnActionWR();
		
		String name = "nome";
		long quantity = 4;
		JSONArray discounts = new JSONArray();
		long wood = 2;
		discounts.add(wood );
		long rock = 5;
		discounts.add(rock);
		long coin = 1;
		discounts.add(coin);
		long servant = 2;
		discounts.add(servant);
		long vp = 2;
		discounts.add(vp);
		long mp = 8;
		discounts.add(mp);
		long fp = 4;
		discounts.add(fp);
		tester.setParam(name, quantity, discounts );
		
		assertEquals(wood, tester.getDiscounts().getWood());
		assertEquals(rock, tester.getDiscounts().getRock());
		assertEquals(coin, tester.getDiscounts().getCoin());
		assertEquals(servant, tester.getDiscounts().getServants());
		assertEquals(vp, tester.getDiscounts().getVP());
		assertEquals(mp, tester.getDiscounts().getMP());
		assertEquals(fp, tester.getDiscounts().getFP());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR#getChosenDiscount()}.
	 */
	@Test
	public void testGetChosenDiscount() {
		
		IncreaseFMValueOnActionWR tester = new IncreaseFMValueOnActionWR();
		String name = "nome";
		long quantity = 4;
		JSONArray discounts = new JSONArray();
		long wood = 2;
		discounts.add(wood );
		long rock = 5;
		discounts.add(rock);
		long coin = 1;
		discounts.add(coin);
		long servant = 2;
		discounts.add(servant);
		long vp = 2;
		discounts.add(vp);
		long mp = 8;
		discounts.add(mp);
		long fp = 4;
		discounts.add(fp);
		tester.setParam(name, quantity, discounts);
		PBoard player = new PBoard();
		int index = 2;
		tester.continueEffect(index , player , new GameLogic());
		Stats ris = tester.getChosenDiscount();
		
		if (index ==1){
			assertEquals(wood, tester.getChosenDiscount().getWood());
		}
		else {
			assertEquals(rock, tester.getChosenDiscount().getRock());
		};
		
	}

}
