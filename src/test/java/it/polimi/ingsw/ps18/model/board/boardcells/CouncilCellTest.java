/**
 * 
 */
package it.polimi.ingsw.ps18.model.board.boardcells;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * @author luca-grella
 *
 */
public class CouncilCellTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell#CouncilCell(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testCouncilCellFMember() {
		
		CouncilCell tester = new CouncilCell();
		Dice dice = new Dice(5);
		FMember councilCellFM = new FMember(dice , 1);
		int ris3 = councilCellFM.getValue();
		tester.setCouncilCellFM(councilCellFM);
		int councilCellValue = 1;
		tester.setCouncilCellValue(councilCellValue);
		int ris = tester.getCouncilCellFM().getValue();
		int ris2 = tester.getCouncilCellValue();
		
		assertEquals(ris3, ris);
		assertEquals(councilCellValue, ris2);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell#CouncilCell()}.
	 */
	@Test
	public void testCouncilCell() {
		
		CouncilCell tester = new CouncilCell();
		tester.setCouncilCellValue(GeneralParameters.baseValueCouncilCells);
		int ris = tester.getCouncilCellValue();
		
		assertEquals(GeneralParameters.baseValueCouncilCells, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell#isEmptyCC()}.
	 */
	@Test
	public void testIsEmptyCC() {
		
		CouncilCell tester = new CouncilCell();
		
		assertTrue(tester.isEmptyCC());
		
		Dice dice = new Dice(3);
		FMember councilCellFM = new FMember(dice , 1);
		tester.setCouncilCellFM(councilCellFM);
		
		assertTrue(!(tester.isEmptyCC()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell#isLegalCC(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testIsLegalCC() {
		
		CouncilCell tester = new CouncilCell();
		Dice dice = new Dice(4);
		FMember pBoardFM = new FMember(dice, 1);
		pBoardFM.setValue(1);
		tester.setCouncilCellValue(1);
		
		
		assertTrue(tester.isLegalCC(pBoardFM));
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell#getCouncilCellFM()}.
	 */
	@Test
	public void testGetCouncilCellFM() {
		
		CouncilCell tester = new CouncilCell();
		FMember councilCellFM = new FMember(5, 3);
		int ris = councilCellFM.getPlayercol();
		tester.setCouncilCellFM(councilCellFM);
		int ris2 = tester.getCouncilCellFM().getPlayercol();
		
		assertEquals(ris, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell#setCouncilCellFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetCouncilCellFM() {

		CouncilCell tester = new CouncilCell();
		FMember councilCellFM = new FMember(5, 3);
		int ris = councilCellFM.getPlayercol();
		tester.setCouncilCellFM(councilCellFM);
		int ris2 = tester.getCouncilCellFM().getPlayercol();
		
		assertEquals(ris, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell#getCouncilCellValue()}.
	 */
	@Test
	public void testGetCouncilCellValue() {
		
		CouncilCell tester = new CouncilCell();
		int councilCellValue = 345;
		tester.setCouncilCellValue(councilCellValue );
		int ris = tester.getCouncilCellValue();
		
		assertEquals(councilCellValue, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell#setCouncilCellValue(int)}.
	 */
	@Test
	public void testSetCouncilCellValue() {
		
		CouncilCell tester = new CouncilCell();
		int councilCellValue = 345;
		tester.setCouncilCellValue(councilCellValue );
		int ris = tester.getCouncilCellValue();
		
		assertEquals(councilCellValue, ris);
		
		
	}

}
