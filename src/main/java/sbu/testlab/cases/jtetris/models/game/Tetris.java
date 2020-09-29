//
// Translated by CS2J (http://www.cs2j.com): 9/29/2020 3:11:50 PM
//

package sbu.testlab.cases.jtetris.models.game;


import sbu.testlab.cases.jtetris.models.elements.*;

import java.util.Random;

/**
 * The game of Tetris is modeled by a class Tetris whose includes six
 * methods. Three of these — MoveRight , MoveLeft and Rotate — model the
 * player’s options of moving the falling block left or right or rotating it respectively.
 * The other three operations — MoveDown , AddBlock and RemoveRow — modelling
 * a block moving down one row, a block being added to the screen, and a row
 * being removed, are controlled by the GameController class.
 */
public class Tetris
{
    public static int DIRECT = 0;
    public static int LEFT = 1;
    public static int RIGHT = 2;
    public static int ROTATE = 3;

    /**
     * The random seed is a fixed number by intention to grantee deterministic behavior
     * to support test phase like automation testing.
     * for deployment version we should use System.currentTimeMillis() instead of constant seed.
     */
    Random random = new Random(1);

    public Screen screen;
    public Block block;
    public int score;

    public Tetris() {
        screen = new Screen();
        score = 0;
        addBlock();
    }

    public void runOneStep(int dir)  {
        if (!screen.isFinish(block.beAddedToScreen()))
        {
            if (dir == LEFT)
                block.moveLeft();
            else if (dir == RIGHT)
                block.moveRight();
            else if (dir == ROTATE)
                block.rotate();
            else
                block.moveDown();   
        }
        else
        {
            screen.addBlock(block.beAddedToScreen());
            addBlock();
        } 
        screen.removeBlock(this);
    }

    public Grid getGameFrame() {
        return screen.union(screen,block.beAddedToScreen());
    }

    public void addBlock() {

        switch(random.nextInt(8))
        {
            case 0: 
                block = new Square();
                break;
            case 1: 
                block = new Rectangle();
                break;
            case 2: 
                block = new Square();
                break;
            case 3: 
                block = new L();
                break;
            case 4: 
                block = new S();
                break;
            case 5: 
                block = new T();
                break;
            case 6: 
                block = new Z();
                break;
            case 7: 
                block = new ReverseL();
                break;
        
        }
    }

    public void advanceScore() {
        score += 10;
    }

}


