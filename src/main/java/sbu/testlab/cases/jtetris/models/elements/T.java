package sbu.testlab.cases.jtetris.models.elements;


/**
 * A kind of Polygon class the shape is like a T character.
 */
public class T  extends Polygon
{
    public T() {
        occupied[1][0] = true;
        occupied[0][1] = true;
        occupied[1][1] = true;
        occupied[2][1] = true;
    }

}


