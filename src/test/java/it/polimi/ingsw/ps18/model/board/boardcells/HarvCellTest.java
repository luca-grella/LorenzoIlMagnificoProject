/**
 * 
 */
package it.polimi.ingsw.ps18.model.board.boardcells;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.VariousModifier;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class HarvCellTest.
 *
 * @author luca-grella
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
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testInsertFM() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
		
		int malus = 2;
		HarvCell tester = new HarvCell(malus);
		tester.setHarvCellValue(2);
		
		Dice dice = new Dice(3);
		FMember pBoardFM = new FMember(dice , 3);
		pBoardFM.setValue(2);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<LeaderCards> cards = new ArrayList<>();
		LeaderCards e = new LeaderCards(a);
		e.setActive(true);
		List<LCPermEffect> permEffects = new ArrayList<>();
		LCPermEffect eff1 = new VariousModifier();
		((VariousModifier) eff1).setParam("SkipFullSpaceControl");
		permEffects.add(eff1);
		e.setPermEffects(permEffects );
		turnplayer.setLeaderCards(cards );
		
		game.setCurrentPlayer(turnplayer );
		tester.insertFM(pBoardFM , game);
	
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#isEmptyHC()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testIsEmptyHC() throws FileNotFoundException, IOException, ParseException {

		int malus = 1;
		HarvCell tester = new HarvCell(malus);
		
		assertTrue(tester.isEmptyHC());
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
		
		tester.setHarvCellValue(2);
		
		Dice dice = new Dice(3);
		FMember pBoardFM = new FMember(dice , 3);
		pBoardFM.setValue(2);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<LeaderCards> cards = new ArrayList<>();
		LeaderCards e = new LeaderCards(a);
		e.setActive(true);
		List<LCPermEffect> permEffects = new ArrayList<>();
		LCPermEffect eff1 = new VariousModifier();
		((VariousModifier) eff1).setParam("SkipFullSpaceControl");
		permEffects.add(eff1);
		e.setPermEffects(permEffects );
		turnplayer.setLeaderCards(cards );
		
		game.setCurrentPlayer(turnplayer );
		tester.insertFM(pBoardFM , game);
		
		assertTrue(!(tester.isEmptyHC()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.HarvCell#isLegalHC(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testIsLegalHC() {
		
		int malus = 1;
		HarvCell tester = new HarvCell(malus);
		tester.setHarvCellValue(35);
		
		int val = 40;
		FMember fm = new FMember(val, 1);
		
		assertTrue(tester.isLegalHC(fm.getValue()));
		
		tester.setHarvCellValue(40);
		
		val = 35;
		fm = new FMember(val, 1);
		
		assertTrue(!(tester.isLegalHC(fm.getValue())));
		
		
		
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
	 * Test to string.
	 */
	@Test
	public void testToString() {
		
		int malus = 2;
		HarvCell tester = new HarvCell(malus);
		tester.setHarvCellValue(5);
		
		String ris = tester.toString(2);
		
		assertEquals("-----------------\nHarvest cell number 2:\nMinimum value to access this cell: 5\nAction Malus from this cell: 2\nHarvest cell is empty!-----------------\n", ris);
		
		FMember harvCellFM = new FMember(5, 2);
		harvCellFM.setColor(2);
		harvCellFM.setValue(1);
		tester.setHarvCellFM(harvCellFM );
		
		ris = tester.toString(2);
		
		assertEquals("-----------------\nHarvest cell number 2:\nMinimum value to access this cell: 5\nAction Malus from this cell: 2\nFamily Member in harvest cell number 2:\n\tPlayer color: 2\n\tFamily Member color: 2\n\tFamily Member value: 1\n-----------------\n",ris);
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
