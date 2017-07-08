package it.polimi.ingsw.ps18.model.personalboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusResources;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.*;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.LCQuickEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.LCRequirement;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.ConfirmHandler;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.server.ClientInterface;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class PBoard.
 */
public class PBoard extends Observable implements Comparable<PBoard>, ConfirmHandler{
	
	/**
	 * The p board view.
	 */
	private PBoardView pBoardView;
	
	/**
	 * The playercol.
	 */
	private int playercol;
	
	/**
	 * The resources.
	 */
	private Stats resources;
	
	private boolean confirm = false;
	
	/**
	 * The cards.
	 */
	private List<Cards> cards = new ArrayList<>();
	
	/**
	 * the excomm Cards
	 */
	private List<Excommunications> excommCards = new ArrayList<>();
	
	private List<LeaderCards> leadercards = new ArrayList<>();
	
	private List<LeaderCards> tempLC = new ArrayList<>();
	
	private LeaderCards currentcard;
	
	private List<LeaderCards> supportforLC = new ArrayList<>();
	
	private List<LeaderCards> secondsupportforLC = new ArrayList<>();
	/**
	 * The fams.
	 */
	private List<FMember> fams = new ArrayList<>(GeneralParameters.nfamperplayer);
	
	
	private int priorityValue;
	
	private ClientInterface player;
	
	
	
	
	public PBoard(int playercol, ClientInterface player){
		this.playercol = playercol;
		this.player = player;
	}
	
	public void completePBoardSetup(List<Dice> dices, MainController mcontroller, List<Cards> BonusTiles){
		pBoardView = new PBoardView(mcontroller, player);
		addObserver(pBoardView);
		notifyLogPBoardView("Setup PBoard Player Number " + playercol + " Initiated.");
//		this.resources = new Stats(2,2,5,2,0,0,0);
		this.resources = new Stats(40,40,40,40,40,40,40);
		for(int i=0; i<dices.size(); i++){
			this.fams.add(new FMember(dices.get(i), playercol, this));
		} 
		this.fams.add(new FMember(666,playercol, this));
		if (! BonusTiles.isEmpty()){
			ChooseBonusTile();
		}
		notifyLogPBoardView("Setup PBoard Player Number " + playercol + " Terminated.");
		
	}
	public void refreshFMembers(List<Dice> dices){
		this.fams.clear();
		int count;
		for(count=0; count<dices.size(); count++){
			this.fams.add(new FMember(dices.get(count), playercol, this));
		} 
		this.fams.add(new FMember(666,playercol, this));
	}
	

	
	public void ChooseBonusTile(){
		notifyActionPBoardView("ChooseBonusTile");
	}
	
	/**
	 * Instantiates a new p board.
	 *
	 * @param playercol
	 *            the playercol
	 * @param dices
	 *            the dices
	 */
	public PBoard(int playercol, List<Dice> dices){
		this.playercol = playercol;
		this.resources = new Stats(2,2,5,2,0,0,0);
		for(int i=0; i<dices.size(); i++){
			this.fams.add(new FMember(dices.get(i), playercol, this));
		} this.fams.add(new FMember(666, playercol, this));
	}
	
	/**
	 * Instantiates a new p board.
	 */
	public PBoard(){
		pBoardView = null;
		playercol = 0;
		resources = null;
		cards = null;
		fams = null;
	}
	
	public static final Comparator<PBoard> victoryComparator = new Comparator<PBoard>(){
		public int compare(PBoard player1, PBoard player2) {
			int compareVP1 = player1.getResources().getVP();
			int compareVP2 = player2.getResources().getVP();
			
			return compareVP2 - compareVP1;
	
		}
	};
	
	@Override
	public int compareTo(PBoard player) {
		int compareMP = player.getResources().getMP();
		return compareMP - this.getResources().getMP();
	}
	@Override
	public boolean equals(Object obj) {
	    if (!(obj instanceof PBoard)) {
	         return false;
	    }
//	    if (obj == null) {
//	        return false;
//	    }  
	    PBoard other = (PBoard) obj;
	    if (this.getResources().getMP() == 0) {
	        return other.getResources().getMP() == 0;
	    }
	    return this.equals(other);
	}
	
	@Override 
	public int hashCode() {
		return this.hashCode();
	}
	
