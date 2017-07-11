package it.polimi.ingsw.ps18.model.messagesandlogs;


/**
 * This type of message are supposed to be recived only by the Veiw and 
 * are going to be printed in the log, i.e. message that notify the successful
 * creation of an object.
 * @author Francesco-Musio
 *
 */
public class LogMessage  extends Message {
	
	/**
	 * The message.
	 */
	private String message;
	
	
	/**
	 * Instantiates a new log message.
	 *
	 * @param msg
	 *            the msg
	 */
	public LogMessage(String msg) {
		this.message = msg;
		this.ID = 1;
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
