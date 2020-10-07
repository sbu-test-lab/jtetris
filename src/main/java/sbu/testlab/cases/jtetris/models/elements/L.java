package sbu.testlab.cases.jtetris.models.elements;

/**
 * A kind of Polygon class the shape is like a L character.
 */
public class L  extends Polygon {

    public L()  {
        occupied[1][0] = true;
        occupied[1][2] = true;
        occupied[1][1] = true;
        occupied[2][0] = true;
    }
}


