package it.polimi.ingsw.ps18.model.personalboard;

import it.polimi.ingsw.ps18.model.gameLogic.Dice;

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
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Owner's Color: " + this.playercol);
		builder.append("\nMember's color: " + this.color);
		builder.append("\nMember's value: " + this.value);
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
