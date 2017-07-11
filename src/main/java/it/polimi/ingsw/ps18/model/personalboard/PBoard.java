package it.polimi.ingsw.ps18.model.personalboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.rmi.ClientInterface;
import it.polimi.ingsw.ps18.view.IdleView;
import it.polimi.ingsw.ps18.view.IdleViewThread;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class PBoard.
 */
public class PBoard extends Observable implements Comparable<PBoard>, ConfirmHandler{
	
	/**
	 * The p board view.
	 */
	private PBoardView pBoardView;
	
	/** The idlethread. */
	private final ExecutorService idlethread = Executors.newSingleThreadExecutor();
	
	/**
	 * The playercol.
	 */
	private int playercol;
	
	/**
	 * The resources.
	 */
	private Stats resources;
	
	/** The confirm. */
	private boolean confirm = false;
	
	/**
	 * The cards.
	 */
	private List<Cards> cards = new ArrayList<>();
	
	/** the excomm Cards. */
	private List<Excommunications> excommCards = new ArrayList<>();
	
	/** The leadercards. */
	private List<LeaderCards> leadercards = new ArrayList<>();
	
	/** The temp LC. */
	private List<LeaderCards> tempLC = new ArrayList<>();
	
	/** The currentcard. */
	private LeaderCards currentcard;
	
	/** The supportfor LC. */
	private List<LeaderCards> supportforLC = new ArrayList<>();
	
	/** The secondsupportfor LC. */
	private List<LeaderCards> secondsupportforLC = new ArrayList<>();
	/**
	 * The fams.
	 */
	private List<FMember> fams = new ArrayList<>(GeneralParameters.nfamperplayer);
	
	
	/** The priority value. */
	private int priorityValue;
	
	/** The player. */
	private ClientInterface player;
	
	/** The tester. */
	private int tester=1;
	
	
	
	
	/**
	 * Instantiates a new p board.
	 *
	 * @param playercol the playercol
	 * @param player the player
	 */
	public PBoard(int playercol, ClientInterface player){
		this.playercol = playercol;
		this.player = player;
	}
	
	/**
	 * Complete P board setup.
	 *
	 * @param dices the dices
	 * @param mcontroller the mcontroller
	 * @param BonusTiles the bonus tiles
	 */
	public void completePBoardSetup(List<Dice> dices, MainController mcontroller, List<Cards> BonusTiles){
		pBoardView = new PBoardView(mcontroller, player);
		addObserver(pBoardView);
		notifyLogPBoardView("Setup PBoard Player Number " + playercol + " Initiated.");
		this.resources = new Stats(2,2,5,2,0,0,0);
//		this.resources = new Stats(40,40,40,40,40,40,40);
		for(int i=0; i<dices.size(); i++){
			this.fams.add(new FMember(dices.get(i), playercol, this));
		} 
		this.fams.add(new FMember(0,playercol, this));
		if (! BonusTiles.isEmpty()){
			ChooseBonusTile();
		}
		notifyLogPBoardView("Setup PBoard Player Number " + playercol + " Terminated.");
		
	}
	
	/**
	 * Refresh F members.
	 *
	 * @param dices the dices
	 */
	public void refreshFMembers(List<Dice> dices){
		this.fams.clear();
		int count;
		for(count=0; count<dices.size(); count++){
			this.fams.add(new FMember(dices.get(count), playercol, this));
		} 
		this.fams.add(new FMember(666,playercol, this));
	}
	

	
	/**
	 * Choose bonus tile.
	 */
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
	
	/** The Constant victoryComparator. */
	public static final Comparator<PBoard> victoryComparator = new Comparator<PBoard>(){
		public int compare(PBoard player1, PBoard player2) {
			int compareVP1 = player1.getResources().getVP();
			int compareVP2 = player2.getResources().getVP();
			
			return compareVP2 - compareVP1;
	
		}
	};
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(PBoard player) {
		int compareMP = player.getResources().getMP();
		return compareMP - this.getResources().getMP();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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
	
	/**
	 * Take leader.
	 *
	 * @param leaders the leaders
	 */
	public void takeLeader(List<LeaderCards> leaders){
		this.tempLC = leaders;
		notifyLogPBoardView("\nGiocatore " + this.playercol + "\n");
		for(int i=0; i<leaders.size(); i++){
			LeaderCards card = leaders.get(i);
			notifyLogPBoardView(card.toString(i + 1));
		}
		notifyStatusPBoardView("ChoiceLC");
	}
	
	/**
	 * Continuetake leader.
	 *
	 * @param choice the choice
	 */
	public void continuetakeLeader(int choice){
		this.leadercards.add(tempLC.get(choice));
		tempLC.remove(choice);
	}
	
	/**
	 * Activate leader.
	 *
	 * @param game the game
	 */
	public void activateLeader(GameLogic game){
		this.supportforLC.clear();
		boolean noOne = true;
		for(LeaderCards card: this.leadercards){
			if(! card.isActive()){
				this.currentcard = card;
				boolean canActivate = false;
				for(LCRequirement requirement: card.getRequirements()){
					if(tester!=999){
					if(requirement.checkRequirement(this)){
						canActivate = true;
						noOne = false;
						}
					}
				}
				
				if(tester!=999){
				
				if(canActivate){
					notifyLogPBoardView(card.toString());
					notifyStatusPBoardView("ActivationChoiceLC");
				}
			}
		}
			if(tester!=999){
		if(noOne){
			notifyLogPBoardView("There are no cards that can be activated.\n");
			return;
		}
			}
		}
		
		if(tester!=999){
		
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
		}}
	}
	
