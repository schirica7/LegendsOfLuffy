/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JFrame;

/**
 * Main game class
 * @author stefanchirica
 */
public class MainClass {

    public static JFrame window;

    /**
     * Main game method; creates game frame, adds gamePanel, and starts game t
     * hread
     * 
     * @param args = String array arguments
     */
    public static void main(String[] args) {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Escape Room Game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        // abcdefghijklmnopqrstuvwxyzî1234567890-=+_!ÎâăÂĂ';":.,></./?țȚțȚȚȚȚț
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}