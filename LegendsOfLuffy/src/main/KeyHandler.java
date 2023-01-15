/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Connects key press to screen movement
 * 
 * W = up, A = left, S = down, D = right
 * @author stefanchirica
 */
public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    /**
     * If key other than w, a, s, or d is typed
     */
    public void keyTyped(KeyEvent arg0) {
        //keyPressed(arg0);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    /**
     * When key is pressed, make corresponding boolean true
     */
    public void keyPressed(KeyEvent arg0) {
        int code = arg0.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        
        if (code != KeyEvent.VK_W && code != KeyEvent.VK_A && code != KeyEvent.VK_S && code != KeyEvent.VK_D) {
            keyTyped(arg0);
        }
        
        
    }

    @Override
    /**
     * When key is released, make corresponding boolean false
     */
    public void keyReleased(KeyEvent arg0) {

        int code = arg0.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
