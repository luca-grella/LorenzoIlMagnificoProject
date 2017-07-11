package it.polimi.ingsw.ps18.controller.controlleractions.vaticanreport;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.VaticanReport;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class VaticanReportTrigger.
 */
public class VaticanReportTrigger implements ActionChoice{

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();       
		int age = game.getAGE();
		
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
					boolean hasEnoughFP = false;
					switch(age){
						case 1:
							hasEnoughFP = (boolean) a.get("SupportOKAge1");
							break;
						case 2:
							hasEnoughFP = (boolean) a.get("SupportOKAge2");
							break;
						case 3:
							hasEnoughFP = (boolean) a.get("SupportOKAge3");
							break;
					}
					if(hasEnoughFP){
						Action action = new VaticanReport(currentplayer.getpBoardView());
						game.setOngoingAction(action);
						((VaticanReport) action).reportChoice();
						return;
					}
					else{
						Action action = new VaticanReport(currentplayer.getpBoardView());
						game.setOngoingAction(action);
						((VaticanReport) action).act(game);
						return;
					}
				}
				//else cella dopo
			}
			 catch (IOException | ParseException e) {
				System.out.println("Errore");
			}
			/*
			 * Se non trova il giocatore non so se ha senso gestirlo
			 */
		}
		

		
//		
//		if(game.getAGE() == 1){ //leggere da JSON
//			if(currentplayer.getResources().getFP() < 3){
//				Action action = new VaticanReport(currentplayer.getpBoardView());
//				((VaticanReport) action).act(game);
//			}
//			else{	
//				Action action = new VaticanReport(currentplayer.getpBoardView());
//				((VaticanReport) action).reportChoice();
//			}
//				
//		}
		
		
	}
	
	
	
	/**
	 * Check FP.
	 *
	 * @param index the index
	 * @param age the age
	 */
	private void checkFP (int index, int age){
//		Integer i = new Integer(index);
//		JSONParser parser = new JSONParser();
//		Object obj;
//		try {
//			obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/controller/controlleractions/FaithCells.json"));
//			JSONObject jsonObject =(JSONObject) obj;
//			JSONObject a = (JSONObject) jsonObject.get(i.toString());
//			long faithPoints = (long) a.get("FP");
//			long victoryPoints = (long) a.get("VP");
//		}
//		 catch (IOException | ParseException e) {
//			e.printStackTrace();
//		}

	}
	
	

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		
	}

}
