/**
 * 
 */
package it.polimi.ingsw.ps18.model.messagesandlogs;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class StatusMessageTest.
 *
 * @author luca-grella
 */
public class StatusMessageTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage#StatusMessage(java.lang.String)}.
	 */
	@Test
	public void testStatusMessage() {
		String msg = "ciao";
		StatusMessage tester = new StatusMessage(msg );
		int ris = tester.getID();
		String ris2 = tester.getMessage();
		
		assertEquals(3,ris);
		assertEquals(msg,ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		String msg = "ciao";
		StatusMessage tester = new StatusMessage(msg );

		String ris2 = tester.getMessage();
		
		assertEquals(msg,ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.Message#getID()}.
	 */
	@Test
	public void testGetID() {
		String msg = "ciao";
		StatusMessage tester = new StatusMessage(msg );
		int ris = tester.getID();
		
		
		assertEquals(3,ris);
	
	}

}
