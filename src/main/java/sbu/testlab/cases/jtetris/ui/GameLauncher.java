package sbu.testlab.cases.jtetris.ui;

import javax.swing.*;
import java.awt.*;

public class GameLauncher extends JFrame {

    public GameLauncher(){
        add(new GameScreen());

        setResizable(false);
        pack();

        setTitle("JTetris");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame gameLauncher = new GameLauncher();
                gameLauncher.setVisible(true);
            }
        });
    }
}

