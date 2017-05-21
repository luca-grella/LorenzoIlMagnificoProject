package it.polimi.ingsw.ps18.PBoard;

import java.util.ArrayList;
import it.polimi.ingsw.ps18.PBoard.Resources.Stats;

public class PBoard {
	private Stats resources;
	//private Card cards = new ArrayList();
	
	
	public void prova(){
		this.resources = new Stats(1,1,1,1,0,0,0);
		this.resources.addWood(5);
		System.out.println(this.resources.getWood());
	}
	

}