package it.polimi.ingsw.ps18.model.cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;

public class GreenC extends Cards {
	private int color = 0;
	private int harvValue;
	private List<HarvestEffect> harveffect = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	public GreenC(){
		JSONParser parser = new JSONParser();
		
		System.out.println(new File(".").getAbsoluteFile());

	    try {
	    	
	    	
	        Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/Model/Cards/cards.json"));


	        JSONObject jsonObject = (JSONObject) obj;
	        //System.out.println(jsonObject);

	        this.setID((int) jsonObject.get("number"));
	        this.setName((String) jsonObject.get("name"));
	        this.setID((int) jsonObject.get("period"));
	        this.setID((int) jsonObject.get("color"));
	        
	   

	       
	    }catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}
	}
	
	
//	private boolean add(QuickEffect e, int quantity){
//	boolean ris = this.effects.add(e);
//	if(ris){
//		QuickEffect effect = this.effects.get(this.effects.lastIndexOf(e));
//		effect.setQuantity(quantity);
//		return true;
//	}
//	return false;		
//}

	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * @return the harvValue
	 */
	public int getHarvValue() {
		return harvValue;
	}

	/**
	 * @param harvValue the harvValue to set
	 */
	public void setHarvValue(int harvValue) {
		this.harvValue = harvValue;
	}

	/**
	 * @return the harveffect
	 */
	public List<HarvestEffect> getHarveffect() {
		return harveffect;
	}

	/**
	 * @param harveffect the harveffect to set
	 */
	public void setHarveffect(List<HarvestEffect> harveffect) {
		this.harveffect = harveffect;
	}
	

	
	

}
