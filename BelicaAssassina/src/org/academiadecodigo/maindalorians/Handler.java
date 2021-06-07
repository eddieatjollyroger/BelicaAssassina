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
    private Mamonas mamona;
    public Picture[] mamonas;
    private String direction;
    public boolean gameOver = false;
    private int counter = 0;
    public int spawnCounter= 10;


    public Handler() {
        rect = new Picture(0, 0, "resources/background.png");
        rect.draw();
        ship = new Picture(0, (int) (rect.getHeight()/2), "resources/blica2.png");
        ship.draw();
        shots = new Picture[50];
          createMamona();
          createMamona();
    }


    @Override
    public void keyPressed(KeyboardEvent event) {
        if (event.getKey() == KeyboardEvent.KEY_SPACE) {
            fireShot();
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
                shots[i]=null;
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

    public void createMamona(){
        mamona = new Mamonas(rect, this);
        mamona.createMamona();
        mamonas = mamona.getMamona();
        System.out.println(spawnCounter);
        spawnCounter--;

        if (spawnCounter == 0){
                   spawnCounter = 10;
        }
    }

    public void colisionDetector(int i) {
        for (int j = 0; j < mamonas.length; j++) {
            if (shots[i] != null && mamonas[j] != null) {
                if ((shots[i].getMaxX() >= mamonas[j].getX()+10) &&
                        shots[i].getY() >= mamonas[j].getY() &&
                        shots[i].getMaxY() <= mamonas[j].getMaxY()) {
                    shots[i].delete();
                    shots[i] = null;
                    mamonas[j].delete();
                    drawExplosion(mamonas[j].getX(), mamonas[j].getY());
                    mamonas[j] = null;
                    createMamona();

                    break;
                }
            }                                                                     
            if (mamonas[j] != null){

                     if(mamonas[j].getMaxY()-10 > ship.getY() && mamonas[j].getY()+10 < ship.getMaxY()
                     && mamonas[j].getX()+10 < ship.getMaxX() && mamonas[j].getMaxX()-10 > ship.getX()) {
                         System.out.println("boas");
                         setGameOver(true);
                     }
        }
    }
    }
    public void moveMamonas(int i) {
     mamona.moveMamonas(i);
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void drawExplosion(int x, int y){
      explosion = new Picture(x, y, "resources/explosion.png");
      explosion.draw();
    }

    @Override
    public void keyReleased(KeyboardEvent event) {
        if (event.getKey() == KeyboardEvent.KEY_SPACE) {
        }
    }
}

