package it.polimi.ingsw.ps18.controller.controlleractions.effectresolution;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.effect.generalEffects.GeneralEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;

public class PrivilegeHandler implements ActionChoice {
	private List<GeneralEffect> effect = new ArrayList<>();
	private Integer index;

	@Override
	public void act(GameLogic game) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/effect/generalEffect/Privileges.json"));
	    	JSONObject jsonObject = (JSONObject) obj;
	        JSONObject a = (JSONObject) jsonObject.get(index.toString());
	        
	        JSONArray effects = (JSONArray) a.get("Effects");
	        JSONArray effectvalues = (JSONArray) a.get("Parameters");
	        for(int count=0; count<effects.size(); count++){
	        	if(effects.get(count)!=null){
//	        		if(effectvalues.get(count)!=null){
//	        			this.add(mapQE.geteffect((String) effects.get(count)), (long) effectvalues.get(count));
//	        		} else {
//	        			this.effects.add(mapQE.geteffect((String) effects.get(count)));
//	        		}
	        	}
	        }
		
		}catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = new Integer(i);

	}

}
