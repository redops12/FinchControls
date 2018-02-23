import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;
import javax.swing.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchControls extends JFrame implements KeyListener{
        
    private JSlider red;
    private JSlider green;
    private JSlider blue;
    private JLabel lWheel;
    private JLabel rWheel;
    private JLabel pitchLbl;
    private double pitch; 
    static Finch robot = new Finch();
    public int leftWheel = 0;
    public int rightWheel = 0;
    int y = 0;
    int turn = 0;
    
    static void main(String[] args){
        FinchControls f = new FinchControls();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(375,200);
        f.setFocusable(true);
        f.requestFocusInWindow();
        f.setVisible(true);
        while (true) {
            robot.setLED(f.getRed(),f.getGreen(),f.getBlue());
            f.requestFocusInWindow();
            robot.setWheelVelocities(f.leftWheel, f.rightWheel);
            robot.playTone(f.getPitch(), 100);
            System.out.println(f.getPitch());
        }
    }
    
    public int getRed() {
        return red.getValue();
    }
    
    public int getGreen() {
        return green.getValue();
    }
    
    public int getBlue() {
        return blue.getValue();
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
        this.addKeyListener(this);
        lWheel = new JLabel(Integer.toString(leftWheel));
        rWheel = new JLabel(Integer.toString(rightWheel));
        add(lWheel);
        add(rWheel);
        pitch = 440;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isShiftDown()) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                y = 128;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                y = -128;
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                turn = 128;
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                turn = -128;
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                y = 255;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                y = -255;
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                turn = 255;
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                turn = -255;
            }
        }
        if(e.getKeyCode() == 33){
            pitch = pitch*Math.pow(pitch, 1.0/13.0);
        }
        if(e.getKeyCode() == 34){
            pitch = pitch/Math.pow(pitch, 1.0/13.0);
        }
        
        if (y+turn>255) {
            rightWheel = 255;
        } else if (y+turn<-255){
            rightWheel = -255;
        } else {
            rightWheel = y+turn;
        }
        if (y-turn>255) {
            leftWheel = 255;
        } else if (y-turn<-255){
            leftWheel = -255;
        } else {
            leftWheel = y-turn;
        }
        rWheel.setText(Integer.toString(rightWheel));
        lWheel.setText(Integer.toString(leftWheel));
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            y = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            y = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            turn = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            turn = 0;
        }
        
        if (y+turn>255) {
            rightWheel = 255;
        } else if (y+turn<-255){
            rightWheel = -255;
        } else {
            rightWheel = y+turn;
        }
        if (y-turn>255) {
            leftWheel = 255;
        } else if (y-turn<-255){
            leftWheel = -255;
        } else {
            leftWheel = y-turn;
        }
        
        rWheel.setText(Integer.toString(rightWheel));
        lWheel.setText(Integer.toString(leftWheel));
    }
        
    @Override
    public void keyTyped(KeyEvent e) {}
    
    public int getPitch(){
        return (int) pitch;
    }
}