	/**
	 * Act harvest.
	 */
	public void actHarvest() {
		notifyStatusPBoardView("actHarvest");
	}
	
	/**
	 * Act production.
	 */
	public void actProduction() {
		notifyStatusPBoardView("actProduction");
	}
	
	/**
	 * Adds the card.
	 *
	 * @param card
	 *            the card
	 * @param game
	 *            the game
	 */
	public void addCard(Cards card, GameLogic game) {
		boolean doubleEffects = false;
		for(LeaderCards leadercard: this.leadercards){
			if(leadercard.isActive()){
				for(LCPermEffect effect: leadercard.getPermEffects()){
					if("VariousModifier".equals(effect.getName())){
						if("DoubleBonus".equals(effect.getShortDescription())){
							doubleEffects = true;
						}
					}
				}
			}
		}
		if(cards.add(card)){
			card.activateQEffects(this,game);
			if(doubleEffects){
				for(int i = 0 ; i < card.getEffects().size() ; i++){
					QuickEffect qeffect = card.getEffects().get(i);
					if(! "privilege".equals(qeffect.getName())){
						if(! "different privilege".equals(qeffect.getName())){
							qeffect.activate(this, game);
						}
					}
				}
			}
		}
		
	}
	
	public void takeLeader(List<LeaderCards> leaders){
		this.tempLC = leaders;
		notifyLogPBoardView("\nGiocatore " + this.playercol + "\n");
		for(int i=0; i<leaders.size(); i++){
			LeaderCards card = leaders.get(i);
			notifyLogPBoardView(card.toString(i));
		}
		notifyStatusPBoardView("ChoiceLC");
	}
	
	public void continuetakeLeader(int choice){
		this.leadercards.add(tempLC.get(choice));
		tempLC.remove(choice);
	}
	
	public void activateLeader(GameLogic game){
		this.supportforLC.clear();
		boolean noOne = true;
		for(LeaderCards card: this.leadercards){
			if(! card.isActive()){
				this.currentcard = card;
				boolean canActivate = false;
				for(LCRequirement requirement: card.getRequirements()){
					if(requirement.checkRequirement(this)){
						canActivate = true;
						noOne = false;
					}
				}
				if(canActivate){
					notifyLogPBoardView(card.toString());
					notifyStatusPBoardView("ActivationChoiceLC");
				}
			}
		}
		if(noOne){
			notifyLogPBoardView("There are no cards that can be activated.\n");
			return;
		}
		for(LeaderCards card: this.supportforLC){
			card.setActive(true);
			for(LCPermEffect effect: card.getPermEffects()){
				if("ModifierValue".equals(effect.getName())){
					((ModifierValue) effect).refreshFMember(game);
				}
				if("VariousModifier".equals(effect.getName())){
					if("CopyLC".equals(effect.getShortDescription())){
						this.currentcard = card;
						if(! copyLC(game)){
							notifyLogPBoardView("There are no cards to copy.\n");
							card.setActive(false);
						}
					}
				}
			}
		}
	}
	
	public boolean copyLC(GameLogic game){
		this.secondsupportforLC.clear();
		for(PBoard player: game.getPlayers()){
			if(player.getPlayercol()!=this.playercol){
				for(LeaderCards card: player.getLeadercards()){
					if(card.isActive()){
						secondsupportforLC.add(card);
					}
				}
			}
		}
		if(! secondsupportforLC.isEmpty()){
			int count = 0;
			for(LeaderCards card: secondsupportforLC){
				notifyLogPBoardView(card.toString(count));
				count++;
			}
			notifyStatusPBoardView("ChooseLCtoCopy");
			return true;
		} return false;
	}
	
	public void discardLC(){
		this.supportforLC.clear();
		boolean canDiscard = false;
		for(LeaderCards card: this.leadercards){
			if(! card.isActive()){
				canDiscard = true;
				this.supportforLC.add(card);
			}
		}
		if(canDiscard){
			for(int i=0; i<this.supportforLC.size(); i++){
				notifyLogPBoardView(supportforLC.get(i).toString(i+1));
			}
			notifyStatusPBoardView("DiscardChoice");
		} else {
			notifyLogPBoardView("There are no cards that can be discarded.\n");
			return;
		}
	}
	
