package it.polimi.ingsw.ps18.controller.controlleractions.famtotower;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.cards.PurpleC;
import it.polimi.ingsw.ps18.model.effect.excommEffects.*;
import it.polimi.ingsw.ps18.model.effect.generalEffects.WoodorRockEffects;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.TowerDiscount;
import it.polimi.ingsw.ps18.model.effect.permeffects.*;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class ReceiveFloortoTower.
 */
public class ReceiveFloortoTower implements ActionChoice {
	
	/**
	 * The index.
	 */
	private int index;

	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		PBoard currentplayer = game.getTurnplayer();
		if(index==0){
			currentplayer.notifyLogPBoardView("\nUndoing...\n");
			if(((FamtoTower) currentaction).isCanGoBacktoTowerChoice()){
				currentplayer.notifyLogPBoardView("\tTurned back to the Tower choice\n");
				((FamtoTower) currentaction).towerChoice();
			} else {
				currentplayer.notifyLogPBoardView("\tTurned back to the Floor choice\n");
				((FamtoTower) currentaction).floorChoice(game);
			}
		} else if(index<0 || index>GeneralParameters.numberofCells){
			currentplayer.notifyLogPBoardView("\nError: not a valid input\n");
			currentplayer.notifyLogPBoardView("\tTurned back to the Floor choice\n");
			((FamtoTower) currentaction).floorChoice(game);
		} else {
	        index -= 1;
			Board gameBoard = game.getBoard();
			List<Tower> boardTowers = gameBoard.getTowers();
			FamtoTower towerIndex = (FamtoTower) game.getOngoingAction();
			ConcreteTower boardTower = (ConcreteTower)boardTowers.get(towerIndex.getChosenTower());
			FMember chosenfam = ((FamtoTower) currentaction).getChosenFam();
			Stats cardStats = new Stats((((boardTower.getTowerCells()).get(index)).getCellCard()).getCardCost());
			Stats tempCostPreview = new Stats(((FamtoTower) currentaction).getTotalCostPreview()); 
			//temporaneo per evitare che totalCostPreview accumuli risorse per ogni giocata
			Stats tempDiscountPreview = new Stats(((FamtoTower) currentaction).getTotalDiscountPreview());
			List<Cards> playerCards = currentplayer.getCards();
			
			//modificatore valore familiare per l'azione
			int modifierValue = 0;
			for(Cards card: playerCards){
				if(card.hasPermanent()){
					if(card.getColor()==1){
						for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
							switch(towerIndex.getChosenTower()){
							case 0:
								if("Green".equals(effect.getName())){
									modifierValue += effect.getQuantity();
								}
								break;
							case 1:
								if("Blue".equals(effect.getName())){
									modifierValue += effect.getQuantity();
								}
								break;
							case 2:
								if("Yellow".equals(effect.getName())){
									modifierValue += effect.getQuantity();
								}
								break;
							case 3:
								if("Purple".equals(effect.getName())){
									modifierValue += effect.getQuantity();
								}
								break;
							}
						}
					} else if(card.getColor()==-1){
						for(Permanenteffect effect: ((BonusTile) card).getPermeffect()){
							switch(towerIndex.getChosenTower()){
							case 0:
								if("Green".equals(effect.getName())){
									modifierValue += effect.getQuantity();
								}
								break;
							case 1:
								if("Blue".equals(effect.getName())){
									modifierValue += effect.getQuantity();
								}
								break;
							case 2:
								if("Yellow".equals(effect.getName())){
									modifierValue += effect.getQuantity();
								}
								break;
							case 3:
								if("Purple".equals(effect.getName())){
									modifierValue += effect.getQuantity();
								}
								break;
							}
						}
					}
				}
			}
			//sconti per l'azione corrente
			for(Cards card: playerCards){
				if(card.hasPermanent()){
					if(card.getColor()==1){
						for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
							switch(towerIndex.getChosenTower()){
							case 0:
								if("Green".equals(effect.getName())){
									if(! ((IncreaseFMValueOnAction) effect).getDiscounts().isEmpty()){
										tempDiscountPreview.addStats(((IncreaseFMValueOnAction) effect).getDiscounts());
									}
								} else if("GreenWR".equals(effect.getName())){
									if(! ((IncreaseFMValueOnActionWR) effect).getDiscounts().isEmpty()){
										WoodorRockEffects wreffect = (WoodorRockEffects) effect;
										wreffect.activate(currentplayer, game);
										tempDiscountPreview.addStats(((IncreaseFMValueOnActionWR) effect).getChosenDiscount());
									}
								}
								break;
							case 1:
								if("Blue".equals(effect.getName())){
									if(! ((IncreaseFMValueOnAction) effect).getDiscounts().isEmpty()){
										tempDiscountPreview.addStats(((IncreaseFMValueOnAction) effect).getDiscounts());
									}
								} else if("BlueWR".equals(effect.getName())){
									if(! ((IncreaseFMValueOnActionWR) effect).getDiscounts().isEmpty()){
										WoodorRockEffects wreffect = (WoodorRockEffects) effect;
										wreffect.activate(currentplayer, game);
										tempDiscountPreview.addStats(((IncreaseFMValueOnActionWR) effect).getChosenDiscount());
									}
								}
								break;
							case 2:
								if("Yellow".equals(effect.getName())){
									if(! ((IncreaseFMValueOnAction) effect).getDiscounts().isEmpty()){
										tempDiscountPreview.addStats(((IncreaseFMValueOnAction) effect).getDiscounts());
									}
								} else if("YellowWR".equals(effect.getName())){
									if(! ((IncreaseFMValueOnActionWR) effect).getDiscounts().isEmpty()){
										WoodorRockEffects wreffect = (WoodorRockEffects) effect;
										wreffect.activate(currentplayer, game);
										tempDiscountPreview.addStats(((IncreaseFMValueOnActionWR) effect).getChosenDiscount());
									}
								}
								break;
							case 3:
								if("Purple".equals(effect.getName())){
									if(! ((IncreaseFMValueOnAction) effect).getDiscounts().isEmpty()){
										tempDiscountPreview.addStats(((IncreaseFMValueOnAction) effect).getDiscounts());
									}
								} else if("PurpleWR".equals(effect.getName())){
									if(! ((IncreaseFMValueOnActionWR) effect).getDiscounts().isEmpty()){
										WoodorRockEffects wreffect = (WoodorRockEffects) effect;
										wreffect.activate(currentplayer, game);
										tempDiscountPreview.addStats(((IncreaseFMValueOnActionWR) effect).getChosenDiscount());
									}
								}
								break;
							}
						}
					} else if(card.getColor()==-1){
						for(Permanenteffect effect: ((BonusTile) card).getPermeffect()){
							switch(towerIndex.getChosenTower()){
							case 0:
								if("Green".equals(effect.getName())){
									if(! ((IncreaseFMValueOnAction) effect).getDiscounts().isEmpty()){
										tempDiscountPreview.addStats(((IncreaseFMValueOnAction) effect).getDiscounts());
									}
								} else if("GreenWR".equals(effect.getName())){
									if(! ((IncreaseFMValueOnActionWR) effect).getDiscounts().isEmpty()){
										WoodorRockEffects wreffect = (WoodorRockEffects) effect;
										wreffect.activate(currentplayer, game);
										tempDiscountPreview.addStats(((IncreaseFMValueOnActionWR) effect).getChosenDiscount());
									}
								}
								break;
							case 1:
								if("Blue".equals(effect.getName())){
									if(! ((IncreaseFMValueOnAction) effect).getDiscounts().isEmpty()){
										tempDiscountPreview.addStats(((IncreaseFMValueOnAction) effect).getDiscounts());
									}
								} else if("BlueWR".equals(effect.getName())){
									if(! ((IncreaseFMValueOnActionWR) effect).getDiscounts().isEmpty()){
										WoodorRockEffects wreffect = (WoodorRockEffects) effect;
										wreffect.activate(currentplayer, game);
										tempDiscountPreview.addStats(((IncreaseFMValueOnActionWR) effect).getChosenDiscount());
									}
								}
								break;
							case 2:
								if("Yellow".equals(effect.getName())){
									if(! ((IncreaseFMValueOnAction) effect).getDiscounts().isEmpty()){
										tempDiscountPreview.addStats(((IncreaseFMValueOnAction) effect).getDiscounts());
									}
								} else if("YellowWR".equals(effect.getName())){
									if(! ((IncreaseFMValueOnActionWR) effect).getDiscounts().isEmpty()){
										WoodorRockEffects wreffect = (WoodorRockEffects) effect;
										wreffect.activate(currentplayer, game);
										tempDiscountPreview.addStats(((IncreaseFMValueOnActionWR) effect).getChosenDiscount());
									}
								}
								break;
							case 3:
								if("Purple".equals(effect.getName())){
									if(! ((IncreaseFMValueOnAction) effect).getDiscounts().isEmpty()){
										tempDiscountPreview.addStats(((IncreaseFMValueOnAction) effect).getDiscounts());
									}
								} else if("PurpleWR".equals(effect.getName())){
									if(! ((IncreaseFMValueOnActionWR) effect).getDiscounts().isEmpty()){
										WoodorRockEffects wreffect = (WoodorRockEffects) effect;
										wreffect.activate(currentplayer, game);
										tempDiscountPreview.addStats(((IncreaseFMValueOnActionWR) effect).getChosenDiscount());
									}
								}
								break;
							}
						}
					}
				}
			}
			for(LeaderCards card: currentplayer.getLeadercards()){
				if(card.isActive()){
					for(LCPermEffect effect: card.getPermEffects()){
						if("TowerDiscount".equals(effect.getName())){
							tempDiscountPreview.addStats(((TowerDiscount)effect).getDiscount());
						}
					}
				}
			}
			//calcola i malus al valore dell'azione dovuti alle scomuniche
			int malusValue = 0;
			int malusServants = 1;
			for(Excommunications card: currentplayer.getExcommCards()){
				for(ExcommEffects effect: card.getEffects()){
					if("MalusValue".equals(effect.getName())){
						switch(towerIndex.getChosenTower()){
						case 0:
							if("Green".equals(((MalusValue) effect).getPlace())){
								malusValue += ((MalusValue) effect).getMalusValue();
							}
							break;
						case 1:
							if("Blue".equals(((MalusValue) effect).getPlace())){
								malusValue += ((MalusValue) effect).getMalusValue();
							}
							break;
						case 2:
							if("Yellow".equals(((MalusValue) effect).getPlace())){
								malusValue += ((MalusValue) effect).getMalusValue();
							}
							break;
						case 3:
							if("Purple".equals(((MalusValue) effect).getPlace())){
								malusValue += ((MalusValue) effect).getMalusValue();
							}
							break;
						}
						if("Servants".equals(((MalusValue) effect).getPlace())){
							malusServants = ((MalusValue) effect).getMalusValue();
							if(malusServants == 0){
								malusServants = 1;
							}
						}
						
					}
				}
			}
			
			
			
			if((((boardTower.getTowerCells()).get(index)).isEmptyTC())){ 
				if(((boardTower.getTowerCells()).get(index)).isLegalTC(chosenfam.getValue() + modifierValue + (((FamtoTower) currentaction).getNumberOfServants() / malusServants ) - malusValue)){	
					//creare un giocatore farlocco e attivare gli effetti della cella e fare l'ultimo controllo su di lui
					PBoard temp = new PBoard();
					temp.setResources(new Stats(currentplayer.getResources()));
					boolean canAct = true;
					for(Cards card: currentplayer.getCards()){
						if(card.hasPermanent()){
							if(card.getColor()==1){
								for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
									if("BlockFloorBonus".equals(effect.getName())){
										if(towerIndex.getChosenFloor() == effect.getQuantity()){
											canAct = false;
										}
									}
								}
							} else if(card.getColor()==-1){
								for(Permanenteffect effect: ((BonusTile) card).getPermeffect()){
									if("BlockFloorBonus".equals(effect.getName())){
										if(towerIndex.getChosenFloor() == effect.getQuantity()){
											canAct = false;
										}
									}
								}
							}
						}
					}
					if(canAct){
						boardTower.getTowerCells().get(index).activateQEffects(temp, game);
					}
					if(towerIndex.getChosenTower() == 3){
						PurpleC chosenCard = (PurpleC) boardTower.getTowerCells().get(index).getCellCard();
						Stats secondaryCost = chosenCard.getSecondaryCost();
						if(!(secondaryCost.isEmpty())){
							if(cardStats.isEmpty()){
								//se ho abbastanza mp pago in mp
								if(chosenCard.getMinMP() <= currentplayer.getResources().getMP()){
									secondaryCost.subStats(tempDiscountPreview);
									secondaryCost.fixStats();
									tempCostPreview.addStats(secondaryCost);
								} else {
									currentplayer.notifyLogPBoardView("\nYou don't have enough MP to pay this card\n");
									currentplayer.notifyLogPBoardView("Turned back to the Floor choice\n");
									((FamtoTower) currentaction).floorChoice(game);
								}
							} else {
								//scelta costo da pagare
								((FamtoTower) currentaction).costChoice();
								int choice = ((FamtoTower) currentaction).getCostchoice();
								if(choice == 1){
									cardStats.subStats(tempDiscountPreview);
									cardStats.fixStats();
									tempCostPreview.addStats(cardStats);
								} else if(choice == 2){
									secondaryCost.subStats(tempDiscountPreview);
									secondaryCost.fixStats();
									tempCostPreview.addStats(secondaryCost);
								}
							}
						} else {
							cardStats.subStats(tempDiscountPreview);
							cardStats.fixStats();
							tempCostPreview.addStats(cardStats);
						}
					} else {
						cardStats.subStats(tempDiscountPreview);
						cardStats.fixStats();
						tempCostPreview.addStats(cardStats);
					}
					tempCostPreview.addServants(((FamtoTower) currentaction).getNumberOfServants());
					if((temp.getResources().enoughStats(tempCostPreview))){
						String string[] = {"st", "nd", "rd", "rth"};
						currentplayer.notifyLogPBoardView("\nYour Family Member was correctly placed in the " 
														+ index+1 + string[index] + " cell of the tower\n");
						((FamtoTower) currentaction).setTotalCostPreview(tempCostPreview);
						((FamtoTower) currentaction).setChosenFloor(index);
						currentaction.act(game);
					}
					else{
						String string[] = {"st", "nd", "rd", "rth"};
						currentplayer.notifyLogPBoardView("\nYou can't access the " 
								+ index+1 + string[index] + " cell of the tower:\n");	
						currentplayer.notifyLogPBoardView("\tYou don't have enough resources to buy this card\n");
						((FamtoTower) currentaction).floorChoice(game);
					}
				}
				else{
					String string[] = {"st", "nd", "rd", "rth"};
					currentplayer.notifyLogPBoardView("\nYou can't access the " 
							+ index+1 + string[index] + " cell of the tower:\n");	
					currentplayer.notifyLogPBoardView("\tThe chosen Family Member doesn't have enough Action Value:\n"
							+ "Please choose another one\n");
					((FamtoTower) currentaction).famchoice();
				}
			}
		    else {
		    	String string[] = {"st", "nd", "rd", "rth"};
				currentplayer.notifyLogPBoardView("\nYou can't access the " 
						+ index+1 + string[index] + " cell of the tower:\n");	
				currentplayer.notifyLogPBoardView("\nThe chosen Cell was already occupied!\n");
		    	((FamtoTower) currentaction).floorChoice(game);
		    }
		}
	}

	/**
	 * Sets the index.
	 *
	 * @param index
	 *            the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

}
