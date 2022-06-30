package LogicPackage.Misc;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AudioHandling {
    private static AudioHandling instance = null;

    private MediaPlayer themeSong;
    private MediaPlayer sliceSound;
    private MediaPlayer gameOver;
    private MediaPlayer startGame;
    private MediaPlayer bombExplode;

    public static AudioHandling getInstance(){
        if(instance == null)
        {
            instance = new AudioHandling();
        }
        return instance;
    }

    public AudioHandling() {
      try{  String url = new File("ThemeSong.mp3").toURI().toString();
          themeSong = new MediaPlayer(new Media(url));
          themeSong.setCycleCount(1);

          url = new File("SliceSound.mp3").toURI().toString();
          sliceSound = new MediaPlayer(new Media(url));
          sliceSound.setCycleCount(1);

          url = new File("GameOver.mp3").toURI().toString();
          gameOver = new MediaPlayer(new Media(url));
          gameOver.setCycleCount(1);

          url = new File("StartGame.mp3").toURI().toString();
          startGame = new MediaPlayer(new Media(url));
          startGame.setCycleCount(1);

          url = new File("BombExplosion.mp3").toURI().toString();
          bombExplode = new MediaPlayer(new Media(url));
          bombExplode.setCycleCount(1);

    }catch (Exception e)
      {
          System.out.println("Music File not found");
      }
      instance = AudioHandling.this;
    }

    public void playThemeSong() {
         themeSong.play();
    }

    public void stopThemeSong( ) {
        themeSong.stop();
    }

    public void playStartGame() {
        startGame.play();
    }

    public void stopStartGame( ) {
        startGame.stop();
    }

    public void playSliceSound() {
        sliceSound.play();
    }

    public void stopSliceSound( ) {
        sliceSound.stop();
    }

    public void playGameOverSound() {
        gameOver.play();
    }

    public void stopGameOverSound( ) {
        gameOver.stop();
    }

    public void playExplodingSound() {
        bombExplode.play();
    }

    public void stopExplodingSound( ) {
        bombExplode.stop();
    }

    public void stopAll(){
        if (themeSong.getStatus().equals(MediaPlayer.Status.PLAYING))
            themeSong.stop();
        if (startGame.getStatus().equals(MediaPlayer.Status.PLAYING))
            startGame.stop();
        if (sliceSound.getStatus().equals(MediaPlayer.Status.PLAYING))
            sliceSound.stop();
        if (gameOver.getStatus().equals(MediaPlayer.Status.PLAYING))
            gameOver.stop();
        if (bombExplode.getStatus().equals(MediaPlayer.Status.PLAYING))
            bombExplode.stop();
    }






}
