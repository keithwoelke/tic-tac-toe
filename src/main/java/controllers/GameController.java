package controllers;

import models.ComputerPlayer;
import models.GameBoard;
import models.GameConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@EnableAutoConfiguration
@RequestMapping("/tic-tac-toe")
public class GameController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GameController.class, args);
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GameBoard newGame(@RequestBody GameConfig gameConfig) {
        if (gameConfig == null) {
            GameConfig.GameConfigBuilder gameConfigBuilder = GameConfig.builder();
            gameConfig = gameConfigBuilder.build();
        }

        GameBoard gameBoard = new GameBoard(gameConfig);
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            gameBoard = new ComputerPlayer(gameConfig).takeTurn(gameBoard);
        }

        return gameBoard;
    }

    @ResponseBody
    @RequestMapping(path = "/play", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GameBoard play(@RequestBody GameBoard gameBoard) {
        return new ComputerPlayer(gameBoard.getGameConfig()).takeTurn(gameBoard);
    }
}
