package it.polimi.ingsw.ps18.model.effect.permeffects;

import java.util.HashMap;
import java.util.Map;

public class HashMapPermE {
	private Map<String,Permanenteffect> permEffects = new HashMap<>();
	
	public HashMapPermE(){
		permEffects.put("IncreaseFMvalueOnAction", new IncreaseFMValueOnAction());
		permEffects.put("BlockFloorBonus", new BlockFloorBonus());
		permEffects.put("SalesCoinBlue", new SalesCoinBlue());
		permEffects.put("SalesWoodorRockYellow", new SalesWoodorRockYellow());
	}
	
	public Permanenteffect getEffect(String code){
		return permEffects.get(code);
	}

}
