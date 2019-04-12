package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

public class Mastermind {

     private boolean systemMode = false;
     public boolean responseIsGood = true;

     private  int menu;
     private  int mode;
     private  int replay;
     private  int mainMenu;

     private  int chance;
     private  int numberCase;
     private  int randomNumber;
     private  int minimumNumber;
     private  int maximumNumber;
     private  int numberPresent;
     private  int numberWellPositioned;

     private String argsRecovery;
     private String answer;
     private String parameter1;
     private String parameter2;
     private String playerNumber="???";
     private String computerNumber;
     private String refereeNumber;
     private String arrayClue="";
     private String name;
     private String dialogueReturn = "error";



     public Mastermind(){}

     public boolean systemMode(String[] args){

         this.argsRecovery = String.valueOf(args);

         return this.systemMode;
     }

     public String randomNumber(int numberCase) {

         this.numberCase = numberCase;

         this.minimumNumber = (int) Math.pow(10, this.numberCase -1);
         this.maximumNumber = (int) Math.pow(10, this.numberCase) -1;

         System.out.println(this.minimumNumber);
         System.out.println(this.maximumNumber);

         this.randomNumber = this.minimumNumber + (int) (Math.random() * (this.maximumNumber - this.minimumNumber + 1));

         return Integer.toString(randomNumber);
     }

     public String createName () {

         ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/name.jpg");

         this.name = (String) JOptionPane.showInputDialog(null,"ENTER YOUR NAME","MASTERMIND",JOptionPane.INFORMATION_MESSAGE,icon_01,null,"USER");
         return this.name;
     }

     public void introduction () throws IOException {

         Properties p = new Properties();
         InputStream is = new FileInputStream("src/com/resources/Config.properties");
         p.load(is);

             ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/mastermind_brain.jpg");
             ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/presentation.jpg");

             JOptionPane.showMessageDialog(null, null, "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_01);
             JOptionPane.showMessageDialog(null, "WELCOME TO THE MASTERMIND GAMES\nIT'S YOUR BUDDY BRAINY AND IT'S A PLEASURE TO MEET YOU\n", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_02);

     }

     public int menu () {

         String[] options = {"PUZZLE", "ENIGMA"};
         ImageIcon icon = new ImageIcon("src/com/resources/picture/mode.jpg");

         this.menu = JOptionPane.showOptionDialog(null, "", "MASTERMIND", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);

         return this.menu;
     }

     public int games (int menu) throws IOException {

         Properties p = new Properties();
         InputStream is = new FileInputStream("src/com/resources/Config.properties");
         p.load(is);

         this.menu = menu;

         String[] options = {"CHALLENGER", "DEFENDER", "DUEL"};
         ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/mode.jpg");
         ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/rule.jpg");


         this.mode = JOptionPane.showOptionDialog(null, "", "MASTERMIND", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]);


         if (this.mode == 0) {
             JOptionPane.showMessageDialog(null, "CHALLENGER MODE \nFIND THE SECRET COMPUTER COMBINATION\nGOOD LUCK !","MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_02);
         }

         else if (this.mode == 1) {
             JOptionPane.showMessageDialog(null, "DEFENDER MODE \nCOMPUTER MUST FIND YOU'RE SECRET COMBINATION", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_02);
         }

         else if (this.mode == 2) {
             JOptionPane.showMessageDialog(null, "DUEL MODE \nTURN-BASED GAMES", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_02);
         }

         return this.mode;
     }

     public String showRresult (int menu,int mode,int chance, String answer){

         this.menu = menu;
         this.mode = mode;
         this.chance = chance;
         this.answer = answer;

         ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/mode.jpg");

         if (this.systemMode) JOptionPane.showMessageDialog(null, String.format("\n\n*** ANSWER *** : %s\n\n", answer));

             do {
                 try {
                     if (this.menu == 0) {this.playerNumber = JOptionPane.showInputDialog(null, (String.format("DIFFICULTY: %s\nCHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s TIPS: %s ", this.numberCase, this.chance, this.name.toUpperCase(), this.playerNumber, this.arrayClue)));}
                     else if (this.menu == 1) {this.playerNumber = JOptionPane.showInputDialog(null, String.format("DIFFICULTY: %s\nCHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s ", this.numberCase, this.chance, this.name.toUpperCase(), this.playerNumber, this.numberWellPositioned, this.numberPresent));}
                     responseIsGood = true;
                 } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "WRONG ANSWER","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_01);
                     //JOptionPane.showMessageDialog(null, String.format("WRONG ANSWER"));
                     responseIsGood = false;
                 }
             } while (!this.responseIsGood);

         return this.playerNumber;
     }

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

