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
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase")));
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
                            //mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase")));
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.setComputerNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            do {
                                do {
                                    mastermind.setPlayerNumber(JOptionPane.showInputDialog(null, String.format("DIFFICULTY: %s\n\nCHOOSE A COMBINATION",p.getProperty("numberCase"))));
                                    System.out.println("computer number = " + mastermind.getRandomNumber());
                                    try {
                                        mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getComputerNumber(), mastermind.getPlayerNumber());
                                        mastermind.responseIsGood = true;
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, String.format("REFEREE: ERROR RETRY"));
                                        mastermind.responseIsGood = false;
                                    }
                                } while (!mastermind.responseIsGood);
                                mastermind.dialogue(mastermind.getMode(), mastermind.getComputerNumber(), mastermind.getPlayerNumber());
                            }while (mastermind.getChance() != 0) ;
                            mastermind.setReplay(JOptionPane.showConfirmDialog(null,String.format("REPLAY",JOptionPane.YES_NO_OPTION)));
                        } while (mastermind.getReplay() == 0);
                        break;

                    case 3 :
                        break;

                        default:
                }
    }
}