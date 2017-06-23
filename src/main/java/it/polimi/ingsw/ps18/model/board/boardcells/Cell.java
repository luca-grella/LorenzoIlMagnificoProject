package it.polimi.ingsw.ps18.model.board.boardcells;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * Defines a Tower cell, which contains a Cards object. <br>
 * 
 * @see
 * {@link it.polimi.ingsw.ps18.model.cards.Cards}
 * 
 * @author yazan-matar
 */

public class Cell { 
	private Cards cellCard;
	private FMember cellFM;
	private int cellValue;
	private List<QuickEffect> cellEffects = new ArrayList<>();
	
	public Cell(JSONObject a) {
		cellCard = null;
		cellFM = null;
		HashMapQE mapQE = new HashMapQE();
		
	    this.setCellValue((long) a.get("CellValue"));
	    JSONArray qeffects = (JSONArray) a.get("QuickEffects");
	    JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectValues");
	    for(int count=0; count<qeffects.size(); count++){
	    	if(qeffects.get(count)!=null){
	    		if(qeffectvalues.get(count)!=null){
	    			this.add(mapQE.geteffect((String) qeffects.get(count)), (long) qeffectvalues.get(count));
	   			} else {
	        		this.cellEffects.add(mapQE.geteffect((String) qeffects.get(count)));
	        	}	
	        }	
	    }	
	    
	}
	
	private boolean add(QuickEffect cellQuickEffect, long quantity){
	    QuickEffect effect = cellQuickEffect;
	    effect.setQuantity((int) quantity);
	    if(this.cellEffects.add(effect)){
	    	return true;
	    } return false;
    }
	
	public void activateQEffects(PBoard player, GameLogic game){
		for(int count=0; count<this.cellEffects.size(); count++){
			QuickEffect cellQuickEffect = this.cellEffects.get(count); //Sicuro mi da errore su Sonar
			cellQuickEffect.activate(player, game);
		}
	}
	
	/**
	 * Places a card in Cell
	 * @param card
	 */
	
	public void insertCard(Cards card) {
		this.cellCard = card;
	}

	/**
	 * Places a FMember from PBoard to Cell
	 * @param pBoardFM
	 * @return card from Cell to PBoard
	 */
	
	public Cards insertFM(FMember pBoardFM) { 
			this.cellFM = pBoardFM;
			return this.cellCard;
	}
	
	/**
	 * Checks Cell state (Empty/Full)
	 * @return a boolean state
	 */
	
	public boolean isEmptyTC() {
		if(this.cellFM==null){ 
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isLegalTC(int actionValue) {
		if(actionValue >= this.getCellValue()){
			if(this.cellCard != null){
				return true;
			}
		}
		return false;
				
	}
	
	public String toString(int index){
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Tower cell number " + index + ":\n");
		
		if(cellCard != null){
			builder.append("Cards in tower cell number " + index + ":\n");
			builder.append(this.cellCard.toString());
		}
		else{
			builder.append("Card already taken!");
		}
		if(cellFM != null){
			builder.append("Family Member in tower cell number " + index + ":\n"
					+ "\tPlayer color: " + cellFM.getPlayercol() + "\n"
					+ "\tFamily Member color: " + cellFM.getColor() + "\n"
					+ "\tFamily Member value: " + cellFM.getValue() + "\n"
					);
		}
		else{
			builder.append("\nTower cell is empty!");
		}
		builder.append("\n-----------------\n");
		return builder.toString();
		
	}
	

	/**
	 * @return the cellCard
	 */
	public Cards getCellCard() {
		return cellCard;
	}

	/**
	 * @param cellCard the cellCard to set
	 */
	public void setCellCard(Cards cellCard) {
		this.cellCard = cellCard;
	}

	/**
	 * @return the cellFM
	 */
	public FMember getCellFM() {
		return cellFM;
	}

	/**
	 * @param cellFM the cellFM to set
	 */
	public void setCellFM(FMember cellFM) {
		this.cellFM = cellFM;
	}

	/**
	 * @return the value
	 */
	public int getCellValue() {
		return cellValue;
	}

	/**
	 * @param l the value to set
	 */
	public void setCellValue(long value) {
		this.cellValue = (int) value;
	}
	
	
	
	
	
}
