package it.polimi.ingsw.ps18.Model.Effect.QuickEffect;

import java.util.HashMap;
import java.util.Map;

public class HashMapQE {
    private static Map<String,QuickEffect> geneffetti = new HashMap<>();
	
	public static void init(){
		geneffetti.put("1", new IncraseFP());
		geneffetti.put("2", new IncraseWood());
	}
	
	public static QuickEffect geteffect(String a){
		return geneffetti.get(a);
	}

}
