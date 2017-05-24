package it.polimi.ingsw.ps18.Model.PBoard;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.Model.Dice;
import it.polimi.ingsw.ps18.Model.GeneralParameters;
import it.polimi.ingsw.ps18.Model.Cards.Cards;
import it.polimi.ingsw.ps18.Model.Effect.QuickEffect.QuickEffect;
import it.polimi.ingsw.ps18.Model.PBoard.Resources.Stats;

public class PBoard {
	private int playercol;
	private Stats resources;
	private List<Cards> cards = new ArrayList<>();
	private List<FMember> fams = new ArrayList<>();
	
	
	public PBoard(int playercol, List<Dice> dices){
		this.playercol = playercol;
		this.resources = new Stats(2,2,5,2,0,0,0);
		for(int i=0; i<dices.size(); i++){
			this.fams.add(new FMember(dices.get(i), playercol));
		} this.fams.add(new FMember(0,playercol));
		
	}
	
	
	public Stats getStats(){
		return this.resources;
	}
	
	
	public void addCard(Cards card){
		cards.add(card);
		for(int i = 0 ; i < 2 ; i++){
			QuickEffect qeffect = card.effects.get(i);
			qeffect.activate(this);
		}
	}
	
	
	

}