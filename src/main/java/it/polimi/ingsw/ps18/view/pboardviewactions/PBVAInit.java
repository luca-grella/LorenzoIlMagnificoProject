package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Class PBVAInit.
 */
public class PBVAInit extends Observable implements PBViewAction {
	private int index;
	
	public PBVAInit(MainController controller){
		addObserver(controller);
	}

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act()
	 */
	@Override
	public void act(ClientInterface playerClient) {
		int ans = -1;
		try{
			do{
				StringBuilder builder = new StringBuilder();
				builder.append("Choose an action:\n");
				builder.append("1. Visualize Towers.\n");
				builder.append("2. Visualize Market.\n");
				builder.append("3. Visualize Council.\n");
				builder.append("4. Visualize Harvest.\n");
				builder.append("5. Visualize Production.\n");
				builder.append("6. Visualize Player Board.\n");
				builder.append("7. Visualize the Excommunications in Game.\n");
				builder.append("8. Place one Familiar to a Tower\n");
				builder.append("9. Place one Familiar to the Market\n");
				builder.append("10. Place one Familiar to the Council\n");
				builder.append("11. Place one Familiar to Harvest\n");
				builder.append("12. Place one Familiar to Production\n");
				builder.append("13. Activate your Leader Cards\n");
				builder.append("14. Activate your Leader Cards Quick Effect\n");
				builder.append("15. Discard one of your Leader Cards");
				playerClient.notify(builder.toString());
				ans = playerClient.read();
				switch (ans){
				case 1:
					notifyStatusMainController("Show Towers Zoom");
						break;
					case 2:
						notifyStatusMainController("Show Market");
						break;
					case 3:
						notifyStatusMainController("Show Council");
						break;
					case 4:
						notifyStatusMainController("Show Harvest");
						break;
					case 5:
						notifyStatusMainController("Show Production");
						break;
					case 6:
						notifyActionMainController("Show Player");
						break;
					case 7:
						notifyStatusMainController("Show Excomm");
						break;
					case 8:
						notifyActionMainController("FamtoTower");
					    break;
					case 9:
						if(index == -1){
							notifyActionMainController("FamtoMarket");
							break;
						} else {
							playerClient.notify("You can't do this becouse of your Excommunication cards.");
							break;
						}
					case 10:
						notifyActionMainController("FamtoCouncil");
						break;
					case 11:
						notifyActionMainController("FamtoHarvest");
						break;
					case 12:
						notifyActionMainController("FamtoProduction");
						break;
					case 13:
						notifyActionMainController("ActivateLC");
						break;
					case 14:
						notifyActionMainController("ActivateLCQE");
						break;
					case 15:
						notifyActionMainController("DiscardLC");
						break;
					}
				}while((index==-1 && (ans<8 || ans>12)) || (index!=-1&&(ans<8 || ans>12 || ans==9)));
			
		} catch (RemoteException e) {
			System.out.println("\n[PBVAInit] Error\n");
		}
		
		
	}
	

	
	/**
	 * Notify action main controller.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyActionMainController(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	/**
	 * Notify status main controller.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

	/**
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		this.index = number;
		
	}

}
