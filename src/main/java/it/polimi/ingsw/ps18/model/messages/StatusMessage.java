package it.polimi.ingsw.ps18.model.messages;

/**
 * This kind of messages handles the request of showing any 
 * info about the game's current status.
 * @author Francesco-Musio
 *
 */
public class StatusMessage extends Message {
	private final int ID = 3;
	private String message;
	
	
	public StatusMessage(String msg) {
		this.message = msg;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
