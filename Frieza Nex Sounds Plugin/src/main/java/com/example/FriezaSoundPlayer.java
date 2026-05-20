package com.example;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;


public class FriezaSoundPlayer {
    public static void playSound(String fileName, int volumePercent) {
        try {
            InputStream inputStream =
                    FriezaSoundPlayer.class.getResourceAsStream("/sounds/" + fileName);

            if (inputStream == null) {
                System.out.println("Sound file not found: " + fileName);
                return;
            }

            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(
                            new BufferedInputStream(inputStream));

            Clip clip = AudioSystem.getClip();

            clip.open(audioStream);

            // Volume Control
            FloatControl gainControl =
                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            float min = gainControl.getMinimum();
            float max = gainControl.getMaximum();

            float volume =
                    min + (max - min) * (volumePercent / 100f);

            gainControl.setValue(volume);

            clip.start();
        }
        catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }
}