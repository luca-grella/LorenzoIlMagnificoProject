package it.polimi.ingsw.ps18.Model.Effect.ExcommEffects;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	private static Map<String,ExcommEffects> geneffetti = new HashMap<>();
	
	public static void init(){
		geneffetti.put("1", new prova());
		geneffetti.put("2", new prova2());
	}
	
	public static ExcommEffects geteffect(String a){
		return geneffetti.get(a);
	}

}
