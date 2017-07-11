package it.polimi.ingsw.ps18.controller.controlleractions.effectresolution;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.effect.generalEffects.DifferentPrivilege;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addCoins;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addFP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addMP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addRock;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addServants;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addWood;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addWoodorRock;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;

/**
 * The Class DifferentPrivilegeHandler.
 */
public class DifferentPrivilegeHandler implements ActionChoice {
	
	/**
	 * The possibilities.
	 */
	private Map<String,GeneralEffect> possibilities = new HashMap<>();
	
	/**
	 * The effect.
	 */
	private List<GeneralEffect> effect = new ArrayList<>();
	
	/**
	 * The index.
	 */
	private Integer index;

	/**
	 * Act.
	 *
	 * @param game the game
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		init();
		DifferentPrivilege effect = (DifferentPrivilege) game.getOngoingEffect();
		List<Integer> previousChoices = effect.getPreviousChoices();
		if(!(previousChoices.contains(index))){
			previousChoices.add(index);
			JSONParser parser = new JSONParser();
			try {
				Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/effect/generalEffects/Privileges.json"));
		    	JSONObject jsonObject = (JSONObject) obj;
		        JSONObject a = (JSONObject) jsonObject.get(index.toString());
		        
		        JSONArray effects = (JSONArray) a.get("Effect");
		        JSONArray effectvalues = (JSONArray) a.get("Parameters");
		        for(int count=0; count<effects.size(); count++){
		        	if(effects.get(count)!=null){
		        		if(effectvalues.get(count)!=null){
		        			this.add(count,geteffect((String) effects.get(count)), (long) effectvalues.get(count));
		        		} else {
		        			this.effect.add(geteffect((String) effects.get(count)));
		        		}
		        	}
		        }
		        
		        for(int i = 0 ; i < this.effect.size() ; i++){
					GeneralEffect qeffect = this.effect.get(i);
					qeffect.activate(game.getTurnplayer(),game);
		        } this.effect.clear();
			}catch (FileNotFoundException e) {
		        System.out.println("File non trovato.");

		    } catch (IOException e) {
			    System.out.println("IOException");
			} catch (org.json.simple.parser.ParseException e) {
				System.out.println("Problema nel parser");
			}
		}
	}

	/**
	 * Sets the index.
	 *
	 * @param i the new index
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = new Integer(i);

	}
	
	/**
	 * Adds the.
	 *
	 * @param count
	 *            the count
	 * @param e
	 *            the e
	 * @param quantity
	 *            the quantity
	 */
	private void add(int count, GeneralEffect e, long quantity){
		GeneralEffect a = e;
		a.setQuantity((int) quantity);
	    (this.effect).add(count, a);	
    }
	
	/**
	 * Inits the.
	 */
	private void init(){
		possibilities.put("AddWoodorRock", new addWoodorRock());
		possibilities.put("AddServant", new addServants());
		possibilities.put("AddCoin", new addCoins());
		possibilities.put("AddPM", new addMP());
		possibilities.put("AddPF", new addFP());
	}
	
	/**
	 * Gets the effect.
	 *
	 * @param a
	 *            the a
	 * @return the effect
	 */
	public GeneralEffect geteffect(String a){
		return possibilities.get(a);
	}

}
