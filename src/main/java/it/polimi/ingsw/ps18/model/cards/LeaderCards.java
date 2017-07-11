package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest;
import it.polimi.ingsw.ps18.model.effect.generalEffects.ActProduction;
import it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.*;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.*;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.*;

/**
 * The Class LeaderCards.
 */
public class LeaderCards {
	
	/** The name. */
	private String name;
	
	/** The active. */
	private boolean active;
	
	/** The effectactivated. */
	private boolean effectactivated = false;
	
	/** The requirements. */
	private List<LCRequirement> requirements = new ArrayList<>();
	
	/** The quick effects. */
	private List<LCQuickEffect> quickEffects = new ArrayList<>();
	
	/** The perm effects. */
	private List<LCPermEffect> permEffects = new ArrayList<>();

	
	/**
	 * Instantiates a new leader cards.
	 *
	 * @param a the a
	 */
	public LeaderCards(JSONObject a){
		this.name = (String) a.get("name");
		this.active = (boolean) a.get("active");
		JSONArray requirements = (JSONArray) a.get("Requirements");
		JSONArray requirementvalues = (JSONArray) a.get("RequirementValues");
		this.addRequirements(requirements, requirementvalues);
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectValues");
		this.addQEffects(qeffects, qeffectvalues);
		JSONArray peffects = (JSONArray) a.get("PermanentEffects");
		JSONArray peffectvalues = (JSONArray) a.get("PermanentEffectValues");
		this.addPEffects(peffects, peffectvalues);
		
	}


	/**
	 * Adds the P effects.
	 *
	 * @param peffects the peffects
	 * @param peffectvalues the peffectvalues
	 */
	private void addPEffects(JSONArray peffects, JSONArray peffectvalues) {
		for(int i=0; i<peffects.size(); i++){
			HashMapLCP map = new HashMapLCP();
			if(peffects.get(i)!=null){
				if(peffectvalues.get(i)!=null){
					LCPermEffect effect;
					if("TowerDiscount".equals(peffects.get(i))){
						effect = map.getLCPermEffect((String) peffects.get(i));
						((TowerDiscount) effect).setParam((JSONArray) peffectvalues.get(i));
						this.permEffects.add(effect);
					} else if("ModifierValue".equals(peffects.get(i))){
						effect = map.getLCPermEffect((String) peffects.get(i));
						((ModifierValue) effect).setParam((JSONArray) peffectvalues.get(i));
						this.permEffects.add(effect);
					} else if("VariousModifier".equals(peffects.get(i))){
						effect = map.getLCPermEffect((String) peffects.get(i));
						((VariousModifier) effect).setParam((String) peffectvalues.get(i));
						this.permEffects.add(effect);
					}
				} else {
					this.permEffects.add(map.getLCPermEffect((String) peffects.get(i)));
				}
			}
		}
		
	}


	/**
	 * Adds the Q effects.
	 *
	 * @param qeffects the qeffects
	 * @param qeffectvalues the qeffectvalues
	 */
	private void addQEffects(JSONArray qeffects, JSONArray qeffectvalues) {
		for(int i=0; i<qeffects.size(); i++){
			HashMapLCQ map = new HashMapLCQ();
			if(qeffects.get(i)!=null){
				if(qeffectvalues.get(i)!=null){
					LCQuickEffect effect;
					if("ActivateHarvest".equals(qeffects.get(i))){
						effect = map.getLCQuickEffect((String) qeffects.get(i));
						long temp = (long) qeffectvalues.get(i);
						((ActHarvest) effect).setQuantity((int) temp);
						this.quickEffects.add(effect);
					} else if("ActivateProduction".equals(qeffects.get(i))){
						effect = map.getLCQuickEffect((String) qeffects.get(i));
						long temp = (long) qeffectvalues.get(i);
						((ActProduction) effect).setQuantity((int) temp);
						this.quickEffects.add(effect);
					} else if("AddResources".equals(qeffects.get(i))){
						effect = map.getLCQuickEffect((String) qeffects.get(i));
						((AddResources) effect).setParam((JSONArray) qeffectvalues.get(i));
						this.quickEffects.add(effect);
					} else if("AddPC".equals(qeffects.get(i))){
						effect = map.getLCQuickEffect((String) qeffects.get(i));
						long temp = (long) qeffectvalues.get(i);
						((Privilege) effect).setQuantity((int) temp);
						this.quickEffects.add(effect);
					} else if("ChangeFamValue".equals(qeffects.get(i))){
						effect = map.getLCQuickEffect((String) qeffects.get(i));
						long temp = (long) qeffectvalues.get(i);
						((ChangeFamValue) effect).setParam((int) temp);
						this.quickEffects.add(effect);
					}
				} else {
					this.quickEffects.add(map.getLCQuickEffect((String) qeffects.get(i)));
				}
			}
		}
	}


