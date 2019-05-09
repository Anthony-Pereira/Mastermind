package com.game;

import javax.swing.*;
import java.io.*;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* <b>the Main Class launches the game execution</b>
* @see Mastermind
* @see Game
* @author Anthony Pereira
* @version %I%, %G%
*/
public class Main {

    static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        Properties p = new Properties();
            InputStream is = new FileInputStream("src/com/resources/Config.properties");
                p.load(is);

            Game game = new Game();
            Game player = new Game();
            Game brainy = new Game();
            player.setChance(Integer.parseInt(p.getProperty("chance")));
            brainy.setChance(Integer.parseInt(p.getProperty("chance")));
            brainy.setName("brainy");
            game.setNumberCase(Integer.parseInt(p.getProperty("numberCase")));

        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/replay.jpg");
            ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/main_menu.jpg");
                ImageIcon icon_03 = new ImageIcon("src/com/resources/picture/good_bye.jpg");
                    ImageIcon icon_04 = new ImageIcon("src/com/resources/picture/your_number_is.jpg");
                        ImageIcon icon_05 = new ImageIcon("src/com/resources/picture/super_brainy.jpg");
                            ImageIcon icon_06 = new ImageIcon("src/com/resources/picture/stunned_brainy.jpg");

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
        player.setName(game.createName());
        do {
             game.menu();
                game.games(game.getMenu());

                switch (game.getMode()) {

                    case 0:
                        do {
                            logger.warn(String.format("system mode = %s",game.getSystemMode()));
                                player.reset();
                                    brainy.setBrainyNumber(brainy.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                                        logger.warn(String.format("Brainy number = %s",brainy.getBrainyNumber()));
                                            brainy.setAnswer(brainy.getBrainyNumber());
                            do {
                                if (game.getSystemMode() == true || Boolean.parseBoolean(p.getProperty("systemMode"))) {
                                    JOptionPane.showMessageDialog(null, "ANSWER: " +
                                            brainy.getAnswer(), "MASTERMIND (DEVELOPER MODE)", JOptionPane.INFORMATION_MESSAGE, icon_05);
                                }
                                if (player.getChance() != 0){
                                        player.setPlayerNumber(player.showResult(game.getMenu(),game.getMode(),player.getChance(),game.getNumberCase()));
                                }
                                player.dialogue(game.getMode(),player.getPlayerNumber(), brainy.getBrainyNumber(), player.getName());
                                    player.logic(game.getMode(), game.getNumberCase(),player.getPlayerNumber(), brainy.getBrainyNumber());
                            } while (player.getChance() != -1);

                            game.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));
                                    logger.warn(String.format("replay = %s",game.getReplay()));
                        } while (game.getReplay() == 0);
                        break;

                    case 1:
                        do {
                            logger.warn(String.format("system mode = %s",game.getSystemMode()));
                            player.reset();
                                brainy.reset();
                                    brainy.setBrainyNumber(brainy.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                                        logger.warn(String.format("Brainy number = %s", brainy.getBrainyNumber()));
                                            player.setPlayerNumber(player.showResult(game.getMenu(), game.getMode(), brainy.getChance(),game.getNumberCase()));
                                                logger.warn(String.format("player number = %s", player.getPlayerNumber()));
                                                    player.setAnswer(player.getPlayerNumber());
                            do {
                                if (game.getSystemMode() == true || Boolean.parseBoolean(p.getProperty("systemMode"))) {
                                    JOptionPane.showMessageDialog(null, "ANSWER: " +
                                            player.getAnswer(), "MASTERMIND (DEVELOPER MODE)", JOptionPane.INFORMATION_MESSAGE, icon_05);
                                }
                                if (brainy.getChance() != 0){
                                    JOptionPane.showMessageDialog(null, "DIFFICULTY: "+
                                            p.getProperty("numberCase")+"\nCHANCE: "+brainy.getChance()+"\nTIPS: "+
                                            brainy.getArrayClue(),"MASTERMIND",JOptionPane.INFORMATION_MESSAGE,icon_06);
                                    JOptionPane.showMessageDialog(null, "DIFFICULTY: "+
                                            p.getProperty("numberCase")+"\nCHANCE: "+brainy.getChance()+"\nBRAINY: YOUR NUMBER IS "+
                                            brainy.getBrainyNumber(),"MASTERMIND",JOptionPane.INFORMATION_MESSAGE,icon_04);
                                }
                                    brainy.dialogue(game.getMode(), brainy.getBrainyNumber(), player.getPlayerNumber(), game.getName());
                                        brainy.logic(game.getMode(), game.getNumberCase(), brainy.getBrainyNumber(), player.getPlayerNumber());
                            } while (brainy.getChance() != -1);
                                    game.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND",
                                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));
                                            logger.warn(String.format("replay = %s",game.getReplay()));
                        } while (game.getReplay() == 0);
                        break;

