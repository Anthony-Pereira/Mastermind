package com.company;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Game extends Mastermind {

    /**
     * Switch between the game and the developer mode.
     * @param args
     *            Value who define the system mode.
     *            This value is chosen in Jshell otherwise system config.properties is charged.
     * @return the system mode.
     */
    public boolean systemMode(String[] args){

        this.systemMode = false;
        this.systemMode = Boolean.valueOf(String.valueOf(args[0]));
        if (args[0].equals("dev")) { this.systemMode = true; }
        logger.info(String.format("system mode = %s",this.systemMode));

        return this.systemMode;
    }


    /**
     * Name creation.
     * @return the username.
     */
    public String createName () {

        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/name.jpg");
        this.name = (String) JOptionPane.showInputDialog(null,"ENTER YOUR NAME","MASTERMIND",
                JOptionPane.INFORMATION_MESSAGE,icon_01,null,"USER");
        logger.info(String.format("username = %s",this.name));
        return this.name;
    }

    /**
     * Game introduction.
     */
    public void introduction (){

        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/mastermind_brain.jpg");
        ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/presentation.jpg");
        JOptionPane.showMessageDialog(null, null, "MASTERMIND",
                JOptionPane.INFORMATION_MESSAGE, icon_01);
        JOptionPane.showMessageDialog
                (null, "WELCOME TO THE MASTERMIND GAMES\nIT'S YOUR BUDDY BRAINY AND IT'S A PLEASURE TO MEET YOU\n", "MASTERMIND",
                        JOptionPane.INFORMATION_MESSAGE, icon_02);
    }

    /**
     * Game menu.
     *
     * @return the choose of user.
     */
    public int menu () {

        String[] options = {"PUZZLE", "ENIGMA"};
        ImageIcon icon = new ImageIcon("src/com/resources/picture/mode.jpg");
        this.menu = JOptionPane.showOptionDialog(null, "", "MASTERMIND",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
        logger.warn(String.format("menu choice = %s",this.menu));
        return this.menu;
    }

    /**
     * Game mode.
     * @param menu
     * @return the choose of user.
     */
    public int games (int menu){

        this.menu = menu;
        String[] options = {"CHALLENGER", "DEFENDER", "DUEL"};

        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/game.jpg");
        ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/rule.jpg");
        ImageIcon icon_03 = new ImageIcon("src/com/resources/picture/mr_cpu_angry.jpg");

        this.mode = JOptionPane.showOptionDialog(null, "", "MASTERMIND",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]);

        switch (this.mode){
            case 0:
                JOptionPane.showMessageDialog(null, "CHALLENGER MODE\nFIND MY SECRET COMBINATION\nGOOD LUCK !","MASTERMIND",
                        JOptionPane.INFORMATION_MESSAGE, icon_02);break;
            case 1:
                JOptionPane.showMessageDialog(null, "DEFENDER MODE\nI MUST FIND YOU'RE SECRET COMBINATION", "MASTERMIND",
                        JOptionPane.INFORMATION_MESSAGE, icon_02);break;
            case 2:
                JOptionPane.showMessageDialog(null, "DUEL MODE\nTURN-BASED\nFIND MY NUMBER\nGOOD LUCK !", "MASTERMIND",
                        JOptionPane.INFORMATION_MESSAGE, icon_03);break;
        }
        logger.info(String.format("menu choice = %s",this.menu));
        logger.warn(String.format("game choice = %s",this.mode));
        return this.mode;
    }

    public String getName() { return this.name; }

    /**
     *         User can chose his name.
     *
     *     <p>
     *          setname is configured for respected some rules.
     *          You need to respect the limit mini and limit maxi define in Config.properties to choose a name.
     *     </p>
     * @param  name
     */
    public void setName(String name) throws IOException {

        Properties p = new Properties();
        InputStream is = new FileInputStream("src/com/resources/Config.properties");
        p.load(is);

        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/invalid_input.jpg");

        do {
            if (this.name.length() < Integer.parseInt(p.getProperty("limitNameMini")) || this.name.length() > Integer.parseInt(p.getProperty("limitNameMaxi"))) {
                JOptionPane.showMessageDialog(null, "INVALID NAME", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_01);
                logger.error(String.format("typing error for the player's name"));
                this.createName();
            } else this.name = name;
        } while (this.name.length() < Integer.parseInt(p.getProperty("limitNameMini")) || this.name.length() > Integer.parseInt(p.getProperty("limitNameMaxi")));
    }

    public Boolean getSystemMode() {
        return this.systemMode;
    }

    public void setSystemMode(Boolean systemMode) {
        this.systemMode = systemMode;
    }

    public int getMode() {
        return this.mode;
    }

    public int getMenu() {
        return this.menu;
    }

    public String getPlayerNumber() {
        return this.playerNumber;
    }

}
