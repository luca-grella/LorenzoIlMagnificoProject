package it.polimi.ingsw.ps18.view.pboardviewactions;

import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;

public class PBVAInit extends Observable implements PBViewAction {
	
	@Override
	public void setObserver(MainController controller){
		addObserver(controller);
	}

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
			builder.append("6. Visualize Player Cards.\n");
			builder.append("7. Visualize Player Resources.\n");
			builder.append("8. Visualize Player Excommunications.\n");
			builder.append("9. Place one Familiar to a Tower\n");
			builder.append("10. Place one Familiar to the Market\n");
			builder.append("11. Place one Familiar to the Council\n");
			builder.append("12. Place one Familiar to Harvest\n");
			builder.append("13. Place one Familiar to Production");
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
//			case 5:
//				
//				break;
//			case 6:
//				
//				break;
//			case 7:
//				
//				break;
//			case 8:
//				
//				break;
			case 9:
				notifyActionMainController("FamtoTower");
			    break;
			case 10:
				notifyActionMainController("FamtoMarket");
				break;
			case 11:
				notifyActionMainController("FamtoCouncil");
				break;
			case 12:
				notifyActionMainController("FamtoHarvest");
				break;
//			case 13:
//				
//				break;
			}
		}while(ans<9);
		
		
	}
	

	
	private void notifyActionMainController(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	private void notifyStatusMainController(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

	@Override
	public void setIndex(int number) {
		return;
		
	}

}
