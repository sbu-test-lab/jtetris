//
// Translated by CS2J (http://www.cs2j.com): 9/29/2020 3:11:50 PM
//

package sbu.testlab.cases.jtetris.models.elements;


/**
 * A kind of Polygon class the shape is like a S character.
 */
public class S  extends Polygon
{
    public S() {
        occupied[0][1] = true;
        occupied[1][1] = true;
        occupied[1][2] = true;
        occupied[2][2] = true;
    }

}


