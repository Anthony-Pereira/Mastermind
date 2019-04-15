package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {

        Getters mastermind = new Getters();
        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/replay.jpg");
        ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/main_menu.jpg");
        ImageIcon icon_03 = new ImageIcon("src/com/resources/picture/good_bye.jpg");
        String[] options = {"YES", "NO"};

        mastermind.systemMode(args);

        Properties p = new Properties();
        InputStream is = new FileInputStream("src/com/resources/Config.properties");
        p.load(is);

        mastermind.introduction();
        mastermind.setName(mastermind.createName());
        do {
             mastermind.menu();
             mastermind.games(mastermind.getMenu());

                switch (mastermind.getMode()) {

                    case 0:
                        do {
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase")));
                            do {
                                mastermind.showRresult(mastermind.getMenu(), mastermind.getMode(),mastermind.getChance(), mastermind.getRandomNumber());
                                mastermind.dialogue(mastermind.getMode(), mastermind.getPlayerNumber(), mastermind.getRandomNumber(), mastermind.getName());
                                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getPlayerNumber(), mastermind.getRandomNumber());
                            } while (mastermind.getChance() != 0);
                            mastermind.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));
                        } while (mastermind.getReplay() == 0);
                        break;

                    case 1:
                        do {
                            mastermind.setName("BRAINY");
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.setComputerNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            mastermind.setPlayerNumber(JOptionPane.showInputDialog(null, String.format("%s NUMBER COMBINATION\n", p.getProperty("numberCase"))));
                            do {
                                JOptionPane.showMessageDialog(null, String.format("%s NUMBER COMBINATION\nCHANCE: %s\n\nCPU: YOU'RE NUMBER IS %s", p.getProperty("numberCase"), mastermind.getChance(), mastermind.getComputerNumber()));
                                mastermind.dialogue(mastermind.getMode(), mastermind.getComputerNumber(), mastermind.getPlayerNumber(), mastermind.getName());
                                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getComputerNumber(), mastermind.getPlayerNumber());
                            } while (mastermind.getChance() != 0);
                            mastermind.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));

                        } while (mastermind.getReplay() == 0);
                        break;

                    case 2:
                        do {
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.setRefereeNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            mastermind.setComputerNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            System.out.println("referee number is: " + mastermind.getRefereeNumber());
                            System.out.println("cpu number is: " + mastermind.getComputerNumber());

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
                                    System.out.println("***referee number is: " + mastermind.getRefereeNumber());
                                    mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getComputerNumber(), mastermind.getRefereeNumber());
                                    if (mastermind.getChance() != 0) { break; }
                                } while (mastermind.getChance() != 0);
                                if (mastermind.getChance() == 0) { break;}
                            } while (mastermind.getChance() != 0 || mastermind.getChance() != 0);
                            mastermind.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));
                        } while (mastermind.getReplay() == 0);
                        break;

                            default:
                }
            mastermind.setMainMenu(JOptionPane.showOptionDialog(null, "MAIN MENU ?", "MASTERMIND", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_02, options, options[0]));
        }while (mastermind.getMainMenu() == 0);
        JOptionPane.showMessageDialog(null, "", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_03);
    }
}

