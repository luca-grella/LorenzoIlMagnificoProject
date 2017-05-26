package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.personalBoard.resources.Stats;

public class YellowC extends Cards {
	private Stats effectCosts = new Stats(0,0,0,0,0,0,0);
	private int color = 2;
	private int value;
	private List<ProductionEffect> prodEffect = new ArrayList<>();

}
