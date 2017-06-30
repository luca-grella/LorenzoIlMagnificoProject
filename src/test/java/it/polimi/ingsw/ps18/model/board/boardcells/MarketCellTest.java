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
import java.util.Observer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.MainView;

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
	@Test
	public void testMarketCell() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
        long minplayers = (long) a.get("MinPlayers");
        long marketcellvalue = (long) a.get("MarketCellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        MarketCell tester = new MarketCell(a);
        
        assertEquals(minplayers, tester.getMinPlayers());
        
        
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#insertFM(it.polimi.ingsw.ps18.model.personalboard.FMember, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testInsertFM() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
        long minplayers = (long) a.get("MinPlayers");
        long marketcellvalue = (long) a.get("MarketCellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        MarketCell tester = new MarketCell(a);
        int nplayer=1;
		MainController mcontroller = new MainController();
		List<PBoard> players = new ArrayList<>();
		PBoard element = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		element.setResources(resources );
		element.setPlayercol(1);
		players.add(0, element);
		GameLogic game = new GameLogic();
        MainView o = new MainView(mcontroller);
		game.addObserver(o );
		game.setCurrentPlayer(element);
//        activateQEffects(game);
		Dice dice = new Dice(5);
		FMember fm = new FMember(dice , 1);
		int expected=257;
		fm.setValue(expected);
		int ris1 = tester.getMinPlayers();
		tester.insertFM(fm, game);
		int ris = tester.getMarketCellFM().getValue();
		int ris2 = tester.getMinPlayers();
		
		assertEquals(expected, ris);
		assertEquals(ris1, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#isEmptyMC()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsEmptyMC() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
        long minplayers = (long) a.get("MinPlayers");
        long marketcellvalue = (long) a.get("MarketCellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        MarketCell tester = new MarketCell(a);
        
        assertTrue(tester.isEmptyMC());
        
        
        
        int nplayer=1;
		MainController mcontroller = new MainController();
		List<PBoard> players = new ArrayList<>();
		PBoard element = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		element.setResources(resources);
		element.setPlayercol(1);
		players.add(0, element);
		GameLogic game = new GameLogic();
        MainView o = new MainView(mcontroller);
		game.addObserver(o);
		game.setCurrentPlayer(element);
		Dice dice = new Dice(5);
		FMember fm = new FMember(dice , 1);

		tester.insertFM(fm, game);
		

		
		assertTrue(!(tester.isEmptyMC()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#isLegalMC(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsLegalMC() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
        long minplayers = (long) a.get("MinPlayers");
        long marketcellvalue = (long) a.get("MarketCellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        MarketCell tester = new MarketCell(a);
        FMember pBoardFM = new FMember(3, 1);
        
        assertTrue(tester.isLegalMC(pBoardFM.getValue()));
        
        int nplayer=1;
		MainController mcontroller = new MainController();
		List<PBoard> players = new ArrayList<>();
		PBoard element = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		element.setResources(resources);
		element.setPlayercol(1);
		players.add(0, element);
		GameLogic game = new GameLogic();
        MainView o = new MainView(mcontroller);
		game.addObserver(o);
		game.setCurrentPlayer(element);
		Dice dice = new Dice(5);
		FMember fm = new FMember(dice , 1);

		tester.insertFM(fm, game);
		
		
		assertTrue(!(tester.isLegalMC(pBoardFM.getValue())));
        
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#getMarketCellFM()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetMarketCellFM() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
        long minplayers = (long) a.get("MinPlayers");
        long marketcellvalue = (long) a.get("MarketCellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        MarketCell tester = new MarketCell(a);
        FMember fm = new FMember(6, 1);
		
		int color = 23;
		fm.setColor(color);
		int playercol = 14;
		fm.setPlayercol(playercol);
		int value = 56;
		fm.setValue(value);
		
		tester.setMarketCellFM(fm);
		
		FMember risfm = tester.getMarketCellFM();
		int ris = risfm.getColor();
		int ris2 = risfm.getPlayercol();
		int ris3 = risfm.getValue();
		
		assertEquals(ris, color);
		assertEquals(ris2, playercol);
		assertEquals(ris3, value);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#setMarketCellFM(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetMarketCellFM() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
        long minplayers = (long) a.get("MinPlayers");
        long marketcellvalue = (long) a.get("MarketCellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        MarketCell tester = new MarketCell(a);
        FMember fm = new FMember(2, 3);
		
		int color = 67;
		fm.setColor(color);
		int playercol = 98;
		fm.setPlayercol(playercol);
		int value = 45;
		fm.setValue(value);
		
		tester.setMarketCellFM(fm);
		
		FMember risfm = tester.getMarketCellFM();
		int ris = risfm.getColor();
		int ris2 = risfm.getPlayercol();
		int ris3 = risfm.getValue();
		
		assertEquals(ris, color);
		assertEquals(ris2, playercol);
		assertEquals(ris3, value);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#getMinPlayers()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetMinPlayers() throws FileNotFoundException, IOException, ParseException {
	
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
        long minplayers = (long) a.get("MinPlayers");
        long marketcellvalue = (long) a.get("MarketCellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        MarketCell tester = new MarketCell(a);
        long min = 456;
		tester.setMinPlayers(min);
		
		int ris = tester.getMinPlayers();
		
		assertEquals(min, ris);
        
        
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.boardcells.MarketCell#setMinPlayers(long)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetMinPlayers() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
        long minplayers = (long) a.get("MinPlayers");
        long marketcellvalue = (long) a.get("MarketCellValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
        
        MarketCell tester = new MarketCell(a);
        long min = 456;
		tester.setMinPlayers(min);
		
		int ris = tester.getMinPlayers();
		
		assertEquals(min, ris);
		
		
	}

}
