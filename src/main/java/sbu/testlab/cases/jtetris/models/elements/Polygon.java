package sbu.testlab.cases.jtetris.models.elements;

/**
 * Five types of blocks are polygons (classes T, S, L, Z and ReverseL). Each can be represented
 * by a grid whose width and height are 3. Hence, we define a general class Polygon
 * from which the individual polygon classes can be derived.
 */
public class Polygon  extends Block 
{
    public Polygon() {
        super(3);
    }

    public void rotate() {
        boolean[][] rot = new boolean[this.width][this.width];

        for (int i = 0;i < this.height;i++) {
            rot[i][2] = this.occupied[0][i];
            rot[i][1] = this.occupied[1][i];
            rot[i][0] = this.occupied[2][i];
        }

        this.occupied = rot;
    }

}


