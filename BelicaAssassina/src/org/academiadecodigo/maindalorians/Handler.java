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
    public Picture[] shots;
    private Mamonas mamona;
    private Picture[] mamonas;

    public boolean gameOver = false;

    public Handler() {
        rect = new Picture(0, 0, "resources/background.png");
        rect.draw();
        ship = new Picture(0, rect.getHeight()/2, "resources/blica1.png");
        ship.draw();
        shots = new Picture[50];
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
        mamona = new Mamonas(rect);
        mamona.createMamona();
        mamonas = mamona.getMamona();

    }

    public void colisionDetector(int i) {
        for (int j = 0; j < mamonas.length; j++) {
            if (shots[i] != null && mamonas[j] != null) {
                if ((shots[i].getMaxX() >= mamonas[j].getX()) && shots[i].getY() >= mamonas[j].getY() && shots[i].getMaxY() <= mamonas[j].getMaxY()) {
                    shots[i].delete();
                    shots[i] = null;
                    mamonas[j].delete();
                    mamonas[j] = null;
                    break;
                }
            }
        }
    }
    @Override
    public void keyReleased(KeyboardEvent event) {
        if (event.getKey() == KeyboardEvent.KEY_SPACE) {
        }
    }
}

