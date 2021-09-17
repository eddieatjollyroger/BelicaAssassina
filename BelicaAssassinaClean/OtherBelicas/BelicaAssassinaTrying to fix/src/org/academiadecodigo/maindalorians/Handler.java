package org.academiadecodigo.maindalorians;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Handler implements KeyboardHandler {
    private Game game;
    private Belica ship;

    public Handler(Game game, Belica ship) {
        this.game = game;
        this.ship = ship;
    }

    @Override
    public void keyPressed(KeyboardEvent event) {
        if (event.getKey() == KeyboardEvent.KEY_SPACE) {
            if (!game.isGameOver()) {
                game.fireShot();
            }
        }
        if (event.getKey() == KeyboardEvent.KEY_ENTER) {
            if (game.isGameOver()) {
                game.setResetGame(true);
            }
        }
        switch (event.getKey()) {
            case KeyboardEvent.KEY_DOWN -> ship.moveShipDown();
            case KeyboardEvent.KEY_UP -> ship.moveShipUp();
            case KeyboardEvent.KEY_RIGHT -> ship.moveShipRight();
            case KeyboardEvent.KEY_LEFT -> ship.moveShipLeft();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent event) {
    }
}

