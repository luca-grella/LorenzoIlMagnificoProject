package swing;

import javax.swing.JFrame; 
import javax.swing.JLabel;



/**
Prova finestra creata con swing.
*/



public class PrimoEsempioSwing {
public static final int LARGHEZZA = 350; 
public static final int ALTEZZA = 200;
public static void main(String args[]) 

{ JFrame finestra = new JFrame();
finestra.setSize(LARGHEZZA, ALTEZZA);
JLabel etichetta = new JLabel("Hello World!");
finestra.add(etichetta);
DistruttoreFinestra ascoltatore = new DistruttoreFinestra(); 
finestra.addWindowListener (ascoltatore);
finestra.setVisible (true);
}}