package it.polimi.ingsw.ps18.Model.GameLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.polimi.ingsw.ps18.Model.Board.Board;
import it.polimi.ingsw.ps18.Model.Board.BoardCells.Tower;
import it.polimi.ingsw.ps18.Model.Cards.Cards;
import it.polimi.ingsw.ps18.Model.Cards.GreenC;
import it.polimi.ingsw.ps18.Model.Effect.QuickEffect.HashMapQE;
import it.polimi.ingsw.ps18.Model.PBoard.FMember;
import it.polimi.ingsw.ps18.Model.PBoard.PBoard;

public class GameLogic {
	Scanner input = new Scanner(System.in);
	
	private int TURN = 0;
	private int AGE = 1;
	private int nplayer;
	private int[] order = new int[nplayer];
	private Board board;
	private List<PBoard> players = new ArrayList<>(nplayer);
	private List<Cards> turncards = new ArrayList<>(2); //size da rivedere
	private List<Dice> dices = new ArrayList<>(GeneralParameters.numberofDices);
	
	
	
	
	public GameLogic(int nplayer){
		this.nplayer = nplayer;
	}
	
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
		ArrayList<Tower> towers = board.getTowers();
		Tower tower = towers.get(0);
		tower.insertCards(turncards);
		//randomizza l'ordine iniziale
	}
	
	public void genDeck(){
		//per ora generiamo solo due carte
		HashMapQE.init();
		this.turncards.add(new GreenC());
		this.turncards.add(new GreenC());
	}
	
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
		PBoard winner = winnerCalc(players);
		System.out.println("Do you want to play again? Y|N");
		String answer = input.nextLine();
		if(answer.equalsIgnoreCase("Y")){
			return true;
		}
		return false;
	}
	
	private void playerTurn(PBoard player) {
		ActionChoice action;
		System.out.println("Scegli qualle familiare muovere.");
		FMember fam =  player.chooseFam(input);
		System.out.println("Sposterai il familiare sulla torre.");
		System.out.println("Scegli la Torre dove vuoi inserire il familiare.");
		int torre = input.nextInt();
		System.out.println("Scegli il piano dove vuoi inserire il familiare.");
		int piano = input.nextInt();
		action = new FamtoTower(torre,piano);
		action.act(fam,this.board, player);
		
		
		
		
	}

	private PBoard winnerCalc(List<PBoard> players2) {
		// TODO Auto-generated method stub
		return null;
	}

	private void VaticanReport(int i) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
