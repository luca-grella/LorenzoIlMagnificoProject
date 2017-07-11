/**
 * 
 */
package it.polimi.ingsw.ps18.model.personalboard;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class PBoardTest.
 *
 * @author luca-grella
 */
public class PBoardTest {

	/** The Constant bonustiles. */
	private static final List<Cards> bonustiles = null;

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#PBoard(int, java.util.List, it.polimi.ingsw.ps18.controller.MainController)}.
	 */
	@Test
	public void testPBoardIntListOfDiceMainController() {
		int playercol = 2;
		List<Dice> dices = new ArrayList<>();
		Dice dice = null;
		PBoard tester = new PBoard(playercol, dices);
		int ris = tester.getPlayercol();
		if(playercol!=ris){
			fail("errore in PBoard (playercol)");
			}


			
		}
	

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#PBoard(int, java.util.List)}.
	 */
	@Test
	public void testPBoardIntListOfDice() {

		int playercol = 2;
		List<Dice> dices = new ArrayList<>();
		Dice dice = null;
		PBoard tester = new PBoard(playercol, dices);
		int ris = tester.getPlayercol();
		if(playercol!=ris){
			fail("errore in PBoard (playercol)");
			}

		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#PBoard()}.
	 */
	@Test
	public void testPBoard() {
		int playercol = 0;
		Stats resources = null;
		List<Cards> cards = null;
		List<FMember> fams = null;

		
		PBoard tester = new PBoard();

		tester.setPlayercol(playercol);
		tester.setResources(resources);
		tester.setCards(cards);
		tester.setFams(fams);

		int ris = tester.getPlayercol();
		Stats ris2 = tester.getResources();
		List<Cards> ris3 = tester.getCards();
		List<FMember> ris4 = tester.getFams();
		
		assertEquals(playercol, ris);
		assertEquals(resources, ris2);
		assertEquals(cards, ris3);
		assertEquals(fams, ris4);

	}


	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#addCard(it.polimi.ingsw.ps18.model.cards.Cards, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAddCard() {
		JSONParser parser = new JSONParser();	
		try {
	    	Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/GreenC.json"));
	    	JSONObject jsonObject = (JSONObject) obj;
	    	JSONObject a = (JSONObject) jsonObject.get("1");
	    	
	    	
	    	List<Cards> cards = new ArrayList<>();
	    	int ris = cards.size();
	    	Cards card = new GreenC(a);
	    	cards.add(card);
	    	int ris2 = cards.size();
	    	GameLogic game= new GameLogic();
	    	int nplayer=1;
	    	game.setNplayer(nplayer);
	    	Action ongoingAction = null;
	    	game.setOngoingAction(ongoingAction);
	    	GeneralEffect ongoingEffect = null;
	    	game.setOngoingEffect(ongoingEffect);
	    	PBoard player= new PBoard();
	    	Stats resources= new Stats(0, 0, 0, 0, 0, 0, 0);
	    	player.setResources(resources);
	    	Stats ris8 = player.getResources();
	    	int ris9 = ris8.getCoin();
	    	cards.get(0).activateQEffects(player, null);
	    	Stats ris3 = player.getResources();
	    	int ris4 = ris3.getCoin();
	    	assertEquals(ris+1, ris2);
	    	assertEquals(ris9, ris4);
	    	
	    	
		}catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}

	}


	
	
	
	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#hasSpace(int)}.
	 */
	@Test
	public void testHasSpace() {
		PBoard tester = new PBoard();
		List<Cards> cards = new ArrayList<>();
		tester.setCards(cards);
		boolean space = tester.hasSpace(5);
		assertTrue(space);
		boolean space2 = tester.hasSpace(199);
		assertTrue(space2);
		boolean space3 = tester.hasSpace(228);
		assertTrue(space3);
		boolean space4 = tester.hasSpace(32);
		assertTrue(space4);
	
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#vPCalc()}.
	 */
	@Test
	public void testVPCalc() {
		PBoard tester = new PBoard();
		int playercol = -154;
		tester.setPlayercol(playercol);
		int ris = tester.vPCalc();
		
		assertEquals(playercol, ris);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#getpBoardView()}.
	 */
	@Test
	public void testGetpBoardView() {
		
    PBoard tester = new PBoard();
    PBoardView pb = new PBoardView(new MainController());
	tester.setpBoardView(pb);
    PBoardView ris = tester.getpBoardView();
    Class<? extends PBoardView> a = ris.getClass();
    String f = a.getName();
    PBoardView pb1 = new PBoardView(new MainController());
	tester.setpBoardView(pb1);
    PBoardView ris2 = tester.getpBoardView();
    Class<? extends PBoardView> b = ris2.getClass();
    String g = b.getName();
    
    assertEquals(f,g);
    
    
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#getPlayercol()}.
	 */
	@Test
	public void testGetPlayercol() {
	
		PBoard tester = new PBoard();
		int test=-4;
		tester.setPlayercol(test);
		int ris = tester.getPlayercol();
		
		assertEquals(test, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#setPlayercol(int)}.
	 */
	@Test
	public void testSetPlayercol() {
	
		PBoard tester = new PBoard();
		int test=-29;
		tester.setPlayercol(test);
		int ris = tester.getPlayercol();
		
		assertEquals(test, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#getResources()}.
	 */
	@Test
	public void testGetResources() {
    
		PBoard tester = new PBoard();
		Stats resources = new Stats(-3,2,7,-8,-3,5,6);
		tester.setResources(resources);
		Stats ris = tester.getResources();
		int wood = ris.getWood();
		int rock = ris.getRock();
		int coin = ris.getCoin();
		int servant = ris.getServants();
		int fp = ris.getFP();
		int mp = ris.getMP();
		int vp = ris.getVP();
		
		assertEquals(-3, wood);
		assertEquals(2, rock);
		assertEquals(7, coin);
		assertEquals(-8, servant);
		assertEquals(-3, fp);
		assertEquals(5, mp);
		assertEquals(6, vp);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#setResources(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testSetResources() {

		PBoard tester = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		resources.addWood(-3);
		resources.addRock(-3);
		resources.addCoins(-3);
		resources.addServants(-3);
		resources.addFP(-3);
		resources.addMP(-3);
		resources.addVP(-3);
		tester.setResources(resources);
		Stats ris = tester.getResources();
		int wood = ris.getWood();
		int rock = ris.getRock();
		int coin = ris.getCoin();
		int servant = ris.getServants();
		int fp = ris.getFP();
		int mp = ris.getMP();
		int vp = ris.getVP();
		
		assertEquals(-3, wood);
		assertEquals(-3, rock);
		assertEquals(-3, coin);
		assertEquals(-3, servant);
		assertEquals(-3, fp);
		assertEquals(-3, mp);
		assertEquals(-3, vp);
	
		
	}

	/**
	 * Test P board int.
	 */
	@Test
	public void testPBoardInt() {
		PBoard tester = new PBoard(1,(ClientInterface) null);
		tester.setPlayercol(2);
		
		assertEquals(2, tester.getPlayercol());
			}
	
	/**
	 * Test choose bonus tile.
	 */
	@Test
	public void testChooseBonusTile() {
		PBoard tester = new PBoard();
		tester.ChooseBonusTile();
		
		
			}
	
	/**
	 * Test refresh F members.
	 */
	@Test
	public void testRefreshFMembers() {
		PBoard tester = new PBoard();
		tester.setPlayercol(3);
		List<FMember> fams = new ArrayList<>();
		Dice e = new Dice(3);
		FMember fm = new FMember(e, 1);
		fams.add(fm);
		tester.setFams(fams );
		List<Dice> dices = new ArrayList<>();
		
		dices.add(e );
		tester.refreshFMembers(dices );
		
		
			}
	
	/**
	 * Test compare.
	 */
	@Test
	public void testCompare() {
		PBoard tester = new PBoard();
		Stats resources = new Stats(10,10,10,10,10,10,10);
		tester.setResources(resources );
		
		PBoard player = new PBoard();
		player.setResources(resources);
		tester.compareTo(player );
		
		assertEquals(0, tester.compareTo(player));
		
			}
	
	/**
	 * Test compare 2.
	 */
	@Test
	public void testCompare2() {
		PBoard tester = new PBoard();
		PBoard tester2 = new PBoard();
		Stats res = new Stats(1,1,1,1,1,1,1);
		Stats res2 = new Stats(2,2,2,2,2,2,2);
		tester.setResources(res );
		tester2.setResources(res2 );
		List<PBoard> players = new ArrayList<>();
		players.add(tester);
		players.add(tester2);
		Collections.sort(players , PBoard.victoryComparator);
		
			}
	
	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		PBoard tester = new PBoard();
		
		Object obj = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		((PBoard) obj).setResources(resources );
		tester.setResources(resources);
		tester.equals(obj );
		
		assertTrue(tester.equals(obj));
		
		PBoard tester2 = new PBoard();
		
		Object obj2 = new Dice(0);
		
		tester2.equals(obj2 );
		
		assertTrue(!(tester2.equals(obj2)));
		
			}
	
	/**
	 * Test continue take leader.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testContinueTakeLeader() throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("21");
		
		PBoard tester = new PBoard();
		List<LeaderCards> leadercards = new ArrayList<>();
		LeaderCards e = new LeaderCards(a);
		leadercards.add(e );
		tester.setTempLC(leadercards);
		tester.setLeaderCards(leadercards );
		tester.continuetakeLeader(0);
		
		
	}
	
	
	/**
	 * Test act harvest.
	 */
	@Test
	public void testActHarvest() {
		PBoard tester = new PBoard();
		tester.actHarvest();
		
		
			}
	
	/**
	 * Test act production.
	 */
	@Test
	public void testActProduction() {
		PBoard tester = new PBoard();
		tester.actProduction();
		
		
			}
	
	/**
	 * Test add cards.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testAddCards() throws FileNotFoundException, IOException, ParseException {
		PBoard tester = new PBoard();
		List<Cards> cards = new ArrayList<>();
		tester.setCards(cards );
		
		JSONParser parser = new JSONParser();	
		
	    Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
	    JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("13");
		
		GreenC card = new GreenC(a);
		GameLogic game = new GameLogic();
		tester.addCard(card, game );
		
		
			}
	
	/**
	 * Test take leader.
	 */
	@Test
	public void testTakeLeader() {
		PBoard tester = new PBoard();
		List<LeaderCards> leaders = new ArrayList<>();
		tester.takeLeader(leaders );
		
		
			}
	
	/**
	 * Test activate leader.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testActivateLeader() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();	
		
	    Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/leadercardstest.json"));
	    JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("1");
		
		
		PBoard tester = new PBoard();
		List<LeaderCards> cards = new ArrayList<>();
		LeaderCards e = new LeaderCards(a);
		cards.add(e );
		tester.setLeaderCards(cards );
		tester.setTester(999);
		tester.activateLeader(new GameLogic());
		
		
			}
	
	/**
	 * Test copy LC.
	 */
	@Test
	public void testCopyLC() {
		PBoard tester = new PBoard();
		tester.setPlayercol(0);
		GameLogic game = new GameLogic();
		LinkedList<PBoard> players = new LinkedList<>();
		PBoard e = new PBoard();
		e.setPlayercol(1);
		players.add(e );
		game.setPlayers(players );
//		tester.copyLC(game);
		
		
			}
	
	/**
	 * Test discard LC.
	 */
	@Test
	public void testDiscardLC() {
		PBoard tester = new PBoard();
		tester.discardLC();
		
		
			}
	
	/**
	 * Test activate LCQE.
	 */
	@Test
	public void testActivateLCQE() {
		PBoard tester = new PBoard();
		tester.activateLCQE(new GameLogic());
		
		
			}
	
	/**
	 * Test generate excomm malus.
	 */
	@Test
	public void testGenerateExcommMalus() {
		PBoard tester = new PBoard();
		tester.generateExcommMalus();
		
		
			}
	
	/**
	 * Test to string fams.
	 */
	@Test
	public void testToStringFams() {
		PBoard tester = new PBoard();
		List<FMember> fams = new ArrayList<>();
		Dice dice = new Dice(2);
		FMember e = new FMember(dice , 0);
		fams.add(e );
		tester.setFams(fams );
		tester.toStringFams();
		
	}
			

	
	
	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#getCards()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetCards() throws FileNotFoundException, IOException, ParseException {
		
		PBoard tester = new PBoard();
		List<Cards> cards = new ArrayList<>();
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a2 = (JSONObject) jsonObject.get("0");
        String name = (String) a2.get("name");
        long number = (long) a2.get("number");
        long color = (long) a2.get("color");
        long period = (long) a2.get("period");
        long harvalue = (long) a2.get("HarvestValue");
		

		
		
		Cards cgreen = new GreenC(a2);

		long cgreenid = cgreen.getID();

		cards.add(cgreen);

		tester.setCards(cards);
		List<Cards> ris = tester.getCards();
		long ris1 = ris.get(0).getID();

		
		
		assertEquals(cgreenid, ris1);

		
	}
	
	/**
	 * Test complete P board setup.
	 */
	@Test
	public void testCompletePBoardSetup() {
		
		PBoard tester = new PBoard();
		List<FMember> fams = new ArrayList<>();
		tester.setFams(fams );
		tester.setPlayercol(0);
		Stats resources = new Stats(0,0,0,0,0,0,0);
		tester.setResources(resources );
		List<Dice> dices = new ArrayList<>();
		Dice a = new Dice(3);
		dices.add(a);
		Dice b = new Dice(5);
		dices.add(b);
		Dice c = new Dice(2);
		dices.add(c);
		MainController mcontroller = new MainController();
//		tester.completePBoardSetup(dices, mcontroller, bonustiles);

	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#setCards(java.util.List)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetCards() throws FileNotFoundException, IOException, ParseException {
		
		PBoard tester = new PBoard();
		List<Cards> cards = new ArrayList<>();
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a2 = (JSONObject) jsonObject.get("0");
        String name = (String) a2.get("name");
        long number = (long) a2.get("number");
        long color = (long) a2.get("color");
        long period = (long) a2.get("period");
        long harvalue = (long) a2.get("HarvestValue");
		

		
		
		Cards cgreen = new GreenC(a2);

		long cgreenid = cgreen.getID();

		cards.add(cgreen);

		tester.setCards(cards);
		List<Cards> ris = tester.getCards();
		long ris1 = ris.get(0).getID();

		
		
		assertEquals(cgreenid, ris1);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#getFams()}.
	 */
	@Test
	public void testGetFams() {

		PBoard tester = new PBoard();
		List<FMember> fams= new ArrayList<>();
		Dice dice = new Dice(4);
		FMember e = new FMember(dice , 1);
		fams.add(e);
		int ris = fams.get(0).getPlayercol();
		tester.setFams(fams);
		int ris2 = tester.getFams().get(0).getPlayercol();
		
		assertEquals(ris, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#setFams(java.util.List)}.
	 */
	@Test
	public void testSetFams() {

		PBoard tester = new PBoard();
		List<FMember> fams= new ArrayList<>();
		Dice dice = new Dice(4);
		FMember e = new FMember(dice , 1);
		fams.add(e);
		int ris = fams.get(0).getPlayercol();
		tester.setFams(fams);
		int ris2 = tester.getFams().get(0).getPlayercol();
		
		assertEquals(ris, ris2);
		
	}
	
	/**
	 * Test to string cards.
	 */
	@Test
	public void testToStringCards() {

		PBoard tester = new PBoard();
		List<Cards> cards = new ArrayList<>();
		tester.setCards(cards );
		String ris = tester.toStringCards();
		assertEquals("Cards of player 0:\n-----------------\nBonus Tiles:\n\n-----------------\nGreen Cards:\n\n-----------------\nBlue Cards:\n\n-----------------\nYellow Cards:\n\n-----------------\nPurple Cards:\n\n-----------------\nExcommunication Cards:\n\n-----------------\nActive Leader Cards:\n\n-----------------\n", ris);
	}
	
	/**
	 * Test to string resources.
	 */
	@Test
	public void testToStringResources() {

		PBoard tester = new PBoard();
		List<FMember> fams = new ArrayList<>();
		tester.setFams(fams );
		tester.setPlayercol(2);
		tester.setResources(new Stats(1,2,3,4,5,6,7));
		String ris1 = tester.toStringResources();
		
		assertEquals("Resources of player 2\n-----------------\nWood: 1\nRock: 2\nCoin: 3\nServant: 4\nFP: 5\nMP: 6\nVP: 7\n-----------------\n", ris1);
		
	}

}
