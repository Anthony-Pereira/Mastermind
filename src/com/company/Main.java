package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {

        Mastermind mastermind = new Mastermind();
        mastermind.systemMode(args);

        Properties p = new Properties();
        InputStream is = new FileInputStream("src/com/resources/Config.properties");
        p.load(is);

                mastermind.introduction();
                mastermind.createName();
                mastermind.menu();
                mastermind.games(mastermind.getMenu());

                switch (mastermind.getMode()){

                    case 1 :
                        do {
                            mastermind.randomNumber(mastermind.getMode(), Integer.parseInt(p.getProperty("numberCase")));
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            do {
                                mastermind.showRresult(mastermind.getMenu(), mastermind.getMode());
                                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getPlayerNumber(), mastermind.getRandomNumber());
                                mastermind.dialogue(mastermind.getMode(), mastermind.getPlayerNumber(), mastermind.getRandomNumber()); //corriger laffichege de entity  celui ci renvoi null
                            } while (mastermind.getChance() != 0);
                            mastermind.setReplay(JOptionPane.showConfirmDialog(null,String.format("REPLAY",JOptionPane.YES_NO_OPTION)));
                        } while (mastermind.getReplay() == 0);
                        break;

                    case 2 :
                        do {
                            mastermind.randomNumber(mastermind.getMode(), mastermind.getNumberCase());
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            do {
                                mastermind.showRresult(mastermind.getMenu(), mastermind.getMode());
                                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getRandomNumber(), mastermind.getPlayerNumber());
                                mastermind.dialogue(mastermind.getMode(), mastermind.getRandomNumber(), mastermind.getPlayerNumber());
                            } while (mastermind.getChance() != 0);
                            mastermind.setReplay(JOptionPane.showConfirmDialog(null,String.format("REPLAY",JOptionPane.YES_NO_OPTION)));
                        } while (mastermind.getReplay() == 0);
                        break;

                    case 3 :
                        break;

                        default:
                }
    }
}