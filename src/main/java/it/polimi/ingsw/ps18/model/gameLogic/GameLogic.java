package it.polimi.ingsw.ps18.model.gameLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;



public class GameLogic {
	Scanner input = new Scanner(System.in);
	
	private int TURN = 0;
	private int AGE = 1;
	private int nplayer;
	private int[] order = new int[nplayer];
	private Board board;
	private List<PBoard> players = new ArrayList<>(nplayer);
	private List<GreenC> turncards = new ArrayList<>(2); //size da rivedere
	private List<Dice> dices = new ArrayList<>(GeneralParameters.numberofDices);
	
	
	/**
	 * Initialize the game
	 * @param nplayer set the number of players this game has
	 */
	public GameLogic(int nplayer){
		this.nplayer = nplayer;
	}
	
	/**
	 * Initial Setup that create:
	 * {@link it.polimi.ingsw.ps18.model.board.Board#Board}
	 * - {@link it.polimi.ingsw.ps18.model.gameLogic.Dice#Dice} 
	 * - {@link it.polimi.ingsw.ps18.model.personalBoard.PBoard#PBoard(int, List)}
	 * - {@link it.polimi.ingsw.ps18.model.gameLogic.GameLogic#genDeck()}
	 * - {@link it.polimi.ingsw.ps18.model.gameLogic.Dice#Dice}
	 * - insert the cards in the Tower Cells {@link it.polimi.ingsw.ps18.model.board.boardcells.Tower#insertCards(List)} 
	 */
	public void setup(){
		this.board = new Board();
		for(int i=0; i<GeneralParameters.numberofDices; i++){
			this.dices.add(new Dice(i));
		}
		for(int i=0; i<nplayer; i++){
		    this.players.add(new PBoard(i,dices)); //the color represent the order in which they are
		                                           //stored in the arraylist, so they are easily identificable
		}
		genDeck();
		List<Tower> towers = board.getTowers();
		Tower tower = towers.get(0);
		//tower.insertCards(turncards);
		//randomizza l'ordine iniziale
	}
	
	/**
	 * TODO
	 */
	public void genDeck(){
		HashMapQE.init();
		this.turncards.add(new GreenC());
		GreenC card = turncards.get(0);
		System.out.println(card.getID() + card.getName() + card.getPeriod() + card.getColor());
	}
	
	/**
	 * Handle the flow of the game, but without th einteraction with the players
	 * @return true if every player want play again
	 */
	public boolean gameFlow(){
		do{
			this.TURN++;
			//riordina giocatori
			for(int i=0; i<GeneralParameters.nfamperplayer; i++){
				for(int j=0; j<nplayer; j++){
					this.playerTurn(players.get(j));
				}
			}
			if(TURN%2==0){
				VaticanReport(TURN/2);
			}
		} while (TURN!=GeneralParameters.totalTurns);
		//PBoard winner = winnerCalc(players);
		System.out.println("Do you want to play again? Y|N");
		String answer = input.nextLine();
		if("Y".equalsIgnoreCase(answer)){
			return true;
		}
		return false;
	}
	
	/**
	 * Handle the player's turn
	 * @param player the player that play in this turn
	 */
	private void playerTurn(PBoard player) {
//		ActionChoice action;
//		System.out.println("Scegli qualle familiare muovere.");
//		FMember fam =  player.chooseFam(input);
//		System.out.println("Sposterai il familiare sulla torre.");
//		System.out.println("Scegli la Torre dove vuoi inserire il familiare.");
//		int torre = input.nextInt();
//		System.out.println("Scegli il piano dove vuoi inserire il familiare.");
//		int piano = input.nextInt();
//		action = new FamtoTower();
//		action.act(fam,this.board, player);
		
		
		
		
	}

	/**
	 * Calls {@link it.polimi.ingsw.ps18.model.personalBoard.PBoard#vPCalc()}
	 * @param players
	 * @return the player who has won
	 */
	private PBoard winnerCalc(List<PBoard> players) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Handle the vatican report phase
	 * @param age 
	 */
	private void VaticanReport(int age) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
