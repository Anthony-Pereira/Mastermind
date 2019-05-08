package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <b>Mastermind is the Class representing the Mastermind Game.</b>
 * <p>
 * this game is characterized by the following information:
 * <ul>
 *      <li>You can switch between the game and the developer mode</li>
 *      <li>A variable who return if the result is true or false</li>
 *      <li>A menu with two style mode</li>
 *      <li>A menu with three games mode</li>
 *      <li>A possibility to replay the games</li>
 *      <li>A possibility to return on the main menu</li>
 *      <li>A chance number defined by the user</li>
 *      <li>A number case defined by the user</li>
 *      <li>A random number defined by the random number method</li>
 *      <li>A minimum number defined by the user</li>
 *      <li>A maximum number defined by the user</li>
 *      <li>A clue telling the user how many number are present in the user's game</li>
 *      <li>A clue telling the user how many number are well positioned in the user's game</li>
 *      <li>A given solution if the user is in developer mode</li>
 *      <li>A useful parameter 1 for the comparison table</li>
 *      <li>A useful parameter 2 for the comparison table</li>
 *      <li>A number chosen by the player</li>
 *      <li>A number chosen by brainy</li>
 *      <li>A number chosen by Mr computer</li>
 *      <li>A clues indicating each number if it is greater, inferior or equal to the result that the user must find</li>
 *      <li>User can chose his name</li>
 *      <li>A given solution if the user is in developer mode</li>
 *      <li>Dialogues for interactivity </li>
 * </ul>
 * </p>
 * @see Mastermind
 * @see Game
 * @author Anthony Pereira
 * @version %I%, %G%
 */
public class Mastermind {

    static final Logger logger = LogManager.getLogger();

    /**
     * System mode. This mode can be modified.
     * @see Game#systemMode(String[])
     * @see Game#getSystemMode()
     */
    protected Boolean systemMode;

    /**
     * Menu mode. This menu can be changed.
     * @see Game#menu()
     * @see Game#getMenu()
     */
    protected  int menu;

    /**
     * Game mode. This menu can be changed.
     * <p>
     *      User chose one of three game.
     * </p>
     * @see Game#games(int)
     * @see Game#getMode()
     */
    protected  int mode;

    /**
     * <p>
     *      At the end game, replay can be changed for restart a game party.
     * </p>
     * @see Mastermind#getReplay()
     * @see Mastermind#setReplay(int)
     */
    protected  int replay;

    /**
     * <p>
     *      If the game party it's not replayed, you can return at main menu.
     * </p>
     * @see Mastermind#getMainMenu()
     * @see Mastermind#setMainMenu(int)
     */
    protected  int mainMenu;

    /**
     * number of chances to find the answer.
     * <p>
     *    Defined in the Config.properties file.
     * </p>
     * @see Game#showRresult(int, int, int)
     * @see Mastermind#dialogue(int, String, String, String)
     * @see Mastermind#reset()
     * @see Mastermind#getChance()
     */
    protected  int chance;

    /**
     * Lenght of number which determines the difficulty.
     * <p>
     *      Defined in the Config.properties file.
     * </p>
     * @see Mastermind#randomNumber(int)
     * @see Game#showRresult(int, int, int)
     * @see Mastermind#reset()
     * @see Mastermind#getNumberCase()
     */
    protected  int numberCase;

    /**
     * Random number who define the first number that Brainy and Mr Computer choose.
     * <p>
     *      This number is defined by the number of case selected in Config.properties file and we use this number in
     *      factor for have a minimum number and a maximum number of same numeration.
     *      Finally with an algorithm, we extract a random number.
     * </p>
     * @see Mastermind#randomNumber(int)
     * @see Mastermind#getNumberCase()
     * @see Mastermind#setBrainyNumber(String)
     * @see Mastermind#setMrCpuNumber(String)
     */
    protected  int randomNumber;

    /**
     * Minimum number used for create a random number.
     * @see Mastermind#randomNumber(int)
     */
    protected  int minimumNumber;

    /**
     * Maximum number used for create a random number.
     * @see Mastermind#randomNumber(int)
     */
    protected  int maximumNumber;

    /**
     * A clue who help the user to know how many number are present to the proposition.
     * @see Game#showRresult(int, int, int)
     * @see Mastermind#logic(int, int, String, String)
     * @see Mastermind#reset()
     */
    protected  int numberPresent;

    /**
     * A clue who help the user to know how many number are well positioned to the proposition.
     * @see Game#showRresult(int, int, int)
     * @see Mastermind#logic(int, int, String, String)
     * @see Mastermind#reset()
     */
    protected  int numberWellPositioned;

