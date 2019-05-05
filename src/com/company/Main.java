package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        Getters mastermind = new Getters();
        Mastermind player = new Getters(mastermind.getName(),mastermind.getChance(),mastermind.getPlayerNumber());
        Mastermind brainy = new Getters("Brainy",mastermind.getChance(),mastermind.getBrainyNumber());
        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/replay.jpg");
        ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/main_menu.jpg");
        ImageIcon icon_03 = new ImageIcon("src/com/resources/picture/good_bye.jpg");
        ImageIcon icon_04 = new ImageIcon("src/com/resources/picture/your_number_is.jpg");
        ImageIcon icon_05 = new ImageIcon("src/com/resources/picture/super_brainy.jpg");

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
                            logger.warn(String.format("system mode = %s",mastermind.getSystemMode()));
                            player.reset();
                            ((Getters) brainy).setBrainyNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            logger.warn(String.format("Brainy number = %s",((Getters) brainy).getBrainyNumber()));
                            mastermind.setAnswer(((Getters) brainy).getBrainyNumber());
                            do {
                                if (mastermind.getSystemMode() == true || Boolean.parseBoolean(p.getProperty("systemMode")))
                                    JOptionPane.showMessageDialog(null, "ANSWER: "+
                                            mastermind.getAnswer(),"MASTERMIND (DEVELOPER MODE)", JOptionPane.INFORMATION_MESSAGE,icon_05);
                                if (((Getters) player).getChance() != 0)((Getters) player).setPlayerNumber(player.showRresult(mastermind.getMenu(),
                                        mastermind.getMode(),((Getters) player).getChance()));
                                player.dialogue(mastermind.getMode(),((Getters) player).getPlayerNumber(), ((Getters) brainy).getBrainyNumber(), ((Getters) player).getName());
                                player.logic(mastermind.getMode(), mastermind.getNumberCase(),((Getters) player).getPlayerNumber(), ((Getters) brainy).getBrainyNumber());
                            } while (((Getters) player).getChance() != -1);
                            mastermind.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND",
                                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));
                            logger.warn(String.format("replay = %s",mastermind.getReplay()));
                        } while (mastermind.getReplay() == 0);
                        break;

                    case 1:
                        do {
                            logger.warn(String.format("system mode = %s",mastermind.getSystemMode()));
                            brainy.reset();
                            ((Getters) brainy).setBrainyNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            logger.warn(String.format("Brainy number = %s",((Getters) brainy).getBrainyNumber()));
                            ((Getters) player).setPlayerNumber(brainy.showRresult(mastermind.getMenu(), mastermind.getMode(),((Getters) brainy).getChance()));
                            logger.warn(String.format("player number = %s",((Getters) player).getPlayerNumber()));
                            mastermind.setAnswer(((Getters) player).getPlayerNumber());
                            do {
                                if (mastermind.getSystemMode() == true || Boolean.parseBoolean(p.getProperty("systemMode")))
                                    JOptionPane.showMessageDialog(null, "ANSWER: "+
                                            mastermind.getAnswer(),"MASTERMIND (DEVELOPER MODE)", JOptionPane.INFORMATION_MESSAGE,icon_05);
                                if (((Getters) brainy).getChance() != 0) JOptionPane.showMessageDialog(null, "DIFFICULTY: "+
                                        p.getProperty("numberCase")+"\nCHANCE: "+((Getters) brainy).getChance()+"\nBRAINY: YOU'RE NUMBER IS "+
                                        ((Getters) brainy).getBrainyNumber(),"MASTERMIND",JOptionPane.INFORMATION_MESSAGE,icon_04);
                                brainy.dialogue(mastermind.getMode(), ((Getters) brainy).getBrainyNumber(), ((Getters) player).getPlayerNumber(),((Getters) brainy).getName());
                                brainy.logic(mastermind.getMode(), mastermind.getNumberCase(), ((Getters) brainy).getBrainyNumber(), ((Getters) player).getPlayerNumber());
                            } while (((Getters) brainy).getChance() != -1);
                            mastermind.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND",
                                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));
                            logger.warn(String.format("replay = %s",mastermind.getReplay()));
                        } while (mastermind.getReplay() == 0);
                        break;

                    case 2:
                        do {
                            logger.warn(String.format("system mode = %s",mastermind.getSystemMode()));
                            ((Getters) brainy).setBrainyNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            logger.warn(String.format("Brainy number = %s",((Getters) brainy).getBrainyNumber()));
                            mastermind.setMrCpuNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                            logger.warn(String.format("Mr CPU number = %s",mastermind.getMrCpuNumber()));

                            player.reset();
                            brainy.reset();

                            mastermind.setAnswer(mastermind.getMrCpuNumber());
                            do {
                                do {
                                    if (mastermind.getSystemMode() == true || Boolean.parseBoolean(p.getProperty("systemMode")))
                                        JOptionPane.showMessageDialog(null, "ANSWER: "+mastermind.getAnswer(),"MASTERMIND (DEVELOPER MODE)", JOptionPane.INFORMATION_MESSAGE,icon_05);
                                    if (((Getters) player).getChance() != 0) ((Getters) player).setPlayerNumber(player.showRresult(mastermind.getMenu(), mastermind.getMode(),((Getters) player).getChance()));
                                    player.dialogue(mastermind.getMode(),((Getters) player).getPlayerNumber(), mastermind.getMrCpuNumber(), ((Getters) player).getName());
                                    player.logic(mastermind.getMode(), mastermind.getNumberCase(),((Getters) player).getPlayerNumber(), mastermind.getMrCpuNumber());
                                    if (((Getters) player).getChance() != -1) {break;}
                                } while (((Getters) player).getChance() != -1);
                                if (((Getters) player).getChance() == -1) {break;}
                                do {
                                    if (((Getters) brainy).getChance() != 0) JOptionPane.showMessageDialog(null, "DIFFICULTY: "+
                                            p.getProperty("numberCase")+"\nCHANCE: "+((Getters) brainy).getChance()+"\nBRAINY: YOU'RE NUMBER IS "+
                                            ((Getters) brainy).getBrainyNumber(),"MASTERMIND",JOptionPane.INFORMATION_MESSAGE,icon_04);
                                    brainy.dialogue(mastermind.getMode(), ((Getters) brainy).getBrainyNumber(), mastermind.getMrCpuNumber(),((Getters) brainy).getName());
                                    brainy.logic(mastermind.getMode(), mastermind.getNumberCase(), ((Getters) brainy).getBrainyNumber(), mastermind.getMrCpuNumber());
                                    if (((Getters) brainy).getChance() != -1) { break; }
                                } while (((Getters) brainy).getChance() != -1);
                                if (((Getters) brainy).getChance() == -1) { break;}
                            } while (((Getters) player).getChance() != -1 || ((Getters) brainy).getChance()!= -1);
                            mastermind.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND",
                                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));
                            logger.warn(String.format("replay = %s",mastermind.getReplay()));
                        } while (mastermind.getReplay() == 0);
                        break;

                            default:
                }
            mastermind.setMainMenu(JOptionPane.showOptionDialog(null, "MAIN MENU ?", "MASTERMIND",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_02, options, options[0]));
            logger.warn(String.format("main menu = %s",mastermind.getMainMenu()));
        }while (mastermind.getMainMenu() == 0);
        JOptionPane.showMessageDialog(null, "", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_03);
    }
}

