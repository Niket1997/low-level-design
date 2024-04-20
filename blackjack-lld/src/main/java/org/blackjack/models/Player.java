package org.blackjack.models;

import org.blackjack.enums.GameName;
import org.blackjack.enums.PlayerType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Player {
    String id;
    String name;
    PlayerType playerType;
    Map<GameName, GameProperties> gamePropertiesMap;

    public Player(String name, PlayerType playerType) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.playerType = playerType;
        gamePropertiesMap = new HashMap<>();
    }

    public void addGameProperty(GameProperties gameProperties) {
        gamePropertiesMap.putIfAbsent(gameProperties.gameName, gameProperties);
    }
}
