package it.polimi.ingsw.ps18.model.messagesandlogs;

// TODO: Auto-generated Javadoc
/**
 * This type of message are supposed to be recived only by the Veiw and 
 * are going to be printed in the log, i.e. message that notify the successful
 * creation of an object.
 * @author Francesco-Musio
 *
 */
public class ActionMessage  extends Message {
	
	/**
	 * The message.
	 */
	private String message;
	
	
	/**
	 * Instantiates a new action message.
	 *
	 * @param msg
	 *            the msg
	 */
	public ActionMessage(String msg) {
		this.message = msg;
		this.ID = 2;
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