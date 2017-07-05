/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.permeffects;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class IncreaseFMValueOnActionTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnAction#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		
		IncreaseFMValueOnAction tester = new IncreaseFMValueOnAction();
		int quantity = 34;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnAction#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		IncreaseFMValueOnAction tester = new IncreaseFMValueOnAction();
		int quantity = 18;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnAction#setParam(java.lang.String, long, org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetParam() {
		
		IncreaseFMValueOnAction tester = new IncreaseFMValueOnAction();
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
		
		assertEquals(name, tester.getName());
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
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnAction#getName()}.
	 */
	@Test
	public void testGetName() {
		
		IncreaseFMValueOnAction tester = new IncreaseFMValueOnAction();
		String name = "Effetto";
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
		tester.setParam(name, 1, discounts);
		
		String ris = tester.getName();
		
		assertEquals("Effetto", ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnAction#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnAction#getDiscounts()}.
	 */
	@Test
	public void testGetDiscounts() {
		
		IncreaseFMValueOnAction tester = new IncreaseFMValueOnAction();
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
		
		assertEquals(wood, tester.getDiscounts().getWood());
		assertEquals(rock, tester.getDiscounts().getRock());
		assertEquals(coin, tester.getDiscounts().getCoin());
		assertEquals(servant, tester.getDiscounts().getServants());
		assertEquals(vp, tester.getDiscounts().getVP());
		assertEquals(mp, tester.getDiscounts().getMP());
		assertEquals(fp, tester.getDiscounts().getFP());
	}

}