	/**
	 * Adds the requirements.
	 *
	 * @param requirements the requirements
	 * @param requirementvalues the requirementvalues
	 */
	private void addRequirements(JSONArray requirements, JSONArray requirementvalues) {
		for(int i=0; i<requirements.size(); i++){
			HashMapLCR map = new HashMapLCR();
			if(requirements.get(i)!=null){
				if(requirementvalues.get(i)!=null){
					LCRequirement effect;
					if("CheckNumberCardType".equals(requirements.get(i))){
						effect = map.getRequirement((String) requirements.get(i));
						JSONArray parameters = (JSONArray) requirementvalues.get(i);
						((CheckNumberCardType) effect).setParam((String) parameters.get(0), (long) parameters.get(1));
						this.requirements.add(effect);
					} else if("CheckResources".equals(requirements.get(i))){
						effect = map.getRequirement((String) requirements.get(i));
						((CheckResources) effect).setParam((JSONArray) requirementvalues.get(i));
						this.requirements.add(effect);
					} else if("CheckMinimumSameTypeCards".equals(requirements.get(i))){
						effect = map.getRequirement((String) requirements.get(i));
						((CheckMinimumSameTypeCards) effect).setParam((long) requirementvalues.get(i));
						this.requirements.add(effect);
					} else if("CheckMinimumAllTypeCards".equals(requirements.get(i))){
						effect = map.getRequirement((String) requirements.get(i));
						((CheckMinimumAllTypeCards) effect).setParam((long) requirementvalues.get(i));
						this.requirements.add(effect);
					}
				} else {
					this.requirements.add(map.getRequirement((String) requirements.get(i)));
				}
			}
		}
	}
	
	/**
	 * To string.
	 *
	 * @param index the index
	 * @return the string
	 */
	public String toString(int index){
		StringBuilder builder = new StringBuilder();
		builder.append("Card number " + index + ":\n"
				+ "\tname: " + this.name + "\n");
		builder.append("\tRequirements for activation:\n");
		for(int i=0; i<requirements.size(); i++){
			builder.append("\t\t" + i + ": " + requirements.get(i).toString() + "\n");
		}
		if(hasLCQE()){
			builder.append("\tQuick Effects:\n");
			for(int i=0; i<quickEffects.size(); i++){
				builder.append("\t\t" + i + ": " + quickEffects.get(i).toString() + "\n");
			}
		}
		if(hasLCPE()){
			builder.append("\tPermanent Effects:\n");
			for(int i=0; i<permEffects.size(); i++){
				builder.append("\t\t" + i + ": " + permEffects.get(i).toString() + "\n");
			}
		}
		return builder.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("name: " + this.name + "\n");
		builder.append("\tRequirements for activation:\n");
		for(int i=0; i<requirements.size(); i++){
			builder.append("\t\t" + i + ": " + requirements.get(i).toString() + "\n");
		}
		if(hasLCQE()){
			builder.append("\tQuick Effects:\n");
			for(int i=0; i<quickEffects.size(); i++){
				builder.append("\t\t" + i + ": " + quickEffects.get(i).toString() + "\n");
			}
		}
		if(hasLCPE()){
			builder.append("\tPermanent Effects:\n");
			for(int i=0; i<permEffects.size(); i++){
				builder.append("\t\t" + i + ": " + permEffects.get(i).toString() + "\n");
			}
		}
		return builder.toString();
	}
	
	/**
	 * Checks for LCQE.
	 *
	 * @return true, if successful
	 */
	public boolean hasLCQE(){
		if(this.quickEffects.isEmpty()){
			return false;
		}
		return true;
	}
	
	/**
	 * Checks for LCPE.
	 *
	 * @return true, if successful
	 */
	public boolean hasLCPE(){
		if(this.permEffects.isEmpty()){
			return false;
		}
		return true;
	}


	/**
	 * Checks if is active.
	 *
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}


	/**
	 * Sets the active.
	 *
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}


	/**
	 * Gets the requirements.
	 *
	 * @return the requirements
	 */
	public List<LCRequirement> getRequirements() {
		return requirements;
	}


	/**
	 * Gets the quick effects.
	 *
	 * @return the quickEffects
	 */
	public List<LCQuickEffect> getQuickEffects() {
		return quickEffects;
	}


	/**
	 * Gets the perm effects.
	 *
	 * @return the permEffects
	 */
	public List<LCPermEffect> getPermEffects() {
		return permEffects;
	}


	/**
	 * Checks if is effectactivated.
	 *
	 * @return the effectactivated
	 */
	public boolean isEffectactivated() {
		return effectactivated;
	}


	/**
	 * Sets the effectactivated.
	 *
	 * @param effectactivated the effectactivated to set
	 */
	public void setEffectactivated(boolean effectactivated) {
		this.effectactivated = effectactivated;
	}


	/**
	 * Sets the quick effects.
	 *
	 * @param quickEffects the quickEffects to set
	 */
	public void setQuickEffects(List<LCQuickEffect> quickEffects) {
		this.quickEffects = quickEffects;
	}


	/**
	 * Sets the perm effects.
	 *
	 * @param permEffects the permEffects to set
	 */
	public void setPermEffects(List<LCPermEffect> permEffects) {
		this.permEffects = permEffects;
	}
	
	
	
	
}
