package org.blackjack.models;

import org.blackjack.enums.GameName;
import org.blackjack.enums.PlayerType;
import org.blackjack.interfaces.IPlayingStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Player {
    String id;
    String name;
    PlayerType playerType;
    IPlayingStrategy playingStrategy;
    Map<GameName, GameProperties> gamePropertiesMap;

    public Player(String name, PlayerType playerType, IPlayingStrategy playingStrategy) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.playerType = playerType;
        this.playingStrategy = playingStrategy;
        gamePropertiesMap = new HashMap<>();
    }

    public int getScore() {
        // TODO: implement me
        return 0;
    }

    public void addGameProperty(GameProperties gameProperties) {
        gamePropertiesMap.putIfAbsent(gameProperties.gameName, gameProperties);
    }
}