	public void activateLCQE(GameLogic game){
		this.supportforLC.clear();
		boolean existoneCardtoActivate = false;
		for(LeaderCards card: this.leadercards){
			//se la carta è attiva, ha effetti rapidi e non è stata attivata questo turno.
			if(card.isActive()){
				if(card.hasLCQE()){
					if(! card.isEffectactivated()){
						existoneCardtoActivate = true;
					}
				}
			}
		}
		if(! existoneCardtoActivate){
			notifyLogPBoardView("There are no cards that can activate their effects.\n");
			return;
		} else {
			for(LeaderCards card: this.leadercards){
				if(card.isActive()){
					if(card.hasLCQE()){
						if(! card.isEffectactivated()){
							this.currentcard = card;
							notifyLogPBoardView(card.toString());
							notifyStatusPBoardView("ActivateQEChoice");
						}
					}
				}
			}
			game.setRequester(this);
			notifyStatusPBoardView("Confirm");
			if(this.confirm){
				for(LeaderCards card: this.supportforLC){
					card.setEffectactivated(true);
					for(LCQuickEffect effect: card.getQuickEffects()){
						effect.activate(this, game);
					}
				}
			} else {
				return;
			}
		}
	}
	
	public Stats generateExcommMalus(){
		Stats totalmalus = new Stats(0,0,0,0,0,0,0);
		for(int i=0; i<this.excommCards.size(); i++){
			Excommunications card = this.excommCards.get(i);
			for(int j=0; j<card.getEffects().size(); j++){
				if("MalusResources".equals(card.getEffects().get(j).getName())){
					totalmalus.addStats(((MalusResources) card.getEffects().get(j)).getMalus());
				}
			}
		}
		return totalmalus;
	}
	
	/**
	 * Checks for space.
	 *
	 * @param cardColor
	 *            the card color
	 * @return true, if successful
	 */
	public boolean hasSpace(int cardColor){
		boolean skipcontrol = false;
		for(LeaderCards card: this.leadercards){
			if(card.isActive()){
				for(LCPermEffect effect: card.getPermEffects()){
					if("VariousModifier".equals(effect.getName())){
						if("SkipMPCheckGreenCards".equals(effect.getShortDescription())){
							skipcontrol = true;
						}
					}
				}
			}
		}
		if(cards.isEmpty())
			return true;
		else{
			int colorCount = 0;
			
			for(int cardIndex=0; cardIndex<this.cards.size(); cardIndex++){
				if((cards.get(cardIndex)).getColor() == cardColor){
					colorCount++;
				}
			}
			if(cardColor != 0){
				if(colorCount < 6)
					return true;
				else
					return false;
			}
			/*
			 * TODO: Else molto meccanico, se possibile sistemare
			 */
			else{
				int futureCount = colorCount+1;
				if(futureCount<=2){
					return true;
				} else if(futureCount == 3){
					if((this.getResources()).getMP() >= 3 || skipcontrol){
						return true;
					}
				} else if(futureCount == 4){
					if((this.getResources()).getMP() >= 7 || skipcontrol){
						return true;
					}
				} else if(futureCount == 5){
				    if((this.getResources()).getMP() >= 12 || skipcontrol){
						return true;
					}
				} else if(futureCount == 6){
				    if((this.getResources()).getMP() >= 18 || skipcontrol){
						return true;
					}
				} 
				return false;
			}
		}
	}
	
	/**
	 * V P calc.
	 *
	 * @return the int
	 */
	public int vPCalc(){
		return playercol;
		
	}
	
	/**
	 * To string fams.
	 */
	public void toStringFams(){
		StringBuilder builder = new StringBuilder();
		List<FMember> fams = this.getFams();
		builder.append("-----------------\n");
		for(int i=0; i<this.fams.size(); i++){
			if((fams.get(i))!=null){
				FMember fam = fams.get(i);
				builder.append("Family Member " + (i+1) + ":\n");
				builder.append(fam.toString());
				builder.append("\n\n");
			} else {
				builder.append("Family Member Already Used\n\n.");
			}
		} builder.append("-----------------\n");
		notifyLogPBoardView(builder.toString());
	}
	
	/**
	 * To string resources.
	 *
	 * @return the string
	 */
	public String toStringResources(){
		StringBuilder builder = new StringBuilder();
		builder.append("Resources of player " + this.playercol + "\n");
		builder.append(this.resources.toString());
		return builder.toString();
		}
	
