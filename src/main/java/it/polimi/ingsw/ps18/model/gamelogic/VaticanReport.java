package it.polimi.ingsw.ps18.model.gamelogic;

import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Observable;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class VaticanReport.
 */
public class VaticanReport extends Observable implements Action{
	
	
	/** The chosen answer. */
	int chosenAnswer;
	/*
	 * Effettivamente il valore arriva, quindi mo faccio if else a manetta
	 */
	
	/**
	 * Instantiates a new vatican report.
	 *
	 * @param view the view
	 */
	public VaticanReport(PBoardView view){
		addObserver(view);
	}
	
	/**
	 * Report choice.
	 */
	public void reportChoice(){
		notifyActionPBoardView("Choose Church Support");
	}
	

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		if(chosenAnswer == 1){
			PBoard currentplayer = game.getTurnplayer();

			for(int index=0; index<16; index++){
				Integer i = new Integer(index);
				JSONParser parser = new JSONParser();
				Object obj;
				try {
					obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/controller/controlleractions/FaithCells.json"));
					JSONObject jsonObject =(JSONObject) obj;
					JSONObject a = (JSONObject) jsonObject.get(i.toString());
					long faithPoints = (long) a.get("FP");
					if(currentplayer.getResources().getFP() == faithPoints){	
						int bonusVP = 0;
						for(LeaderCards card: game.getTurnplayer().getLeadercards()){
							if(card.isActive()){
								for(LCPermEffect effect: card.getPermEffects()){
									if("VariousModifier".equals(effect.getName())){
										if("BonusVPVaticanReport".equals(effect.getShortDescription())){
											bonusVP = 5;
										}
									}
								}
							}
						}
						long victoryPoints = (long) a.get("VP");
						currentplayer.getResources().addFP( - currentplayer.getResources().getFP()); //Elegantissimo proprio
						currentplayer.getResources().addVP((int) victoryPoints + bonusVP);
						return;
					}
				}
				 catch (IOException | ParseException e) {
					System.out.println("Errore in parser VaticanReport");
				}
			}
		}
		else if(chosenAnswer == 2){
			PBoard currentplayer = game.getTurnplayer();
			Excommunications excommCard = game.getExcommcards().get(game.getAGE());
			List<Excommunications> playerExcommCards = currentplayer.getExcommCards();
			playerExcommCards.add(excommCard);
		}
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)
	 */
	@Override
	public void setChosenFam(FMember chosenFam) {
		return;
	}
	
	
	/**
	 * Notify action P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

	/**
	 * Gets the chosen answer.
	 *
	 * @return the chosenAnswer
	 */
	public int getChosenAnswer() {
		return chosenAnswer;
	}

	/**
	 * Sets the chosen answer.
	 *
	 * @param chosenAnswer the chosenAnswer to set
	 */
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#setNumberOfServants(int)
	 */
	@Override
	public void setNumberOfServants(int numberOfServants) {
		
	}

	/**
	 * Gets the chosen fam.
	 *
	 * @param chosenFam the chosen fam
	 * @return the chosen fam
	 */
	public FMember getChosenFam(FMember chosenFam) {
		return chosenFam;
		
	}

	/**
	 * Gets the number of servants.
	 *
	 * @param numberOfServants the number of servants
	 * @return the number of servants
	 */
	public int getNumberOfServants(int numberOfServants) {
		return numberOfServants;
	}
	
	
	

}
