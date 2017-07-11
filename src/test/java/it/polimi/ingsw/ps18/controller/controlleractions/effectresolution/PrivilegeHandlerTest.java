/**
 * 
 */
package it.polimi.ingsw.ps18.controller.controlleractions.effectresolution;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class PrivilegeHandlerTest.
 *
 * @author luca-grella
 */
public class PrivilegeHandlerTest {
	
	/** The index. */
	Integer index;

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.PrivilegeHandler#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testAct() throws FileNotFoundException, IOException, ParseException {
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/privilegesprova.json"));
//    	JSONObject jsonObject = (JSONObject) obj;
//        JSONObject a = (JSONObject) jsonObject.get(index.toString());
//        
//        PrivilegeHandler tester = new PrivilegeHandler();
//      
//        GameLogic game = new GameLogic();
//        PBoard turnplayer = new PBoard();
//        turnplayer.setPlayercol(1);
//		game.setCurrentPlayer(turnplayer );
//		tester.act(game);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.PrivilegeHandler#setIndex(int)}.
	 */
	@Test
	public void testSetIndex() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.effectresolution.PrivilegeHandler#geteffect(java.lang.String)}.
	 */
	@Test
	public void testGeteffect() {
		
	}

}
