/**
 * 
 */
package it.polimi.ingsw.ps18.model.board;

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

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.MainView;

/**
 * The Class BoardTest.
 *
 * @author luca-grella
 */
public class BoardTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#Board(it.polimi.ingsw.ps18.controller.MainController, int)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testBoard() throws FileNotFoundException, IOException, ParseException {
		
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller , 1, new MainView(mcontroller));
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        JSONObject ac = (JSONObject) a.get("0");
        long cellval = (long) ac.get("CellValue");
        
       
        
		JSONParser parser2 = new JSONParser();

    	Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("1");
        long minplayers = (long) a2.get("MinPlayers");

        
        MarketCell tester2 = new MarketCell(a2);
        
		JSONParser parser3 = new JSONParser();

    	Object obj3 = parser3.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
    	JSONObject jsonObject3 = (JSONObject) obj3;
        JSONObject a3 = (JSONObject) jsonObject3.get("1");
        long number = (long) a3.get("number");
        long period = (long) a3.get("period");
        JSONArray effects = (JSONArray) a3.get("Effects");
        JSONArray effectvalues = (JSONArray) a3.get("EffectsValues");
        
		JSONParser parser4 = new JSONParser();

    	Object obj4 = parser4.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
    	JSONObject jsonObject4 = (JSONObject) obj4;
        JSONObject a4 = (JSONObject) jsonObject4.get("8");
        long number1 = (long) a4.get("number");
        long period1 = (long) a4.get("period");

        
		JSONParser parser5 = new JSONParser();

    	Object obj5 = parser5.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
    	JSONObject jsonObject5 = (JSONObject) obj5;
        JSONObject a5 = (JSONObject) jsonObject5.get("15");
        long number2 = (long) a5.get("number");
        long period2 = (long) a5.get("period");

		
		List<CouncilCell> councilCells = new ArrayList<>();
		CouncilCell ccell = new CouncilCell();
		int ccellvalue = 134;
		ccell.setCouncilCellValue(ccellvalue);
		councilCells.add(0, ccell);
		tester.setCouncilCells(councilCells);
		List<Excommunications> excommCells = new ArrayList<>();
		Excommunications ecell = new Excommunications(a3);
		excommCells.add(0, ecell);
		Excommunications ecell1 = new Excommunications(a4);
		excommCells.add(1, ecell1);
		Excommunications ecell2 = new Excommunications(a5);
		excommCells.add(2, ecell2);
		tester.setExcommCells(excommCells);
		List<HarvCell> harvestCells = new ArrayList<>();
		HarvCell hcell = new HarvCell(1);
		int hcellvalue = 34;
		hcell.setHarvCellValue(hcellvalue);
		harvestCells.add(0, hcell);
		tester.setHarvestCells(harvestCells);
		List<MarketCell> marketCells = new ArrayList<>();
		marketCells.add(0, tester2);
		tester.setMarketCells(marketCells);
		List<ProdCell> productionCells = new ArrayList<>();
		ProdCell pcell = new ProdCell(1);
		int pcellvalue = 46;
		pcell.setProdCellValue(pcellvalue);
		productionCells.add(0, pcell);
		tester.setProductionCells(productionCells);
		List<Tower> towers = new ArrayList<>();
		Tower tower = new ConcreteTower(0, a);
		towers.add(0, tower);
		tester.setTowers(towers);
		
		assertEquals(ccellvalue, tester.getCouncilCells().get(0).getCouncilCellValue());
		assertEquals(number, tester.getExcommCells().get(0).getID());
		assertEquals(period, tester.getExcommCells().get(0).getPeriod());
		assertEquals(number1, tester.getExcommCells().get(1).getID());
		assertEquals(period1, tester.getExcommCells().get(1).getPeriod());
		assertEquals(number2, tester.getExcommCells().get(2).getID());
		assertEquals(period2, tester.getExcommCells().get(2).getPeriod());
		assertEquals(1 , tester.getHarvestCells().get(0).getMalus());
		assertEquals(hcellvalue , tester.getHarvestCells().get(0).getHarvCellValue());
		assertEquals(minplayers, tester.getMarketCells().get(0).getMinPlayers());
		assertEquals(1, tester.getProductionCells().get(0).getMalus());
		assertEquals(pcellvalue, tester.getProductionCells().get(0).getProdCellValue());
		assertEquals(cellval, tester.getTowers().get(0).getTowerCells().get(0).getCellValue());
		
		
	}

	
	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#isFullMarket(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsFullMarket() throws FileNotFoundException, IOException, ParseException {
		
		MainController mcontroller2 = new MainController();
		Board tester2 = new Board(mcontroller2 , 2, new MainView(mcontroller2));
		
		assertTrue(!(tester2.isFullMarket()));
		
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");

        
		JSONParser parser2 = new JSONParser();

    	Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("2");
        
        MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller , 2, new MainView(mcontroller));
        
		MarketCell mcell = new MarketCell(a);
		FMember fm = new FMember(1, 2);
		mcell.setMarketCellFM(fm);
		MarketCell mcell2 = new MarketCell(a2);
		FMember fm2 = new FMember(2, 5);
		mcell2.setMarketCellFM(fm2);
		
        List<MarketCell> marketCells = new ArrayList<>();
        marketCells.add(0, mcell);
        marketCells.add(1, mcell2);
		tester.setMarketCells(marketCells);
		
		
		assertTrue(tester.isFullMarket());
		
	}
	
	
	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#isLegalHarv(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testIsLegalHarv() {
		

		MainController mcontroller = new MainController();
		Board tester = new Board(new MainController(), 2, new MainView(mcontroller));
		List<HarvCell> hcell = new ArrayList<>();
		HarvCell element = new HarvCell(1);
		hcell.add(0, element);
		tester.setHarvestCells(hcell);
		
		FMember fm = new FMember(4, 9);
		assertTrue(tester.isLegalHarv(fm));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#isLegalProd(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testIsLegalProd() {
		
		MainController mcontroller = new MainController();
		Board tester = new Board(new MainController(), 2, new MainView(mcontroller));
		List<ProdCell> pcell = new ArrayList<>();
		ProdCell element = new ProdCell(1);
		pcell.add(0, element);
		tester.setProductionCells(pcell);;
		
		FMember fm = new FMember(2, 13);
		assertTrue(tester.isLegalProd(fm));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#insertFMHarv(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