         this.computerNumber = "";
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
             this.computerNumber+=Integer.toString(arrayIndex[i]);
             System.out.println(String.format("parameter 1: %s", this.parameter1));
             System.out.println(String.format("parameter 2: %s", this.parameter2));
             System.out.println(String.format("Le nombre de la colonne %s est: %s et deviens %s .",i,parameter1.charAt(i),arrayIndex[i]));
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
         System.out.println("clue : " + this.arrayClue);
         System.out.println( "number well positioned : " + this.numberWellPositioned);
         System.out.println("number present : " + this.numberPresent);
     }

     public void dialogue (int mode,String parameter1, String parameter2, String name) {

         this.mode = mode;
         this.parameter1 = parameter1;
         this.parameter2 = parameter2;
         this.name = name;

         ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/win.jpg");
         ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/.jpg");
         ImageIcon icon_03 = new ImageIcon("src/com/resources/picture/wrong_answer.jpg");


         if (this.parameter1.equals(this.parameter2)) {
             JOptionPane.showMessageDialog(null, "BRAINY: CONGRATULATION "+this.name.toUpperCase()+ " WIN !\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_01);
             Integer.toString(this.chance = 0);
         } else if (this.chance == 0) {
             JOptionPane.showMessageDialog(null, "BRAINY: YOU DON'T HAVE TRIES ANYMORE\nPADLOCK WAS: "+this.parameter1+"\nYOU LOOSE\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_02);
             if (this.mode == 2) { String.format("REFEREE WIN"); }
         }else {
             JOptionPane.showMessageDialog(null, "WRONG ANSWER","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_03);
             this.chance--;
             System.out.println(String.format("chance: %s",this.chance));
         }
     }

    /* GETTERS AND SETTERS */

     public String getRandomNumber() {
         return Integer.toString(this.randomNumber);
     }

     public void setRandomNumber(int randomNumber) {
         this.randomNumber = randomNumber;
     }

     public String getName() {
         return this.name;
     }

     public void setName(String name) {

         ImageIcon icon = new ImageIcon("src/com/resources/picture/mastermind_menu.png");

         this.name = name;

         do {
             if (this.name.length() > 15) {
                 this.responseIsGood = false;
                 JOptionPane.showMessageDialog(null, "INVALID NAME", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon);
                 this.createName();
             } else this.responseIsGood = true;
         } while (this.responseIsGood = false);

     }

     public int getMode() {
         return this.mode;
     }

     public void setMode(int mode) {
         this.mode = mode;
     }

     public int getMenu() {
         return this.menu;
     }

     public void setMenu(int menu) {
         this.menu = menu;
     }

     public String getPlayerNumber() {
         return this.playerNumber ;
     }

     public void setPlayerNumber(String playerNumber) { this.playerNumber = playerNumber; }

     public String getComputerNumber() {
         return computerNumber;
     }

     public void setComputerNumber(String computerNumber) {
         this.computerNumber = computerNumber;
     }

     public String getDialogueReturn() {
         return dialogueReturn;
     }

     public void setDialogueReturn(String dialogueReturn) {
         this.dialogueReturn = dialogueReturn;
     }

     public int getChance() {
         return chance;
     }

     public void setChance(int chance) { this.chance = chance; }

     public int getReplay() {
         return replay;
     }

     public void setReplay(int replay) {
         this.replay = replay;
     }

     public int getMinimumNumber() {
         return minimumNumber;
     }

     public void setMinimumNumber(int minimumNumber) { this.minimumNumber = minimumNumber; }

     public int getMaximumNumber() {
         return maximumNumber;
     }

     public void setMaximumNumber(int maximumNumber) { this.maximumNumber = maximumNumber; }

     public int getNumberCase() {
         return numberCase;
     }

     public void setNumberCase(int numberCase) { this.numberCase = numberCase; }

    public String getArgsRecovery() {
        return argsRecovery;
    }

    public void setArgsRecovery(String argsRecovery) {
        this.argsRecovery = argsRecovery;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String getRefereeNumber() {
        return refereeNumber;
    }

    public void setRefereeNumber(String refereeNumber) { this.refereeNumber = refereeNumber; }

    public int getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(int mainMenu) {
        this.mainMenu = mainMenu;
    }
}



