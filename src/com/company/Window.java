package com.company;

import javax.swing.*;
import java.awt.*;

public class Window  extends JFrame {
    private Panel panelMode = new Panel();
    private Panel panelGame = new Panel();

    private JButton button01 = new JButton("PUZZLE");
    private JButton button02 = new JButton("ENIGMA");
    private JButton button03 = new JButton("CHALLENGER");
    private JButton button04 = new JButton("DEFENDER");
    private JButton button05 = new JButton("DUEL");




    public Window (){}

    public void mode () {
        this.setTitle("MASTERMIND");
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        panelMode.add(button01);
        panelMode.add(button02);
        this.setContentPane(panelMode);
        panelMode.setBackground(Color.ORANGE);

    }

    public void game () {
        this.setTitle("MASTERMIND");
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        panelGame.add(button03);
        panelGame.add(button04);
        panelGame.add(button05);

        this.setContentPane(panelGame);
        panelGame.setBackground(Color.ORANGE);

    }
}
