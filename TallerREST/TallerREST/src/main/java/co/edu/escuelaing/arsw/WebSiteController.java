package co.edu.escuelaing.arsw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class WebSiteController {
    @Autowired
    PlayDB plays;

    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(
            value = "/status",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. "
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Running!\"}";
    }

    /**
     * This API method returns a json with the following format
     * @return {"timestamp" : <date+time>, "receivedMsg" : "val=<val>&player=<player>"}
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(
            value = "/play",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public String play(@RequestParam(value = "val", defaultValue = "-1") String val,
                       @RequestParam(value = "player", defaultValue = "--") String player) {
        String played = "{\"timestamp\":\""
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "\","
                + "\"val\":\"" + val + "\",\"jugador\":\"" +  player + "\"}";
        plays.setPlay(played);
        return played;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(
            value = "/getPlay",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public String getPlays(){
        String play = plays.getPlay();
        if ("".equals(play)){
            return "";
        }
        return play;
    }



}

