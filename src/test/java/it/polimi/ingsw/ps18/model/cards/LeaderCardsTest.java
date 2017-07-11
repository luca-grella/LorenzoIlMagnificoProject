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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.AddResources;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.LCQuickEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.LCRequirement;

/**
 * The Class LeaderCardsTest.
 *
 * @author luca-grella
 */
public class LeaderCardsTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#toString(int)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testToStringInt() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		
		String ris = tester.toString(1);
		
		assertEquals("Card number 1:\n\tname: ProvaTest\n\tRequirements for activation:\n\t\t0: 4 Purple cards.\n\t\t1: 2 Yellow cards.\n\tQuick Effects:\n\t\t0: Trigger an Harvest Action with a Value of 1\n\tPermanent Effects:\n\t\t0: Every time you take a card from a tower, discount its cost by:\n-----------------\nCoin: 3\n-----------------\n\n",ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#toString()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testToString() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		
		String ris = tester.toString();
		
		assertEquals("name: ProvaTest\n\tRequirements for activation:\n\t\t0: 4 Purple cards.\n\t\t1: 2 Yellow cards.\n\tQuick Effects:\n\t\t0: Trigger an Harvest Action with a Value of 1\n\tPermanent Effects:\n\t\t0: Every time you take a card from a tower, discount its cost by:\n-----------------\nCoin: 3\n-----------------\n\n",ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#hasLCQE()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHasLCQE() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		
		assertTrue(tester.hasLCQE());
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("20");
		
		LeaderCards tester2 = new LeaderCards(a2);
		
		assertTrue(!(tester2.hasLCQE()));
		
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#hasLCPE()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHasLCPE() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		
		assertTrue(tester.hasLCPE());
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("1");
		
		LeaderCards tester2 = new LeaderCards(a2);
		
		assertTrue(!(tester2.hasLCPE()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#isActive()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testIsActive() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		
		assertTrue(!tester.isActive());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#getRequirements()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetRequirements() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		List<LCRequirement> ris = tester.getRequirements();
		LCRequirement ciao = ris.get(0);
		String ciao2 = ciao.toString();
		assertEquals("4 Purple cards.",ciao2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#getQuickEffects()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetQuickEffects() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		List<LCQuickEffect> quickEffects = new ArrayList<>();
		LCQuickEffect e = new AddResources();
		quickEffects.add(e );
		tester.setQuickEffects(quickEffects );
		
		assertEquals(quickEffects, tester.getQuickEffects());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#getPermEffects()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetPermEffects() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		
		assertNotNull(tester.getPermEffects());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#isEffectactivated()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testIsEffectactivated() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		
		boolean effectactivated = true;
		tester.setEffectactivated(effectactivated );
		
		assertTrue(tester.isEffectactivated());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#setEffectactivated(boolean)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetEffectactivated() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		
		boolean effectactivated = true;
		tester.setEffectactivated(effectactivated );
		
		assertTrue(tester.isEffectactivated());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.LeaderCards#setQuickEffects(java.util.List)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetQuickEffects() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		LeaderCards tester = new LeaderCards(a);
		List<LCQuickEffect> quickEffects = new ArrayList<>();
		LCQuickEffect e = new AddResources();
		quickEffects.add(e );
		tester.setQuickEffects(quickEffects );
		
		assertEquals(quickEffects, tester.getQuickEffects());
	}

}
