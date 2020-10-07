package sbu.testlab.cases.jtetris.models.elements;

/**
 * The class Grid models a two dimensional grid which may have some of its
 * positions filled. It is used in the specification to define both the playing screen and
 * the various types of blocks of the game.
 */
public class Grid {
    public final int width;
    public final int height;

    public boolean[][] occupied;

    public Grid(int w, int h) {
        width = w;
        height = h;
        occupied = new boolean[w][h];
    }

    protected void fillCell(int x, int y) {
        occupied[x][y] = true;
    }

    protected void unFillCell(int x, int y){
        occupied[x][y] = false;
    }

    public boolean isFinish(Grid block){
        for (int i = 0;i < block.occupied.length;i++) {

            for (int j = 0;j < block.occupied[0].length;j++) {

                if (block.occupied[i][j]) {
                    if (j == 0 || this.occupied[i][j - 1]) {
                        return true;
                    }

                }
                 
            }
        }
        return false;
    }

    protected boolean[][] union(boolean[][] c1, boolean[][] c2) {
        int w=c1.length;
        int h=c1[0].length;
        boolean[][] result = new boolean[w][h];

        for (int i = 0;i < w;i++) {

            for (int j = 0;j < h;j++){

                result[i][j] = c1[i][j] | c2[i][j];
            }
        }

        return result;
    }

    protected boolean isRow(int index, boolean predicate){
        Grid g = this;
        int w = g.occupied.length;

        boolean r = true;
        for (int i = 0;i < w;i++)
            if (g.occupied[i][index] != predicate)
                r = false;
             
        return r;
    }

    protected boolean isColumn(int index, boolean predicate) {
        Grid g = this;
        int h = g.occupied[0].length;

        boolean r = true;
        for (int i = 0;i < h;i++)
            if (g.occupied[index][i] != predicate)
                r = false;
             
        return r;
    }

    public void shiftToLeft() {
        Grid g = this;

        int w = g.occupied.length;
        int h = g.occupied[0].length;

        for (int i = 1;i < w;i++)
            for (int j = 0;j < h;j++)
                g.occupied[i - 1][j] = g.occupied[i][j];

        for (int j = 0;j < h;j++)
            g.occupied[w - 1][j] = false;
    }

    public void shiftToRight() {
        Grid g = this;

        int w = g.occupied.length;
        int h = g.occupied[0].length;

        for (int i = w - 1;i > 0;i--)
            for (int j = 0;j < h;j++)
                g.occupied[i][j] = g.occupied[i - 1][j];

        for (int j = 0;j < h;j++)
            g.occupied[0][j] = false;
    }

    public void shiftToDown(int index){
        Grid g = this;

        int w = g.occupied.length;
        int h = g.occupied[0].length;

        for (int j = index + 1;j < h;j++)
            for (int i = 0;i < w;i++)
                g.occupied[i][j - 1] = g.occupied[i][j];

        for (int i = 0;i < w;i++)
            g.occupied[i][h - 1] = false;
    }

}


