package it.polimi.ingsw.ps18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class jasoncardstest {
	
	
	public static void main(String[] args) {
	JSONParser parser = new JSONParser();

    try {

        Object obj = parser.parse(new FileReader("/Users/luca/LorenzoIlMagnificoProject/src/main/java/it/polimi/ingsw/ps18/Model/Cards/cards.json"));

        JSONObject jsonObject = (JSONObject) obj;
        System.out.println(jsonObject);

        String name = (String) jsonObject.get("name");
        System.out.println(name);

       
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