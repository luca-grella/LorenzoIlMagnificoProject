package it.polimi.ingsw.ps18.model.effect.excommEffects;

import java.util.HashMap;
import java.util.Map;

public class HashMapExcomm {
	private static Map<String,ExcommEffects> geneffetti = new HashMap<>();
	
	public static void init(){
		
	}
	
	public static ExcommEffects geteffect(String a){
		return geneffetti.get(a);
	}

}
