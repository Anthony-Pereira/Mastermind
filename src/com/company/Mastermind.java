package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

public class Mastermind {

    protected Boolean systemMode = false;
    protected Boolean responseIsGood = true;

    protected  int menu;
    protected  int mode;
    protected  int replay;
    protected  int mainMenu;

    protected  int chance;
    protected  int numberCase;
    protected  int randomNumber;
    protected  int minimumNumber;
    protected  int maximumNumber;
    protected  int numberPresent;
    protected  int numberWellPositioned;

    protected String answer;
    protected String parameter1;
    protected String parameter2;
    protected String playerNumber;
    protected String brainyNumber;
    protected String mrCpuNumber;
    protected String arrayClue;
    protected String name;
    protected String dialogueReturn = "error";

     public Mastermind(){

         this.playerNumber = "???";
         this.arrayClue = "???";
         this.numberWellPositioned = 0;
         this.numberPresent = 0;
     }

    public boolean systemMode(String[] args){

         this.systemMode = Boolean.getBoolean(String.valueOf(args));

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
         ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/game.jpg");
         ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/rule.jpg");
         ImageIcon icon_03 = new ImageIcon("src/com/resources/picture/mr_cpu_angry.jpg");



         this.mode = JOptionPane.showOptionDialog(null, "", "MASTERMIND", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon_01, options, options[0]);


         if (this.mode == 0) {
             JOptionPane.showMessageDialog(null, "CHALLENGER MODE\nFIND MY SECRET COMBINATION\nGOOD LUCK !","MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_02);
         }

         else if (this.mode == 1) {
             JOptionPane.showMessageDialog(null, "DEFENDER MODE\nI MUST FIND YOU'RE SECRET COMBINATION", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_02);
         }

         else if (this.mode == 2) {
             JOptionPane.showMessageDialog(null, "DUEL MODE\nTURN-BASED\nFIND MY NUMBER\nGOOD LUCK !", "MASTERMIND", JOptionPane.INFORMATION_MESSAGE, icon_03);
         }

         return this.mode;
    }

    public String showRresult (int menu,int mode,int chance, Boolean systemMode) {

         this.menu = menu;
         this.mode = mode;
         this.chance = chance;
         this.systemMode = systemMode;

         ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/mode.jpg");

        if (this.systemMode) JOptionPane.showMessageDialog(null, String.format("\n\n*** ANSWER *** : %s\n\n", answer));

        switch (this.menu){

            case 0 : this.playerNumber = JOptionPane.showInputDialog(null, (String.format("DIFFICULTY: %s\nCHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s TIPS: %s ", this.numberCase, this.chance, this.name.toUpperCase(), this.playerNumber, this.arrayClue)));
            break;
            case 1 : this.playerNumber = JOptionPane.showInputDialog(null, String.format("DIFFICULTY: %s\nCHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s ", this.numberCase, this.chance, this.name.toUpperCase(), this.playerNumber, this.numberWellPositioned, this.numberPresent));
            break;
        }

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

    public void dialogue (int mode, String parameter1, String parameter2, String name) {

         this.mode = mode;
         this.parameter1 = parameter1;
         this.parameter2 = parameter2;
         this.name = name;

        ImageIcon icon_01 = new ImageIcon("src/com/resources/picture/pain_brainy.jpg");
        ImageIcon icon_02 = new ImageIcon("src/com/resources/picture/happy_brainy.jpg");
        ImageIcon icon_03 = new ImageIcon("src/com/resources/picture/wrong_answer_brainy.jpg");
        ImageIcon icon_04 = new ImageIcon("src/com/resources/picture/mr_cpu_pain.jpg");
        ImageIcon icon_05 = new ImageIcon("src/com/resources/picture/mr_cpu_happy.jpg");
        ImageIcon icon_06 = new ImageIcon("src/com/resources/picture/mr_cpu_wrong_answer.jpg");

        switch (this.mode){

             case 0 :

                 if (this.parameter1.equals(this.parameter2)) {
                     JOptionPane.showMessageDialog(null, "BRAINY: CONGRATULATION "+this.name.toUpperCase()+ " , YOU WIN !\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_01);
                     Integer.toString(this.chance = 0);
                 } else if (this.chance == 0) {
                     JOptionPane.showMessageDialog(null, "BRAINY: YOU DON'T HAVE TRIES ANYMORE\nPADLOCK WAS: "+this.parameter1+"\nYOU LOOSE\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_02);
                 }else {
                     JOptionPane.showMessageDialog(null, "WRONG ANSWER","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_03);
                     this.chance--;
                     System.out.println(String.format("chance: %s",this.chance));
                 }
                 break;

             case 1 :

                 if (this.parameter1.equals(this.parameter2)) {
                     JOptionPane.showMessageDialog(null, "BRAINY: YEAH !!! I WON !\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_02);
                     Integer.toString(this.chance = 0);
                 } else if (this.chance == 0) {
                     JOptionPane.showMessageDialog(null, "BRAINY: I DON'T HAVE TRIES ANYMORE\nPADLOCK WAS: "+this.parameter1+"\nI LOST\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_01);
                 }else {
                     JOptionPane.showMessageDialog(null, "WRONG ANSWER","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_03);
                     this.chance--;
                     System.out.println(String.format("chance: %s",this.chance));
                 }
                 break;

             case 2 :

                 if (this.parameter1.equals(this.parameter2)) {
                     JOptionPane.showMessageDialog(null, "CPU: CONGRATULATION "+this.name.toUpperCase()+ " WIN !\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_04);
                     Integer.toString(this.chance = 0);
                 } else if (this.chance == 0) {
                     JOptionPane.showMessageDialog(null, "CPU: YOU DON'T HAVE TRIES ANYMORE\nPADLOCK WAS: "+this.parameter1+"\nYOU LOOSE\n","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_05);
                 }else {
                     JOptionPane.showMessageDialog(null, "WRONG ANSWER","MASTERMIND", JOptionPane.INFORMATION_MESSAGE,icon_06);
                     this.chance--;
                     System.out.println(String.format("chance: %s",this.chance));
                 }
                 break;
         }
     }

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
    }

}



