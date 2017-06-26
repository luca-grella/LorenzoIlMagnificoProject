package it.polimi.ingsw.ps18.model.messagesandlogs;

// TODO: Auto-generated Javadoc
/**
 * This kind of messages handles the request of showing any 
 * info about the game's current status.
 * @author Francesco-Musio
 *
 */
public class StatusMessage extends Message {
	
	/**
	 * The message.
	 */
	private String message;
	
	
	/**
	 * Instantiates a new status message.
	 *
	 * @param msg
	 *            the msg
	 */
	public StatusMessage(String msg) {
		this.message = msg;
		this.ID = 3;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	

}
