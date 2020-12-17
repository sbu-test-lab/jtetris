package sbu.testlab.cases.jtetris;

import sbu.testlab.cases.jtetris.models.elements.Square;

public class FakeLancher {
    public static void main(String[] args) {
        Square s1 = new Square();
        s1.beAddedToScreen();
        s1.moveRight();
        s1.moveRight();
        s1.moveDown();
        s1.moveLeft();
        s1.moveRight();
        s1.moveRight();
        s1.moveDown();
        s1.beAddedToScreen();
        System.out.println("create a square and move it");
    }
}
