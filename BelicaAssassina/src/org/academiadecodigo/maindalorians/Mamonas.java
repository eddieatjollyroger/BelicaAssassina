package org.academiadecodigo.maindalorians;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Mamonas {
    private int x;
    private int y;
    private Picture[] mamona = new Picture[25];
    private Picture rect;

    public Mamonas(Picture rect) {
        this.rect = rect;
    }

    public void createMamona() {
        int counter = (int) Math.random()*2;
        for (int i = 0; i < mamona.length; i++) {
            if (mamona[i] == null) {
                mamona[i] = new Picture((int) (Math.random() +
                        (rect.getWidth() / 2)), (int) (Math.random() * (rect.getHeight()-172)), "resources/boobies1.png");
                drawMamonas(i);
                break;
            }
        }
    }
    public void drawMamonas(int i){
    mamona[i].draw();
    }

    public Picture[] getMamona(){
    return mamona;
    }

    public void collisionDetector(int i){
    }
}