//Name: Jonathan Ng
//Date: 2/8/2023
/*
 * This project codes a timer
 * and animation
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class App extends JFrame implements ActionListener, KeyListener {

    Timer myTimer = new Timer(10, this);

    boolean OnorOff = true;

    Bird bird = new Bird();

    float[] birdPos = new float[2];

    ArrayList<Pipes> pipes = new ArrayList<>();
    
    int spawnTimer = 0;

    Random random = new Random();

    // create the init method
    // the init is the first method to run

    public App() {

        super("Flappy Bird");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // pnlInput.setLayout(new GridLayout(0,2));

        addKeyListener(this);

        pipes.add(new Pipes());

        // this is a very cool test
        myTimer.start();
        //repaint();

    }

    public static void main(String[] args) {

        // Place components on the applet panel
        final int FRAME_WIDTH = 620;
        final int FRAME_HEIGHT = 620;

        // this is a edit
        App frame = new App();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

    }

    // when you push the button it comes this method
    public void actionPerformed(ActionEvent event) {

        Object objSource = event.getSource();
        if (OnorOff) {

        }
        bird.applyGravity();

        Pipes pipe = new Pipes();

        spawnTimer++;
        for (int i = 0; i < pipes.size(); i++) {
            pipes.get(i).x--; 
        }

        if(spawnTimer == 250){
            pipes.add(new Pipes());
            spawnTimer = 0;
            System.out.println("spawned pipe");
        }

        // requestFocus();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 32:
                bird.jump();
                break;
            default:
                System.out.print("key code: " + e.getKeyCode());
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    // create the paint method to show graphics
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(32, 145, 40));
        birdPos = bird.getPosition();
        bird.applyGravity();
        g.fillRect((int)birdPos[0], (int)birdPos[1], 50, 50);
        //System.out.println(birdPos[1]);
        for (int i = 0; i < pipes.size(); i++) {
            g.fillRect(pipes.get(i).x, pipes.get(i).y, pipes.get(i).width, pipes.get(i).topLength);
            g.fillRect(pipes.get(i).x, pipes.get(i).topLength + pipes.get(i).lengthVariance, pipes.get(i).width, 1000);
        }
        drawBird(g);

    }

    public void Update(Graphics gr) {

        // call the paint method
        paint(gr);
        //repaint();
    }

    public void startTheTimer() {

        System.out.println("timer started");
        myTimer.start();
        OnorOff = true;
    }

    public void stopTheTimer() {

        myTimer.stop();
        OnorOff = false;
    }

    public void drawBird(Graphics g){
        
    }
}