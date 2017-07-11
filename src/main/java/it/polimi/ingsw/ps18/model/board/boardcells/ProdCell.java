package it.polimi.ingsw.ps18.model.board.boardcells;

import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * Defines a production cell. <br>
 * When a FMember is placed, this cell activates a set of permanent effects if
 * conditions are fulfilled.
 *
 * @author yazan-matar
 * @see {@link it.polimi.ingsw.ps18.model.effect.prodEffect.HashMapPE}
 */

public class ProdCell {
	
	/**
	 * The prod cell FM.
	 */
	private FMember prodCellFM;
	
	/**
	 * The prod cell value.
	 */
	private int prodCellValue;
	
	/**
	 * The malus.
	 */
	private int malus = 0;

	/**
	 * Instantiates a new prod cell.
	 *
	 * @param malus
	 *            the malus
	 */
	public ProdCell(int malus) {
		prodCellFM = null;
		this.malus = malus;
		prodCellValue = GeneralParameters.baseValueProdCells - malus;
		
	}

	
	/**
	 * Insert FM.
	 *
	 * @param pBoardFM            the board FM
	 * @param game the game
	 * @return true, if successful
	 */
	public boolean insertFM(FMember pBoardFM, GameLogic game) {
		boolean skipfullspacecontrol = false;
		for(LeaderCards card: game.getTurnplayer().getLeadercards()){
			if(card.isActive()){
				for(LCPermEffect effect: card.getPermEffects()){
					if("VariousModifier".equals(effect.getName())){
						if("SkipFullSpaceControl".equals(effect.getShortDescription())){
							skipfullspacecontrol = true;
						}
					}
				}
			}
		}
		if(skipfullspacecontrol){
			if(pBoardFM.getValue() >= prodCellValue){
				return true;
			}
		} else {
			if(this.isEmptyPC()){	
				if(pBoardFM.getValue() >= prodCellValue){
					this.prodCellFM = pBoardFM;
					return true;
					
				}return false;
			}
		}return false;
	}
	
	/**
	 * Checks if is empty PC.
	 *
	 * @return true, if is empty PC
	 */
	public boolean isEmptyPC() {
		if(this.prodCellFM==null){ 
			return true;	
		}
		else {
			return false;
		}
	}
	
	/**
	 * Checks if is legal PC.
	 *
	 * @param actionValue the action value
	 * @return true, if is legal PC
	 */
	public boolean isLegalPC(int actionValue){
		if(actionValue>= this.getProdCellValue()){
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * To string.
	 *
	 * @param index
	 *            the index
	 * @return the string
	 */
	public String toString(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Production cell number " + index + ":\n");
		builder.append("Minimum value to access this cell: " + prodCellValue);
		builder.append("\nAction Malus from this cell: " + malus);
		
		if(prodCellFM != null){
			builder.append("\nFamily Member in production cell number " + index + ":\n"
					+ "\tPlayer color: " + prodCellFM.getPlayercol() + "\n"
					+ "\tFamily Member color: " + prodCellFM.getColor() + "\n"
					+ "\tFamily Member value: " + prodCellFM.getValue() + "\n"
					);
		}
		else{
			builder.append("\nProduction cell is empty!");
		}
		return builder.toString();
	}


	/**
	 * Gets the prod cell FM.
	 *
	 * @return the prodCellFM
	 */
	public FMember getProdCellFM() {
		return prodCellFM;
	}


	/**
	 * Sets the prod cell FM.
	 *
	 * @param prodCellFM
	 *            the prodCellFM to set
	 */
	public void setProdCellFM(FMember prodCellFM) {
		this.prodCellFM = prodCellFM;
	}


	/**
	 * Gets the prod cell value.
	 *
	 * @return the prodCellValue
	 */
	public int getProdCellValue() {
		return prodCellValue;
	}


	/**
	 * Sets the prod cell value.
	 *
	 * @param prodCellValue
	 *            the prodCellValue to set
	 */
	public void setProdCellValue(int prodCellValue) {
		this.prodCellValue = prodCellValue;
	}


	/**
	 * Gets the malus.
	 *
	 * @return the malus
	 */
	public int getMalus() {
		return malus;
	}


	/**
	 * Sets the malus.
	 *
	 * @param malus
	 *            the malus to set
	 */
	public void setMalus(int malus) {
		this.malus = malus;
	}
	
	
	
	
}
