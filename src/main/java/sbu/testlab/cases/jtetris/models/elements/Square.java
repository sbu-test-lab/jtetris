package sbu.testlab.cases.jtetris.models.elements;

/**
 * Class Square inherits Block and adds to the constructor
 * the statement stating that the width, and therefore the height, of the grid is 2.
 * Since rotating a square block has no effect on the occupied positions — all
 * positions are occupied and remain so — the definition of the Rotate method
 * is completed in this class by just adding it with no statements.
 */
public class Square  extends Block
{
    public Square() {
        super(2);
        occupied[0][ 0] = true;
        occupied[0][1] = true;
        occupied[1][0] = true;
        occupied[1][1] = true;
    }

//    @Override
//    public void rotate(){
//        // do nothing
//    }
}


