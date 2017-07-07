/**
 * 
 */
package it.polimi.ingsw.ps18.model.gamelogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.effect.generalEffects.WoodorRockEffects;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addWood;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addWoodorRock;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.ChoiceLeaderEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.TowerDiscount;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.AddResources;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.MainView;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class GameLogicTest {

	@Test
	public void test() {
		LinkedList<PBoard> player = new LinkedList<>();
		PBoard turnplayer = new PBoard();
		List<FMember> fams = new ArrayList<>();
		Dice dice = new Dice(3);
		FMember s = new FMember(dice , 0);
		fams.add(s );
		turnplayer.setFams(fams );
		turnplayer.setPlayercol(0);
		player.add(turnplayer);
		MainController mc = new MainController();
		GameLogic tester = new GameLogic(2,mc,player );
		tester.toString();
		tester.getAGE();
		tester.getBoard();
		tester.getBonusTiles();
		tester.getExcommcards();
		tester.getNplayer();
		tester.getOngoingAction();
		tester.getOngoingEffect();
		tester.getOngoingLCEffect();
		tester.getOngoingWREffect();
		tester.getPlayers();
		tester.getTurnplayer();
		MainView mv= new MainView(mc);
		Board board = new Board(mc , 0, mv);
		tester.setBoard(board );
		
		tester.setCurrentPlayer(turnplayer );
		tester.setNplayer(1);
		PBoardView pbv = new PBoardView(mc);
		Action ongoingAction = new FamtoCouncil(pbv );
		tester.setOngoingAction(ongoingAction);
		GeneralEffect ongoingEffect = new addWood();
		tester.setOngoingEffect(ongoingEffect );
		WoodorRockEffects woodorRockEffects = new addWoodorRock();
		tester.setOngoingWREffect(woodorRockEffects );
		List<PBoard> players = new ArrayList<>();
		tester.toStringPlayers(players );
		tester.setNplayer(1);
		tester.setCurrentPlayer(turnplayer);
//		tester.setup(mc);
		
		
	}

}
