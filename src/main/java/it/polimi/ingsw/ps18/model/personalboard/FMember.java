package it.polimi.ingsw.ps18.model.personalboard;

import it.polimi.ingsw.ps18.model.gamelogic.Dice;

// TODO: Auto-generated Javadoc
/**
 * The Class FMember.
 */
public class FMember {
	
	/**
	 * The playercol.
	 */
	private int playercol;
	
	/**
	 * The color.
	 */
	private int color;
	
	/**
	 * The value.
	 */
	private int value;
	
	/**
	 * Instantiates a new f member.
	 *
	 * @param dice
	 *            the dice
	 * @param playercol
	 *            the playercol
	 */
	public FMember(Dice dice, int playercol){
		this.value = dice.getValue();
		this.color = dice.getColor();
		this.playercol = playercol;
	}
	
	/**
	 * Instantiates a new f member.
	 *
	 * @param value
	 *            the value
	 * @param playercol
	 *            the playercol
	 */
	public FMember(int value, int playercol){
		this.value = value;
		this.color = -1;
		this.playercol = playercol;
	}
	
	/**
	 * Fmember farlocco per prendere la carta da effetto di un'altra carta.
	 *
	 * @param value
	 *            the value
	 */
	public FMember(int value){
		this.value = value;
		this.color = -2;
		this.playercol = -2;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("\n   Owner's Color: " + this.playercol);
		builder.append("\n   Member's color: " + this.color);
		builder.append("\n   Member's value: " + this.value);
		return builder.toString();
	}

	/**
	 * Gets the playercol.
	 *
	 * @return the playercol
	 */
	public int getPlayercol() {
		return playercol;
	}



	/**
	 * Sets the playercol.
	 *
	 * @param playercol
	 *            the playercol to set
	 */
	public void setPlayercol(int playercol) {
		this.playercol = playercol;
	}



	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color
	 *            the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
	
	
	

}
