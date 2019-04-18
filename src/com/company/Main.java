package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {

        Getters mastermind = new Getters();
        Mastermind player = new Getters(mastermind.name,mastermind.getChance(),mastermind.getPlayerNumber());
        Mastermind brainy = new Getters("Brainy",mastermind.getChance(),mastermind.getBrainyNumber());
        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/replay.jpg");
        ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/main_menu.jpg");
        ImageIcon icon_03 = new ImageIcon("src/com/resources/picture/good_bye.jpg");
        ImageIcon icon_04 = new ImageIcon("src/com/resources/picture/your_number_is.jpg");

        String[] options = {"YES", "NO"};

        mastermind.systemMode(args);

        Properties p = new Properties();
        InputStream is = new FileInputStream("src/com/resources/Config.properties");
        p.load(is);

        mastermind.introduction();
        ((Getters) player).setName(player.createName());
        do {
             mastermind.menu();
             mastermind.games(mastermind.getMenu());

                switch (mastermind.getMode()) {

                    case 0:
                        do {
                            mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase")));
                            do {
                                mastermind.showRresult(mastermind.getMenu(), mastermind.getMode(),mastermind.getChance(),mastermind.getSystemMode());
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
                            mastermind.setBrainyNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            mastermind.setPlayerNumber(JOptionPane.showInputDialog(null, String.format("DIFFICULTY: %s\n", p.getProperty("numberCase"))));
                            do {
                                JOptionPane.showMessageDialog(null, "DIFFICULTY: "+p.getProperty("numberCase")+" \nCHANCE: "+mastermind.getChance()+"\nBRAINY: YOU'RE NUMBER IS "+mastermind.getBrainyNumber(),"MASTERMIND",JOptionPane.INFORMATION_MESSAGE,icon_04);
                                mastermind.dialogue(mastermind.getMode(), mastermind.getBrainyNumber(), mastermind.getPlayerNumber(), mastermind.getName());
                                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getBrainyNumber(), mastermind.getPlayerNumber());
                            } while (mastermind.getChance() != 0);
                            mastermind.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));

                        } while (mastermind.getReplay() == 0);
                        break;

                    case 2:
                        do {
                            ((Getters) player).setChance(Integer.parseInt(p.getProperty("chance")));
                            ((Getters) brainy).setChance(Integer.parseInt(p.getProperty("chance")));
                            mastermind.setMrCpuNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            ((Getters) brainy).setBrainyNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));


                            System.out.println("Mr CPU number is: " + mastermind.getMrCpuNumber());
                            System.out.println("Brainy number is: " + ((Getters) brainy).getBrainyNumber());

                            do {
                                do {
                                    player.showRresult(mastermind.getMenu(), mastermind.getMode(),((Getters) player).getChance(),mastermind.getSystemMode());
                                    player.dialogue(mastermind.getMode(),((Getters) player).getPlayerNumber(), mastermind.getMrCpuNumber(), ((Getters) player).getName());
                                    player.logic(mastermind.getMode(), mastermind.getNumberCase(),((Getters) player).getPlayerNumber(), mastermind.getMrCpuNumber());
                                    if (((Getters) player).getChance() != 0) { break; }
                                } while (((Getters) player).getChance() != 0);
                                if (((Getters) player).getChance() == 0) { break;}
                                do {
                                    //((Getters) brainy).setChance(mastermind.getChance());
                                    JOptionPane.showMessageDialog(null, "DIFFICULTY: "+p.getProperty("numberCase")+"\nCHANCE: "+((Getters) brainy).getChance()+"\nBRAINY: YOU'RE NUMBER IS "+((Getters) brainy).getBrainyNumber(),"MASTERMIND",JOptionPane.INFORMATION_MESSAGE,icon_04);
                                    brainy.dialogue(mastermind.getMode(), ((Getters) brainy).getBrainyNumber(), mastermind.getMrCpuNumber(),((Getters) brainy).getName());
                                    brainy.logic(mastermind.getMode(), mastermind.getNumberCase(), ((Getters) brainy).getBrainyNumber(), mastermind.getMrCpuNumber());
                                    if (((Getters) brainy).getChance() != 0) { break; }
                                } while (((Getters) brainy).getChance() != 0);
                                if (((Getters) brainy).getChance() == 0) { break;}
                            } while (((Getters) player).getChance() != 0 || ((Getters) brainy).getChance()!= 0);
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

