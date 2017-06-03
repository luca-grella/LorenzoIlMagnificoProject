package it.polimi.ingsw.ps18.model.messages;

/**
 * This kind of messages handles the request of showing any 
 * info about the game's current status.
 * @author Francesco-Musio
 *
 */
public class StatusMessage extends Message {
	private String message;
	
	
	public StatusMessage(String msg) {
		this.message = msg;
		this.ID = 3;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
