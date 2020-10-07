package sbu.testlab.cases.jtetris.models.elements;


/**
 * A kind of Polygon class the shape is like a reverse L character.
 */
public class ReverseL  extends Polygon 
{
    public ReverseL()  {
        occupied[0][0] = true;
        occupied[1][0] = true;
        occupied[1][1] = true;
        occupied[1][2] = true;
    }

}


