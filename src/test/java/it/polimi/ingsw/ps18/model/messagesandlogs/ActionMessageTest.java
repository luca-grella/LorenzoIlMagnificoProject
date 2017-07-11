/**
 * 
 */
package it.polimi.ingsw.ps18.model.messagesandlogs;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class ActionMessageTest.
 *
 * @author luca-grella
 */
public class ActionMessageTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage#ActionMessage(java.lang.String)}.
	 */
	@Test
	public void testActionMessage() {
		String msg = "ciao";
		ActionMessage tester = new ActionMessage(msg );
		int ris = tester.getID();
		String ris2 = tester.getMessage();
		
		assertEquals(2, ris);
		assertEquals(msg, ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		String msg = "ciao";
		ActionMessage tester = new ActionMessage(msg );

		String ris2 = tester.getMessage();
		
		
		assertEquals(msg, ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.messagesandlogs.Message#getID()}.
	 */
	@Test
	public void testGetID() {
		String msg = "ciao";
		ActionMessage tester = new ActionMessage(msg );
		int ris = tester.getID();
	
		
		assertEquals(2, ris);
	}

}
