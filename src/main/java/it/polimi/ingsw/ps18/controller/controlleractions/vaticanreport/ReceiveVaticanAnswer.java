package it.polimi.ingsw.ps18.controller.controlleractions.vaticanreport;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.VaticanReport;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveVaticanAnswer.
 */
public class ReceiveVaticanAnswer implements ActionChoice{

	/** The support choice. */
	int supportChoice;
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		((VaticanReport) currentaction).setChosenAnswer(supportChoice);
		((VaticanReport) currentaction).act(game);
	}
		
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int supportChoice) {
		this.supportChoice = supportChoice;
	}
	
	
}
