package com.company;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class Mastermind {

     private boolean systemMode = false;
     public boolean responseIsGood = true;

     private  int mode;
     private  int mainMenu;
     private  int replay;
     private  int menu;
     private  int chance;
     private  int numberCase;
     private  int randomNumber;

     private  int minimumNumber;
     private  int maximumNumber;
     private  int numberPresent;
     private  int numberWellPositioned;

     private String arrayClue="";
     private String argsRecovery;
     private String name = "USER";
     private String dialogueReturn = "error";
     private String playerNumber="???";
     private String computerNumber;
     private String refereeNumber;
     private String answer;
     private String parameter1;
     private String parameter2;

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

         this.name = JOptionPane.showInputDialog(null, String.format("ENTER YOUR NAME"));

         return this.name;
     }

     public void introduction () throws IOException {

         Properties p = new Properties();
         InputStream is = new FileInputStream("src/com/resources/Config.properties");
         p.load(is);

         JOptionPane.showMessageDialog(null, String.format(p.getProperty("presentation")));
     }

     public int menu () {

         this.menu = Integer.parseInt(JOptionPane.showInputDialog(null, String.format("MODE [ 1 PUZZLE - 2 ENIGMA ]")));    //JBUTTON

         return this.menu;
     }

     public int games (int menu) throws IOException {

         Properties p = new Properties();
         InputStream is = new FileInputStream("src/com/resources/Config.properties");
         p.load(is);

         this.menu = menu;

         this.mode = Integer.parseInt(JOptionPane.showInputDialog(null, String.format("MODE [ 1 CHALLENGER - 2 DEFENDER - 3 DUEL ]")));    //JBUTTON

         if (this.mode == 1) {
             JOptionPane.showMessageDialog(null, String.format(p.getProperty("presentationChallengerMode")));
         }

         else if (this.mode == 2) {
             JOptionPane.showMessageDialog(null, String.format(p.getProperty("presentationDefenderMode")));
         }

         else if (this.mode == 3) {
             JOptionPane.showMessageDialog(null, String.format(p.getProperty("presentationDuelMode")));
         }

         return this.mode;
     }

     public String showRresult (int menu,int mode,int chance, String answer){

         this.menu = menu;
         this.mode = mode;
         this.chance = chance;
         this.answer = answer;

         if (this.systemMode) JOptionPane.showMessageDialog(null, String.format("\n\n*** ANSWER *** : %s\n\n", answer));

             do {
                 try {
                     if (this.menu == 1) {this.playerNumber = JOptionPane.showInputDialog(null, (String.format("DIFFICULTY: %s\nCHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s TIPS: %s ", this.numberCase, this.chance, this.name.toUpperCase(), this.playerNumber, this.arrayClue)));}
                     else if (this.menu == 2) {this.playerNumber = JOptionPane.showInputDialog(null, String.format("DIFFICULTY: %s\nCHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s ", this.numberCase, this.chance, this.name.toUpperCase(), this.playerNumber, this.numberWellPositioned, this.numberPresent));}
                     responseIsGood = true;
                 } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, String.format("WRONG ANSWER"));
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

         ArrayList al = new ArrayList();

         this.computerNumber = "";
         this.arrayClue = "";
         this.numberWellPositioned = 0;
         this.numberPresent = 0;

         for (int i=0;i<Integer.parseInt(p.getProperty("numberCase"));i++) {

             //al.add(this.parameter1.charAt(i));
             //al.add(this.parameter2.charAt(i));
             /*al.add(arrayClue);
             al.add(cases);
             al.add(arrayNumberWellPositioned);
             al.add(arrayIndex);*/

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

         if (this.parameter1.equals(this.parameter2)) {
             JOptionPane.showMessageDialog(null, String.format("\nREFEREE: CONGRATULATION %s WIN !\n", this.name.toUpperCase()));
             Integer.toString(this.chance = 0);
         } else if (this.chance == 0) {
             JOptionPane.showMessageDialog(null,String.format("\nREFEREE: YOU DON'T HAVE TRIES ANYMORE\nPADLOCK WAS: %s\nYOU LOOSE\n", this.parameter1));
             if (this.menu == 3) { String.format("REFEREE WIN"); }
         }else {
             JOptionPane.showMessageDialog(null,String.format("\nREFEREE: WRONG ANSWERS\n"));
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
         this.name = name;
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



