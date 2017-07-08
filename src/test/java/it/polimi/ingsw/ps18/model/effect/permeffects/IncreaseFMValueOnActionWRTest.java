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
import it.polimi.ingsw.ps18.view.PBoardView;

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
		tester.setQuantity(5);
		PBoard player = new PBoard();
		Stats resources = new Stats(1,6,6,6,6,6,6);
		player.setResources(resources);
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		player.setpBoardView(pb );
		GameLogic game = new GameLogic();
		tester.activate(player, game);
		
		assertEquals(new Stats(0,5,0,0,0,0,0).getRock(), tester.getChosenDiscount().getRock());
		
		resources = new Stats(6,1,6,6,6,6,6);
		player.setResources(resources);
		tester.activate(player, game);
	
		assertEquals(new Stats(5,0,0,0,0,0,0).getWood(), tester.getChosenDiscount().getWood());
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
		int index = 1;
		tester.continueEffect(index , player , new GameLogic());
		Stats ris = tester.getChosenDiscount();
		
		assertEquals(wood, tester.getChosenDiscount().getWood());
		
		index = 2;
		tester.continueEffect(index , player , new GameLogic());
		ris = tester.getChosenDiscount();
		
		assertEquals(rock, tester.getChosenDiscount().getRock());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR#toString()}.
	 */
	@Test
	public void testToString() {
		
		IncreaseFMValueOnActionWR tester = new IncreaseFMValueOnActionWR();
		JSONArray discounts = new JSONArray();
		long a = 1;
		long b = 1;
		long c = 1;
		long d = 1;
		long e = 1;
		long f = 1;
		long g = 1;
		discounts.add(a);
		discounts.add(b);
		discounts.add(c);
		discounts.add(d);
		discounts.add(e);
		discounts.add(f);
		discounts.add(g);
		tester.setParam("ciao", 1, discounts);
		tester.toString();
		
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
