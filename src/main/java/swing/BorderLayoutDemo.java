package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Container;



public class BorderLayoutDemo extends JFrame {
	public static final int LARGHEZZA = 300;
	public static final int ALTEZZA = 200;
	
	public BorderLayoutDemo(){ 
		setSize(LARGHEZZA, ALTEZZA);
		addWindowListener(new DistruttoreFinestra());
		setTitle("SevenSevenSeven");
		
		setLayout(new BorderLayout());
		
		JLabel etichetta1 = new JLabel("Center");
		add(etichetta1, "Center");
		JLabel etichetta2 = new JLabel("West");
		add(etichetta2, "West");
		JLabel etichetta3 = new JLabel("East");
		add(etichetta3, "East");
		JLabel etichetta4 = new JLabel("South");
		add(etichetta4, "South");
		JLabel etichetta5 = new JLabel("North");
		add(etichetta5, "North");
	}
	
	public static void main(String[] args) {
		BorderLayoutDemo gui = new BorderLayoutDemo();
		gui.setVisible(true);
	}

}
