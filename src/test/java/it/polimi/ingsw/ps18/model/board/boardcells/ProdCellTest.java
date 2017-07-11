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

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.VariousModifier;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ProdCellTest.
 *
 * @author luca-grella
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
		ProdCell tester = new ProdCell(malus);
		tester.setProdCellValue(2);
		
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
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ProdCell#isEmptyPC()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testIsEmptyPC() throws FileNotFoundException, IOException, ParseException {
		
		int malus = 1;
		ProdCell tester = new ProdCell(malus);
		
		assertTrue(tester.isEmptyPC());
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
		
		tester.setProdCellValue(2);
		
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
		
		assertTrue(!(tester.isEmptyPC()));
		
	}

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
		
		tester.setProdCellValue(40);
		
		val = 35;
		fm = new FMember(val, 1);
		
		assertTrue(!(tester.isLegalPC(fm.getValue())));
		
		
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
	 * Test to string.
	 */
	@Test
	public void testToString() {
		
		int malus = 2;
		ProdCell tester = new ProdCell(malus);
		tester.setProdCellValue(5);
		
		String ris = tester.toString(2);
		
		assertEquals("-----------------\nProduction cell number 2:\nMinimum value to access this cell: 5\nAction Malus from this cell: 2\nProduction cell is empty!", ris);
		
		FMember prodCellFM = new FMember(5, 2);
		prodCellFM.setColor(2);
		prodCellFM.setValue(1);
		tester.setProdCellFM(prodCellFM );
		
		ris = tester.toString(2);
		
		assertEquals("-----------------\nProduction cell number 2:\nMinimum value to access this cell: 5\nAction Malus from this cell: 2\nFamily Member in production cell number 2:\n\tPlayer color: 2\n\tFamily Member color: 2\n\tFamily Member value: 1\n",ris);
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
