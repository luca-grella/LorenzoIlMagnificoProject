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
public class MessageTest {

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
