package co.edu.escuelaing.arsw;

import org.springframework.stereotype.Component;

@Component
public class PlayDB {
    private String play= "";
    public void PlayDB(){};
    public void setPlay(String play){
        this.play = play;
    }
    public String getPlay(){
        String tmp = play;
        play = "";
        return tmp;
    }
}
