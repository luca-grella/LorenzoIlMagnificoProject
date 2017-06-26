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

/**
 * @author luca-grella
 *
 */
public class MarketCellTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#MarketCell(java.lang.Integer)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
//	@Test
//	public void testMarketCell() throws FileNotFoundException, IOException, ParseException {
//		
//		JSONParser parser = new JSONParser();
//
//    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
//    	JSONObject jsonObject = (JSONObject) obj;
//        JSONObject a = (JSONObject) jsonObject.get("1");
//        long minplayers = (long) a.get("MinPlayers");
//        long marketcellvalue = (long) a.get("MarketCellValue");
//        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
//        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
//        
//        MarketCell tester = new MarketCell(0);
//        
//        
//		
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#insertFM(it.polimi.ingsw.ps18.model.personalboard.FMember, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testInsertFM() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#isEmptyMC()}.
	 */
	@Test
	public void testIsEmptyMC() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#isLegalMC(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testIsLegalMC() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#getMarketCellFM()}.
	 */
	@Test
	public void testGetMarketCellFM() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#setMarketCellFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetMarketCellFM() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#getMinPlayers()}.
	 */
	@Test
	public void testGetMinPlayers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#setMinPlayers(long)}.
	 */
	@Test
	public void testSetMinPlayers() {
		fail("Not yet implemented");
	}

}
