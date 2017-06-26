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
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

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
        String name = (String) a2.get("name");
        long number = (long) a2.get("number");
        long color = (long) a2.get("color");
        long period = (long) a2.get("period");
        long harvalue = (long) a2.get("HarvestValue");

	Cell tester = new Cell(a);
	Cards card = new GreenC(a2);
	long ris = card.getID();
	tester.insertCard(card);
	long ris2 = tester.getCellCard().getID();
	
	assertEquals(ris, ris2);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#insertFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testInsertFM() throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        long value = (long) a.get("CellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        Cell tester = new Cell(a);
        Dice dice = new Dice(1);
		FMember pBoardFM = new FMember(dice , 1);
		int ris = pBoardFM.getPlayercol();
		int riscol = pBoardFM.getColor();
		int risval = pBoardFM.getValue();
		tester.insertFM(pBoardFM);
		int ris2 = tester.getCellFM().getPlayercol();
		int riscol2 = tester.getCellFM().getColor();
		int risval2 = tester.getCellFM().getValue();
		
		assertEquals(ris, ris2);
		assertEquals(riscol, riscol2);
		assertEquals(risval, risval2);
		
		
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
        
        
		JSONParser parser2 = new JSONParser();
		
    	Object obj2 = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("0");
        String name = (String) a2.get("name");
        long number = (long) a2.get("number");
        long color = (long) a2.get("color");
        long period = (long) a2.get("period");
        long harvalue = (long) a2.get("HarvestValue");

        
        Cards card = new GreenC(a2);
        
        Cell tester = new Cell(a);
        
        tester.insertCard(card);
       
        
        
		boolean legal = tester.isLegalTC(7);
		assertTrue(legal);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#getCellCard()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetCellCard() throws FileNotFoundException, IOException, ParseException {
    
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
        String name = (String) a2.get("name");
        long number = (long) a2.get("number");
        long color = (long) a2.get("color");
        long period = (long) a2.get("period");
        long harvalue = (long) a2.get("HarvestValue");

        
        Cards card = new GreenC(a2);
        
        long ris = card.getID();
        
        Cell tester = new Cell(a);
        
        tester.insertCard(card);
        
        long ris2 = tester.getCellCard().getID();
        
        assertEquals(ris, ris2);
       
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#setCellCard(it.polimi.ingsw.ps18.model.cards.Cards)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetCellCard() throws FileNotFoundException, IOException, ParseException {

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
        String name = (String) a2.get("name");
        long number = (long) a2.get("number");
        long color = (long) a2.get("color");
        long period = (long) a2.get("period");
        long harvalue = (long) a2.get("HarvestValue");

        
        Cards card = new GreenC(a2);
        
        long ris = card.getID();
        
        Cell tester = new Cell(a);
        
        tester.insertCard(card);
        
        long ris2 = tester.getCellCard().getID();
        
        assertEquals(ris, ris2);
	

	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#getCellFM()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetCellFM() throws FileNotFoundException, IOException, ParseException {
		

		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        long value = (long) a.get("CellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        Cell tester = new Cell(a);
        Dice dice = new Dice(3);
		FMember cellFM = new FMember(dice , 1);
		int ris = cellFM.getPlayercol();
		tester.setCellFM(cellFM);
		int ris2 = tester.getCellFM().getPlayercol();
		
		assertEquals(ris, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#setCellFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetCellFM() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        long value = (long) a.get("CellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        Cell tester = new Cell(a);
        Dice dice = new Dice(3);
		FMember cellFM = new FMember(dice , 1);
		int ris = cellFM.getPlayercol();
		tester.setCellFM(cellFM);
		int ris2 = tester.getCellFM().getPlayercol();
		
		assertEquals(ris, ris2);
		
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#getCellValue()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetCellValue() throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        long value = (long) a.get("CellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        Cell tester = new Cell(a);
        int ris = tester.getCellValue();
        
        assertEquals(value, ris);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell#setCellValue(long)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetCellValue() throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        long value = (long) a.get("CellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        Cell tester = new Cell(a);
        
        tester.setCellValue(tester.getCellValue()+5);
        
        int ris = tester.getCellValue();
        
        assertEquals(value+5, ris);
		
		
	}

}
