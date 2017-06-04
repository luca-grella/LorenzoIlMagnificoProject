package it.polimi.ingsw.ps18.model.messages;

public class ParamMessage extends Message{
    private String message;
    private int number;
	
	
	public ParamMessage(String msg,int number) {
		this.message = msg;
		this.number = number;
		this.ID = 4;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the fam
	 */
	public int getNumber() {
		return number;
	}
	
	

}
