package it.polimi.ingsw.ps18.model.effect.excommEffects;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class LoseVPforCosts.
 */
public class LoseVPforCosts implements ExcommEffects {

	
	/**
	 * The lose VP.
	 */
	private int loseVP;
	
	/**
	 * The name.
	 */
	private String name = "LoseVpforCosts";
	
	
	public void activate(PBoard player){
		int count = 0;
		for(Cards card: player.getCards()){
			if(card.getColor() == 2){
				Stats cost = card.getCardCost();
				count += cost.getWood();
				count += cost.getRock();
			}
		}
		Stats resources = player.getResources();
		resources.addVP((int) - (count * loseVP));
	}
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity){
		this.loseVP=quantity;
	}
	
	/**
	 * Gets the lose VP.
	 *
	 * @return the loseVP
	 */
	public int getLoseVP() {
		return loseVP;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return "Lose " + loseVP + " Victory Point for each wood or rock represented on each yellow card in your PBoard";
	}

}
