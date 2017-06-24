/**
 * 
 */
package it.polimi.ingsw.ps18.model.personalboard;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.cards.PurpleC;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

// TODO: Auto-generated Javadoc
/**
 * The Class PBoardTest.
 *
 * @author luca-grella
 */
public class PBoardTest {

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

	List<Cards> cards = new ArrayList<>();
	int ris = cards.size();
	Cards card = new GreenC(1);
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
//	@Test
//	public void testGetpBoardView() {
//    PBoard tester = new PBoard();
//    PBoardView ciao = new PBoardView(null);
//    
//    PBoardView ris = tester.getpBoardView();
//     
//    
//    DA RIVEDERE
//    
//	}

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
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#getCards()}.
	 */
//	@Test
//	public void testGetCards() {
//		
//		PBoard tester = new PBoard();
//		List<Cards> cards = new ArrayList<>();
//		Cards cgreen = new GreenC(1);
//		Cards cblue = new BlueC(2);
//		Cards cyellow = new YellowC(3);
//		Cards cpurple = new PurpleC(4);
//		long cgreenid = cgreen.getID();
//		long cblueid = cblue.getID();
//		long cyellowid = cyellow.getID();
//		long cpurpleid = cpurple.getID();
//		cards.set(1, cgreen);
//		cards.set(2, cblue);
//		cards.set(3, cyellow);
//		cards.set(4, cpurple);
//		tester.setCards(cards);
//		List<Cards> ris = tester.getCards();
//		long ris1 = ris.get(1).getID();
//		long ris2 = ris.get(2).getID();
//		long ris3 = ris.get(3).getID();
//		long ris4 = ris.get(4).getID();
//		
//		
//		assertEquals(cgreenid, ris1);
//		assertEquals(cblueid, ris2);
//		assertEquals(cyellowid, ris3);
//		assertEquals(cpurpleid, ris4);
//		
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#setCards(java.util.List)}.
	 */
//	@Test
//	public void testSetCards() {
//		PBoard tester = new PBoard();
//		List<Cards> cards = new ArrayList<>();
//		Cards cgreen = new GreenC(1);
//		Cards cblue = new BlueC(2);
//		Cards cyellow = new YellowC(3);
//		Cards cpurple = new PurpleC(4);
//		long cgreenid = cgreen.getID();
//		long cblueid = cblue.getID();
//		long cyellowid = cyellow.getID();
//		long cpurpleid = cpurple.getID();
//		cards.set(1, cgreen);
//		cards.set(2, cblue);
//		cards.set(3, cyellow);
//		cards.set(4, cpurple);
//		tester.setCards(cards);
//		List<Cards> ris = tester.getCards();
//		long ris1 = ris.get(1).getID();
//		long ris2 = ris.get(2).getID();
//		long ris3 = ris.get(3).getID();
//		long ris4 = ris.get(4).getID();
//		
//		
//		assertEquals(cgreenid, ris1);
//		assertEquals(cblueid, ris2);
//		assertEquals(cyellowid, ris3);
//		assertEquals(cpurpleid, ris4);
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#getFams()}.
	 */
//	@Test
//	public void testGetFams() {
//
//		PBoard tester = new PBoard();
//		List<FMember> fams = new ArrayList<>();
//		FMember fam1 = new FMember(1, 1);
//		FMember fam2 = new FMember(2, 2);
//		FMember fam3 = new FMember(3, 3);
//		int fam1r = fam1.getPlayercol();
//		int fam2r = fam2.getPlayercol();
//		int fam3r = fam3.getPlayercol();
//		fams.add(fam1);
//		fams.add(fam2);
//		fams.add(fam3);
//		tester.setFams(fams);
//		List<FMember> ris = tester.getFams();
//		int ris1 = ris.get(1).getPlayercol();
//		int ris2 = ris.get(2).getPlayercol();
//		int ris3 = ris.get(3).getPlayercol();
//		
//		assertEquals(fam1r, ris1);
//		assertEquals(fam2r, ris2);
//		assertEquals(fam3r, ris3);
//		
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.PBoard#setFams(java.util.List)}.
	 */
//	@Test
//	public void testSetFams() {
//
//		PBoard tester = new PBoard();
//		List<FMember> fams = new ArrayList<>();
//		FMember fam1 = new FMember(1, 1);
//		FMember fam2 = new FMember(2, 2);
//		FMember fam3 = new FMember(3, 3);
//		int fam1r = fam1.getPlayercol();
//		int fam2r = fam2.getPlayercol();
//		int fam3r = fam3.getPlayercol();
//		fams.add(fam1);
//		fams.add(fam2);
//		fams.add(fam3);
//		tester.setFams(fams);
//		List<FMember> ris = tester.getFams();
//		int ris1 = ris.get(1).getPlayercol();
//		int ris2 = ris.get(2).getPlayercol();
//		int ris3 = ris.get(3).getPlayercol();
//		
//		assertEquals(fam1r, ris1);
//		assertEquals(fam2r, ris2);
//		assertEquals(fam3r, ris3);
//		
//	}

}
