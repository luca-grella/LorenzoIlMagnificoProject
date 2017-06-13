package it.polimi.ingsw.ps18.model.cards;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;




import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.HashMapExcomm;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;

public class Excommunications {
	public List<ExcommEffects> effects = new ArrayList<>();

	public Excommunications(Integer i){
		JSONParser parser = new JSONParser();
		HashMapExcomm mapExcomm = new HashMapExcomm();
		
		try {
	    	Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/Excommunications.json"));
	    	JSONObject jsonObject = (JSONObject) obj;
	        JSONObject a = (JSONObject) jsonObject.get(i.toString());
	        this.setID((long) a.get("number"));
	        this.setPeriod((long) a.get("period"));
	        JSONArray eeffects = (JSONArray) a.get("Effects");
	        JSONArray eeffectvalues = (JSONArray) a.get("EffectsValues");
	        addEffects(eeffects,eeffectvalues,mapExcomm);
	        
	    }catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}
	}

	private void addEffects(JSONArray eeffects, JSONArray eeffectvalues, HashMapExcomm mapExcomm) {
		// TODO Auto-generated method stub
		
	}

	private void setPeriod(long l) {
		// TODO Auto-generated method stub
		
	}

	private void setID(long l) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
