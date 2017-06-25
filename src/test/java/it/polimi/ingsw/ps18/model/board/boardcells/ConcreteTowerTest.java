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

// TODO: Auto-generated Javadoc
/**
 * The Class ConcreteTowerTest.
 *
 * @author luca-grella
 */
public class ConcreteTowerTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#ConcreteTower(java.lang.Integer)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
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
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
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
        ConcreteTower tester = new ConcreteTower(0);
        
        long ris = card.getID();
        long ris2 = card.getID();
        long ris3 = card.getID();
        long ris4 = card.getID();
        
        List<Cards> towerCards = new ArrayList<>();

        
		towerCards.add(card);
        towerCards.add(card2);
        towerCards.add(card3);
        towerCards.add(card4);
        
		tester.insertCards(towerCards , 1);
		long risfinal = tester.getTowerCells().get(0).getCellCard().getID();
		
		assertTrue((ris==risfinal)||(ris2==risfinal)||(ris3==risfinal)||(ris4==risfinal));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#insertFM(it.polimi.ingsw.ps18.model.personalboard.FMember, int)}.
	 */
//	@Test
//	public void testInsertFM() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#isLegalT(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
//	 */
//	@Test
//	public void testIsLegalT() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#isEmptyT()}.
//	 */
//	@Test
//	public void testIsEmptyT() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#getTowerCells()}.
//	 */
//	@Test
//	public void testGetTowerCells() {
//		
//		ConcreteTower tester = new ConcreteTower(1);
//		List<Cell> towerCells = new ArrayList<>();
//		Cell e = new Cell(null);
//		towerCells.add(e );
//		tester.setTowerCells(towerCells);
//		List<Cell> ris = tester.getTowerCells();
//		
//	}
//
//	/**
//	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower#setTowerCells(java.util.List)}.
//	 */
//	@Test
//	public void testSetTowerCells() {
//		fail("Not yet implemented");
//	}
//
}
