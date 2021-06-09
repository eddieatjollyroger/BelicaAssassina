package org.academiadecodigo.maindalorians;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Start implements KeyboardHandler {
    private Game game;
    private static Start handler;
    int x = 0;
    Picture startGame = new Picture(0, 0, "resources/background.png");
    Picture gameStart = new Picture(310, 80, "resources/splash.png");

    public Start(Game game){
    this.game = game;
    }

    public void initScreen() {

        handler = new Start(game);

        Keyboard keyboard = new Keyboard(handler);
        KeyboardEvent enterKeyPress = new KeyboardEvent();
        enterKeyPress.setKey(KeyboardEvent.KEY_ENTER);
        enterKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(enterKeyPress);

        startGame.draw();
        gameStart.draw();
    }

    @Override
    public void keyPressed(KeyboardEvent event) {

        if (event.getKey() == KeyboardEvent.KEY_ENTER) {
            System.out.println("beuas");
            game.screen = 2;



        }
    }
        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){

        }


    }
