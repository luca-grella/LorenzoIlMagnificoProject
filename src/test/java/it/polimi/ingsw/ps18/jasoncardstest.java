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
    	
    	FileReader f = new FileReader("src\\test\\java\\it\\polimi\\ingsw\\ps18\\cards.json");

<<<<<<< 067aa5cde749c25182a44e9d3da2c60e5d23925b
        Object obj = parser.parse(new FileReader("/Users/luca/LorenzoIlMagnificoProject/src/main/java/it/polimi/ingsw/ps18/Model/Cards/cards.json"));
=======
        Object obj = parser.parse(f);
        
>>>>>>> d2cf374d066484e0ea053973e666e639d92763e1

        JSONObject jsonObject = (JSONObject) obj;
        //System.out.println(jsonObject);

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