    /**
     * The answer is given when the developer mode is activated.
     *<p>
     *     If system mode = true, the developer mode is activated and all result will be give.
     *</p>
     * @see Mastermind#getAnswer()
     * @see Mastermind#setAnswer(String)
     */
    protected String answer;

    /**
     *     A useful parameter 1 for the comparison table.
     *     <p>
     *         Parameter 1 takes the value of playerNumber in using the parameter of the logic method.
     *     </p>
     * @see Mastermind#logic(int, int, String, String)
     */
    protected String parameter1;

    /**
     *     A useful parameter 2 for the comparison table.
     *     <p>
     *         Parameter 2 takes the value of playerNumber in using the parameter of the logic method.
     *     </p>
     * @see Mastermind#logic(int, int, String, String)
     */
    protected String parameter2;

    /**
     *     A number chosen by the player.
     *     <p>
     *          setPlayerNumber is configured for respected some rules.
     *          Like insert the good number quantity and insert only numeric characters with condition and regex.
     *     </p>
     * @see Mastermind#reset()
     * @see Mastermind#getPlayerNumber()
     * @see Mastermind#setPlayerNumber(String)
     */
    protected String playerNumber;

    /**
     *     A number chosen by Brainy.
     *     <p>
     *          Brainy number is created with random number.
     *     </p>
     * @see Mastermind#logic(int, int, String, String)
     * @see Mastermind#getBrainyNumber()
     * @see Mastermind#setBrainyNumber(String)
     */
    protected String brainyNumber;

    /**
     *     A number chosen by Mr Computer.
     *     <p>
     *          Mr Computer number is created with random number.
     *     </p>
     * @see Mastermind#getMrCpuNumber() ()
     * @see Mastermind#setMrCpuNumber(String)
     */
    protected String mrCpuNumber;

    /**
     *     A clues indicating each number if it is greater, inferior or equal to the result that the user must find.
     *     <p>
     *          If number is greater,our number will increase of +1
     *          else if number is inferior, our number will decrease of -1
     *          If the number is equal, it will stay the same.
     *     </p>
     * @see Game#showRresult(int, int, int)
     * @see Mastermind#logic(int, int, String, String)
     * @see Mastermind#reset()
     * @see Mastermind#getMrCpuNumber() ()
     * @see Mastermind#setMrCpuNumber(String)
     */
    protected String arrayClue;

    /**
     *         User can chose his name.
     *     <p>
     *          setname is configured for respected some rules.
     *          You need to respect the limit mini and limit maxi define in Config.properties to choose a name.
     *     </p>
     * @see Game#createName()
     * @see Game#showRresult(int, int, int)
     * @see Mastermind#dialogue(int, String, String, String)
     * @see Game#getName()
     * @see Game#setName(String)
     */
    protected String name;

    /**
     * Mastermind Constructor.
     * <p>
     * When you construct a Mastermind object, player number and array clue are fixed  at ???
     * and number well positioned and number present are fixed at 0.
     * </p>
     * @see Mastermind#playerNumber
     * @see Mastermind#arrayClue
     * @see Mastermind#numberWellPositioned
     * @see Mastermind#numberPresent
     */
     public Mastermind(){

         this.playerNumber = "???";
            this.arrayClue = "???";
                this.numberWellPositioned = 0;
                    this.numberPresent = 0;
     }

    public Mastermind(String name, int chance, String parameter1){
        this.name = name;
        this.chance = chance;
        this.parameter1 = parameter1;
    }

    /**
     * Switch between the game and the developer mode.
     * @param numberCase
     * number of digits in the combination, define in Config.properties file.
     * @return a random number casted in String.
     */
    public String randomNumber(int numberCase){

         this.numberCase = numberCase;
            this.minimumNumber = (int) Math.pow(10, this.numberCase -1);
                this.maximumNumber = (int) Math.pow(10, this.numberCase) -1;
                    this.randomNumber = this.minimumNumber + (int) (Math.random() * (this.maximumNumber - this.minimumNumber + 1));

         logger.info(String.format("number case = %s",this.numberCase));
            logger.info(String.format("minimum number = %s",this.minimumNumber));
                logger.info(String.format("maximum number = %s",this.maximumNumber));
                    logger.info(String.format("random number = %s",this.randomNumber));

        return Integer.toString(randomNumber);
    }



