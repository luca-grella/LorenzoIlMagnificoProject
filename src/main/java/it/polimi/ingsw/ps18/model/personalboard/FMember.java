package it.polimi.ingsw.ps18.model.personalboard;

import it.polimi.ingsw.ps18.model.gamelogic.Dice;

public class FMember {
	private int playercol;
	private int color;
	private int value;
	
	public FMember(Dice dice, int playercol){
		this.value = dice.getValue();
		this.color = dice.getColor();
		this.playercol = playercol;
	}
	
	public FMember(int value, int playercol){
		this.value = value;
		this.color = -1;
		this.playercol = playercol;
	}
	
	/**
	 * Fmember farlocco per prendere la carta da effetto di un'altra carta
	 * @param value
	 */
	public FMember(int value){
		this.value = value;
		this.color = -2;
		this.playercol = -2;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("\n   Owner's Color: " + this.playercol);
		builder.append("\n   Member's color: " + this.color);
		builder.append("\n   Member's value: " + this.value);
		return builder.toString();
	}

	/**
	 * @return the playercol
	 */
	public int getPlayercol() {
		return playercol;
	}



	/**
	 * @param playercol the playercol to set
	 */
	public void setPlayercol(int playercol) {
		this.playercol = playercol;
	}



	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

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
	
	
	
	

}
