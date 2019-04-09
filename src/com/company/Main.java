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
        do {
            do {
                try {
                    mastermind.menu();
                    mastermind.responseIsGood = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"PLEASE SELECT A MODE");
                    mastermind.responseIsGood = false;
                }
            } while (!mastermind.responseIsGood || mastermind.getMenu() < 1 || mastermind.getMenu() > 2 );

            do {
                try {
                    mastermind.games(mastermind.getMenu());
                    mastermind.responseIsGood = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"PLEASE SELECT A GAME");
                    mastermind.responseIsGood = false;
                }
            } while (!mastermind.responseIsGood || mastermind.getMode() < 1 || mastermind.getMode() > 3 );

                switch (mastermind.getMode()) {

                    case 1:
                        do {
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase")));
                            do {
                                mastermind.showRresult(mastermind.getMenu(), mastermind.getMode(),mastermind.getChance(), mastermind.getRandomNumber());
                                mastermind.dialogue(mastermind.getMode(), mastermind.getPlayerNumber(), mastermind.getRandomNumber(), mastermind.getName());
                                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getPlayerNumber(), mastermind.getRandomNumber());
                            } while (mastermind.getChance() != 0);
                            mastermind.setReplay(JOptionPane.showConfirmDialog(null, String.format("REPLAY", JOptionPane.YES_NO_OPTION)));
                        } while (mastermind.getReplay() == 0);
                        break;

                    case 2:
                        do {
                            mastermind.setName("CPU");
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.setComputerNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            mastermind.setPlayerNumber(JOptionPane.showInputDialog(null, String.format("%s NUMBER COMBINATION\n", p.getProperty("numberCase"))));
                            do {
                                JOptionPane.showMessageDialog(null, String.format("%s NUMBER COMBINATION\nCHANCE: %s\n\nCPU: YOU'RE NUMBER IS %s", p.getProperty("numberCase"), mastermind.getChance(), mastermind.getComputerNumber()));
                                mastermind.dialogue(mastermind.getMode(), mastermind.getComputerNumber(), mastermind.getPlayerNumber(), mastermind.getName());
                                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getComputerNumber(), mastermind.getPlayerNumber());
                            } while (mastermind.getChance() != 0);
                            mastermind.setReplay(JOptionPane.showConfirmDialog(null, String.format("REPLAY", JOptionPane.YES_NO_OPTION)));
                        } while (mastermind.getReplay() == 0);
                        break;

                    case 3:
                        do {
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase")));
                            mastermind.setRefereeNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            System.out.println("referee number is: " + mastermind.getRefereeNumber());
                            JOptionPane.showMessageDialog(null, String.format("%s NUMBER COMBINATION\n\nREFEREE: FIND MY NUMBER\nGOOD LUCK !", p.getProperty("numberCase")));

                            do {
                                do {
                                    mastermind.showRresult(mastermind.getMenu(), mastermind.getMode(),mastermind.getChance(), mastermind.getRandomNumber());
                                    mastermind.dialogue(mastermind.getMode(), mastermind.getPlayerNumber(), mastermind.getRefereeNumber(), mastermind.getName());
                                    mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getPlayerNumber(), mastermind.getRefereeNumber());
                                    if (mastermind.getChance() != 0) { break; }
                                } while (mastermind.getChance() != 0);
                                if (mastermind.getChance() == 0) { break;}
                                do {
                                    JOptionPane.showMessageDialog(null, String.format("%s NUMBER COMBINATION\nCHANCE: %s\n\nCPU: YOU'RE NUMBER IS %s", p.getProperty("numberCase"), mastermind.getChance(), mastermind.getComputerNumber()));
                                    mastermind.dialogue(mastermind.getMode(), mastermind.getComputerNumber(), mastermind.getRefereeNumber(), mastermind.getName());
                                    mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getComputerNumber(), mastermind.getRefereeNumber());
                                    if (mastermind.getChance() != 0) { break; }
                                } while (mastermind.getChance() != 0);
                                if (mastermind.getChance() == 0) { break;}
                            } while (mastermind.getChance() != 0 || mastermind.getChance() != 0);
                            mastermind.setReplay(JOptionPane.showConfirmDialog(null, String.format("REPLAY", JOptionPane.YES_NO_OPTION)));
                        } while (mastermind.getReplay() == 0);

                            break;

                            default:
                }
            mastermind.setMainMenu(JOptionPane.showConfirmDialog(null, String.format("MAIN MENU", JOptionPane.YES_NO_OPTION)));
        }while (mastermind.getMainMenu() == 0);
        JOptionPane.showMessageDialog(null,String.format("GOOD BYE"));
    }
}

