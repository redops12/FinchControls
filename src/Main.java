import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		FinchControls f = new FinchControls();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(375,200);
		f.setFocusable(true);
		f.requestFocusInWindow();
		f.setVisible(true);
	}
}
