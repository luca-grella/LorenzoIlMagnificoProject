package swing;
import javax.swing.JFrame;


public class SwingJFrame
{
	
public static void main(String[] args) {
JFrame window = new JFrame();
// decido le dimensioni della finestra
window.setSize(150, 150);
// rendo visibile la finestra
window.setVisible(true);
// scelgo che cosa succedera quando si chiudera la finestra
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// centro la finestra nello schermo
window.setLocationRelativeTo(null);
}
}