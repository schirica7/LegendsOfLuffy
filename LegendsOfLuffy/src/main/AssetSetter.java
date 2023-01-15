/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import objects.Villain;

/**
 * Sets objects on the screen
 * 
 * @author stefanchirica
 */
public class AssetSetter {

    GamePanel gp;

    /**
     * Connects asset setter to gamePanel 
     * @param gp = GamePanel
     */
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    /**
     * Sets objects depending on what level the game is on
     */
    public void setObject() {
        gp.keySet();
    }
}
