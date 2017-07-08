/**
 * 
 */
package it.polimi.ingsw.ps18.model.board.boardcells;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * @author luca-grella
 *
 */
public class ProdCellTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#ProdCell(int)}.
	 */
	@Test
	public void testProdCell() {
		
		int malus = 2;
		ProdCell tester = new ProdCell(malus);
		tester.setProdCellValue(GeneralParameters.baseValueProdCells - malus);
		int ris = tester.getProdCellValue();
		
		assertEquals(GeneralParameters.baseValueProdCells - malus, ris);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#insertFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
//	@Test
//	public void testInsertFM() {
//		
//		int malus = 2;
//		ProdCell tester = new ProdCell(malus);
//		Dice dice = new Dice(3);
//		int playercol=3;
//		FMember fm = new FMember(dice, playercol);
//		tester.insertFM(fm, new GameLogic());
//		int ris = tester.getProdCellFM().getPlayercol();
//		
//		assertEquals(playercol, ris);
//		
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#isEmptyPC()}.
	 */
//	@Test
//	public void testIsEmptyPC() {
//		
//		int malus = 1;
//		ProdCell tester = new ProdCell(malus);
//		
//		assertTrue(tester.isEmptyPC());
//		
//		int val = 56;
//		FMember fm = new FMember(3, val);
//		tester.insertFM(fm, new GameLogic());
//		
//		assertTrue(!(tester.isEmptyPC()));
//		
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#isLegalPC(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testIsLegalPC() {
		

		int malus = 1;
		ProdCell tester = new ProdCell(malus);
		tester.setProdCellValue(35);
		
		int val = 40;
		FMember fm = new FMember(val, 1);
		
		assertTrue(tester.isLegalPC(fm.getValue()));
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#getProdCellFM()}.
	 */
	@Test
	public void testGetProdCellFM() {
		
		int malus = 1;
		ProdCell tester = new ProdCell(malus);
		int playercol = 2;
		FMember prodCellFM = new FMember(4, playercol);
		prodCellFM.setValue(78);
		tester.setProdCellFM(prodCellFM);
		int ris = tester.getProdCellFM().getValue();
		
		assertEquals(78, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#setProdCellFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetProdCellFM() {
		
		int malus = 1;
		ProdCell tester = new ProdCell(malus);
		int playercol = 2;
		FMember prodCellFM = new FMember(4, playercol);
		prodCellFM.setValue(78);
		tester.setProdCellFM(prodCellFM);
		int ris = tester.getProdCellFM().getValue();
		
		assertEquals(78, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#getProdCellValue()}.
	 */
	@Test
	public void testGetProdCellValue() {
		
		int malus = 2;
		ProdCell tester = new ProdCell(malus);
		int expected = 18;
		tester.setProdCellValue(expected);
		int ris = tester.getProdCellValue();
		
		assertEquals(expected, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#setProdCellValue(int)}.
	 */
	@Test
	public void testSetProdCellValue() {
		
		int malus = 2;
		ProdCell tester = new ProdCell(malus);
		int expected = 18;
		tester.setProdCellValue(expected);
		int ris = tester.getProdCellValue();
		
		assertEquals(expected, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#getMalus()}.
	 */
	@Test
	public void testGetMalus() {
		
		
		int malus = 3;
		ProdCell tester = new ProdCell(malus);
		int expected = 84;
		tester.setMalus(expected);
		int ris = tester.getMalus();
		
		
		assertEquals(expected, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#setMalus(int)}.
	 */
	@Test
	public void testSetMalus() {
		
		int malus = 3;
		ProdCell tester = new ProdCell(malus);
		int expected = 84;
		tester.setMalus(expected);
		int ris = tester.getMalus();
		
		
		assertEquals(expected, ris);
		
	}

}
