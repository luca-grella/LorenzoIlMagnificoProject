package it.polimi.ingsw.ps18.model.board.boardcells;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * Defines a Tower composed by Cell objects. <br>
 * Inherits and overrides methods from the Tower Interface.
 *
 * @author yazan-matar
 * @see {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell}
 * @see {@link it.polimi.ingsw.ps18.model.board.boardcells.Tower}
 */

public class ConcreteTower implements Tower {
	
	/**
	 * The tower cells.
	 */
	private List<Cell> towerCells = new ArrayList<>(GeneralParameters.numberofCells);
	
	/**
	 * The color.
	 */
	private int color;
	
	/**
	 * Instantiates a new concrete tower.
	 *
	 * @param towerIndex
	 *            the tower index
	 */
	public ConcreteTower (Integer towerIndex) {
		JSONParser parser = new JSONParser();
		this.color = towerIndex;
		
		
		try {
		    	Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/board/boardcells/TowerCell.json")); 
		    	JSONObject jsonObject = (JSONObject) obj;
		        JSONObject a = (JSONObject) jsonObject.get(towerIndex.toString());
		        for(Integer count=0; count<GeneralParameters.numberofCells; count++){
		        	JSONObject cell = (JSONObject) a.get(count.toString());
				    this.towerCells.add(count, new Cell(cell));
				}
		        
		        
	    }catch (FileNotFoundException e) {
	    	System.out.println("File not found.");
	    } catch (IOException e) {
	    	System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problem in parser");
		}
	}
	
	/**
	 * Inserts specific cards in a Tower:
	 * <ul>
	 * <li>Shuffles and cycles the cards in the ArrayList until a card with a
	 * specific period is found
	 * <li>Uses the Cell method insertCard, that places a card in a cell and
	 * iterates it for all the Cells in a Tower.
	 * </ul>
	 *
	 * @param towerCards
	 *            ArrayList that contains the card with the same type of the
	 *            chosen Tower
	 * @param period
	 *            An integer used to find a card of a specific period in
	 *            towerCards
	 */
	public void insertCards (List<Cards> towerCards, int period) {
		Collections.shuffle(towerCards);
		
		for(int i=0; i<GeneralParameters.numberofCells; i++){
			Cell towerCell = this.towerCells.get(i);
			Iterator<Cards> itr = towerCards.iterator();
			Cards cellCard = itr.next();
			while(itr.hasNext() && cellCard.getPeriod() != period){
				cellCard = itr.next();
			}
			towerCell.insertCard(cellCard);
			towerCards.remove(cellCard);

		}
	}
	
	
	/**
	 * Inserts a FMember in a Tower Cell:
	 * <ul>
	 * 	<li>Uses the Cell method insertFM, that places a FMember in a Cell
	 * 		after selecting the Cell floor in a tower.
	 * </ul>
	 * @param pBoardFM 
	 * FMember chosen for the current action
	 * @param floor
	 * Chosen floor of a Tower
	 * @return the Card of the chosen Tower Cell
	 */
	
	public Cards insertFM(FMember pBoardFM, int floor) {
		Cell towerCell = this.towerCells.get(floor);
		return towerCell.insertFM(pBoardFM);  //insertFM chiama isEmpty
	}
	
	/**
	 * Checks the legality of the current player's action.
	 * @param pBoardFM is the family member chosen by the player
	 * @return a boolean value:
	 * <ul>
	 * 	<li>True:
	 * 		<ul>
	 * 			<li> The tower is empty
	 * 			<li> The tower contains some family Member, but there's no Family Member
	 * 				 of the current player's color
	 * 			<li> The tower contains a Family Member that belongs to the current player
	 * 				 that's not neutral and the chosen Family Member is neutral
	 * 			<li> The tower contains a Family Member that belongs to the current player
	 * 				 that's neutral
	 * 		</ul>
	 * 	<li> False:
	 * 		<ul>
	 * 			<li> The tower contains a Family Member that belongs to the current player
	 * 				 that's not neutral and the chosen Family Member is not neutral
	 * 		</ul>
	 * </ul>
	 */
	public boolean isLegalTower(FMember pBoardFM) {
		
		if(this.isEmptyTower()){
			return true;
		}
		else{
			for(int index=0; index<GeneralParameters.numberofCells; index++){
				Cell towerCell = towerCells.get(index);
				FMember towerCellFM = towerCell.getCellFM();
				if( ! (towerCell.isEmptyTC())){ 
					if(towerCellFM.getPlayercol() == pBoardFM.getPlayercol()){
						if(towerCellFM.getColor() != GeneralParameters.neutralFMColor){
							if(pBoardFM.getColor() == GeneralParameters.neutralFMColor){
								return true;
							}
							else{
								return false;
							}
						}
					}	
				}
			}
			return true;
		}
	}
	
	/**
	 * Checks the Tower status.
	 *
	 * @return a boolean value:
	 *         <ul>
	 *         <li>True:
	 *         <ul>
	 *         <li>The tower is empty
	 *         </ul>
	 *         <li>False:
	 *         <ul>
	 *         <li>The tower contains at least a Family member (regardless of
	 *         the Family Member player color)
	 *         </ul>
	 *         </ul>
	 */
	public boolean isEmptyTower(){
			for(int index=0; index<GeneralParameters.numberofCells; index++){
				Cell towerCell = towerCells.get(index);
				if( !(towerCell.isEmptyTC()))
					return false;
			}
			return true;	
	}
	
	/**
	 * Checks the Tower status.
	 *
	 * @return a boolean value:
	 *         <ul>
	 *         <li>True:
	 *         <ul>
	 *         <li>The tower is full, meaning that all of the tower cells are
	 *         occupied by a Family Member (regardless of the Family Member
	 *         player color)
	 *         </ul>
	 *         <li>False:
	 *         <ul>
	 *         <li>The tower contains at least an empty cell
	 *         </ul>
	 *         </ul>
	 */
	public boolean isFullTower (){
		for(int index=0; index<GeneralParameters.numberofCells; index++){
			Cell towerCell = towerCells.get(index);
			if(towerCell.isEmptyTC())
				return false;
		}
		return true;
	}
	
	
	
	/**
	 * @see it.polimi.ingsw.ps18.model.board.boardcells.Tower#toString(int)
	 */
	@Override
	public String toString(int index){
		StringBuilder builder = new StringBuilder();

		builder.append("-----------------\n");
		builder.append("Cells in tower number" + index + ":\n");
		
		for(int cellIndex=0; cellIndex<GeneralParameters.numberofCells; cellIndex++){
			Cell towerCell = towerCells.get(cellIndex);
			builder.append(towerCell.toString(cellIndex));
			builder.append("\n-----------------\n");
		}
		
		return builder.toString();
	}
	
	
 	//TODO: Definire Info generali di una torre
	public String toString(){
		StringBuilder builder = new StringBuilder();

		builder.append("-----------------\n");
		builder.append("Details of tower: \n");
		builder.append("\tTower color: " + this.color + "\n");
		builder.append("\tNumber of cells in tower: " + this.towerCells.size());
		return builder.toString();
	}
	

	/**
	 * Gets the tower cells.
	 *
	 * @return the towerCells
	 */
	public List<Cell> getTowerCells() {
		return towerCells;
	}

	/**
	 * Sets the tower cells.
	 *
	 * @param towerCells
	 *            the towerCells to set
	 */
	public void setTowerCells(List<Cell> towerCells) {
		this.towerCells = towerCells;
	}
	

}
