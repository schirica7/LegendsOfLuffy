/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("/music/gameBackground.wav");
        soundURL[1] = getClass().getResource("/music/coin.wav");
    }

    /**
     * Sets sound to a specific index of the array soundURL
     *
     * @param i = int index of array soundURL
     */
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {

        }
    }

    /**
     * Starts playing music
     */
    public void play() {
        clip.start();
    }

    /**
     * Plays music forever unless interrupted
     */
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Stops sound
     */
    public void stop() {
        clip.stop();
    }
}
