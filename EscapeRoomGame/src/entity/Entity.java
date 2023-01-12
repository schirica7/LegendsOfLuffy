/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Superclass for player and any other entities created in the future such as
 * NPCs
 *
 * @author stefanchirica
 */
public class Entity {

    public int worldX, worldY;
    public int screenX, screenY;

    public int speed;

    public BufferedImage up, down, left, right;
    public String direction;

    public int solidAreaDefaultX, solidAreaDefaultY;
    public Rectangle solidArea;
    public boolean collisionOn = false;

    //add a graphics folder to the repository
}
