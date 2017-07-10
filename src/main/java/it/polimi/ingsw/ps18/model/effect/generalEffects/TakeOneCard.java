package it.polimi.ingsw.ps18.model.effect.generalEffects;

import java.util.Observable;

import org.json.simple.JSONArray;
import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class TakeAnyCard.
 */
public class TakeOneCard extends Observable implements FinalEffect, HarvestEffect, ProductionEffect, QuickEffect {
	
	/**
	 * The name.
	 */
	private String name = "Take one Card";
	
	/**
	 * The quantity.
	 */
	private int actionValue;
	
	private int chosenTower;
	
	private int tester=1;
	
	private Stats discount;
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		Action action = new FamtoTower(player.getpBoardView());
		game.setOngoingAction(action);
		((FamtoTower) action).getTotalDiscountPreview().addStats(discount);
		((FamtoTower) action).setChosenFam(new FMember(actionValue));
		((FamtoTower) action).setCanGoBacktoFamChoice(false);
		if(chosenTower!=-1){
			((FamtoTower) action).setCanGoBacktoTowerChoice(false);
			((FamtoTower) action).setChosenTower(chosenTower);
			
			if(tester!=999){
			((FamtoTower) action).floorChoice(game);}
		} else {
			if(tester!=999){
			((FamtoTower) action).towerChoice();}	
		}
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		return;
	}
	
	public void setParameters(long actionValue, String chosenTower, JSONArray discount){
		this.actionValue = (int) actionValue;
		if("Green".equals(chosenTower)){
			this.chosenTower=0;
		} else if("Blue".equals(chosenTower)){
			this.chosenTower=1;
		} else if("Yellow".equals(chosenTower)){
			this.chosenTower=2;
		} else if("Purple".equals(chosenTower)){
			this.chosenTower=3;
		} else {
			this.chosenTower=-1;
		}
		this.discount = new Stats(discount);
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder();
		switch(chosenTower){
		case -1:
			builder.append("Take a card from a Tower of your Choice with an Action Value of " + this.actionValue);
			break;
		case 0:
			builder.append("Take a card from the Green Tower with an Action Value of " + this.actionValue);
			break;
		case 1:
			builder.append("Take a card from the Blue Tower with an Action Value of " + this.actionValue);
			break;
		case 2:
			builder.append("Take a card from the Yellow Tower with an Action Value of " + this.actionValue);
			break;
		case 3:
			builder.append("Take a card from the Purple Tower with an Action Value of " + this.actionValue);
			break;
		default:
			builder.append("Take a card with an Action Value of " + this.actionValue);
		}
		if(! this.discount.isEmpty()){
			builder.append("\n\t with a discount of:\n" + discount.toStringCost());
		}
		return builder.toString();
	}

	/**
	 * @return
	 */
	public int getQuantity(int quantity) {
		
		return quantity;
	}

	/**
	 * 
	 */
	public void setChosenTower(int chosenTower) {
		this.chosenTower=chosenTower;
		
	}

	/**
	 * 
	 */
	public void setDiscount(Stats discount) {
		this.discount=discount;
		
	}

	/**
	 * @param i
	 */
	public void setTester(int tester) {
		this.tester=tester;
		
	}

}
