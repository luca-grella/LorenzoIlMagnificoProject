/**
 * 
 */
package it.polimi.ingsw.ps18.model.personalboard;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.gamelogic.Dice;

// TODO: Auto-generated Javadoc
/**
 * The Class FMemberTest.
 *
 * @author luca-grella
 */
public class FMemberTest {
	
	/**
	 * The rand.
	 */
	Random rand  = new Random();
	
	/**
	 * The dicevalue.
	 */
	int dicevalue = rand.nextInt(5)+1;
	
	/**
	 * The dicecolor.
	 */
	int dicecolor = rand.nextInt(2)+1;
	
	/**
	 * The fmvalue.
	 */
	int fmvalue = rand.nextInt(10);
	
	/**
	 * The playercol.
	 */
	int playercol = rand.nextInt(3);
	
	/**
	 * The dice.
	 */
	Dice dice = new Dice(dicecolor);

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.FMember#FMember(it.polimi.ingsw.ps18.model.gamelogic.Dice, int)}.
	 */
	@Test
	public void testFMemberDiceInt() {
		FMember tester = new FMember(dice, playercol);
		int ris = tester.getPlayercol();
		if(playercol!=ris){
			fail("errore in FMember(playercol)");
		int ris2 = tester.getColor();
		int ris3 = tester.getValue();
		assertEquals(dicecolor, ris2);
		assertEquals(dicevalue, ris3);
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.FMember#FMember(int, int)}.
	 */
	@Test
	public void testFMemberIntInt() {
		FMember tester = new FMember(fmvalue, playercol);
		int ris = tester.getValue();
		if(fmvalue!=ris){
			fail("errore in FMember(value)");
		}
		int ris1 = tester.getColor();
		int dicecolor1 = -1;
		if(dicecolor1!=ris1){
			fail("errore in FMember(color)");
		}
		int ris2 = tester.getPlayercol();
		if(playercol!=ris2){
			fail("errore in FMember(playercol)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.FMember#FMember(int)}.
	 */
	@Test
	public void testFMemberInt() {
		FMember tester = new FMember(fmvalue);
		int ris = tester.getValue();
		if(fmvalue!=ris){
			fail("errore in FMember(value)");
		}
		int ris1 = tester.getColor();
		int dicecolor2=-2;
		if(dicecolor2!=ris1){
			fail("errore in FMember(color)");
		}
		int ris2 = tester.getPlayercol();
		int playercol1=-2;
		if(playercol1!=ris2){
			fail("errore in FMember(playercol)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.FMember#getPlayercol()}.
	 */
	@Test
	public void testGetPlayercol() {
		FMember tester = new FMember(fmvalue, playercol);
		int ris = tester.getPlayercol();
		if(playercol!=ris){
			fail("errore nel getPlayercol");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.FMember#setPlayercol(int)}.
	 */
	@Test
	public void testSetPlayercol() {
		int a=0;
		int b=5;
		FMember tester = new FMember(b, a);
		tester.setPlayercol(playercol);
		int ris = tester.getPlayercol();
		if(playercol!=ris){
			fail("errore nella setPlayercol");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.FMember#getValue()}.
	 */
	@Test
	public void testGetValue() {
		FMember tester = new FMember(fmvalue);
		int ris = tester.getValue();
		if(fmvalue!=ris){
			fail("errore nel getValue");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.FMember#setValue(int)}.
	 */
	@Test
	public void testSetValue() {
		int a=0;
		FMember tester = new FMember(a);
		tester.setValue(5);
		int ris = tester.getValue();
		if(5!=ris){
			fail("errore nella setValue");
		}
		

	
	}
	
	@Test
	public void testSetValue2() {
		int a=0;
		FMember tester = new FMember(a);
		tester.setValue(-5);
		int ris2=tester.getValue();
		assertEquals(0, ris2);
		

	
	}
	
	
	
	
	

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.FMember#getColor()}.
	 */
	@Test
	public void testGetColor() {
		FMember tester = new FMember(fmvalue);
		tester.setColor(dicecolor);
		int ris = tester.getColor();
		if(dicecolor!=ris){
			fail("errore nel getColor");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.FMember#setColor(int)}.
	 */
	@Test
	public void testSetColor() {
		int a=0;
		FMember tester = new FMember(a);
		tester.setColor(dicecolor);
		int ris = tester.getColor();
		if(dicecolor!=ris){
			fail("errore nella setColor");
		}}

}
