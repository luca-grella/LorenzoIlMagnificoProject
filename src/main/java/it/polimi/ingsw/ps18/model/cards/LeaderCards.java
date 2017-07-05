package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.effect.leaderEffects.*;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.LCQuickEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.LCRequirement;

/**
 * The Class LeaderCards.
 */
public class LeaderCards {
	private String name;
	private boolean active;
	private List<LCRequirement> requirements = new ArrayList<>();
	private List<LCQuickEffect> quickEffects = new ArrayList<>();
	private List<LCPermEffect> permEffects = new ArrayList<>();

}
