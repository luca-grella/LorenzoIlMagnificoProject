package it.polimi.ingsw.ps18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class jasoncardstest {
	
	
	public static void main(String[] args) {
	JSONParser parser = new JSONParser();
	
	System.out.println(new File(".").getAbsoluteFile());

    try {
    	
    	FileReader f = new FileReader("src/main/java/it/polimi/ingsw/ps18/Model/Cards/cards.json");

        Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/Model/Cards/cards.json"));


        JSONObject jsonObject = (JSONObject) obj;
        //System.out.println(jsonObject);
        
        Integer i=1;
        JSONObject a = (JSONObject) jsonObject.get(i.toString());
        String name = (String) a.get("name");
        System.out.println(name);
        long harvValue = (long) a.get("HarvestValue");
        System.out.println(harvValue);

       
    }catch (FileNotFoundException e) {
        e.printStackTrace();

} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (org.json.simple.parser.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}