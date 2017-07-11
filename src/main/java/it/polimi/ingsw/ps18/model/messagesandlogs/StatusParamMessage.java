package it.polimi.ingsw.ps18.model.messagesandlogs;

/**
 * The Class StatusParamMessage.
 */
public class StatusParamMessage extends Message {

    /**
	 * The message.
	 */
    private String message;
    
    /**
	 * The number.
	 */
    private int number = -1;
    
    /** The color. */
    private int color;
    
	
	/**
	 * Instantiates a new param message.
	 *
	 * @param msg            the msg
	 * @param color the color
	 * @param number            the number
	 */
	public StatusParamMessage(String msg, int color, int number) {
		this.message = msg;
		this.color = color;
		this.number = number;
		this.ID = 5;
	}

	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the number.
	 *
	 * @return the fam
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public int getColor(){
		return color;
	}
}