	/**
	 * To string cards.
	 *
	 * @return the string
	 */
	public String toStringCards(){
		StringBuilder builder = new StringBuilder();
		List<Cards> cards = this.getCards();
		int count;
		builder.append("Cards of player " + this.playercol + ":\n-----------------\n");
		
		builder.append("Bonus Tiles:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==-1){
				builder.append(card.toString(count));
				count++;
			}
		}
		builder.append("\n-----------------\nGreen Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==0){
				builder.append(card.toString(count));
				count++;
			}
		}
		builder.append("\n-----------------\nBlue Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==1){
				builder.append(card.toString(count));
				count++;
			}
		}
		builder.append("\n-----------------\nYellow Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==2){
				builder.append(card.toString(count));
				count++;
			}
		}
		builder.append("\n-----------------\nPurple Cards:\n");
		count = 1;
		for(Cards card: cards){
			if(card.getColor()==3){
				builder.append(card.toString(count));
				count++;
			}
		}
		builder.append("\n-----------------\nExcommunication Cards:\n");
		count = 1;
		for(Excommunications card: this.excommCards){
			builder.append(card.toString(count));
			count++;
		}
		builder.append("\n-----------------\n");
		return builder.toString();
	}
	
	/**
	 * Notify log P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyLogPBoardView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	/**
	 * Notify status P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyStatusPBoardView(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}
	
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

	/**
	 * Gets the p board view.
	 *
	 * @return the pBoardView
	 */
	public PBoardView getpBoardView() {
		return pBoardView;
	}

	/**
	 * Gets the playercol.
	 *
	 * @return the playercol
	 */
	public int getPlayercol() {
		return playercol;
	}

	/**
	 * Sets the playercol.
	 *
	 * @param playercol
	 *            the playercol to set
	 */
	public void setPlayercol(int playercol) {
		this.playercol = playercol;
	}

	/**
	 * Gets the resources.
	 *
	 * @return the resources
	 */
	public Stats getResources() {
		return resources;
	}

	/**
	 * Sets the resources.
	 *
	 * @param resources
	 *            the resources to set
	 */
	public void setResources(Stats resources) {
		this.resources = resources;
	}

	/**
	 * Gets the cards.
	 *
	 * @return the cards
	 */
	public List<Cards> getCards() {
		return cards;
	}

	/**
	 * Sets the cards.
	 *
	 * @param cards
	 *            the cards to set
	 */
	public void setCards(List<Cards> cards) {
		this.cards = cards;
	}

	/**
	 * Gets the fams.
	 *
	 * @return the fams
	 */
	public List<FMember> getFams() {
		return fams;
	}

	/**
	 * Sets the fams.
	 *
	 * @param fams
	 *            the fams to set
	 */
	public void setFams(List<FMember> fams) {
		this.fams = fams;
	}

	/**
	 * @return the excommCards
	 */
	public List<Excommunications> getExcommCards() {
		return excommCards;
	}

	/**
	 * Per Test
	 * 
	 */
	public void setpBoardView(PBoardView pb) {
		this.pBoardView=pb;		
	}

	/**
	 * @return the priorityValue
	 */
	public int getPriorityValue() {
		return priorityValue;
	}

	/**
	 * @param priorityValue the priorityValue to set
	 */
	public void setPriorityValue(int priorityValue) {
		this.priorityValue = priorityValue;
	}

	/*
	 * @return the tempLC
	 */
	public List<LeaderCards> getTempLC() {
		return tempLC;
	}

	/**
	 * @return the leadercards
	 */
	public List<LeaderCards> getLeadercards() {
		return leadercards;
	}

	/**
	 * @return the currentcard
	 */
	public LeaderCards getCurrentcard() {
		return currentcard;
	}

	/**
	 * @return the tobeActivated
	 */
	public List<LeaderCards> getSupportforLC() {
		return supportforLC;
	}

	/**
	 * @param confirm the confirm to set
	 */
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	/**
	 * @return the secondsupportforLC
	 */
	public List<LeaderCards> getSecondsupportforLC() {
		return secondsupportforLC;
	}

	/**
	 * @param cards2
	 */
	public void setLeaderCards(List<LeaderCards> leadercards) {
		this.leadercards=leadercards;
		
	}
	
	

	

}