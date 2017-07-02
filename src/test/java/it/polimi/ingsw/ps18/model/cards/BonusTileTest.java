/**
 * 
 */
package it.polimi.ingsw.ps18.model.cards;

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

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addVP;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnAction;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class BonusTileTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#hasHarvest()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasHarvest() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");

		
		BonusTile tester = new BonusTile(a);
		
		assertTrue(tester.hasHarvest());
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("5");

		
		BonusTile tester2 = new BonusTile(a2);
		
		assertTrue(!(tester2.hasHarvest()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#hasProduction()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasProduction() throws FileNotFoundException, IOException, ParseException {
JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");

		
		BonusTile tester = new BonusTile(a);
		
		assertTrue(tester.hasProduction());
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("5");

		
		BonusTile tester2 = new BonusTile(a2);
		
		assertTrue(!(tester2.hasProduction()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#hasFinal()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasFinal() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");

		
		BonusTile tester = new BonusTile(a);
		
		assertTrue(!(tester.hasFinal()));
		

	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#hasPermanent()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasPermanent() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");

		
		BonusTile tester = new BonusTile(a);
		
		assertTrue(!(tester.hasPermanent()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#BonusTile(org.json.simple.JSONObject)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testBonusTile() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");	    
		
		BonusTile tester = new BonusTile(a);
		
		assertEquals ("BonusTile00", tester.getName());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#getHarvValue()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetHarvValue() throws FileNotFoundException, IOException, ParseException {

		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");
	    long harvalue = (long) a.get("HarvValue");
		
		BonusTile tester = new BonusTile(a);
		long ris = tester.getHarvValue();
		
		assertEquals(harvalue, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#setHarvValue(long)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetHarvValue() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");
	    long harvalue = (long) a.get("HarvValue");
		
		BonusTile tester = new BonusTile(a);
		tester.setHarvValue(56);
		long ris = tester.getHarvValue();
		
		assertEquals(56, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#getHarveffect()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetHarveffect() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");
	    long harvalue = (long) a.get("HarvValue");
		
		BonusTile tester = new BonusTile(a);
		
		List<HarvestEffect> he = tester.getHarveffect();
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources );
		he.get(0).activate(player, new GameLogic());
		he.get(1).activate(player, new GameLogic());
		he.get(2).activate(player, new GameLogic());
		
		int wood = player.getResources().getWood();
		int stone = player.getResources().getRock();
		int servant = player.getResources().getServants();
		
		assertEquals(1, wood);
		assertEquals(1, stone);
		assertEquals(1, servant);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#setHarveffect(java.util.List)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetHarveffect() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");
	    long harvalue = (long) a.get("HarvValue");
		
		BonusTile tester = new BonusTile(a);
		List<HarvestEffect> harveffect = new ArrayList<>();
		HarvestEffect e = new addCoins();
		e.setQuantity(56);
		harveffect.add(e );
		tester.setHarveffect(harveffect );
		
		List<HarvestEffect> he = tester.getHarveffect();
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources );
		he.get(0).activate(player, new GameLogic());
		
		int coin = player.getResources().getCoin();
		
		assertEquals(56, coin);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#getProductionValue()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetProductionValue() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");
	    long prodvalue = (long) a.get("ProductionValue");
		
		BonusTile tester = new BonusTile(a);
		long ris = tester.getHarvValue();
		
		assertEquals(prodvalue, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#setProductionValue(long)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetProductionValue() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");
	    long prodvalue = (long) a.get("ProductionValue");
		
		BonusTile tester = new BonusTile(a);
		tester.setProductionValue(12);
		long ris = tester.getProductionValue();
		
		assertEquals(12, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#getProdEffect()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetProdEffect() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");
		
		BonusTile tester = new BonusTile(a);
		
		List<ProductionEffect> pe = tester.getProdEffect();
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources );
		pe.get(0).activate(player, new GameLogic());
		pe.get(1).activate(player, new GameLogic());
		
		int coin = player.getResources().getCoin();
		int pm = player.getResources().getMP();
		
		assertEquals(2, coin);
		assertEquals(1, pm);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#setProdEffect(java.util.List)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetProdEffect() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("0");
		
		BonusTile tester = new BonusTile(a);
		List<ProductionEffect> prodeffect = new ArrayList<>();
		ProductionEffect e = new addCoins();
		e.setQuantity(94);
		prodeffect.add(e );
		tester.setProdEffect(prodeffect);
		
		List<ProductionEffect> pe = tester.getProdEffect();
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources );
		pe.get(0).activate(player, new GameLogic());
		
		int coin = player.getResources().getCoin();
		
		assertEquals(94, coin);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#getPermeffect()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetPermeffect() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("6");
	    JSONArray name = (JSONArray) a.get("PermanentEffect");
	    JSONArray value = (JSONArray) a.get("PermanentEffectValue");
		
		BonusTile tester = new BonusTile(a);
		
		List<Permanenteffect> pe = tester.getPermeffect();
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources );
		Permanenteffect ris = pe.get(0);

		String effect = ris.toString();
		
		assertEquals("You can't receive anymore the Bonus from the\n\t1 floor of any Tower.", effect);

	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#setPermeffect(java.util.List)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetPermeffect() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("6");
	    JSONArray name = (JSONArray) a.get("PermanentEffect");
	    JSONArray value = (JSONArray) a.get("PermanentEffectValue");
		
		BonusTile tester = new BonusTile(a);
		
		List<Permanenteffect> q = new ArrayList<>();
		Permanenteffect e = new IncreaseFMValueOnAction();
		JSONArray discount = new JSONArray();
		for(int i=0; i<7; i++){
			long prova = 0;
			discount.add(prova);
		}
		((IncreaseFMValueOnAction) e).setParam("Green", 2, discount);
		q.add(e );
		tester.setPermeffect(q );
		
		List<Permanenteffect> pe = tester.getPermeffect();
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources );
		Permanenteffect ris = pe.get(0);

		String effect = ris.toString();
		
		assertEquals("Incrase Permanently the Action Value by 2\n\t   when you take a card from the Green Tower", effect);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#getFineffect()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetFineffect() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("6");
		
		BonusTile tester = new BonusTile(a);
		List<FinalEffect> fine = tester.getFineffect();
		PBoard player= new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources );
		
		fine.get(0).activate(player, new GameLogic());
		int ris = player.getResources().getVP();
		
		
		assertEquals(1, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BonusTile#setFineffect(java.util.List)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetFineffect() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("6");
		
		BonusTile tester = new BonusTile(a);
		List<FinalEffect> fineffect = new ArrayList<>();
		FinalEffect e = new addVP();
		e.setQuantity(56);
		fineffect.add(e );
		tester.setFineffect(fineffect );
		
		List<FinalEffect> fine = tester.getFineffect();
		PBoard player= new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources );
		
		fine.get(0).activate(player, new GameLogic());
		int ris = player.getResources().getVP();
		
		
		assertEquals(56, ris);
	}

}
