package io.github.mysterix5.sortgame;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/game")
public class SortGameController {
    @GetMapping
    public Game getPlayingField(){
        GameProperties gameProperties = new GameProperties(4, 6, 2);
        Game game = new Game(gameProperties);

        List<Container> dummyGameWon = new ArrayList<>();
        Container container = new Container(gameProperties.getContainerHeight());
        container.addColor(Color.BLUE);
        container.addColor(Color.BLUE);
        container.addColor(Color.BLUE);
        container.addColor(Color.BLUE);
        dummyGameWon.add(container);
        dummyGameWon.add(new Container(gameProperties.getContainerHeight()));
        PlayingField playingField = new PlayingField(gameProperties.getContainerHeight());
        playingField.setContainers(dummyGameWon);
        game.setPosition(playingField);
        System.out.println("won? " + game.isWon());
//        System.out.println("solvable? " + game.isSolvable());
        System.out.println(game);


        game.setPosition(StaticMethods.createDummyGame(gameProperties));
        System.out.println("won? " + game.isWon());
//        System.out.println("solvable? " + game.isSolvable());
        return game;
    }
}
