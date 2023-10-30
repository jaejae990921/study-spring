package com.example.SpringEx.game;

import org.springframework.stereotype.Component;

@Component
public class GameEngine {
    private GameConsole game;

    public GameEngine(GameConsole game) {
        this.game = game;
    }

    public void run() {
        game.up();
        game.down();
        game.right();
        game.left();
    }
}