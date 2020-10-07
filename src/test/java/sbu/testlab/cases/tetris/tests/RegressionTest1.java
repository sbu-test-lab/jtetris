package sbu.testlab.cases.tetris.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest1 {

    public static boolean debug = false;

    @Test
    public void test501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test501");
        sbu.testlab.cases.jtetris.models.game.Tetris tetris0 = new sbu.testlab.cases.jtetris.models.game.Tetris();
        tetris0.addBlock();
        tetris0.moveLeft();
        tetris0.moveRight();
        tetris0.moveLeft();
    }

 }

