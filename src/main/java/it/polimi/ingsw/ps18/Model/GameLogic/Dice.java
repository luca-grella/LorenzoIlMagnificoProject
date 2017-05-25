package it.polimi.ingsw.ps18.Model.GameLogic;

public class Dice {
	private int color;
	private int value;
	
	public Dice(int color){
		this.color = color;
		//gen. random value
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
	
	

}
