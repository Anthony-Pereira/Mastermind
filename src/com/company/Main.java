package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        Properties p = new Properties();
            InputStream is = new FileInputStream("src/com/resources/Config.properties");
                p.load(is);

        Mastermind mastermind = new Mastermind();
            Game game = new Game();
                Mastermind player = new Mastermind(game.getName(),mastermind.getChance(),mastermind.getPlayerNumber());
                    Mastermind brainy = new Mastermind("Brainy",mastermind.getChance(),mastermind.getBrainyNumber());

        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/replay.jpg");
            ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/main_menu.jpg");
                ImageIcon icon_03 = new ImageIcon("src/com/resources/picture/good_bye.jpg");
                    ImageIcon icon_04 = new ImageIcon("src/com/resources/picture/your_number_is.jpg");
                        ImageIcon icon_05 = new ImageIcon("src/com/resources/picture/super_brainy.jpg");

        String[] options = {"YES", "NO"};

        try {
            game.systemMode(args);
        } catch (Exception e){
            game.setSystemMode(Boolean.parseBoolean(p.getProperty("systemMode")));
            logger.debug(String.format("no developper parameter finded to Main Class\n" +
                    "value key of systemMode will be the value to  args of Main class\n" +
                    "value key = %s",p.getProperty("systemMode")));
        }

        game.introduction();
        game.setName(game.createName());
        do {
             game.menu();
                game.games(game.getMenu());

                switch (game.getMode()) {

                    case 0:
                        do {
                            logger.warn(String.format("system mode = %s",game.getSystemMode()));
                                player.reset();
                                    brainy.setBrainyNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                                        logger.warn(String.format("Brainy number = %s",brainy.getBrainyNumber()));
                                            mastermind.setAnswer(brainy.getBrainyNumber());
                            do {
                                if (game.getSystemMode() == true || Boolean.parseBoolean(p.getProperty("systemMode"))) {
                                    JOptionPane.showMessageDialog(null, "ANSWER: " +
                                            mastermind.getAnswer(), "MASTERMIND (DEVELOPER MODE)", JOptionPane.INFORMATION_MESSAGE, icon_05);
                                }
                                if (player.getChance() != 0){
                                        player.setPlayerNumber(game.showRresult(game.getMenu(),game.getMode(),mastermind.getChance()));
                                }
                                player.dialogue(game.getMode(),player.getPlayerNumber(), brainy.getBrainyNumber(), game.getName());
                                    player.logic(game.getMode(), mastermind.getNumberCase(),player.getPlayerNumber(), brainy.getBrainyNumber());
                            } while (player.getChance() != -1);

                            mastermind.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));
                                    logger.warn(String.format("replay = %s",mastermind.getReplay()));
                        } while (mastermind.getReplay() == 0);
                        break;

                    case 1:
                        do {
                            logger.warn(String.format("system mode = %s",game.getSystemMode()));
                                brainy.reset();
                                    brainy.setBrainyNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                                        logger.warn(String.format("Brainy number = %s", brainy.getBrainyNumber()));
                                            player.setPlayerNumber(game.showRresult(game.getMenu(), game.getMode(), brainy.getChance()));
                                                logger.warn(String.format("player number = %s", player.getPlayerNumber()));
                                                    mastermind.setAnswer(player.getPlayerNumber());
                            do {
                                if (game.getSystemMode() == true || Boolean.parseBoolean(p.getProperty("systemMode"))) {
                                    JOptionPane.showMessageDialog(null, "ANSWER: " +
                                            mastermind.getAnswer(), "MASTERMIND (DEVELOPER MODE)", JOptionPane.INFORMATION_MESSAGE, icon_05);
                                }
                                if (brainy.getChance() != 0){
                                    JOptionPane.showMessageDialog(null, "DIFFICULTY: "+
                                        p.getProperty("numberCase")+"\nCHANCE: "+brainy.getChance()+"\nBRAINY: YOUR NUMBER IS "+
                                            brainy.getBrainyNumber(),"MASTERMIND",JOptionPane.INFORMATION_MESSAGE,icon_04);
                                }
                                    brainy.dialogue(game.getMode(), brainy.getBrainyNumber(), player.getPlayerNumber(), game.getName());
                                        brainy.logic(game.getMode(), mastermind.getNumberCase(), brainy.getBrainyNumber(), player.getPlayerNumber());
                            } while (brainy.getChance() != -1);

                                    mastermind.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND",
                                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));
                                            logger.warn(String.format("replay = %s",mastermind.getReplay()));
                        } while (mastermind.getReplay() == 0);
                        break;

                    case 2:
                        do {
                            logger.warn(String.format("system mode = %s",game.getSystemMode()));
                                brainy.setBrainyNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                                    logger.warn(String.format("Brainy number = %s", brainy.getBrainyNumber()));
                                        mastermind.setMrCpuNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                                            logger.warn(String.format("Mr CPU number = %s",mastermind.getMrCpuNumber()));

                            player.reset();
                                brainy.reset();

                            mastermind.setAnswer(mastermind.getMrCpuNumber());
                            do {
                                do {
                                    if (game.getSystemMode() == true || Boolean.parseBoolean(p.getProperty("systemMode")))
                                        JOptionPane.showMessageDialog
                                            (null, "ANSWER: " + mastermind.getAnswer(), "MASTERMIND (DEVELOPER MODE)",
                                                JOptionPane.INFORMATION_MESSAGE, icon_05);
                                    if (player.getChance() != 0)
                                            player.setPlayerNumber(game.showRresult(game.getMenu(), game.getMode(), player.getChance()));
                                                player.dialogue(game.getMode(), player.getPlayerNumber(), mastermind.getMrCpuNumber(), game.getName());
                                                    player.logic(game.getMode(), mastermind.getNumberCase(), player.getPlayerNumber(), mastermind.getMrCpuNumber());
                                    if (player.getChance() != -1) {break;}
                                } while (player.getChance() != -1);
                                if (player.getChance() == -1) {break;}
                                do {
                                    if (brainy.getChance() != 0) JOptionPane.showMessageDialog(null, "DIFFICULTY: "+
                                        p.getProperty("numberCase")+"\nCHANCE: "+ brainy.getChance()+"\nBRAINY: YOUR NUMBER IS "+
                                            brainy.getBrainyNumber(),"MASTERMIND",JOptionPane.INFORMATION_MESSAGE,icon_04);
                                    brainy.dialogue(game.getMode(), brainy.getBrainyNumber(), mastermind.getMrCpuNumber(), game.getName());
                                    brainy.logic(game.getMode(), mastermind.getNumberCase(), brainy.getBrainyNumber(), mastermind.getMrCpuNumber());
                                    if (brainy.getChance() != -1) {break;}
                                } while (brainy.getChance() != -1);
                                if (brainy.getChance() == -1) { break;}
                            } while (player.getChance() != -1 || brainy.getChance()!= -1);
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

