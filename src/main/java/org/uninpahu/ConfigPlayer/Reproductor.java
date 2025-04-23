
package org.uninpahu.ConfigPlayer;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


public class Reproductor {
    public static MediaPlayer mediaPlayer;
    private Duration pauseTime = Duration.ZERO;
            
    public Reproductor(){}
    
    public void play(String filePath){
        try{
            if(mediaPlayer != null){
                mediaPlayer.stop();
            }
            Media media = new Media(new File(filePath).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        }
        catch(Exception e){
            System.err.println("Player error" + e.getMessage());
        }
    }
    
    public void pauseSong(){
        if(mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
            pauseTime = mediaPlayer.getCurrentTime();
            mediaPlayer.pause();
        }
    }
    
    public void resumeSong(){
        if(mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED){
            mediaPlayer.seek(pauseTime);
            mediaPlayer.play();
        }
    }
    
    public void stopSong(){
        mediaPlayer.stop();
    }
    
    public void stopExit(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
}
