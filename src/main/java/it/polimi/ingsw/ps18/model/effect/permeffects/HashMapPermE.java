package it.polimi.ingsw.ps18.model.effect.permeffects;

import java.util.HashMap;
import java.util.Map;

public class HashMapPermE {
	private Map<String,Permanenteffect> permEffects = new HashMap<>();
	
	public HashMapPermE(){
		permEffects.put("IncreaseFMvalueOnGreenTower", new IncraseFMValueOnGreenTower());
		permEffects.put("IncreaseFMvalueOnBlueTower", new IncraseFMValueOnBlueTower());
		permEffects.put("IncreaseFMvalueOnYellowTower", new IncraseFMValueOnYellowTower());
		permEffects.put("IncreaseFMvalueOnPurpleTower", new IncraseFMValueOnPurpleTower());
		permEffects.put("IncreaseFMvalueOnHarvest", new IncraseFMValueOnHarvest());
		permEffects.put("IncreaseFMvalueOnProduction", new IncraseFMValueOnProduction());
		permEffects.put("BlockFloorBonus", new BlockFloorBonus());
		permEffects.put("SalesCoinBlue", new SalesCoinBlue());
		permEffects.put("SalesWoodorRockYellow", new SalesWoodorRockYellow());
	}
	
	public Permanenteffect getEffect(String code){
		return permEffects.get(code);
	}

}
