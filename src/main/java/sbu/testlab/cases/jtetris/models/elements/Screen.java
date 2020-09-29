//
// Translated by CS2J (http://www.cs2j.com): 9/29/2020 3:11:50 PM
//

package sbu.testlab.cases.jtetris.models.elements;

import sbu.testlab.cases.jtetris.models.game.Tetris;

/**
 * The playing screen is that portion of the actual computer screen in which
 * blocks can occur. It can be modelled by a grid object whose width is 10 and height
 * is 22. The occupied positions, corresponding to fallen blocks, form a contiguous
 * shape at the bottom of the screen
 * The playing screen is, therefore, modelled by a class Screen which inherits
 * Grid and set width to 10 and height to 22.
 * Initially, at the beginning of a game, the playing screen
 * will have no occupied positions. The class Screen has two main operations: AddBlock
 * corresponding to a block being added to the screen and RemoveRow correspond-
 * ing to a fully occupied row of the screen being removed.
 *
 */
public class Screen  extends Grid {

    public Screen() {
        super(10, 22);
    }

    public void addBlock(Grid ocupp) {
        this.occupied = union(this.occupied,ocupp.occupied);
    }

    public void removeBlock(Tetris tetris) {
        int j = 0;
        while (j < this.height)
        {
            if (this.isRow(j,true))
            {
                this.shiftToDown(j);
                tetris.advanceScore();
            }
            else
                j++; 
        }
    }

    public Grid union(Grid g1, Grid g2) {
        Grid result = new Grid(g1.width,g1.height);
        result.occupied = union(g1.occupied,g2.occupied);
        return result;
    }

}


