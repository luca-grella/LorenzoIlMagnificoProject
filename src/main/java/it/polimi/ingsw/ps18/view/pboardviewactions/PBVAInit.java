package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class PBVAInit.
 */
public class PBVAInit extends Observable implements PBViewAction {
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setObserver(it.polimi.ingsw.ps18.controller.MainController)
	 */
	@Override
	public void setObserver(MainController controller){
		addObserver(controller);
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#act()
	 */
	@Override
	public void act() {
		Scanner input = new Scanner(System.in);
		int ans;
		do{
			input.reset();
			StringBuilder builder = new StringBuilder();
			builder.append("Choose an action:\n");
			builder.append("1. Visualize Towers.\n");
			builder.append("2. Visualize Market.\n");
			builder.append("3. Visualize Council.\n");
			builder.append("4. Visualize Harvest.\n");
			builder.append("5. Visualize Production.\n");
			builder.append("6. Visualize Player Board.\n");
			builder.append("7. Visualize Player Excommunications.\n");
			builder.append("8. Place one Familiar to a Tower\n");
			builder.append("9. Place one Familiar to the Market\n");
			builder.append("10. Place one Familiar to the Council\n");
			builder.append("11. Place one Familiar to Harvest\n");
			builder.append("12. Place one Familiar to Production");
			System.out.println(builder.toString());
			ans = input.nextInt();
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
//			case 7:
//				
//				break;
			case 8:
				notifyActionMainController("FamtoTower");
			    break;
			case 9:
				notifyActionMainController("FamtoMarket");
				break;
			case 10:
				notifyActionMainController("FamtoCouncil");
				break;
			case 11:
				notifyActionMainController("FamtoHarvest");
				break;
			case 12:
				notifyActionMainController("FamtoProduction");
				break;
			}
		}while(ans<8);
		
		
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

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.view.pboardviewactions.PBViewAction#setIndex(int)
	 */
	@Override
	public void setIndex(int number) {
		return;
		
	}

}
