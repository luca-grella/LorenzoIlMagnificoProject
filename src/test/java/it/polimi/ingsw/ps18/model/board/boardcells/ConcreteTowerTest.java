/**
 * 
 */
package it.polimi.ingsw.ps18.model.board.boardcells;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author luca-grella
 *
 */
public class ConcreteTowerTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#ConcreteTower(java.lang.Integer)}.
	 */
	@Test
	public void testConcreteTower() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#insertCards(java.util.List, int)}.
	 */
	@Test
	public void testInsertCards() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#insertFM(it.polimi.ingsw.ps18.model.personalboard.FMember, int)}.
	 */
	@Test
	public void testInsertFM() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#isLegalT(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testIsLegalT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#isEmptyT()}.
	 */
	@Test
	public void testIsEmptyT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#getTowerCells()}.
	 */
	@Test
	public void testGetTowerCells() {
		
		ConcreteTower tester = new ConcreteTower(1);
		List<Cell> towerCells = new ArrayList<>();
		Cell e = new Cell(null);
		towerCells.add(e );
		tester.setTowerCells(towerCells);
		List<Cell> ris = tester.getTowerCells();
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#setTowerCells(java.util.List)}.
	 */
	@Test
	public void testSetTowerCells() {
		fail("Not yet implemented");
	}

}