                    case 2:
                        do {
                            logger.warn(String.format("system mode = %s",game.getSystemMode()));
                                brainy.setBrainyNumber(brainy.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                                    logger.warn(String.format("Brainy number = %s", brainy.getBrainyNumber()));
                                        game.setMrCpuNumber(game.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
                                            logger.warn(String.format("Mr CPU number = %s",game.getMrCpuNumber()));

                            player.reset();
                                brainy.reset();

                            game.setAnswer(game.getMrCpuNumber());
                            do {
                                do {
                                    if (game.getSystemMode() == true || Boolean.parseBoolean(p.getProperty("systemMode")))
                                        JOptionPane.showMessageDialog
                                            (null, "ANSWER: " + game.getAnswer(), "MASTERMIND (DEVELOPER MODE)",
                                                JOptionPane.INFORMATION_MESSAGE, icon_05);
                                    if (player.getChance() != 0)
                                            player.setPlayerNumber(player.showResult(game.getMenu(), game.getMode(), player.getChance(),game.getNumberCase()));
                                                player.dialogue(game.getMode(), player.getPlayerNumber(), game.getMrCpuNumber(), player.getName());
                                                    player.logic(game.getMode(), game.getNumberCase(), player.getPlayerNumber(), game.getMrCpuNumber());
                                    if (player.getChance() != -1) {break;}
                                } while (player.getChance() != -1);
                                if (player.getChance() == -1) {break;}
                                do {
                                    if (brainy.getChance() != 0) JOptionPane.showMessageDialog(null, "DIFFICULTY: "+
                                        p.getProperty("numberCase")+"\nCHANCE: "+ brainy.getChance()+"\nBRAINY: YOUR NUMBER IS "+
                                            brainy.getBrainyNumber(),"MASTERMIND",JOptionPane.INFORMATION_MESSAGE,icon_04);
                                    brainy.dialogue(game.getMode(), brainy.getBrainyNumber(), game.getMrCpuNumber(), brainy.getName());
                                    brainy.logic(game.getMode(), game.getNumberCase(), brainy.getBrainyNumber(), game.getMrCpuNumber());
                                    if (brainy.getChance() != -1) {break;}
                                } while (brainy.getChance() != -1);
                                if (brainy.getChance() == -1) { break;}
                            } while (player.getChance() != -1 || brainy.getChance()!= -1);
                            game.setReplay(JOptionPane.showOptionDialog(null, "REPLAY ?", "MASTERMIND",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]));
                                    logger.warn(String.format("replay = %s",game.getReplay()));
                        } while (game.getReplay() == 0);
                        break;
                    default:
                }
            game.setMainMenu(JOptionPane.showOptionDialog(null, "MAIN MENU ?", "MASTERMIND",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_02, options, options[0]));
                    logger.warn(String.format("main menu = %s",game.getMainMenu()));
        }while (game.getMainMenu() == 0);
            JOptionPane.showMessageDialog(null, "", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_03);
    }
}

