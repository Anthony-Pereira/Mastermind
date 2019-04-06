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
                                mastermind.showRresult(mastermind.getMenu(), mastermind.getMode(),mastermind.getRandomNumber());
                                mastermind.dialogue(mastermind.getMode(), mastermind.getPlayerNumber(), mastermind.getRandomNumber(), mastermind.getName());
                                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getPlayerNumber(), mastermind.getRandomNumber());
                            } while (mastermind.getChance() !=0);
                            mastermind.setReplay(JOptionPane.showConfirmDialog(null,String.format("REPLAY",JOptionPane.YES_NO_OPTION)));
                        } while (mastermind.getReplay() ==0);
                        break;

                    case 2 :
                        do {
                            mastermind.setName("CPU");
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.setComputerNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            mastermind.setPlayerNumber(JOptionPane.showInputDialog(null, String.format("DIFFICULTY: %s\n\nCHOOSE A COMBINATION",p.getProperty("numberCase"))));
                            do {
                                JOptionPane.showMessageDialog(null,String.format("DIFFICULTY: %s\nCHANCE: %s\n\nCPU: YOU'RE NUMBER IS %s",p.getProperty("numberCase"),mastermind.getChance(),mastermind.getComputerNumber()));
                                mastermind.dialogue(mastermind.getMode(), mastermind.getComputerNumber(), mastermind.getPlayerNumber(),mastermind.getName());
                                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getComputerNumber(), mastermind.getPlayerNumber());
                            } while (mastermind.getChance() !=0);
                                mastermind.setReplay(JOptionPane.showConfirmDialog(null,String.format("REPLAY",JOptionPane.YES_NO_OPTION)));
                        } while (mastermind.getReplay() ==0);
                        break;

                    case 3 :
                        do {
                            mastermind.setRefereeNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            System.out.println("referee number is: "+mastermind.getRefereeNumber());

                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase")));

                            JOptionPane.showMessageDialog(null,String.format("DIFFICULTY: %s\nCHANCE: %s\n\nREFEREE: FIND MY NUMBER",p.getProperty("numberCase"),mastermind.getChance(),mastermind.getComputerNumber()));

                            do {
                                    do {
                                        mastermind.showRresult(mastermind.getMenu(), mastermind.getMode(),mastermind.getRandomNumber());
                                        mastermind.dialogue(mastermind.getMode(), mastermind.getPlayerNumber(), mastermind.getRandomNumber(), mastermind.getName());
                                        mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getPlayerNumber(), mastermind.getRandomNumber());
                                        if (mastermind.getChance() !=0) break;
                                    } while (mastermind.getChance() !=0);
                                do {
                                    JOptionPane.showMessageDialog(null,String.format("DIFFICULTY: %s\nCHANCE: %s\n\nCPU: YOU'RE NUMBER IS %s",p.getProperty("numberCase"),mastermind.getChance(),mastermind.getComputerNumber()));
                                    mastermind.dialogue(mastermind.getMode(), mastermind.getComputerNumber(), mastermind.getPlayerNumber(),mastermind.getName());
                                    mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getComputerNumber(), mastermind.getPlayerNumber());
                                    if (mastermind.getChance() !=0) break;
                                } while (mastermind.getChance() !=0);



                            } while (mastermind.getReplay() ==0);
                                mastermind.setReplay(JOptionPane.showConfirmDialog(null, String.format("REPLAY", JOptionPane.YES_NO_OPTION)));
                        }  while (mastermind.getReplay() ==0) ;

                            break;

                            default:
                }
    }
}

