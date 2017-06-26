package it.polimi.ingsw.ps18.controller.controlleractions;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.VaticanReport;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveVaticanAnswer implements ActionChoice{
	/*
	 * Da capire cosa viene settato realmente, capire chi setta cosa
	 * Ma credo sia corretto
	 * In pratica
	 */
	int supportChoice;
	
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		if(supportChoice == 1){
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
						/*
						 * Dove lo faccio uscire?
						 */
						return;
					}
					//else cella dopo
				}
				 catch (IOException | ParseException e) {
					e.printStackTrace();
				}
			}
			
		}
		else if (supportChoice == 2){
			/*
			 * Mantiene i punti fede ma attua la scomunica
			 */
			Action action = new VaticanReport(currentplayer.getpBoardView());
			((VaticanReport) action).act(game);
		}
	}
		
	@Override
	public void setIndex(int supportChoice) {
		this.supportChoice = supportChoice;
	}
	
	
}
