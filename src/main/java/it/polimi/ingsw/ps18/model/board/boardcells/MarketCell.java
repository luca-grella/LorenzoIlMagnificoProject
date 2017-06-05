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
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


/**
 * Defines a market cell. <br>
 * When a family member is placed, MarketCell activates a set of quick effects.
 * 
 */

public class MarketCell {
	private FMember marketCellFM;
	private List<QuickEffect> effects = new ArrayList<>();
	
	
	public MarketCell() {
		
		marketCellFM = null;
		JSONParser parser = new JSONParser();

	    try {
	    	//Edit PATH (JSON cards file is now splitted in four different files)
	    	Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/Model/Cards/cards.json")); 
	    	JSONObject jsonObject = (JSONObject) obj;
	        JSONObject a = (JSONObject) jsonObject.get(1); //get(i.toString())
	        
	        
	        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
	        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
	        for(int count=0; count<qeffects.size(); count++){
	        	if(qeffects.get(count)!=null){
	        		if(qeffectvalues.get(count)!=null){
	        			this.add(HashMapQE.geteffect((String) qeffects.get(count)), (long) qeffectvalues.get(count));
	        		} else {
	        			this.effects.add(HashMapQE.geteffect((String) qeffects.get(count)));
	        		}
	        	}
	        }
	    }catch (FileNotFoundException e) {
	        System.out.println("File not found.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problem in parser");
		}
		
	}

	/**
	 * Places a FMember from PBoard to the cell
	 * @param pBoardFM
	 */
	public boolean insertFM (FMember pBoardFM, PBoard player) {
		
		if(this.isEmpty()){
			this.marketCellFM = pBoardFM;
			activateQEffects(player); 			//attivo effetti sul giocatore
			return true;
		} return false;
		//QuickEff activation gestita dal chiamante
	}
	
	/**
	 * Checks the cell's state (Empty/Full)
	 * @return a boolean state
	 */
	
	private boolean isEmpty() {
		if(this.marketCellFM==null){ 
			return true;		
		}
		else {
			return false;
		}	
	}
	
	
	private boolean add(QuickEffect marketQuickEffect, long quantity){
	    boolean isAdded = this.effects.add(marketQuickEffect);
	    if(isAdded){
		    marketQuickEffect.setQuantity(Math.toIntExact(quantity));
		    return true;
	    }
	    else
	    	return false;		
    }
	
	private void activateQEffects(PBoard player){
		for(int count=0; count<this.effects.size(); count++){
			QuickEffect marketQuickEffect = this.effects.get(count); //Sicuro mi da errore su Sonar
			marketQuickEffect.activate(player);
		}
	}
	
	public String toString(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Market cell number " + index + ":\n");
		
		if(marketCellFM != null){
			builder.append("Family Member in market cell number " + index + ":\n"
					+ "Player color: " + marketCellFM.getPlayercol() + "\n"
					+ "Family Member color: " + marketCellFM.getColor() + "\n"
					+ "Family Member value: " + marketCellFM.getValue() + "\n"
					);
		}
		else{
			builder.append("\nMarket cell is empty!");
		}
		builder.append("\n-----------------\n");
		return builder.toString();
	}

	/**
	 * @return the marketCellFM
	 */
	public FMember getMarketCellFM() {
		return marketCellFM;
	}

	/**
	 * @param marketCellFM the marketCellFM to set
	 */
	public void setMarketCellFM(FMember marketCellFM) {
		this.marketCellFM = marketCellFM;
	}
	
	
}
