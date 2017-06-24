package it.polimi.ingsw.ps18.model.messages;

// TODO: Auto-generated Javadoc
/**
 * The Class ParamMessage.
 */
public class ParamMessage extends Message{
    
    /**
	 * The message.
	 */
    private String message;
    
    /**
	 * The number.
	 */
    private int number;
	
	
	/**
	 * Instantiates a new param message.
	 *
	 * @param msg
	 *            the msg
	 * @param number
	 *            the number
	 */
	public ParamMessage(String msg,int number) {
		this.message = msg;
		this.number = number;
		this.ID = 4;
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
	
	

}
