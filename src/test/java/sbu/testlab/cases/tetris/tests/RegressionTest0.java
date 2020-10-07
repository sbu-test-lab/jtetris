package sbu.testlab.cases.tetris.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sbu.testlab.cases.jtetris.models.elements.Square;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        Square s1 = new Square();

        s1.moveRight();
        s1.moveRight();
        s1.moveDown();
        s1.moveRight();
        s1.moveDown();

        Assert.assertEquals(s1.x_position, 3);
        Assert.assertEquals(s1.y_position, 18);
        Assert.assertEquals(s1.occupied[0][0], true);
        Assert.assertEquals(s1.occupied[0][1], true);
        Assert.assertEquals(s1.occupied[1][0], true);
        Assert.assertEquals(s1.occupied[1][1], true);
    }

}

