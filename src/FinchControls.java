import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;
import javax.swing.*;

public class FinchControls extends JFrame implements KeyListener{
		
	private JSlider red;
	private JSlider green;
	private JSlider blue;
	int leftWheel = 0;
	int rightWheel = 0;
	int y;
	int turn;
	
	public int getRed() {
		return red.getValue();
	}
	
	public int getGreen() {
		return green.getValue();
	}
	
	public int getBlue() {
		return blue.getValue();
	}
	
	public int getLeftSpeed() {
		return y+turn;
	}
	
	public FinchControls() {
		super("Finch Robot");	
		setLayout(new FlowLayout());
		red = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		green = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		blue = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		red.setSnapToTicks(true);
		green.setSnapToTicks(true);
		blue.setSnapToTicks(true);
		red.setMinorTickSpacing(1);	
		green.setMinorTickSpacing(1);
		blue.setMinorTickSpacing(1);
		red.setName("red");
		green.setName("green");
		blue.setName("blue");
		add(red);
		add(new JLabel("Red"));
		add(green);
		add(new JLabel("Green"));
		add(blue);
		add(new JLabel("Blue"));
		addKeyListener(this);
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}
