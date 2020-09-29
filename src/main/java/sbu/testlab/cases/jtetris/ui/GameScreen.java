package sbu.testlab.cases.jtetris.ui;

import sbu.testlab.cases.jtetris.models.elements.Grid;
import sbu.testlab.cases.jtetris.models.game.Tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameScreen extends JPanel implements ActionListener {
    enum Movement{
        Direct,
        Left,
        Right,
        Rotate
    }

    private final int SCREEN_WIDTH = 10*30;
    private final int SCREEN_HEIGHT = 22*30;

    //timer delay between each movement
    private final int DELAY = 300;
    private Timer timer;

    // a flag for game-over detection
    private boolean inGame = true;


    private Tetris tetrisGameModel;
    private Movement nextPlayerMovement=Movement.Direct;
    private boolean nextMoveIsFallMove=true;

    public GameScreen() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        //loadImages();
        initGame();
    }

    private void initGame() {

        tetrisGameModel=new Tetris();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        if (inGame) {

            int w = SCREEN_WIDTH / 10;
            int h = SCREEN_HEIGHT / 22;

            Grid blocks = tetrisGameModel.getGameFrame();
            for (int i = 0;i < blocks.occupied.length;i++)
            {
                for (int j = 0;j < blocks.occupied[0].length;j++)
                {
                    if (blocks.occupied[i][j])
                    {
                        g.setColor(Color.white);
                        g.drawRect(i * w, -1 * (j * h) + 21 * h, w, h);
                     }

                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (SCREEN_WIDTH - metr.stringWidth(msg)) / 2, SCREEN_HEIGHT / 2);
    }

    private void moveBasedOnPlayerIntention() {
       switch (nextPlayerMovement){
           case Left:tetrisGameModel.runOneStep(Tetris.LEFT);
           break;
           case Right:tetrisGameModel.runOneStep(Tetris.RIGHT);
               break;
           case Rotate:tetrisGameModel.runOneStep(Tetris.ROTATE);
               break;
           case Direct:tetrisGameModel.runOneStep(Tetris.DIRECT);
               break;
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            if(nextMoveIsFallMove){
                tetrisGameModel.runOneStep(Tetris.DIRECT);
                nextMoveIsFallMove=false;
            }
            else {
                moveBasedOnPlayerIntention();
                nextPlayerMovement=Movement.Direct;
                nextMoveIsFallMove=true;
            }
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT)) {
                nextPlayerMovement=Movement.Left;
            }

            if ((key == KeyEvent.VK_RIGHT)) {
                nextPlayerMovement=Movement.Right;
            }

            if ((key == KeyEvent.VK_UP)) {
                nextPlayerMovement=Movement.Rotate;
            }

            if ((key == KeyEvent.VK_DOWN)) {
                nextPlayerMovement=Movement.Rotate;
            }
        }
    }
}