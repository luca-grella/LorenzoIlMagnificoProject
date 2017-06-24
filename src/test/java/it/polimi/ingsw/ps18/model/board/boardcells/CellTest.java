/**
 * 
 */
package it.polimi.ingsw.ps18.model.board.boardcells;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

// TODO: Auto-generated Javadoc
/**
 * The Class CellTest.
 *
 * @author luca-grella
 */


public class CellTest {


	/**
	 * Test method for
	 * {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#Cell(org.json.simple.JSONObject)}.
	 *
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testCell() throws FileNotFoundException, IOException, ParseException {
		

		JSONParser parser = new JSONParser();

	    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
	    	JSONObject jsonObject = (JSONObject) obj;
	        JSONObject a = (JSONObject) jsonObject.get("0");
	        long value = (long) a.get("CellValue");
	        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
	        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
	        
		Cell tester = new Cell(a);

		long ris = tester.getCellValue();
		
		assertEquals(value, ris);
	}

	/**
	 * Test method for
	 * {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#activateQEffects(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 *
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testActivateQEffects() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        long value = (long) a.get("CellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
	Cell tester = new Cell(a);
	PBoard player = new PBoard();
    Stats resources = new Stats(-67,0,0,0,0,0,0);
	//	GameLogic game = new GameLogic();
	player.setResources(resources);
	int wood = player.getResources().getWood();

	tester.activateQEffects(player, null);
	int ris = player.getResources().getWood();
	
	assertEquals(wood+1, ris);

		
	}

	/**
	 * Test method for
	 * {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#insertCard(it.polimi.ingsw.ps18.model.cards.Cards)}.
	 *
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testInsertCard() throws FileNotFoundException, IOException, ParseException {
    
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        long value = (long) a.get("CellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
		JSONParser parser2 = new JSONParser();
		
    	Object obj2 = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("0");
//        String name = (String) a2.get("name");
//        int number = (int) a2.get("number");
//        int color = (int) a2.get("color");
//        int period = (int) a2.get("period");
//        int harvalue = (int) a2.get("HarvestValue");

	Cell tester = new Cell(a);
	Cards card = new GreenC((Integer)1);
	long ris = card.getID();
	tester.insertCard(card);
	long ris2 = tester.getCellCard().getID();
	
	assertEquals(ris, ris2);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#insertFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testInsertFM() {
//		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#isEmptyTC()}.
	 *
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testIsEmptyTC() throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        long value = (long) a.get("CellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        Cell tester = new Cell(a);
		boolean empty = tester.isEmptyTC();
		FMember cellFM = new FMember(1, 1);
		tester.setCellFM(cellFM );
		boolean full = tester.isEmptyTC();
		assertTrue(!full);
		assertTrue(empty);
		
		
	}

	/**
	 * Test method for
	 * {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#isLegalTC(int)}.
	 *
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testIsLegalTC() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        long value = (long) a.get("CellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        Cell tester = new Cell(a);
        int actionValue=1;
		boolean legal = tester.isLegalTC(actionValue);
		assertEquals(actionValue, legal);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#getCellCard()}.
	 */
	@Test
	public void testGetCellCard() {
    
		JSONObject o = new JSONObject();
		
		Cell tester = new Cell(o);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#setCellCard(it.polimi.ingsw.ps18.model.cards.Cards)}.
	 */
	@Test
	public void testSetCellCard() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#getCellFM()}.
	 */
	@Test
	public void testGetCellFM() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#setCellFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetCellFM() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#getCellValue()}.
	 */
	@Test
	public void testGetCellValue() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#setCellValue(long)}.
	 */
	@Test
	public void testSetCellValue() {
		fail("Not yet implemented");
	}

}
