package swing;

import javax.swing.JFrame; 
import javax.swing.JLabel; 
import java.awt.Color; 
import java.awt.Container;

public class SecondaFinestra extends JFrame 
{ 	public static final int LARGHEZZA = 300; 
	public static final int ALTEZZA = 200;

public SecondaFinestra() { 
	super();

setSize(LARGHEZZA, ALTEZZA);
JLabel etichetta = new JLabel ("Ora disponibile a colori");
		add(etichetta);
setTitle("Seconda Finestra");
Container pannelloDelContenuto = getContentPane();
pannelloDelContenuto.setBackground(Color.BLUE);
addWindowListener(new DistruttoreFinestra());

}
public SecondaFinestra(Color colorePersonalizzato) { 
	super();

setSize(LARGHEZZA, ALTEZZA);
JLabel etichetta = new JLabel ("Ora disponibile a colori"); 
add(etichetta);
setTitle("SecondaFinestra");
getContentPane().setBackground(colorePersonalizzato); 
addWindowListener(new DistruttoreFinestra());


}}