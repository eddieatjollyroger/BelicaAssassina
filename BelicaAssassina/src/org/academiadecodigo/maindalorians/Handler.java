package org.academiadecodigo.maindalorians;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;


public class Handler implements KeyboardHandler {

    public Picture rect;
    public Picture ship;
    private Picture explosion;
    public Picture[] shots;
    public Picture[] mamona;
    private String[] direction;
    public boolean gameOver = false;
    private int[] counter = new int[50];
    public int spawnCounter = 10;


    public Handler() {
        rect = new Picture(0, 0, "resources/background.png");
        rect.draw();
        ship = new Picture(0, (int) (rect.getHeight() / 2), "resources/blica2.png");
        ship.draw();
        shots = new Picture[50];
        mamona = new Picture[50];
        direction = new String[50];
        this.direction = direction;
        for (int i = 0; i <counter.length; i++){
            counter[i] = 10;
        }
        createMamona();
        createMamona();
    }


    @Override
    public void keyPressed(KeyboardEvent event) {
        if (event.getKey() == KeyboardEvent.KEY_SPACE) {
            if (!gameOver){fireShot(); }

        }
        switch (event.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                if (ship.getMaxY() < 735) {
                    ship.translate(0, 20);
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (ship.getY() > 0) {
                    ship.translate(0, -20);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (ship.getMaxX() < 1185) {
                    ship.translate(20, 0);
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (ship.getX() > 0) {
                    ship.translate(-20, 0);
                }
                break;
        }

    }

    public void fireShot() {
        for (int i = 0; i < shots.length; i++) {
            if (shots[i] == null) {
                shots[i] = new Picture(ship.getMaxX(), (ship.getY() + (int) ((ship.getMaxY() - ship.getY()) / 2)) - 2, "resources/fireshot.png");
                if (ship.getMaxX() + shots[i].getWidth() < rect.getWidth()) {
                    shots[i].draw();
                    System.out.println(i + "boas ");
                    break;
                }
                shots[i] = null;
            }


        }
//        System.out.println("x:" + ship.getX());
//        System.out.println("y:" + ship.getY());
//        System.out.println("maxx:" + ship.getMaxX());
//        System.out.println("maxy:" + ship.getMaxY());
//        System.out.println("espermx:" + shot.getX());
//        System.out.println("spermy:" + shot.getY());
//        System.out.println("spermmaxx:" + shot.getMaxX());
//        System.out.println("spermmaxy:" + shot.getMaxY());

        //moveShot();
    }

    public void moveShot(int i) {
        if (shots[i].getMaxX() > 1185) {
            shots[i].delete();
            shots[i] = null;
            System.out.println(i);
            System.out.println(shots[i]);

        }
        if (shots[i] != null) {
            shots[i].translate(20, 0);
        }
    }

    public void createMamona() {

        for (int i = 0; i < mamona.length; i++) {
            if (mamona[i] == null) {
                mamona[i] = new Picture((int) (Math.random() +
                        (rect.getWidth() - 158)), (int) (Math.random() * (rect.getHeight() - 172)), "resources/boobies1.png");

                mamona[i].draw();
                break;
            }
        }
    }

    public void colisionDetector(int i) {
        for (int j = 0; j < mamona.length; j++) {
            if (shots[i] != null && mamona[j] != null) {
                if (mamona[j].getMaxY() - 10 > shots[i].getY() && mamona[j].getY() + 10 < shots[i].getMaxY()
                        && mamona[j].getX() + 10 < shots[i].getMaxX() && mamona[j].getMaxX() - 10 > shots[i].getX()) {
                    shots[i].delete();
                    shots[i] = null;
                    mamona[j].delete();
                    drawExplosion(mamona[j].getX(), mamona[j].getY());
                    mamona[j] = null;

                    createMamona();
                    if (Math.random() * 100 > 70) {
                        createMamona();
                    }
                    break;
                }
            }
            if (mamona[j] != null) {

                if (mamona[j].getMaxY() - 10 > ship.getY() && mamona[j].getY() + 10 < ship.getMaxY()
                        && mamona[j].getX() + 10 < ship.getMaxX() && mamona[j].getMaxX() - 10 > ship.getX()) {
                    System.out.println("boas");
                    setGameOver(true);
                }
            }
        }
    }

    public void moveMamonas(int i) {
        if (mamona[i].getX() < 10) {
            setGameOver(true);
            counter[i] = 10;
        } else if (mamona[i].getY() < 10) {
            mamona[i].translate(0, 15);
            counter[i] = 10;
        } else if (mamona[i].getMaxY() > 720) {
            mamona[i].translate(0, -15);
            counter[i] = 10;
        }
        if (counter[i] < 10) {
            if (direction[i] == "up") {
                mamona[i].translate(0, 15);
                counter[i]++;
            } else if (direction[i] == "down") {
                mamona[i].translate(0, -15);
                counter[i]++;
            } else if (direction[i] == "left") {
                mamona[i].translate(-15, 0);
                counter[i]++;
            }
        }
        if (counter[i] == 10) {
            int random = (int) (Math.random() * (100));


                if (random > 70) {                                               //  is up
                    mamona[i].translate(0, 10);
                    direction[i] = "up";
                    System.out.println("up");
                    System.out.println("ez bugzito");
                    counter[i] = 0;

                }
                else if (40 < random && random < 71 ) {
                    mamona[i].translate(0, -10);
                    direction[i] = "down";
                    System.out.println("down");
                    System.out.println("ez bugzit");
                    counter[i] = 0;
                                                                // is down
                }
                else if (random < 39) {                                               // is right
                    mamona[i].translate(-10, 0);
                    direction[i] = "left";
                    System.out.println("left");
                    System.out.println("ez bugzito");
                    counter[i] = 0;

                }
            }
        }


    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }



    public void drawExplosion(int x, int y) {
        explosion = new Picture(x, y, "resources/explosion.png");
        explosion.draw();
    }


    @Override
    public void keyReleased(KeyboardEvent event) {
        if (event.getKey() == KeyboardEvent.KEY_SPACE) {
        }
    }
}

