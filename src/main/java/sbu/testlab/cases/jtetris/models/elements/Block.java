//
// Translated by CS2J (http://www.cs2j.com): 9/29/2020 3:11:49 PM
//

package sbu.testlab.cases.jtetris.models.elements;

/**
 * we specify a general and abstract class Block from which other block shpaes can be de-
 * rived, we inherit the class Grid. Constructor indicates that the width and the height
 * of the grid are equal and that there are four occupied positions.
 * We also add state variables x_position and y_position denoting
 * the block’s position on the playing screen
 */
abstract public class Block  extends Grid 
{
    public int x_position, y_position;

    public Block(int len) {
        super(len, len);
        y_position = 22 - height;
        x_position = 3;
    }

    public void moveRight() {
        if (x_position + width < 10) {
            x_position++;
        }
        else if (this.isColumn(width - 1,false)) {
            this.shiftToRight();
        }
    }

    public void moveLeft() {
        if (x_position > 0)
            x_position--;
        else if (this.isColumn(0,false))
        {
            this.shiftToLeft();
        }
          
    }

    public void moveDown() {
        if (y_position > 0)
            y_position--;
        else if (this.isRow(0,false))
            this.shiftToDown(0);
          
    }

    public void rotate() {
    }

    public Grid beAddedToScreen() {
        Grid result = new Grid(10,22);
        for (int i = 0;i < this.width;i++)
        {
            for (int j = 0;j < this.height;j++)
            {
                result.occupied[x_position + i][ y_position + j] = this.occupied[i][j];
            }
        }
        return result;
    }

}


