package it.polimi.ingsw.ps18.model.board.boardcells;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * Defines a market cell. <br>
 * When a family member is placed, MarketCell activates a set of quick effects.
 * 
 */

public class MarketCell {
	
	/**
	 * The min players.
	 */
	private long minPlayers;
	
	/**
	 * The market cell FM.
	 */
	private FMember marketCellFM;
	
	/**
	 * The value.
	 */
	private int value;
	
	/**
	 * The effects.
	 */
	private List<QuickEffect> effects = new ArrayList<>();
	
	
	/**
	 * Instantiates a new market cell.
	 *
	 * @param a
	 *            the i
	 */
	public MarketCell(JSONObject a) {
		marketCellFM = null;
		HashMapQE mapQE = new HashMapQE();
	        
		this.setMinPlayers((long) a.get("MinPlayers"));
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		for(int count=0; count<qeffects.size(); count++){
			if(qeffects.get(count)!=null){
				if(qeffectvalues.get(count)!=null){
					this.add(mapQE.geteffect((String) qeffects.get(count)), (long) qeffectvalues.get(count));
				} else {
					this.effects.add(mapQE.geteffect((String) qeffects.get(count)));
				}	
			}	
	    }	
	}

	/**
	 * Places a FMember from PBoard to the cell.
	 *
	 * @param pBoardFM
	 *            the board FM
	 * @param game
	 *            the game
	 * @return true, if successful
	 */
	public boolean insertFM (FMember pBoardFM, GameLogic game) {
		
		if(this.isEmptyMC()){
			this.marketCellFM = pBoardFM;
			activateQEffects(game); 			//attivo effetti sul giocatore
			return true;
		} return false;
		//QuickEff activation gestita dal chiamante
	}
	
	/**
	 * Checks the cell's state (Empty/Full).
	 *
	 * @return a boolean state
	 */
	
	public boolean isEmptyMC() {
		if(this.marketCellFM==null){
			return true;		
		}
		else {
			return false;
		}	
	}
	
	/**
	 * Checks if is legal MC.
	 *
	 * @param pBoardFM
	 *            the board FM
	 * @return true, if is legal MC
	 */
	public boolean isLegalMC(int actionValue){
		if(this.isEmptyMC()){
			if(actionValue >= this.value){
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Adds the.
	 *
	 * @param marketQuickEffect
	 *            the market quick effect
	 * @param quantity
	 *            the quantity
	 * @return true, if successful
	 */
	private boolean add(QuickEffect marketQuickEffect, long quantity){
	    boolean isAdded = this.effects.add(marketQuickEffect);
	    if(isAdded){
		    marketQuickEffect.setQuantity(Math.toIntExact(quantity));
		    return true;
	    }
	    else
	    	return false;		
    }
	
	/**
	 * Activate Q effects.
	 *
	 * @param game
	 *            the game
	 */
	private void activateQEffects(GameLogic game){
		for(int count=0; count<this.effects.size(); count++){
			QuickEffect marketQuickEffect = this.effects.get(count); //Sicuro mi da errore su Sonar
			marketQuickEffect.activate(game.getTurnplayer(), game);
		}
	}
	
	/**
	 * To string.
	 *
	 * @param index
	 *            the index
	 * @return the string
	 */
	public String toString(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Market cell number " + (index+1) + ":\n");
		
		if(marketCellFM != null){
			builder.append("Family Member in market cell number " + index + ":\n"
					+ "\tPlayer color: " + marketCellFM.getPlayercol() + "\n"
					+ "\tFamily Member color: " + marketCellFM.getColor() + "\n"
					+ "\tFamily Member value: " + marketCellFM.getValue() + "\n"
					);
		}
		else{
			builder.append("Market cell is empty!\n");
		}
		builder.append("Quick Effects:\n");
		for(int i=0; i<(this.effects).size(); i++){
			builder.append("\t" + i + ": " + ((this.effects).get(i)).toString() + "\n");
		}
		builder.append("-----------------\n");
		return builder.toString();
	}

	/**
	 * Gets the market cell FM.
	 *
	 * @return the marketCellFM
	 */
	public FMember getMarketCellFM() {
		return marketCellFM;
	}

	/**
	 * Sets the market cell FM.
	 *
	 * @param marketCellFM
	 *            the marketCellFM to set
	 */
	public void setMarketCellFM(FMember marketCellFM) {
		this.marketCellFM = marketCellFM;
	}

	/**
	 * Gets the min players.
	 *
	 * @return the minPlayers
	 */
	public int getMinPlayers() {
		return (int) minPlayers;
	}

	/**
	 * Sets the min players.
	 *
	 * @param minPlayers
	 *            the minPlayers to set
	 */
	public void setMinPlayers(long minPlayers) {
		this.minPlayers = minPlayers;
	}
	
	
	
	
	
}
