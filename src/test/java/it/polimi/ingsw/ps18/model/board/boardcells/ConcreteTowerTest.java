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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * The Class ConcreteTowerTest.
 *
 * @author luca-grella
 */
public class ConcreteTowerTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#ConcreteTower(java.lang.Integer)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testConcreteTower() throws FileNotFoundException, IOException, ParseException {
		int f=1;
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        JSONObject b = (JSONObject) a.get("0");
        
        long value = (long) b.get("CellValue");
		
        assertEquals(f, value);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#insertCards(java.util.List, int)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testInsertCards() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        
		JSONParser parser2 = new JSONParser();
		
    	Object obj2 = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("0");
        JSONObject a3 = (JSONObject) jsonObject2.get("1");
        JSONObject a4 = (JSONObject) jsonObject2.get("2");
        JSONObject a5 = (JSONObject) jsonObject2.get("3");
        String name = (String) a2.get("name");
        long number = (long) a2.get("number");
        long color = (long) a2.get("color");
        long period = (long) a2.get("period");
        long harvalue = (long) a2.get("HarvestValue");

	
        Cards card = new GreenC(a2);
        Cards card2 = new GreenC(a3);
        Cards card3 = new GreenC(a4);
        Cards card4 = new GreenC(a5);
        ConcreteTower tester = new ConcreteTower(0, a);
        
        long ris = card.getID();
        long ris2 = card2.getID();
        long ris3 = card3.getID();
        long ris4 = card4.getID();
        
        List<Cards> towerCards = new ArrayList<>();

        
		towerCards.add(card);
        towerCards.add(card2);
        towerCards.add(card3);
        towerCards.add(card4);
        
		tester.insertCards(towerCards, 1);
		long risfinal = tester.getTowerCells().get(0).getCellCard().getID();
		
		assertTrue((ris==risfinal)||(ris2==risfinal)||(ris3==risfinal)||(ris4==risfinal));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#insertFM(it.polimi.ingsw.ps18.model.personalboard.FMember, int)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testInsertFM() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        
        ConcreteTower tester = new ConcreteTower(0, a);
        Dice dice = new Dice(3);
		FMember pBoardFM = new FMember(dice , 1);
		int floor=2;
		int ris = pBoardFM.getPlayercol();
//		tester.isEmptyTower();
		tester.insertFM(pBoardFM, floor);
        int ris2 = tester.getTowerCells().get(2).getCellFM().getPlayercol();
        
        assertEquals(ris, ris2);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#isLegalT(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testIsLegalT() throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        
        ConcreteTower tester = new ConcreteTower(0, a);
        
        Dice dice = new Dice(3);
		FMember pBoardFM = new FMember(dice , 1);
		int floor=2;
		int ris = pBoardFM.getPlayercol();
		
		assertTrue(tester.isEmptyTower());
		assertTrue(tester.isLegalTower(pBoardFM));
		
		tester.insertFM(pBoardFM, floor);
        int ris2 = tester.getTowerCells().get(2).getCellFM().getPlayercol();
        
		Dice dice2 = new Dice(3);
		FMember pBoardFM2 = new FMember(dice2, 2);
		
		assertTrue(tester.isLegalTower(pBoardFM2));
		
		int b = 2;
		int c = 1;
		FMember pBoardFM3 = new FMember(b, c);
		assertTrue(tester.isLegalTower(pBoardFM3));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#isEmptyT()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testIsEmptyTower() throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        
        ConcreteTower tester = new ConcreteTower(0, a);
        
        assertTrue(tester.isEmptyTower());
		
		
		
	}
	
	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#isFullTower()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testIsFullTower () throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        
        ConcreteTower tester = new ConcreteTower(0, a);
        
        FMember pBoardFM = new FMember(2, 0);
		tester.insertFM(pBoardFM, 0);
        FMember pBoardFM1 = new FMember(5, 1);
		tester.insertFM(pBoardFM1, 1);
        FMember pBoardFM2 = new FMember(1, 2);
		tester.insertFM(pBoardFM2, 2);
        FMember pBoardFM3 = new FMember(6, 3);
		tester.insertFM(pBoardFM3, 3);
		
		assertTrue(tester.isFullTower());
	
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#getTowerCells()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetTowerCells() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        
		JSONParser parser2 = new JSONParser();

    	Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("0");
        long value = (long) a2.get("CellValue");
        JSONArray qeffects = (JSONArray) a2.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a2.get("QuickEffectsValues");
             
        
        ConcreteTower tester = new ConcreteTower(0, a);
        List<Cell> towerCells = new ArrayList<>();
        Cell cell = new Cell(a2);
        
		towerCells.add(0, cell);
		tester.setTowerCells(towerCells);
        int ris = tester.getTowerCells().get(0).getCellValue();
        
        assertEquals(value, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#setTowerCells(java.util.List)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetTowerCells() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        
		JSONParser parser2 = new JSONParser();

    	Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/cellprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("0");
        long value = (long) a2.get("CellValue");
        JSONArray qeffects = (JSONArray) a2.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a2.get("QuickEffectsValues");
             
        
        ConcreteTower tester = new ConcreteTower(0, a);
        List<Cell> towerCells = new ArrayList<>();
        Cell cell = new Cell(a2);
        
		towerCells.add(0, cell);
		tester.setTowerCells(towerCells);
        int ris = tester.getTowerCells().get(0).getCellValue();
        
        assertEquals(value, ris);
		
		
	}

}
