package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class FamtoTower.
 */
public class FamtoTower extends Observable implements Action {
	
	/**
	 * The chosen fam.
	 */
	private FMember chosenFam;
	
	
	private int numberOfServants;
	
	/**
	 * The index famto remove.
	 */
	private int indexFamtoRemove;
	
	/**
	 * The chosen tower.
	 */
	private int chosenTower;
	
	/**
	 * The chosen floor.
	 */
	int chosenFloor;
	
	/**
	 * The total cost preview.
	 */
	Stats totalCostPreview = new Stats(0,0,0,0,0,0,0);
	int costchoice; //1 = risorse , 2 = mp
	
	Stats totalDiscountPreview = new Stats(0,0,0,0,0,0,0);
	
	private boolean canGoBacktoFamChoice;
	
	private boolean canGoBacktoTowerChoice;
	
	/**
	 * Instantiates a new famto tower.
	 *
	 * @param view
	 *            the view
	 */
	public FamtoTower(PBoardView view){
		addObserver(view);
		this.canGoBacktoTowerChoice = true;
		this.canGoBacktoFamChoice = true;
	}
	
	/**
	 * Famchoice.
	 */
	public void famchoice(){
		notifyActionPBoardView("Fam Choice Tower");
	}
	
//	public void servantsChoice(){
//		notifyParamPBoardView("Servants Choice", this.chosenTower);
//	}
	
	/**
	 * Tower choice.
	 */
	public void towerChoice(){
		notifyActionPBoardView("Tower Choice");
	}
	
	/**
	 * Floor choice.
	 */
	public void floorChoice(GameLogic game){
		PBoard currentplayer = game.getTurnplayer();
		ShowBoard showBoard = new ShowBoard(currentplayer.getpBoardView());
		showBoard.showTowerCell(game.getBoard(), chosenTower);
		
		numberOfServants = -1;
		while(this.numberOfServants < 0 || this.numberOfServants > currentplayer.getResources().getServants()){
			notifyParamPBoardView("Servants Choice", this.chosenTower);	
		}
		notifyParamPBoardView("Floor Choice",this.chosenTower);
	}
	
	public void costChoice(){
		notifyActionPBoardView("CardCostChoice");
	}

	/**
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Board board = game.getBoard();
		ArrayList<Tower> towers = (ArrayList<Tower>) board.getTowers();
		Tower tower = towers.get(this.chosenTower);
		Cards newcard = tower.insertFM(this.chosenFam, this.chosenFloor);
		PBoard currentplayer = game.getTurnplayer();
		currentplayer.getFams().set(indexFamtoRemove, null);
		//riattivare gli effetti della cella sul giocatore se può
		boolean canAct = true;
		for(Cards card: currentplayer.getCards()){
			if(card.hasPermanent()){
				if(card.getColor()==1){
					for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
						if("BlockFloorBonus".equals(effect.getName())){
							if(this.chosenFloor == effect.getQuantity()){
								canAct = false;
							}
						}
					}
				} else if(card.getColor()==-1){
					for(Permanenteffect effect: ((BonusTile) card).getPermeffect()){
						if("BlockFloorBonus".equals(effect.getName())){
							if(this.chosenFloor == effect.getQuantity()){
								canAct = false;
							}
						}
					}
				}
			}
		}
		if(canAct){
			tower.getTowerCells().get(chosenFloor).activateQEffects(currentplayer, game);
		}
		if(currentplayer.getResources().enoughStats(totalCostPreview)){
			currentplayer.getResources().subStats(totalCostPreview);
			currentplayer.addCard(newcard,game);
		} else {
			this.famchoice(); //Teoricamente non si entra mai qui, ma sarebbe piu' sensato rimandarlo alla scelta dell'azione
		}
		

	}
	

	/**
	 * Notify action P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	/**
	 * Notify param P board view.
	 *
	 * @param msg
	 *            the msg
	 * @param index
	 *            the index
	 */
	private void notifyParamPBoardView(String msg,int index){
		setChanged();
		notifyObservers(new ParamMessage(msg,index));
	}

