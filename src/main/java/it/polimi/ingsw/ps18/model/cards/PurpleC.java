package it.polimi.ingsw.ps18.model.cards;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;


public class PurpleC extends Cards {
	private List<FinalEffect> fineffect = new ArrayList<>();
	
	public PurpleC(Integer i) {
		JSONParser parser = new JSONParser();

	    try {
	    	Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/Model/Cards/GreenC.json"));
	    	JSONObject jsonObject = (JSONObject) obj;
	        JSONObject a = (JSONObject) jsonObject.get(i.toString());
	        
	        this.setName((String) a.get("name"));
	        this.setID((long) a.get("number"));
	        this.setColor((long) a.get("color"));
	        this.setPeriod((long) a.get("period"));
	        
	    }catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}
	}
	
	
	/**
	 * @return the fineffect
	 */
	public List<FinalEffect> getFineffect() {
		return fineffect;
	}
	/**
	 * @param fineffect the fineffect to set
	 */
	public void setFineffect(List<FinalEffect> fineffect) {
		this.fineffect = fineffect;
	}
	
	

}
