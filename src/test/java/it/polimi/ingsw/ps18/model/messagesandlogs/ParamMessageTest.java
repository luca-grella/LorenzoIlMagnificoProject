/**
 * 
 */
package it.polimi.ingsw.ps18.model.messagesandlogs;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author luca-grella
 *
 */
public class ParamMessageTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage#ParamMessage(java.lang.String, int)}.
	 */
	@Test
	public void testParamMessage() {
		
		String msg = "ciao";
		int number =1;
		ParamMessage tester = new ParamMessage(msg, number );
		
		int ris = tester.getID();
		String ris2 = tester.getMessage();
		int ris3 = tester.getNumber();
		
		assertEquals(4,ris);
		assertEquals(msg,ris2);
		assertEquals(number, ris3);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		String msg = "ciao";
		int number =1;
		ParamMessage tester = new ParamMessage(msg, number );
		
		
		String ris2 = tester.getMessage();
		
		
		
		assertEquals(msg,ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage#getNumber()}.
	 */
	@Test
	public void testGetNumber() {
		String msg = "ciao";
		int number =1;
		ParamMessage tester = new ParamMessage(msg, number );
		
		int ris3 = tester.getNumber();
		
		
		assertEquals(number, ris3);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.Message#getID()}.
	 */
	@Test
	public void testGetID() {
		String msg = "ciao";
		int number =1;
		ParamMessage tester = new ParamMessage(msg, number );
		
		int ris = tester.getID();
		
		
		assertEquals(4,ris);
		
	}

}