    /**
     * Used to process information, comparison, clue.
     * @param mode
     * @param numberCase
     * number case defined by the user.
     * @param parameter1
     * allows to compare the parameter 1 and the parameter 2 between them.
     * @param parameter2
     * allows to compare the parameter 1 and the parameter 2 between them.
     */
    public void logic (int mode,int numberCase, String parameter1, String parameter2) throws IOException {

         Properties p = new Properties();
            InputStream is = new FileInputStream("src/com/resources/Config.properties");
                p.load(is);

         this.mode = mode;
            this.numberCase = numberCase;
                this.parameter1 = parameter1;
                    this.parameter2 = parameter2;

         char[] arrayClue = new char[Integer.parseInt(p.getProperty("numberCase"))];
            int[] cases = new int[Integer.parseInt(p.getProperty("numberCase"))];
                int[] arrayNumberWellPositioned = new int[Integer.parseInt(p.getProperty("numberCase"))];
                    int[] arrayIndex = new int[Integer.parseInt(p.getProperty("numberCase"))];

         this.brainyNumber = "";
            this.arrayClue = "";
                this.numberWellPositioned = 0;
                    this.numberPresent = 0;

         for (int i=0;i<Integer.parseInt(p.getProperty("numberCase"));i++) {

             if (this.parameter1.charAt(i) < this.parameter2.charAt(i)) {
                 arrayClue[i] = '+';
                    arrayNumberWellPositioned[i] = 0;
                        arrayIndex[i] = Character.getNumericValue(this.parameter1.charAt(i)) ;
                            arrayIndex[i]++;
             } else if (this.parameter1.charAt(i) > this.parameter2.charAt(i)) {
                 arrayClue[i] = '-';
                    arrayNumberWellPositioned[i] = 0;
                        arrayIndex[i] = Character.getNumericValue(this.parameter1.charAt(i));
                            arrayIndex[i]--;
             }   else {
                    arrayClue[i] = '=';
                        arrayNumberWellPositioned[i] = 1;
                            arrayIndex[i] = Character.getNumericValue(this.parameter1.charAt(i));
             }

             cases[i] = this.parameter2.indexOf(this.parameter1.charAt(i));
             if (cases[i] == -1) {
                 cases[i] = 0;
             } else if (cases[i] != -1) {
                 cases[i] = 1;
             }
             this.brainyNumber+=Integer.toString(arrayIndex[i]);

             logger.info(String.format("game choice = %s",this.mode));
                logger.info(String.format("number case = %s",this.numberCase));
                    logger.warn(String.format("number column %s = %s is becoming %s ",i,parameter1.charAt(i),arrayIndex[i]));
         }

         for (char total : arrayClue) {
             this.arrayClue+=total;
         }

         for(int total : arrayNumberWellPositioned) {
             this.numberWellPositioned += total;
         }

         for(int total : cases) {
             this.numberPresent += total;
         }

         for (int total: arrayIndex) {
             this.parameter1 += total;
         }
         logger.warn(String.format("array clue = %s",this.arrayClue));
            logger.warn(String.format("number well positioned : ", this.numberWellPositioned));
                logger.warn(String.format("number present : " ,this.numberPresent));
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

    /**
     * Resets the game.
     */
    public void reset () throws IOException {

        Properties p = new Properties();
            InputStream is = new FileInputStream("src/com/resources/Config.properties");
                p.load(is);

         this.numberCase = Integer.parseInt(p.getProperty("numberCase"));
            this.chance = Integer.parseInt(p.getProperty("chance"));
                this.playerNumber = "???";
                    this.arrayClue = "???";
                        this.numberWellPositioned = 0;
                            this.numberPresent = 0;

        logger.warn(String.format("reset number case = %s",this.numberCase));
            logger.warn(String.format("reset chance = ",this.chance));
                logger.warn(String.format("reset player number = ",this.playerNumber));
                    logger.warn(String.format("reset array clue = %s",this.arrayClue));
                        logger.warn(String.format("reset number well positioned = %s",this.numberWellPositioned));
                            logger.warn(String.format("reset number present = %s",this.numberPresent));
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
                game.showRresult(menu,mode,chance);
            } else this.playerNumber = playerNumber;
        } while (this.playerNumber.length() < Integer.parseInt(p.getProperty("numberCase")) || this.playerNumber.length() > Integer.parseInt(p.getProperty("numberCase")));
    }
    public String getPlayerNumber() { return null; }
    public String getBrainyNumber() { return this.brainyNumber; }
    public void setBrainyNumber(String brainyNumber) { this.brainyNumber = brainyNumber; }
    public String getMrCpuNumber() { return mrCpuNumber; }
    public void setMrCpuNumber(String mrCpuNumber) { this.mrCpuNumber = mrCpuNumber; }
    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
    public int getReplay() { return replay; }
    public void setReplay(int replay) { this.replay = replay; }
    public int getChance() { return chance; }
    public int getNumberCase() { return numberCase; }
    public int getMainMenu() { return mainMenu; }
    public void setMainMenu(int mainMenu) { this.mainMenu = mainMenu; }
}



