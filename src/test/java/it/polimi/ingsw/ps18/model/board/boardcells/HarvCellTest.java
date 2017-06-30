/**
 * 
 */
package it.polimi.ingsw.ps18.model.board.boardcells;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * @author luca-grella
 *
 */
public class HarvCellTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#HarvCell(int)}.
	 */
	@Test
	public void testHarvCell() {
		
		int malus = 2;
		HarvCell tester = new HarvCell(malus);
		tester.setHarvCellValue(GeneralParameters.baseValueHarvCells - malus);
		int ris = tester.getHarvCellValue();
		
		assertEquals(GeneralParameters.baseValueHarvCells - malus, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#insertFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testInsertFM() {
		
		int malus = 3;
		HarvCell tester = new HarvCell(malus);
		int val = 506;
		FMember fm = new FMember(4, val);
		tester.insertFM(fm);
		int ris = tester.getHarvCellFM().getPlayercol();
		
		assertEquals(val, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#isEmptyHC()}.
	 */
	@Test
	public void testIsEmptyHC() {

		int malus = 2;
		HarvCell tester = new HarvCell(malus);
		
		assertTrue(tester.isEmptyHC());
		
		int val = 56;
		FMember fm = new FMember(3, val);
		tester.insertFM(fm);
		
		assertTrue(!(tester.isEmptyHC()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#isLegalHC(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testIsLegalHC() {
		
		int malus = 2;
		HarvCell tester = new HarvCell(malus);
		tester.setHarvCellValue(57);
		
		int val = 58;
		FMember fm = new FMember(val, 1);
		
		assertTrue(tester.isLegalHC(fm.getValue()));
		
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#getHarvCellFM()}.
	 */
	@Test
	public void testGetHarvCellFM() {
		int malus = 2;
		HarvCell tester = new HarvCell(malus);
		int playercol = 2;
		FMember harvCellFM = new FMember(4, playercol);
		harvCellFM.setValue(506);
		tester.setHarvCellFM(harvCellFM);
		int ris = tester.getHarvCellFM().getValue();
		
		assertEquals(506, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#setHarvCellFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetHarvCellFM() {
		
		int malus = 2;
		HarvCell tester = new HarvCell(malus);
		int playercol = 2;
		FMember harvCellFM = new FMember(4, playercol);
		harvCellFM.setValue(51);
		tester.setHarvCellFM(harvCellFM);
		int ris = tester.getHarvCellFM().getValue();
		
		assertEquals(51, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#getHarvCellValue()}.
	 */
	@Test
	public void testGetHarvCellValue() {
		
		int malus = 2;
		HarvCell tester = new HarvCell(malus);
		int expected = 23;
		tester.setHarvCellValue(expected );
		int ris = tester.getHarvCellValue();
		
		assertEquals(expected, ris);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#setHarvCellValue(int)}.
	 */
	@Test
	public void testSetHarvCellValue() {
		
		int malus = 2;
		HarvCell tester = new HarvCell(malus);
		int expected = 23;
		tester.setHarvCellValue(expected );
		int ris = tester.getHarvCellValue();
		
		assertEquals(expected, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#setMalus(int)}.
	 */
	@Test
	public void testSetMalus() {
		
		int malus = 3;
		HarvCell tester = new HarvCell(malus);
		int expected = 57;
		tester.setMalus(expected);
		int ris = tester.getMalus();
		
		
		assertEquals(expected, ris);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#getMalus()}.
	 */
	@Test
	public void testGetMalus() {
		
		int malus = 3;
		HarvCell tester = new HarvCell(malus);
		int expected = 57;
		tester.setMalus(expected);
		int ris = tester.getMalus();
		
		
		assertEquals(expected, ris);
		
		
	}

}
