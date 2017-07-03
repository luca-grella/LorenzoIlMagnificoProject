package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import it.polimi.ingsw.ps18.model.effect.excommEffects.*;


/**
 * The Class Excommunications.
 */
public class Excommunications {
	
	/**
	 * The effects.
	 */
	public List<ExcommEffects> effects = new ArrayList<>();
	
	/**
	 * The id.
	 */
	private long ID;
	
	/**
	 * The period.
	 */
	private long period;

	public Excommunications(JSONObject a){
		HashMapExcomm mapExcomm = new HashMapExcomm();
		
		this.setID((long) a.get("number"));
		this.setPeriod((long) a.get("period"));
		JSONArray eeffects = (JSONArray) a.get("Effects");
		JSONArray eeffectvalues = (JSONArray) a.get("EffectsValues");
		addEffects(eeffects, eeffectvalues, mapExcomm);
	}

	
	
	/**
	 * Adds the effects.
	 *
	 * @param eeffects
	 *            the eeffects
	 * @param eeffectvalues
	 *            the eeffectvalues
	 * @param mapExcomm
	 *            the map excomm
	 */
	private void addEffects(JSONArray eeffects, JSONArray eeffectvalues, HashMapExcomm map){
		ExcommEffects effect;
		for(int pos=0; pos<eeffects.size(); pos++){
			if(eeffects.get(pos)!=null){
				if(eeffectvalues.get(pos)!=null){
					if("MalusResources".equals(eeffects.get(pos))){
						effect = map.geteffect((String) eeffects.get(pos));
						((MalusResources) effect).setMalus((JSONArray) eeffectvalues.get(0));
						this.effects.add(effect);
					}
					if("MalusValue".equals(eeffects.get(pos))){
						effect = map.geteffect((String) eeffects.get(pos));
						((MalusValue) effect).setName((String) eeffectvalues.get(0)); 
						long temp = (long) eeffectvalues.get(1);
						((MalusValue) effect).setQuantity((int) temp);
						this.effects.add(effect);
					}
					if("IgnoreCards".equals(eeffects.get(pos))){
						effect = map.geteffect((String) eeffects.get(pos));
						((IgnoreCards) effect).setName((String) eeffectvalues.get(0));
						this.effects.add(effect);
					}
					if("LoseVPforVP".equals(eeffects.get(pos))){
						effect = map.geteffect((String) eeffects.get(pos));
						((LoseVPforVP) effect).setExcommParam((JSONArray) eeffectvalues.get(0));
						this.effects.add(effect);
					}
					if("LoseVPforMP".equals(eeffects.get(pos))){
						effect = map.geteffect((String) eeffects.get(pos));
						((LoseVPforMP) effect).setExcommParam((JSONArray) eeffectvalues.get(0));
						this.effects.add(effect);
					}
					if("LoseVPforCosts".equals(eeffects.get(pos))){
						effect = map.geteffect((String) eeffects.get(pos));
						long temp = (long) eeffectvalues.get(0);
						((LoseVPforCosts) effect).setQuantity((int) temp);
						this.effects.add(effect);
					}
					if("LoseVPforResources".equals(eeffects.get(pos))){
						effect = map.geteffect((String) eeffects.get(pos));
						long temp = (long) eeffectvalues.get(0);
						((LoseVPforResources) effect).setQuantity((int) temp);
						this.effects.add(effect);
					}
				}
			}
		}
	}
	

	/**
	 * To string.
	 *
	 * @param pos
	 *            the pos
	 * @return the string
	 */
	public String toString(int pos){
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Card number " + pos + ":\n"
				+ "\tID: " + this.getID() + "\n"
				+ "\tPeriod: " + this.getPeriod() + "\n"
				);
		builder.append("Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
		}

		return builder.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Current Card:\n"
				+ "\tID: " + this.getID() + "\n"
				+ "\tPeriod: " + this.getPeriod() + "\n"
				);
		builder.append("Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
		}

		return builder.toString();
	}


	/**
	 * Gets the id.
	 *
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}

	/**
	 * Sets the id.
	 *
	 * @param iD
	 *            the iD to set
	 */
	public void setID(long iD) {
		ID = iD;
	}
	
	/**
	 * Gets the period.
	 *
	 * @return the period
	 */
	public long getPeriod() {
		return period;
	}

	/**
	 * Sets the period.
	 *
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(long period) {
		this.period = period;
	}
	
	/**
	 * Gets the effects.
	 *
	 * @return the effects
	 */
	public List<ExcommEffects> getEffects() {
		return effects;
	}

	/**
	 * Sets the effects.
	 *
	 * @param effects
	 *            the effects to set
	 */
	public void setEffects(List<ExcommEffects> effects) {
		this.effects = effects;
	}
	

	/**
	 * Checks for effect.
	 *
	 * @return true, if successful
	 */
	public boolean hasEffect() {
		if(effects.isEmpty()){
			return false;
		}
		return true;
	}

	
	
}
