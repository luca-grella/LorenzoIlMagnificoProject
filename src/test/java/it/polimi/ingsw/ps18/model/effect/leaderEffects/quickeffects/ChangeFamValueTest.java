/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * @author luca-grella
 *
 */
public class ChangeFamValueTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.ChangeFamValue#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.ChangeFamValue#continueEffect(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testContinueEffect() {
		
		ChangeFamValue tester = new ChangeFamValue();
		tester.setChoice(0);
		int newvalue = 5;
		tester.setParam(newvalue );
		PBoard player = new PBoard();
		List<FMember> fams = new ArrayList<>();
		Dice dice = new Dice(4);
		FMember e = new FMember(dice , 2);
		e.setValue(1);
		fams.add(e );
		player.setFams(fams );
		tester.continueEffect(player, new GameLogic());
		int ris= player.getFams().get(0).getValue();
		assertEquals(newvalue, ris);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.ChangeFamValue#setParam(int)}.
	 */
	@Test
	public void testSetParam() {
		ChangeFamValue tester = new ChangeFamValue();
		tester.setChoice(0);
		int newvalue = 5;
		tester.setParam(newvalue );
		PBoard player = new PBoard();
		List<FMember> fams = new ArrayList<>();
		Dice dice = new Dice(4);
		FMember e = new FMember(dice , 2);
		e.setValue(1);
		fams.add(e );
		player.setFams(fams );
		tester.continueEffect(player, new GameLogic());
		int ris= player.getFams().get(0).getValue();
		assertEquals(newvalue, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.ChangeFamValue#setChoice(int)}.
	 */
	@Test
	public void testSetChoice() {
		ChangeFamValue tester = new ChangeFamValue();
		tester.setChoice(0);
		int newvalue = 5;
		tester.setParam(newvalue );
		PBoard player = new PBoard();
		List<FMember> fams = new ArrayList<>();
		Dice dice = new Dice(4);
		FMember e = new FMember(dice , 2);
		e.setValue(1);
		fams.add(e );
		player.setFams(fams );
		tester.continueEffect(player, new GameLogic());
		int ris= player.getFams().get(0).getValue();
		assertEquals(newvalue, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.quickeffects.ChangeFamValue#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#Observable()}.
	 */
	@Test
	public void testObservable() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#addObserver(java.util.Observer)}.
	 */
	@Test
	public void testAddObserver() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#deleteObserver(java.util.Observer)}.
	 */
	@Test
	public void testDeleteObserver() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#notifyObservers()}.
	 */
	@Test
	public void testNotifyObservers() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#notifyObservers(java.lang.Object)}.
	 */
	@Test
	public void testNotifyObserversObject() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#deleteObservers()}.
	 */
	@Test
	public void testDeleteObservers() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#setChanged()}.
	 */
	@Test
	public void testSetChanged() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#clearChanged()}.
	 */
	@Test
	public void testClearChanged() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#hasChanged()}.
	 */
	@Test
	public void testHasChanged() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#countObservers()}.
	 */
	@Test
	public void testCountObservers() {
		
	}

}
