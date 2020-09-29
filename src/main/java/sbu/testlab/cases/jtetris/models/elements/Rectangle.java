//
// Translated by CS2J (http://www.cs2j.com): 9/29/2020 3:11:49 PM
//

package sbu.testlab.cases.jtetris.models.elements;

/**
 * A type of block is the rectangle block. This block has
 * two possible positions — vertical and horizontal.
 * It is modelled by a class Rectangle which inherits Block and adds to the constructor
 *  a statement stating that the width (and height) of the grid is 4, and a statement
 *  stating that the rectangle is in one of the two positions — vertical or horizontal
 */
public class Rectangle  extends Block 
{
    private Grid state1;
    private Grid state2;

    public Rectangle() {
        super(4);
        state1 = new Grid(4,4);
        state1.occupied[1][0] = true;
        state1.occupied[1][1] = true;
        state1.occupied[1][2] = true;
        state1.occupied[1][3] = true;

        state2 = new Grid(4,4);
        state2.occupied[0][2] = true;
        state2.occupied[1][2] = true;
        state2.occupied[2][2] = true;
        state2.occupied[3][2] = true;

        this.occupied = state1.occupied;
    }

    public void rotate() {

        if (this.occupied.equals(state1.occupied)) {
            this.occupied = state2.occupied;
        }
        else {
            this.occupied = state1.occupied;
        }

    }

}


