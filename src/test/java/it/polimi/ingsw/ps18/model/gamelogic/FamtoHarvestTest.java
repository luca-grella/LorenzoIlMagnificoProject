/**
 * 
 */
package it.polimi.ingsw.ps18.model.gamelogic;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class FamtoHarvestTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#FamtoHarvest(it.polimi.ingsw.ps18.view.PBoardView)}.
	 */
	@Test
	public void testFamtoHarvest() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#getChosenFam()}.
	 */
	@Test
	public void testGetChosenFam() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		Dice dice = new Dice(3);
		FMember chosenFam = new FMember(dice , 2);
		tester.setChosenFam(chosenFam );
		FMember ris = tester.getChosenFam();
		assertEquals(chosenFam, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetChosenFam() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		Dice dice = new Dice(3);
		FMember chosenFam = new FMember(dice , 2);
		tester.setChosenFam(chosenFam );
		FMember ris = tester.getChosenFam();
		assertEquals(chosenFam, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#setChosenCell(int)}.
	 */
	@Test
	public void testSetChosenCell() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		int chosenCell = 3;
		tester.setChosenCell(chosenCell );
		int ris = tester.getChosenCell();
		
		assertEquals(chosenCell, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#setActionValue(int)}.
	 */
	@Test
	public void testSetActionValue() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		int actionValue = 5;
		tester.setActionValue(actionValue );
		int ris = tester.getActionValue();
		
		assertEquals(actionValue,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#setIndexFamtoRemove(int)}.
	 */
	@Test
	public void testSetIndexFamtoRemove() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		int indexFamtoRemove=4;
		tester.setIndexFamtoRemove(indexFamtoRemove);
		int ris = tester.getIndexFamtoRemove();
		
		assertEquals(indexFamtoRemove,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#getNumberOfServants()}.
	 */
	@Test
	public void testGetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		int numberOfServants = 4;
		tester.setNumberOfServants(numberOfServants );
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants,ris);
				
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#setNumberOfServants(int)}.
	 */
	@Test
	public void testSetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		int numberOfServants = 4;
		tester.setNumberOfServants(numberOfServants );
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants,ris);
	}

}
