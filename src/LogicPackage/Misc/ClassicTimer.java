package LogicPackage.Misc;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ClassicTimer {
    private static ClassicTimer instance;
    private static Timeline timeline;
    private Text text;
    private String time;

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }

    public int getSecs() {
        return secs;
    }

    public void setSecs(int secs) {
        this.secs = secs;
    }

    public int getMillis() {
        return millis;
    }

    public void setMillis(int millis) {
        this.millis = millis;
    }

    private int mins = 0, secs = 0, millis = 0;
    private Label timerLabel = new Label();
    boolean sos = true;
    boolean counting = false;
    boolean flag = false;
    Font labelFont = new Font("verdana",22);


    private void setTime(String time){
        this.time = time;
        timerLabel.setText(time);
    }
    public  Timeline getTimeline() {
        return timeline;
    }

    private ClassicTimer(){

    }
    public static ClassicTimer getInstance(){
        if (instance== null) {
            instance = new ClassicTimer();
        }
        return instance;
    }

    public Label getTimeLabel(){
        setTime("00:00");
        timerLabel.setTextFill(Color.WHITE);
        timerLabel.setFont(labelFont);
        //Timer for timerLabel------------------------------------------------------------------------------------------
        timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change(text);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.play();
        flag = true;
        counting = true;
        //--------------------------------------------------------------------------------------------------------------
        return timerLabel;
    }
    private void change(Text text) {
        if(millis == 1000) {
            secs++;
            millis = 0;
        }
        if(secs == 60) {
            mins++;
            secs = 0;
        }
        setTime((((mins/10) == 0) ? "0" : "") + mins + ":"
                + (((secs/10) == 0) ? "0" : "") + secs);
        millis++;
    }
    public void pauseTimer(){
        if (counting)
        {   timeline.pause();
        counting = false;}
    }
    public void playTimer(){
        if (!counting){
        timeline.play();
        counting = true;}
    }
    public void resetTimer(){
        if (flag){
        mins = 0;
        secs = 0;
        millis = 0;
        timeline.pause();
        counting = false;
        setTime("00:00");
        if(!sos) {
            sos = true;
        }}
    }
    public String getcurrentTime() {
        return time;
    }
}
