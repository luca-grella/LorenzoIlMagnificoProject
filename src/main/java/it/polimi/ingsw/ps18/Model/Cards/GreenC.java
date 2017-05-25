package it.polimi.ingsw.ps18.Model.Cards;

import java.util.Scanner;

import it.polimi.ingsw.ps18.Model.Effect.QuickEffect.HashMapQE;

public class GreenC implements Cards {
	Scanner input = new Scanner(System.in);
	
	public GreenC(){
		System.out.println("Immetti codice primo effetto");
		String a = input.nextLine();
		effects.add(HashMapQE.geteffect(a));
//		System.out.println("Immetti codice secondo effetto");
//	    a = input.nextLine();
//		effects.add(HashMapQE.geteffect(a));
	}

}
