package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.GridLayout;



public class GridLayoutDemo extends JFrame {
	public static final int LARGHEZZA = 300;
	public static final int ALTEZZA = 200;
	
	public GridLayoutDemo(){ 
		setSize(LARGHEZZA, ALTEZZA);
		addWindowListener(new DistruttoreFinestra());
		setTitle("Prova di Grid Layout");
		
		setLayout(new GridLayout(1, 3));
		
		JLabel etichetta1 = new JLabel("Trattore");
		add(etichetta1);
		JLabel etichetta2 = new JLabel("Casa");
		add(etichetta2, "Center");
		JLabel etichetta3 = new JLabel("Cane");
		add(etichetta3);
	/*	JLabel etichetta4 = new JLabel("Cannuccia!");
		add(etichetta4);
		JLabel etichetta5 = new JLabel("Birra!");
		add(etichetta5);
		JLabel etichetta6 = new JLabel("Ciao!");
		add(etichetta6); */
	}
	
	public static void main(String[] args) {
		GridLayoutDemo gui = new GridLayoutDemo();
		gui.setVisible(true);
	}

}