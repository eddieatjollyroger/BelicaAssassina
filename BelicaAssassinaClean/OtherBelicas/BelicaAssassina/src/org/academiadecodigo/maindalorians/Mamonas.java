package org.academiadecodigo.maindalorians;

//import org.academiadecodigo.simplegraphics.graphics.Rectangle;
//import org.academiadecodigo.simplegraphics.pictures.Picture;
//
//public class Mamonas {
//
//    public Picture[] mamona = new Picture[50];
//    private Picture rect;
//    private String direction;
//    private int counter = 4;
//    private Handler handler;
//    public int spawnMaker = 0;
//
//    public Mamonas(Picture rect, Handler handler) {
//        this.rect = rect;
//        this.direction = direction;
//        this.handler = handler;
//    }
//
//    public void createMamona() {
//        int counter = (int) Math.random()*2;
//        for (int i = 0; i < mamona.length; i++) {
//            if (mamona[i] == null) {
//                mamona[i] = new Picture((int) (Math.random() +
//                        (rect.getWidth() / 2)), (int) (Math.random() * (rect.getHeight()-172)), "resources/boobies1.png");
//                drawMamonas(i);
//                break;
//            }
//        }
//    }
//    public void drawMamonas(int i){
//    mamona[i].draw();
//    }
//    public String getDirection() {
//        return direction;
//    }
//
//    public Picture[] getMamona(){
//    return mamona;
//    }
//public void moveMamonas(int i){
//    if (mamona[i].getX() < 10) {
//        handler.setGameOver(true);
//        counter = 4;
//    } else if (mamona[i].getY() < 10) {
//        mamona[i].translate(0, 20);
//        counter = 4;
//    } else if (mamona[i].getMaxY() > 720) {
//        mamona[i].translate(0, -20);
//        counter = 4;
//    }
//    if (counter < 4) {
//        if (this.direction == "up") {
//            mamona[i].translate(0, 20);
//            counter++;
//        } else if (this.direction == "down") {
//            mamona[i].translate(0, -20);
//            counter++;
//        } else if (this.direction == "left") {
//            mamona[i].translate(-20, 0);
//            counter++;
//        }
//    }
//    if (counter == 4) {
//        switch ((int) (Math.random() * (4))) {
//
//            case 0: {                                               //  is up
//                mamona[i].translate(0, 20);
//                direction = "up";
//                System.out.println("up");
//                counter = 0;
//                break;
//            }
//            case 1: {
//                mamona[i].translate(0, -20);
//                direction = "down";
//                System.out.println("down");
//                counter = 0;
//                break;                                              // is down
//            }
//            case 2: {                                               // is right
//                mamona[i].translate(-20, 0);
//                direction = "left";
//                System.out.println("left");
//                counter = 0;
//                break;
//            }
//        }
//    }
//
//}
//    public void collisionDetector(int i){
//    }
//}