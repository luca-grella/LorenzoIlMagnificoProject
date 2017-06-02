package it.polimi.ingsw.ps18.model.messages;

/**
 * This type of message are supposed to be recived only by the Veiw and 
 * are going to be printed in the log, i.e. message that notify the successful
 * creation of an object.
 * @author Francesco-Musio
 *
 */
public class ActionMessage  extends Message {
	private String message;
	
	
	public ActionMessage(String msg) {
		this.message = msg;
		this.ID = 2;
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