package it.polimi.ingsw.ps18.view.pboardviewstatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Support for the Strategy Pattern that runs the various PBoard's View status 
 * @author Francesco-Musio
 *
 */
public class HashMapPBVS {
	private static Map<String,PBViewStatus> genPBVStatus = new HashMap<>();
	
	public static void init(){
		genPBVStatus.put("Tower Choice", new ChooseTowertoShow());
		genPBVStatus.put("Player Choice", new ChoosePlayertoShow());
		genPBVStatus.put("PrivilegeChoice", new ChoosePrivilege());
	}
	
	public static PBViewStatus geteffect(String a){
		return genPBVStatus.get(a);
	}

}
