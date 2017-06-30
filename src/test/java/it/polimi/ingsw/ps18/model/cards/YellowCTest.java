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

import it.polimi.ingsw.ps18.model.effect.generalEffects.TakeOneCard;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinPC;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class YellowCTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.YellowC#hasHarvest()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasHarvest() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("10");

		
		YellowC tester = new YellowC(a);
		
		assertTrue(!(tester.hasHarvest()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.YellowC#hasProduction()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasProduction() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("10");

		
		YellowC tester = new YellowC(a);
		
		assertTrue(!(tester.hasProduction()));
		
		JSONParser parser2 = new JSONParser();
		
    	Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("5");

		
		YellowC tester2 = new YellowC(a2);
		
		assertTrue(tester2.hasProduction());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.YellowC#hasFinal()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasFinal() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("10");

		
		YellowC tester = new YellowC(a);
		
		assertTrue(!(tester.hasFinal()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.YellowC#hasPermanent()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasPermanent() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("10");

		
		YellowC tester = new YellowC(a);
		
		assertTrue(!(tester.hasFinal()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.YellowC#YellowC(org.json.simple.JSONObject)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testYellowCJSONObject() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("10");

		
		YellowC tester = new YellowC(a);
		
		assertEquals("YellowProva2", tester.getName());
		assertEquals(5, tester.getProductionValue());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.YellowC#YellowC()}.
	 */
	@Test
	public void testYellowC() {
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.YellowC#getProductionValue()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetProductionValue() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("10");
        long pval = (long) a.get("ProductionValue");

		
		YellowC tester = new YellowC(a);
		long ris = tester.getProductionValue();
		assertEquals(pval, ris );
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.YellowC#setProductionValue(int)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetProductionValue() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("10");
        long pval = (long) a.get("ProductionValue");

		
		YellowC tester = new YellowC(a);
		int value = 94;
		tester.setProductionValue(value);
		long ris = tester.getProductionValue();
		assertEquals(value, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.YellowC#getProdEffect()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetProdEffect() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
        
		JSONParser parser2 = new JSONParser();
		
    	Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("10");
        YellowC tester2 = new YellowC(a2);
        
        JSONParser parser3 = new JSONParser();
		
    	Object obj3 = parser3.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject3 = (JSONObject) obj3;
        JSONObject a3 = (JSONObject) jsonObject3.get("11");
        YellowC tester3 = new YellowC(a3);
		
		YellowC tester = new YellowC(a);
		List<ProductionEffect> ris = tester.getProdEffect();
		PBoard player = new PBoard();
		List<Cards> cards = new ArrayList<>();
		cards.add(tester2);
		cards.add(tester3);
		player.setCards(cards);
		int coin=23;
		Stats resources = new Stats(0,0,coin,0,0,0,0);
		player.setResources(resources);
		ris.get(0).activate(player, new GameLogic());
		int coinfinal = player.getResources().getCoin();
		
		assertEquals(coin+2, coinfinal);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.YellowC#setProdEffect(java.util.List)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetProdEffect() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
        
        YellowC tester = new YellowC(a);
        List<ProductionEffect> pe = new ArrayList<>();
        ProductionEffect e = new addCoins();
        e.setQuantity(35);
		pe.add(e );
		tester.setProdEffect(pe );
		PBoard player= new PBoard();
		Stats resources = new Stats(8,8,8,8,8,8,8);
		player.setResources(resources);
		e.activate(player, new GameLogic());
		Stats asd = player.getResources();
		int ris = asd.getCoin();
		
		assertEquals(35+8, ris);
		
	}

}
