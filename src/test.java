import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class test extends JFrame implements KeyListener{
	
	public static void main(String[] args) {
		test f = new test();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(375,200);
		f.setFocusable(true);
		f.requestFocusInWindow();
		f.setVisible(true);
	}
	
	private JSlider red;
	private JSlider green;
	private JSlider blue;
	public int r = 0;
	public int g = 0;
	public int b = 0;
	int leftWheel = 0;
	int rightWheel = 0;
	
	public test() {
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
