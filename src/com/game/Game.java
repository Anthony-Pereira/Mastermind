package com.game;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Game extends Mastermind {

    public Game () {}

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

    /**
     * Insert the number chosen by the user.
     * @param menu
     * Sets the style mode for input window.
     * @param mode
     * @param chance
     * allows to know the number of chance remaining in the sentence.
     * @return input of user.
     */
    public String showRresult (int menu,int mode,int chance,int numberCase) throws IOException {

        Properties p = new Properties();
        InputStream is = new FileInputStream("src/com/resources/Config.properties");
        p.load(is);

        this.menu = menu;
        this.mode = mode;
        this.chance = chance;
        this.numberCase = numberCase;

        String previousNumber;

        if (this.playerNumber.length() != Integer.parseInt(p.getProperty("numberCase"))){
            previousNumber = "???";
            logger.error(String.format("typing error previous number = %s",previousNumber));
        } else {
            previousNumber = this.playerNumber;
            logger.info(String.format("good seizure previous number = %s",previousNumber));
        }

        switch (this.menu){

            case 0 : this.playerNumber = JOptionPane.showInputDialog
                    (null, (String.format("DIFFICULTY: %s\nCHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s TIPS: %s ",
                            this.numberCase, this.chance, this.name.toUpperCase(), previousNumber, this.arrayClue)));
                break;
            case 1 : this.playerNumber = JOptionPane.showInputDialog
                    (null, String.format("DIFFICULTY: %s\nCHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s ",
                            this.numberCase, this.chance, this.name.toUpperCase(), previousNumber, this.numberWellPositioned, this.numberPresent));
                break;
        }

        logger.info(String.format("menu choice = %s",this.menu));
        logger.info(String.format("game choice = %s",this.mode));
        logger.info(String.format("number case = %s",this.numberCase));
        logger.info(String.format("chance = %s",this.chance));
        logger.info(String.format("name = %s",this.name));
        logger.warn(String.format("previous number = %s",previousNumber));
        logger.warn(String.format("player number = %s",this.playerNumber));
        logger.warn(String.format("array clue = %s",this.arrayClue));
        logger.warn(String.format("number well positioned = %s",this.numberWellPositioned));
        logger.warn(String.format("number present = %s",this.numberPresent));
        return this.playerNumber;
    }

    /**
     * Defines the game interactivity.
     * @param mode
     * @param parameter1
     * allows to defines the interactivity.
     * @param parameter2
     * allows to defines the interactivity.
     * @param name
     * allows to defines the interactivity.
     */
    public void dialogue (int mode, String parameter1, String parameter2, String name) {

        this.mode = mode;
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.name = name;

        logger.info(String.format("game choice = %s",this.mode));
        logger.info(String.format("username = %s",this.name));

        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/pain_brainy.jpg");
        ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/happy_brainy.jpg");
        ImageIcon icon_03 = new ImageIcon("src/com/resources/picture/wrong_answer_brainy.jpg");
        ImageIcon icon_04 = new ImageIcon("src/com/resources/picture/mr_cpu_pain.jpg");
        ImageIcon icon_05 = new ImageIcon("src/com/resources/picture/mr_cpu_happy.jpg");
        ImageIcon icon_06 = new ImageIcon("src/com/resources/picture/mr_cpu_wrong_answer.jpg");

        switch (this.mode){

            case 0 :
                if (this.parameter1.equals(this.parameter2)) {
                    JOptionPane.showMessageDialog(null, "BRAINY: CONGRATULATION "+this.name.toUpperCase()+
                            " , YOU WIN !\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_01);
                    Integer.toString(this.chance = -1);
                } else if (this.chance == 0) {
                    JOptionPane.showMessageDialog(null, "BRAINY: YOU DON'T HAVE TRIES ANYMORE\nPADLOCK WAS: "+
                            this.parameter2+"\nYOU LOOSE\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_02);
                    Integer.toString(this.chance = -1);
                }else {
                    JOptionPane.showMessageDialog(null, "WRONG ANSWER","MASTERMIND",
                            JOptionPane.INFORMATION_MESSAGE,icon_03);
                    this.chance--;
                }
                logger.warn(String.format("chance = %s",this.chance));
                break;

            case 1 :
                if (this.parameter1.equals(this.parameter2)) {
                    JOptionPane.showMessageDialog(null, "BRAINY: YEAH !!! I WIN !\n","MASTERMIND",
                            JOptionPane.INFORMATION_MESSAGE,icon_02);
                    Integer.toString(this.chance = -1);
                } else if (this.chance == 0) {
                    JOptionPane.showMessageDialog(null, "BRAINY: I DON'T HAVE TRIES ANYMORE\nPADLOCK WAS: "+
                            this.parameter2+"\nYOU WIN\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_01);
                    Integer.toString(this.chance = -1);
                }else {
                    JOptionPane.showMessageDialog(null, "WRONG ANSWER","MASTERMIND",
                            JOptionPane.INFORMATION_MESSAGE,icon_03);
                    this.chance--;
                }
                logger.warn(String.format("chance = %s",this.chance));
                break;

            case 2 :
                if (this.parameter1.equals(this.parameter2)) {
                    JOptionPane.showMessageDialog(null, "CPU: CONGRATULATION "+this.name.toUpperCase()+
                            " WIN !\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_04);
                    Integer.toString(this.chance = -1);
                } else if (this.chance == 0) {
                    JOptionPane.showMessageDialog(null, "CPU: YOU DON'T HAVE TRIES ANYMORE\nPADLOCK WAS: "+
                            this.parameter2+"\nYOU LOOSE\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_05);
                    Integer.toString(this.chance = -1);
                }else {
                    JOptionPane.showMessageDialog(null, "WRONG ANSWER","MASTERMIND",
                            JOptionPane.INFORMATION_MESSAGE,icon_06);
                    this.chance--;
                }
                logger.warn(String.format("chance = %s",this.chance));
                break;
        }
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

        this.name = name;
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

    /**
     *     A number chosen by the player.
     *
     *     <p>
     *          setPlayerNumber is configured for respected some rules.
     *          Like insert the good number quantity and insert only numeric characters with condition and regex.
     *     </p>
     *
     * @param playerNumber
     */
    public void setPlayerNumber(String playerNumber) throws IOException {

        Game game = new Game();
        Properties p = new Properties();
        InputStream is = new FileInputStream("src/com/resources/Config.properties");
        p.load(is);
        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/invalid_input.jpg");

        boolean regexPlayerNumber = this.playerNumber.matches("^[0-9]+$");

        logger.warn(String.format("player number -> numeric = %s",regexPlayerNumber));
        do {
            if (this.playerNumber.length() < Integer.parseInt(p.getProperty("numberCase")) || this.playerNumber.length() > Integer.parseInt(p.getProperty("numberCase")) || !regexPlayerNumber) {
                JOptionPane.showMessageDialog(null, "INVALID NUMBER", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_01);
                logger.error(String.format("typing error for the player's number"));
                this.showRresult(this.menu,this.mode,this.chance,this.numberCase);
            } else this.playerNumber = playerNumber;
        } while (this.playerNumber.length() < Integer.parseInt(p.getProperty("numberCase")) || this.playerNumber.length() > Integer.parseInt(p.getProperty("numberCase")));
    }
    public String getPlayerNumber() { return this.playerNumber; }
    public String getArrayClue() { return arrayClue; }
}