	/**
	 * Copy LC.
	 *
	 * @param game the game
	 * @return true, if successful
	 */
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
	
	/**
	 * Discard LC.
	 */
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
	
	/**
	 * Activate LCQE.
	 *
	 * @param game the game
	 */
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
	
	/**
	 * Generate excomm malus.
	 *
	 * @return the stats
	 */
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
	 *
	 * @return the string
	 */
	public String toStringFams(){
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
		return builder.toString();
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
		builder.append("\n-----------------\nActive Leader Cards:\n");
		count = 1;
		for(LeaderCards card: this.leadercards){
			if(card.isActive()){
				builder.append(card.toString(count));
				count++;
			}
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
	public void notifyLogPBoardView(String msg){
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
	
	/**
	 * Notify action P board view.
	 *
	 * @param msg the msg
	 */
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	/**
	 * Notify param P board view.
	 *
	 * @param msg the msg
	 * @param color the color
	 */
	public void notifyParamPBoardView(String msg, int color){
		setChanged();
		notifyObservers(new ParamMessage(msg,color));
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
	 * Gets the excomm cards.
	 *
	 * @return the excommCards
	 */
	public List<Excommunications> getExcommCards() {
		return excommCards;
	}

	/**
	 * Per Test.
	 *
	 * @param pb the new p board view
	 */
	public void setpBoardView(PBoardView pb) {
		this.pBoardView=pb;		
	}

	/**
	 * Gets the priority value.
	 *
	 * @return the priorityValue
	 */
	public int getPriorityValue() {
		return priorityValue;
	}

	/**
	 * Sets the priority value.
	 *
	 * @param priorityValue the priorityValue to set
	 */
	public void setPriorityValue(int priorityValue) {
		this.priorityValue = priorityValue;
	}

	/**
	 * Gets the temp LC.
	 *
	 * @return the temp LC
	 */
	/*
	 * @return the tempLC
	 */
	public List<LeaderCards> getTempLC() {
		return tempLC;
	}

	/**
	 * Gets the leadercards.
	 *
	 * @return the leadercards
	 */
	public List<LeaderCards> getLeadercards() {
		return leadercards;
	}

	/**
	 * Gets the currentcard.
	 *
	 * @return the currentcard
	 */
	public LeaderCards getCurrentcard() {
		return currentcard;
	}

	/**
	 * Gets the supportfor LC.
	 *
	 * @return the tobeActivated
	 */
	public List<LeaderCards> getSupportforLC() {
		return supportforLC;
	}

	/**
	 * Sets the confirm.
	 *
	 * @param confirm the confirm to set
	 */
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	/**
	 * Gets the secondsupportfor LC.
	 *
	 * @return the secondsupportforLC
	 */
	public List<LeaderCards> getSecondsupportforLC() {
		return secondsupportforLC;
	}

	/**
	 * Sets the leader cards.
	 *
	 * @param leadercards the new leader cards
	 */
	public void setLeaderCards(List<LeaderCards> leadercards) {
		this.leadercards=leadercards;
		
	}

	/**
	 * Sets the excomm cards.
	 *
	 * @param excommCards the new excomm cards
	 */
	public void setExcommCards(List<Excommunications> excommCards) {
		this.excommCards=excommCards;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public ClientInterface getPlayer() {
		return player;
	}

	/**
	 * Gets the idlethread.
	 *
	 * @return the idlethread
	 */
	public ExecutorService getIdlethread() {
		return idlethread;
	}

	/**
	 * Sets the temp LC.
	 *
	 * @param tempLC the new temp LC
	 */
	public void setTempLC(List<LeaderCards> tempLC) {
		this.tempLC=tempLC;
		
	}

	/**
	 * Sets the tester.
	 *
	 * @param tester the new tester
	 */
	public void setTester(int tester) {
		this.tester=tester;
		
	}

	/**
	 * Sets the player.
	 *
	 * @param player the player to set
	 */
	public void setPlayer(ClientInterface player) {
		this.player = player;
	}
	
	
	

	

}