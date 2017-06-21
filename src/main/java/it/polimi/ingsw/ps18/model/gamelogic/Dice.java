package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.Random;

public class Dice {
	private int color;
	private int value;
	
	
	/**
	 * Constructor. Generate the value and assign it to the dice
	 * @param color value the indicates color. Assigned to the dice
	 */
	public Dice(int color){
		Random rand = new Random();
		this.color = color;
		this.value = 999;
//		this.value = rand.nextInt(5) + 1;
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
