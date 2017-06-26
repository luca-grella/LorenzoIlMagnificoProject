package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.HashMapExcomm;
import it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforMP;
import it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforVP;


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
	private void addEffects(JSONArray eeffects, JSONArray eeffectvalues, HashMapExcomm mapExcomm){
		ExcommEffects effect;
		JSONArray valueffect;
		for(int pos=0; pos<eeffects.size(); pos++){
			if(eeffects.get(pos)!=null){
				switch((String) eeffects.get(pos)){
				case "LoseVPforVP":
					effect = mapExcomm.geteffect((String) eeffects.get(pos));
					valueffect = (JSONArray) eeffectvalues.get(pos);
					((LoseVPforVP) effect).setVEx((long) valueffect.get(0), (long) valueffect.get(1));
					this.effects.add(pos, effect);
					break;
				case "LoseVPforMP":
					effect = mapExcomm.geteffect((String) eeffects.get(pos));
					valueffect = (JSONArray) eeffectvalues.get(pos);
					((LoseVPforMP) effect).setVEx((long) valueffect.get(0), (long) valueffect.get(1));
					this.effects.add(pos, effect);
					break;
				default:
					if(eeffectvalues.get(pos)!=null){
		        		this.add(mapExcomm.geteffect((String) eeffects.get(pos)), (long) eeffectvalues.get(pos));
		        		} else {
		        			this.effects.add(mapExcomm.geteffect((String) eeffects.get(pos)));
	        		}
				}
			}
		}
	}
	
	
	
	
	
	
	/**
	 * Adds the.
	 *
	 * @param e
	 *            the e
	 * @param quantity
	 *            the quantity
	 * @return true, if successful
	 */
	private boolean add(ExcommEffects e, long quantity){
		ExcommEffects a = e;
		a.setQuantity((int) quantity);
	    return (this.getEffects()).add(a);
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
		builder.append("Card number " + pos + ":\n"
				+ "\tID: " + this.getID() + "\n"
				+ "\tPeriod: " + this.getPeriod() + "\n"
				);
		builder.append("Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString());
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