//	@Test
//	public void testInsertFMHarv() {
//		
//		MainController mcontroller = new MainController();
//		Board tester = new Board(new MainController(), 2, new MainView(mcontroller));
////		List<HarvCell> hcell = new ArrayList<>();
////		tester.setHarvestCells(hcell);
//		
//		FMember fm = new FMember(4, 9);
//		fm.setColor(34);
//		fm.setPlayercol(455);
//		fm.setValue(12);
//		tester.insertFMHarv(fm, 1, new GameLogic());
//		int color = tester.getHarvestCells().get(0).getHarvCellFM().getColor();
//		int playercol = tester.getHarvestCells().get(0).getHarvCellFM().getPlayercol();
//		int value = tester.getHarvestCells().get(0).getHarvCellFM().getValue();
//		
//		assertEquals(34, color);
//		assertEquals(455, playercol);
//		assertEquals(12, value);
//		
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#insertFMProd(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
//	@Test
//	public void testInsertFMProd() {
//		
//		MainController mcontroller = new MainController();
//		Board tester = new Board(new MainController(), 2, new MainView(mcontroller));
////		List<HarvCell> hcell = new ArrayList<>();
////		tester.setHarvestCells(hcell);
//		
//		FMember fm = new FMember(4, 9);
//		fm.setColor(82);
//		fm.setPlayercol(876);
//		fm.setValue(39);
//		tester.insertFMProd(fm, 1, new GameLogic());
//		int color = tester.getProductionCells().get(0).getProdCellFM().getColor();
//		int playercol = tester.getProductionCells().get(0).getProdCellFM().getPlayercol();
//		int value = tester.getProductionCells().get(0).getProdCellFM().getValue();
//		
//		assertEquals(82, color);
//		assertEquals(876, playercol);
//		assertEquals(39, value);
//		
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#getTowers()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetTowers() throws FileNotFoundException, IOException, ParseException {
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller , 1, new MainView(mcontroller));
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        JSONObject ac = (JSONObject) a.get("0");
        long cellval = (long) ac.get("CellValue");
        
       
		
		List<Tower> towers = new ArrayList<>();
		Tower tower = new ConcreteTower(0, a);
		towers.add(0, tower);
		tester.setTowers(towers);
		
		
		assertEquals(cellval, tester.getTowers().get(0).getTowerCells().get(0).getCellValue());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#setTowers(java.util.List)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetTowers() throws FileNotFoundException, IOException, ParseException {
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller , 1, new MainView(mcontroller));
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/concretetowerprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        JSONObject ac = (JSONObject) a.get("0");
        long cellval = (long) ac.get("CellValue");
        
       
		
		List<Tower> towers = new ArrayList<>();
		Tower tower = new ConcreteTower(0, a);
		towers.add(0, tower);
		tester.setTowers(towers);
		
		
		assertEquals(cellval, tester.getTowers().get(0).getTowerCells().get(0).getCellValue());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#getMarketCells()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetMarketCells() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser2 = new JSONParser();

    	Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("1");
        long minplayers = (long) a2.get("MinPlayers");
		
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		List<MarketCell> mc = new ArrayList<>();
		MarketCell a = new MarketCell(a2);
		mc.add(a);
		tester.setMarketCells(mc);
		
		assertEquals(minplayers, tester.getMarketCells().get(0).getMinPlayers());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#setMarketCells(java.util.List)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetMarketCells() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser2 = new JSONParser();

    	Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("1");
        long minplayers = (long) a2.get("MinPlayers");
		
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		List<MarketCell> mc = new ArrayList<>();
		MarketCell a = new MarketCell(a2);
		mc.add(a);
		tester.setMarketCells(mc);
		
		assertEquals(minplayers, tester.getMarketCells().get(0).getMinPlayers());

		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#getCouncilCells()}.
	 */
	@Test
	public void testGetCouncilCells() {
		
		
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		List<CouncilCell> cc = new ArrayList<>();
		CouncilCell e = new CouncilCell();
		e.setCouncilCellValue(899);
		cc.add(e);
		tester.setCouncilCells(cc);
		int ris = tester.getCouncilCells().get(0).getCouncilCellValue();
		
		assertEquals(899, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#setCouncilCells(java.util.List)}.
	 */
	@Test
	public void testSetCouncilCells() {
		
		
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		List<CouncilCell> cc = new ArrayList<>();
		CouncilCell e = new CouncilCell();
		e.setCouncilCellValue(24);
		cc.add(e);
		tester.setCouncilCells(cc);
		int ris = tester.getCouncilCells().get(0).getCouncilCellValue();
		
		assertEquals(24, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#getHarvestCells()}.
	 */
	@Test
	public void testGetHarvestCells() {
		
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		
		List<HarvCell> hc = new ArrayList<>();
		HarvCell e = new HarvCell(3);
		e.setHarvCellValue(19);
		hc.add(e);
		tester.setHarvestCells(hc);
		int ris = tester.getHarvestCells().get(0).getHarvCellValue();
		int ris2 = tester.getHarvestCells().get(0).getMalus();
		
		assertEquals(19, ris);
		assertEquals(3, ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#setHarvestCells(java.util.List)}.
	 */
	@Test
	public void testSetHarvestCells() {
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		
		List<HarvCell> hc = new ArrayList<>();
		HarvCell e = new HarvCell(3);
		e.setHarvCellValue(19);
		hc.add(e);
		tester.setHarvestCells(hc);
		int ris = tester.getHarvestCells().get(0).getHarvCellValue();
		int ris2 = tester.getHarvestCells().get(0).getMalus();
		
		assertEquals(19, ris);
		assertEquals(3, ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#getProductionCells()}.
	 */
	@Test
	public void testGetProductionCells() {
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		
		List<ProdCell> pc = new ArrayList<>();
		ProdCell e = new ProdCell(34);
		e.setProdCellValue(13);
		pc.add(e);
		tester.setProductionCells(pc);
		int ris = tester.getProductionCells().get(0).getProdCellValue();
		int ris2 = tester.getProductionCells().get(0).getMalus();
		
		assertEquals(13, ris);
		assertEquals(34, ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#setProductionCells(java.util.List)}.
	 */
	@Test
	public void testSetProductionCells() {
		
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		
		List<ProdCell> pc = new ArrayList<>();
		ProdCell e = new ProdCell(14);
		e.setProdCellValue(82);
		pc.add(e);
		tester.setProductionCells(pc);
		int ris = tester.getProductionCells().get(0).getProdCellValue();
		int ris2 = tester.getProductionCells().get(0).getMalus();
		
		assertEquals(82, ris);
		assertEquals(14, ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#getExcommCells()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetExcommCells() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser3 = new JSONParser();

    	Object obj3 = parser3.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
    	JSONObject jsonObject3 = (JSONObject) obj3;
        JSONObject a3 = (JSONObject) jsonObject3.get("1");
        long number = (long) a3.get("number");
        long period = (long) a3.get("period");
        JSONArray effects = (JSONArray) a3.get("Effects");
        JSONArray effectvalues = (JSONArray) a3.get("EffectsValues");
        
		JSONParser parser4 = new JSONParser();

    	Object obj4 = parser4.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
    	JSONObject jsonObject4 = (JSONObject) obj4;
        JSONObject a4 = (JSONObject) jsonObject4.get("8");
        long number1 = (long) a4.get("number");
        long period1 = (long) a4.get("period");

        
		JSONParser parser5 = new JSONParser();

    	Object obj5 = parser5.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
    	JSONObject jsonObject5 = (JSONObject) obj5;
        JSONObject a5 = (JSONObject) jsonObject5.get("15");
        long number2 = (long) a5.get("number");
        long period2 = (long) a5.get("period");
		
		
		
		
		
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		
		List<Excommunications> ec = new ArrayList<>();
		Excommunications e = new Excommunications(a3);
		ec.add(e);
		Excommunications e1 = new Excommunications(a4);
		ec.add(e1);
		Excommunications e2 = new Excommunications(a5);
		ec.add(e2);
		tester.setExcommCells(ec);
		
		long risid = tester.getExcommCells().get(0).getID();
		long risperiod = tester.getExcommCells().get(0).getPeriod();
		long risid1 = tester.getExcommCells().get(1).getID();
		long risperiod1 = tester.getExcommCells().get(1).getPeriod();
		long risid2 = tester.getExcommCells().get(2).getID();
		long risperiod2 = tester.getExcommCells().get(2).getPeriod();
		
		assertEquals(number, risid);
		assertEquals(period, risperiod);
		assertEquals(number1, risid1);
		assertEquals(period1, risperiod1);
		assertEquals(number2, risid2);
		assertEquals(period2, risperiod2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#setExcommCells(java.util.List)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetExcommCells() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser3 = new JSONParser();

    	Object obj3 = parser3.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
    	JSONObject jsonObject3 = (JSONObject) obj3;
        JSONObject a3 = (JSONObject) jsonObject3.get("1");
        long number = (long) a3.get("number");
        long period = (long) a3.get("period");
        JSONArray effects = (JSONArray) a3.get("Effects");
        JSONArray effectvalues = (JSONArray) a3.get("EffectsValues");
        
		JSONParser parser4 = new JSONParser();

    	Object obj4 = parser4.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
    	JSONObject jsonObject4 = (JSONObject) obj4;
        JSONObject a4 = (JSONObject) jsonObject4.get("8");
        long number1 = (long) a4.get("number");
        long period1 = (long) a4.get("period");

        
		JSONParser parser5 = new JSONParser();

    	Object obj5 = parser5.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
    	JSONObject jsonObject5 = (JSONObject) obj5;
        JSONObject a5 = (JSONObject) jsonObject5.get("15");
        long number2 = (long) a5.get("number");
        long period2 = (long) a5.get("period");
		
		
		
		
		
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		
		List<Excommunications> ec = new ArrayList<>();
		Excommunications e = new Excommunications(a3);
		ec.add(e);
		Excommunications e1 = new Excommunications(a4);
		ec.add(e1);
		Excommunications e2 = new Excommunications(a5);
		ec.add(e2);
		tester.setExcommCells(ec);
		
		long risid = tester.getExcommCells().get(0).getID();
		long risperiod = tester.getExcommCells().get(0).getPeriod();
		long risid1 = tester.getExcommCells().get(1).getID();
		long risperiod1 = tester.getExcommCells().get(1).getPeriod();
		long risid2 = tester.getExcommCells().get(2).getID();
		long risperiod2 = tester.getExcommCells().get(2).getPeriod();
		
		assertEquals(number, risid);
		assertEquals(period, risperiod);
		assertEquals(number1, risid1);
		assertEquals(period1, risperiod1);
		assertEquals(number2, risid2);
		assertEquals(period2, risperiod2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#getNplayer()}.
	 */
	@Test
	public void testGetNplayer() {
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		int nplayer = 3;
		tester.setNplayer(nplayer );
		int ris = tester.getNplayer();
		
		assertEquals(nplayer, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.board.Board#setNplayer(int)}.
	 */
	@Test
	public void testSetNplayer() {

		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		int nplayer = 1;
		tester.setNplayer(nplayer );
		int ris = tester.getNplayer();
		
		assertEquals(nplayer, ris);

	}
	
	@Test
	public void testRefreshBoard() {

		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		tester.refreshBoard();

	}
	
	@Test
	public void testGetActionValueProd() {

		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		Dice dice = new Dice(4);
		FMember fam = new FMember(dice , 0);
		fam.setValue(5);
		int chosenCell = 0;
		tester.getActionValueProd(fam , chosenCell );
		
		assertEquals(fam.getValue(), tester.getActionValueProd(fam , chosenCell ));
		
		chosenCell=1;
		tester.getActionValueProd(fam , chosenCell );
		int ris = tester.getActionValueProd(fam , chosenCell );
		assertEquals(fam.getValue()-3, ris);

	}
	
	
	@Test
	public void testGetActionValueHarv() {

		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		Dice dice = new Dice(4);
		FMember fam = new FMember(dice , 0);
		fam.setValue(5);
		int chosenCell = 0;
		tester.getActionValueHarv(fam , chosenCell );
		
		assertEquals(fam.getValue(), tester.getActionValueHarv(fam , chosenCell ));
		
		chosenCell=1;
		tester.getActionValueHarv(fam , chosenCell );
		int ris = tester.getActionValueHarv(fam , chosenCell );
		assertEquals(fam.getValue()-3, ris);

	}
	
	@Test
	public void testInsertFMHarv() {

		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		game.setCurrentPlayer(turnplayer );
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		List<HarvCell> harvCells = new ArrayList<>();
		HarvCell harvCellNoMalus = new HarvCell(2);
		harvCells.add(harvCellNoMalus);
		tester.setHarvestCells(harvCells );
		Dice dice = new Dice(3);
		FMember fam = new FMember(dice , 0);
		
		int chosenCell = 0;
		
		tester.setHarvCellNoMalus(harvCellNoMalus );
		tester.insertFMHarv(fam, chosenCell, game);

	}
	
	@Test
	public void testInsertFMProd() {

		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		game.setCurrentPlayer(turnplayer );
		MainController mcontroller = new MainController();
		Board tester = new Board(mcontroller, 4, new MainView(mcontroller));
		List<ProdCell> productionCells = new ArrayList<>();
		ProdCell prodCellNoMalus = new ProdCell(2);
		productionCells.add(prodCellNoMalus);
		tester.setProductionCells(productionCells );
		Dice dice = new Dice(3);
		FMember fam = new FMember(dice , 0);
		
		int chosenCell = 0;
		
		tester.setProdCellNoMalus(prodCellNoMalus );
		tester.insertFMProd(fam, chosenCell, game);

	}

}
