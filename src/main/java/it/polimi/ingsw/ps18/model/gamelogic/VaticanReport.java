package it.polimi.ingsw.ps18.model.gamelogic;

import it.polimi.ingsw.ps18.model.cards.Excommunications;
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

public class VaticanReport extends Observable implements Action{
	
	
	int chosenAnswer;
	/*
	 * Effettivamente il valore arriva, quindi mo faccio if else a manetta
	 */
	
	public VaticanReport(PBoardView view){
		addObserver(view);
	}
	
	public void reportChoice(){
		notifyActionPBoardView("Choose Church Support");
	}
	

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
						long victoryPoints = (long) a.get("VP");
						currentplayer.getResources().addFP( - currentplayer.getResources().getFP()); //Elegantissimo proprio
						currentplayer.getResources().addVP((int) victoryPoints);
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
			Excommunications excommCard = game.getExcommcards().get(0);
			List<Excommunications> playerExcommCards = currentplayer.getExcommCards();
			playerExcommCards.add(excommCard);
		}
	}

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
	 * @return the chosenAnswer
	 */
	public int getChosenAnswer() {
		return chosenAnswer;
	}

	/**
	 * @param chosenAnswer the chosenAnswer to set
	 */
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}
	
	
	

}
