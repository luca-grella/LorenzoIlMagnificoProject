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
public class LogMessageTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage#LogMessage(java.lang.String)}.
	 */
	@Test
	public void testLogMessage() {
		String msg = "ciao";
		LogMessage tester = new LogMessage(msg );
		int ris = tester.getID();
		String ris2 = tester.getMessage();
		
		assertEquals(1, ris);
		assertEquals(msg, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		String msg = "ciao";
		LogMessage tester = new LogMessage(msg );
		
		String ris2 = tester.getMessage();
		
		
		assertEquals(msg, ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.Message#getID()}.
	 */
	@Test
	public void testGetID() {
		String msg = "ciao";
		LogMessage tester = new LogMessage(msg );
		int ris = tester.getID();
		
		
		assertEquals(1, ris);
	}

}
