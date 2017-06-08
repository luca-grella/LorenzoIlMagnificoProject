package swing;
import java.awt.Color;


public class SecondaFinestraDemo {
	
	/**
	 * Crea e visualizza due finestre della classe SecondaFinestra
	 */
	
	public static void main(String args[]) {
		SecondaFinestra finestra1= new SecondaFinestra();
		finestra1.setVisible(true);
		finestra1.setLocationRelativeTo(null);
		
		SecondaFinestra finestra2=new SecondaFinestra(Color.GREEN);
		finestra2.setVisible(true);
		finestra2.setLocationRelativeTo(null);
		
	}
	

}
