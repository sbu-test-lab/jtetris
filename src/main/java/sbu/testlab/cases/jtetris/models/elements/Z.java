//
// Translated by CS2J (http://www.cs2j.com): 9/29/2020 3:11:50 PM
//

package sbu.testlab.cases.jtetris.models.elements;

/**
 * A kind of Polygon class the shape is like a Z character.
 */
public class Z  extends Polygon 
{
    public Z() {
        occupied[0][2] = true;
        occupied[1][2] = true;
        occupied[1][1] = true;
        occupied[2][1] = true;
    }

}


