package org.academiadecodigo.maindalorians;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    private static Handler handler;

    public Game() {

    }

    public void init() {

        handler = new Handler();

        Keyboard keyboard = new Keyboard(handler);

        KeyboardEvent spacePressed = new KeyboardEvent();

        KeyboardEvent upArrowPress = new KeyboardEvent();

        KeyboardEvent downArrowPress = new KeyboardEvent();

        KeyboardEvent leftArrowPress = new KeyboardEvent();

        KeyboardEvent rightArrowPress = new KeyboardEvent();

        KeyboardEvent enterKeyPress = new KeyboardEvent();

        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        upArrowPress.setKey(KeyboardEvent.KEY_UP);
        upArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        downArrowPress.setKey(KeyboardEvent.KEY_DOWN);
        downArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        leftArrowPress.setKey(KeyboardEvent.KEY_LEFT);
        leftArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        rightArrowPress.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        enterKeyPress.setKey(KeyboardEvent.KEY_ENTER);
        enterKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(spacePressed);
        keyboard.addEventListener(upArrowPress);
        keyboard.addEventListener(downArrowPress);
        keyboard.addEventListener(leftArrowPress);
        keyboard.addEventListener(rightArrowPress);
        keyboard.addEventListener(enterKeyPress);


    }

    public void start() {
        while (!handler.gameOver) {
            for (int i = 0; i < handler.shots.length; i++) {
                if (handler.shots[i] != null && handler.shots[i].getMaxX() < handler.rect.getWidth()) {
                    handler.moveShot(i);
                    handler.colisionDetector(i);
                }
            }

            for (int i = 0; i < handler.mamona.length; i++) {
                if (handler.mamona[i] != null) {
                    handler.moveMamonas(i);
                    handler.colisionDetector(i);
                }
            }
            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gameOver();
    }

    public void gameOver() {
        int x = 0;
        while (handler.resetGame == 0) {
            Picture overGame = new Picture(0, 0, "resources/background.png");
            Picture gameOver = new Picture(0, 0, "resources/gameover.png");
            if (x == 0) {
                overGame.draw();
                gameOver.draw();
                x++;
            }
        }
        restart();
    }

//    public void startScreen(){
//        int x = 0;
//        while (handler.gameStart == 0){
//            Picture startGame = new Picture(0, 0, "resources/background.png");
//            Picture gameStart = new Picture(0, 0, "resources/splash.png");
//            if (x == 0){
//                startGame.draw();
//                gameStart.draw();
//                x++;
//            }
//        }
//        restart();
//    }

    public void restart() {
        handler = null;
        init();
        start();

    }

}