	/**
	 * Gets the chosen fam.
	 *
	 * @return the chosenFam
	 */
	public FMember getChosenFam() {
		return chosenFam;
	}

	/**
	 * Sets the chosen fam.
	 *
	 * @param chosenFam
	 *            the chosenFam to set
	 */
	public void setChosenFam(FMember chosenFam) {
		this.chosenFam = chosenFam;
	}

	/**
	 * Gets the chosen tower.
	 *
	 * @return the chosenTower
	 */
	public int getChosenTower() {
		return chosenTower;
	}

	/**
	 * Sets the chosen tower.
	 *
	 * @param chosenTower
	 *            the chosenTower to set
	 */
	public void setChosenTower(int chosenTower) {
		this.chosenTower = chosenTower;
	}

	/**
	 * Gets the chosen floor.
	 *
	 * @return the chosenFloor
	 */
	public int getChosenFloor() {
		return chosenFloor;
	}

	/**
	 * Sets the chosen floor.
	 *
	 * @param chosenFloor
	 *            the chosenFloor to set
	 */
	public void setChosenFloor(int chosenFloor) {
		this.chosenFloor = chosenFloor;
	}

	/**
	 * Gets the total cost preview.
	 *
	 * @return the totalCostPreview
	 */
	public Stats getTotalCostPreview() {
		return totalCostPreview;
	}
	
	

	/**
	 * @param totalCostPreview the totalCostPreview to set
	 */
	public void setTotalCostPreview(Stats totalCostPreview) {
		this.totalCostPreview = totalCostPreview;
	}

	/**
	 * Sets the index famto remove.
	 *
	 * @param indexFamtoRemove
	 *            the indexFamtoRemove to set
	 */
	public void setIndexFamtoRemove(int indexFamtoRemove) {
		this.indexFamtoRemove = indexFamtoRemove;
	}

	/**
	 * @return the costchoice
	 */
	public int getCostchoice() {
		return costchoice;
	}

	/**
	 * @param costchoice the costchoice to set
	 */
	public void setCostchoice(int costchoice) {
		this.costchoice = costchoice;
	}

	/**
	 * @return the canGoBacktoFamChoice
	 */
	public boolean isCanGoBacktoFamChoice() {
		return canGoBacktoFamChoice;
	}

	/**
	 * @param canGoBacktoFamChoice the canGoBacktoFamChoice to set
	 */
	public void setCanGoBacktoFamChoice(boolean canGoBacktoFamChoice) {
		this.canGoBacktoFamChoice = canGoBacktoFamChoice;
	}

	/**
	 * @return the canGoBacktoTowerChoice
	 */
	public boolean isCanGoBacktoTowerChoice() {
		return canGoBacktoTowerChoice;
	}

	/**
	 * @param canGoBacktoTowerChoice the canGoBacktoTowerChoice to set
	 */
	public void setCanGoBacktoTowerChoice(boolean canGoBacktoTowerChoice) {
		this.canGoBacktoTowerChoice = canGoBacktoTowerChoice;
	}

	/**
	 * @return the totalDiscountPreview
	 */
	public Stats getTotalDiscountPreview() {
		return totalDiscountPreview;
	}

	
	
	/**
	 * @return the numberOfServants
	 */
	public int getNumberOfServants() {
		return numberOfServants;
	}

	@Override
	public void setNumberOfServants(int numberOfServants) {
		this.numberOfServants = numberOfServants;
	}

	/**
	 * @return
	 */
	public int getIndexFamtoRemove() {
		
		return indexFamtoRemove;
	}

	/**
	 * @param totalDiscountPreview
	 */
	public void setTotalDiscountPreview(Stats totalDiscountPreview) {
		
		this.totalDiscountPreview = totalDiscountPreview;
		
	}

	
	
	
	
}
