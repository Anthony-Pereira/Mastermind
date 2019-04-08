package com.company;

import jdk.nashorn.internal.parser.Scanner;

import javax.swing.*;

public class Configuration  {
/*
    public String compare() {

        this.computerNumber.charAt(0);
        this.computerNumber.charAt(1);
        this.computerNumber.charAt(2);
        this.computerNumber.charAt(3);

        this.playerNumber.charAt(0);
        this.playerNumber.charAt(1);
        this.playerNumber.charAt(2);
        this.playerNumber.charAt(3);


        if (this.playerNumber.charAt(0) < this.computerNumber.charAt(0)) {
            this.clueThousand = "+";
            this.numberWellPositionedThousand = 0;
        } else if (this.playerNumber.charAt(0) > this.computerNumber.charAt(0)) {
            this.clueThousand = "-";
            this.numberWellPositionedThousand = 0;
        } else {
            this.clueThousand = "=";
            this.numberWellPositionedThousand = 1;
        }

        if (this.playerNumber.charAt(1) < this.computerNumber.charAt(1)) {
            this.clueHundred = "+";
            this.numberWellPositionedHundreed = 0;
        } else if (this.playerNumber.charAt(1) > this.computerNumber.charAt(1)) {
            this.clueHundred = "-";
            this.numberWellPositionedHundreed = 0;
        } else {
            this.clueHundred = "=";
            this.numberWellPositionedHundreed = 1;
        }

        if (this.playerNumber.charAt(2) < this.computerNumber.charAt(2)) {
            this.clueDecade = "+";
            this.numberWellPositionedDecade = 0;
        } else if (this.playerNumber.charAt(2) > this.computerNumber.charAt(2)) {
            this.clueDecade = "-";
            this.numberWellPositionedDecade = 0;
        } else {
            this.clueDecade = "=";
            this.numberWellPositionedDecade = 1;
        }

        if (this.playerNumber.charAt(3) < this.computerNumber.charAt(3)) {
            this.clueUnit = "+";
            this.numberWellPositionedUnit = 0;
        } else if (this.playerNumber.charAt(3) > this.computerNumber.charAt(3)) {
            this.clueUnit = "-";
            this.numberWellPositionedUnit = 0;
        } else {
            this.clueUnit = "=";
            this.numberWellPositionedUnit = 1;
        }

        this.numberWellPositioned = this.numberWellPositionedThousand + this.numberWellPositionedHundreed + this.numberWellPositionedDecade + this.numberWellPositionedUnit;

///////

        this.case0 = this.computerNumber.indexOf(this.playerNumber.charAt(0));
        if (this.case0 == -1){this.numberPresentThousand = 0;}
        else if (this.case0 != -1){this.numberPresentThousand = 1;}

        this.case1 = this.computerNumber.indexOf(this.playerNumber.charAt(1));
        if (this.case1 == -1){this.numberPresentHundreed = 0;}
        else if (this.case1 != -1){this.numberPresentHundreed = 1;}

        this.case2 = this.computerNumber.indexOf(this.playerNumber.charAt(2));
        if (this.case2 == -1){this.numberPresentDecade = 0;}
        else if (this.case2 != -1){this.numberPresentDecade = 1;}

        this.case3 = this.computerNumber.indexOf(this.playerNumber.charAt(3));
        if (this.case3 == -1){this.numberPresentUnit = 0;}
        else if (this.case3 != -1){this.numberPresentUnit = 1;}

        this.numberPresent = this.numberPresentThousand + this.numberPresentHundreed + this.numberPresentDecade + this.numberPresentUnit;

        return this.playerNumber;
    }

    public String compareDefender() {

        this.computerNumber.charAt(0);
        this.computerNumber.charAt(1);
        this.computerNumber.charAt(2);
        this.computerNumber.charAt(3);

        this.playerNumber.charAt(0);
        this.playerNumber.charAt(1);
        this.playerNumber.charAt(2);
        this.playerNumber.charAt(3);

        this.computerNumberThousand = Integer.parseInt(String.valueOf(this.computerNumber.charAt(0)));
        this.computerNumberHundreed = Integer.parseInt(String.valueOf(this.computerNumber.charAt(1)));
        this.computerNumberDecade = Integer.parseInt(String.valueOf(this.computerNumber.charAt(2)));
        this.computerNumberUnit = Integer.parseInt(String.valueOf(this.computerNumber.charAt(3)));

        this.playerNumberThousand = Integer.parseInt(String.valueOf(this.playerNumber.charAt(0)));
        this.playerNumberHundreed = Integer.parseInt(String.valueOf(this.playerNumber.charAt(1)));
        this.playerNumberDecade = Integer.parseInt(String.valueOf(this.playerNumber.charAt(2)));
        this.playerNumberUnit = Integer.parseInt(String.valueOf(this.playerNumber.charAt(3)));

        if (this.computerNumberThousand < this.playerNumberThousand) {
            this.clueThousand = "+";
            this.computerNumberThousand++;
            this.numberWellPositionedThousand = 0;
        } else if (this.computerNumberThousand > this.playerNumberThousand) {
            this.clueThousand = "-";
            this.computerNumberThousand--;
            this.numberWellPositionedThousand = 0;
        } else {
            this.clueThousand = "=";
            this.numberWellPositionedThousand = 1;
        }

        if (this.computerNumberHundreed < this.playerNumberHundreed) {
            this.clueHundred = "+";
            this.computerNumberHundreed++;
            this.numberWellPositionedHundreed = 0;
        } else if (this.computerNumberHundreed > this.playerNumberHundreed) {
            this.clueHundred = "-";
            this.computerNumberHundreed--;
            this.numberWellPositionedHundreed = 0;
        } else {
            this.clueHundred = "=";
            this.numberWellPositionedHundreed = 1;
        }

        if (this.computerNumberDecade < this.playerNumberDecade) {
            this.clueDecade = "+";
            this.computerNumberDecade++;
            this.numberWellPositionedDecade = 0;
        } else if (this.computerNumberDecade > this.playerNumberDecade) {
            this.clueDecade = "-";
            this.computerNumberDecade--;
            this.numberWellPositionedDecade = 0;
        } else {
            this.clueDecade = "=";
            this.numberWellPositionedDecade = 1;
        }

        if (this.computerNumberUnit < this.playerNumberUnit) {
            this.clueUnit = "+";
            this.computerNumberUnit++;
            this.numberWellPositionedUnit = 0;
        } else if (this.computerNumberUnit > this.playerNumberUnit) {
            this.clueUnit = "-";
            this.computerNumberUnit--;
            this.numberWellPositionedUnit = 0;
        } else {
            this.clueUnit = "=";
            this.numberWellPositionedUnit = 1;
        }

        this.numberWellPositioned = this.numberWellPositionedThousand + this.numberWellPositionedHundreed + this.numberWellPositionedDecade + this.numberWellPositionedUnit;

        this.case0 = this.playerNumber.indexOf(this.computerNumber.charAt(0));
        if (this.case0 == -1) {
            this.numberPresentThousand = 0;
        } else if (this.case0 != -1) {
            this.numberPresentThousand = 1;
        }

        this.case1 = this.playerNumber.indexOf(this.computerNumber.charAt(1));
        if (this.case1 == -1) {
            this.numberPresentHundreed = 0;
        } else if (this.case1 != -1) {
            this.numberPresentHundreed = 1;
        }

        this.case2 = this.playerNumber.indexOf(this.computerNumber.charAt(2));
        if (this.case2 == -1) {
            this.numberPresentDecade = 0;
        } else if (this.case2 != -1) {
            this.numberPresentDecade = 1;
        }

        this.case3 = this.playerNumber.indexOf(this.computerNumber.charAt(3));
        if (this.case3 == -1) {
            this.numberPresentUnit = 0;
        } else if (this.case3 != -1) {
            this.numberPresentUnit = 1;
        }

        this.numberPresent = this.numberPresentThousand + this.numberPresentHundreed + this.numberPresentDecade + this.numberPresentUnit;

        return this.computerNumber;
    }


    //////////////////////////////////////////////////////////////
        //CLASS ENIGMA
    /////////////////////////////////////////////////////////////////////////



    public GameEnigma(){}

    public void challenger() throws IOException {

        Scanner sc = new Scanner(System.in);
        Properties p = new Properties();
        InputStream is = new FileInputStream("src/com/resources/Config.properties");
        p.load(is);
        Game gameChallenger = new Challenger();

        if (Game.modeSystem){
            System.out.println(p.getProperty("presentationChallengerMode"));
        }
        else {
            JOptionPane.showMessageDialog(null, p.getProperty("presentationChallengerMode"));
        }

        do {
            Game.playerNumber = (p.getProperty("resetNumber"));
            Game.chancePlayer = Integer.parseInt(p.getProperty("chance")) ;
            Game.numberWellPositioned = 0;
            Game.numberPresent = 0;
            Game.computerNumber = Game.randomNumber();

            do {
                if (Game.modeSystem){
                    System.out.println(String.format("\n\n*** ANSWER *** : %s\n\n", Game.computerNumber));
                    System.out.println(String.format("CHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s TIPS: %s%s%s%s\n(4 numeric combination)",Game.chancePlayer,Game.name.toUpperCase(),  Game.playerNumber, Game.clueThousand, Game.clueHundred, Game.clueDecade, Game.clueUnit));
                    Game.playerNumber = sc.nextLine();
                }
                else {
                    Game.playerNumber = JOptionPane.showInputDialog(null, (String.format("CHANCE: %s\n\nPREVIOUS NUMBER: %s TIPS: %s%s%s%s\n\n(4 numeric combination)", Game.chancePlayer, Game.playerNumber, Game.clueThousand, Game.clueHundred, Game.clueDecade, Game.clueUnit)));

                }

                try {
                    Game.responseIsGood = true;
                    gameChallenger.compare();
                } catch (Exception e) {
                    Game.responseIsGood = false;
                }
            } while (!Game.responseIsGood);

            if (Game.modeSystem){
                System.out.println(gameChallenger.dialogue());
            }
            else {
                JOptionPane.showMessageDialog(null, gameChallenger.dialogue());
            }

            do {
                Game.chancePlayer--;
                do {
                    if (Game.modeSystem){
                        System.out.println(String.format("\n\n*** ANSWER *** : %s\n\n", Game.computerNumber));
                        System.out.println(String.format("CHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s ",Game.chancePlayer,Game.name.toUpperCase(), Game.playerNumber, Game.numberWellPositioned, Game.numberPresent));
                        Game.playerNumber = sc.nextLine();
                        System.out.println(gameChallenger.dialogue());
                    }
                    else {
                        Game.playerNumber = JOptionPane.showInputDialog(null, (String.format("CHANCE: %s\n\nPREVIOUS NUMBER: %s\n\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s ", Game.chancePlayer, Game.playerNumber, Game.numberWellPositioned, Game.numberPresent)));
                        JOptionPane.showMessageDialog(null, gameChallenger.dialogue());
                    }

                    if (!Game.computerNumber.equals(Game.playerNumber) && Game.chancePlayer != 0) {
                        try {
                            Game.responseIsGood = true;
                            gameChallenger.compare();
                        } catch (Exception e) {
                            Game.responseIsGood = false;
                            if (Game.modeSystem) {
                                System.out.println(String.format("PLEASE 4 COMBINATION"));
                            } else {
                                JOptionPane.showMessageDialog(null, String.format("PLEASE 4 COMBINATION"));
                            }
                        }
                    } else if (!Game.computerNumber.equals(Game.playerNumber) && Game.chancePlayer == 0) {
                        if (Game.modeSystem) {
                            System.out.println(String.format("REPLAY ? [ Y / N ]"));
                            Game.replayDevMode = sc.nextLine().charAt(0);
                        }
                        else {
                            Game.replay = JOptionPane.showConfirmDialog(null, String.format("REPLAY ?", JOptionPane.YES_NO_OPTION));
                        }
                    } else {
                        if (Game.modeSystem){
                            System.out.println(String.format("REPLAY ? [ Y / N ]"));
                            Game.replayDevMode = sc.nextLine().charAt(0);
                        }
                        else {

                            Game.replay = JOptionPane.showConfirmDialog(null, String.format("REPLAY ?", JOptionPane.YES_NO_OPTION));
                        }
                    }
                } while (!Game.responseIsGood);
            } while (Game.chancePlayer != 0);
        } while (Game.replay == 0 || Game.replayDevMode == 'y');
    }

    public void defender() throws IOException {

        Scanner sc = new Scanner(System.in);
        Properties p = new Properties();
        InputStream is = new FileInputStream("src/com/resources/Config.properties");
        p.load(is);
        Game gameDefender = new Defender();

        if (Game.modeSystem){
            System.out.println(p.getProperty("presentationDefenderMode"));
        }
        else {
            JOptionPane.showMessageDialog(null, p.getProperty("presentationDefenderMode"));
        }

        do {
            Game.playerNumber = (p.getProperty("resetNumber"));
            Game.chancePlayer = Integer.parseInt(p.getProperty("chance")) ;
            Game.numberWellPositioned = 0;
            Game.numberPresent = 0;
            Game.computerNumber = Game.randomNumber();

            do {
                if (Game.modeSystem){
                    System.out.println(String.format("\n\n*** ANSWER *** : %s\n\n", Game.playerNumber));
                    System.out.println(String.format("PLAYER: %s\nCHOOSE THE PADLOCK\n(4 numeric combination)",Game.name.toUpperCase()));
                    Game.playerNumber = sc.nextLine();
                }
                else {
                    Game.playerNumber = JOptionPane.showInputDialog(null, (String.format("PLAYER: %s\nCHOOSE THE PADLOCK\n(4 numeric combination)",Game.name.toUpperCase())));
                }

                try {
                    Game.responseIsGood = true;
                    gameDefender.compare();
                } catch (Exception e) {
                    Game.responseIsGood = false;
                }
            } while (!Game.responseIsGood);

            do {
                Game.chanceCom--;
                do {
                    if (Game.modeSystem){
                        System.out.println(String.format("\n\n*** ANSWER *** : %s\n\n", Game.playerNumber));
                        System.out.println(String.format("CPU: PADLOCK IS: %s", Game.computerNumber));
                        System.out.println(gameDefender.dialogue());
                    }
                    else {
                        JOptionPane.showMessageDialog(null, String.format("CPU: PADLOCK IS: %s", Game.computerNumber));
                        JOptionPane.showMessageDialog(null, gameDefender.dialogue());
                    }

                    if (!Game.computerNumber.equals(Game.playerNumber) && Game.chanceCom != 0) {
                        gameDefender.compare();
                        Game.computerNumber = String.format("%s%s%s%s", Game.computerNumberThousand, Game.computerNumberHundreed, Game.computerNumberDecade, Game.computerNumberUnit);
                        if (Game.modeSystem){
                            System.out.println(String.format("CHANCE: %s   ANSWER : %s\nI'M THINKING ...\n???  010100011  ???  101011100  ???\n", Game.chancePlayer, Game.playerNumber));
                        }
                        else {
                            JOptionPane.showMessageDialog(null, String.format("CHANCE: %s     SOLUTION: %s\n\nI'M THINKING ...\n???  010100011  ???  101011100  ???\n\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s ", Game.chanceCom, Game.playerNumber, Game.numberWellPositioned, Game.numberPresent));
                        }
                    } else if (!Game.computerNumber.equals(Game.playerNumber) && Game.chanceCom == 0) {
                        if (Game.modeSystem){
                            System.out.println(String.format("REPLAY ? [ Y / N ]"));
                            Game.replayDevMode = sc.nextLine().charAt(0);
                        }
                        else {
                            Game.replay = JOptionPane.showConfirmDialog(null, String.format("REPLAY ?", JOptionPane.YES_NO_OPTION));
                        }
                    } else {
                        if (Game.modeSystem){
                            System.out.println(String.format("REPLAY ? [ Y / N ]"));
                            Game.replayDevMode = sc.nextLine().charAt(0);
                        }
                        else {
                            Game.replay = JOptionPane.showConfirmDialog(null, String.format("REPLAY ?", JOptionPane.YES_NO_OPTION));
                        }
                    }
                } while (!Game.responseIsGood);
            } while (Game.chanceCom != 0);
        } while (Game.replay == 0 || Game.replayDevMode == 'y');
    }

    public void duel() throws IOException {

        Scanner sc = new Scanner(System.in);
        Properties p = new Properties();
        InputStream is = new FileInputStream("src/com/resources/Config.properties");
        p.load(is);

        if (Game.modeSystem){
            System.out.println(p.getProperty("presentationDuelMode"));
        }
        else {
            JOptionPane.showMessageDialog(null, p.getProperty("presentationDuelMode"));
        }

        do {
            Game.playerNumber = (p.getProperty("resetNumber"));
            Game.computerNumber =(p.getProperty("resetNumber"));
            Game.chancePlayer = Integer.parseInt(p.getProperty("chance")) ;
            Game.chanceCom = Integer.parseInt(p.getProperty("chance"));
            Game.numberWellPositioned = 0;
            Game.numberPresent = 0;
            Game.quanticNumber = Game.randomNumber();
            Game.computerNumber = Game.randomNumber();

            do {
                if (Game.modeSystem){
                    System.out.println(String.format("\n\n*** ANSWER *** : %s\n\n", Game.quanticNumber));
                    System.out.println(String.format("CHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s\n(4 numeric combination)",Game.chancePlayer,Game.name.toUpperCase(), Game.playerNumber, Game.numberWellPositioned, Game.numberPresent));
                    Game.playerNumber = sc.nextLine();
                }
                else {
                    Game.playerNumber = JOptionPane.showInputDialog(null, (String.format("PLAYER:\n\nCHANCE: %s\n\nPREVIOUS NUMBER: %s\n\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s\n\n(4 numeric combination)", Game.chancePlayer, Game.playerNumber, Game.numberWellPositioned, Game.numberPresent)));
                }

                try {
                    Game.responseIsGood = true;
                    Duel.playerVsQuanticCpuDuelComparaison();
                    Duel.cpuVsQuanticCpuDuelComparaison();
                } catch (Exception e) {
                    Game.responseIsGood = false;
                }
            } while (!Game.responseIsGood);

            do {
                do {
                    if (!Game.quanticNumber.equals(Game.computerNumber) && Game.chanceCom != 0) {
                        Duel.cpuVsQuanticCpuDuelComparaison();
                        Game.computerNumber = String.format("%s%s%s%s", Game.computerNumberThousand, Game.computerNumberHundreed, Game.computerNumberDecade, Game.computerNumberUnit);
                    }
                    if (Game.modeSystem){
                        System.out.println(String.format("\nCHANCE: %s\nCPU: PADLOCK IS: %s", Game.chanceCom, Game.computerNumber));
                    }
                    else {
                        JOptionPane.showMessageDialog(null, (String.format("CPU:\n\nCHANCE: %s\n\nPADLOCK IS: %s ", Game.chanceCom, Game.computerNumber)));
                    }
                    Game.chanceCom--;
                    JOptionPane.showMessageDialog(null, Duel.CpuDuelDialogue());
                    break;
                } while (Game.chancePlayer != 0 || Game.chanceCom != 0);
                if (Game.chancePlayer == 0 || Game.chanceCom == 0) {
                    break;
                }

                do {
                    Game.chancePlayer--;
                    do {
                        if (Game.modeSystem){
                            System.out.println(String.format("\n\n*** ANSWER *** : %s\n\n", Game.quanticNumber));
                            System.out.println(String.format("CHANCE: %s\nPLAYER: %s\nPREVIOUS NUMBER: %s\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s\n(4 numeric combination)",Game.chancePlayer,Game.name.toUpperCase(), Game.playerNumber, Game.numberWellPositioned, Game.numberPresent));
                            Game.playerNumber = sc.nextLine();
                        }
                        else {
                            Game.playerNumber = JOptionPane.showInputDialog(null, (String.format("PLAYER:\n\nCHANCE: %s\n\nPREVIOUS NUMBER: %s\n\nNUMBER WELL POSITIONED: %s\nNUMBER PRESENT: %s\n\n(4 numeric combination)", Game.chancePlayer, Game.playerNumber, Game.numberWellPositioned, Game.numberPresent)));
                        }

                        if (!Game.quanticNumber.equals(Game.playerNumber) && Game.chancePlayer != 0) {
                            try {
                                Game.responseIsGood = true;
                                Duel.playerVsQuanticCpuDuelComparaison();
                            } catch (Exception e) {
                                Game.responseIsGood = false;
                                if (Game.modeSystem){
                                    System.out.println(String.format("PLEASE 4 COMBINATION"));
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, String.format("PLEASE 4 COMBINATION"));
                                }
                            }
                        }
                        if (Game.modeSystem){
                            System.out.println(Duel.playerDuelDialogue());
                        }
                        else {
                            JOptionPane.showMessageDialog(null, Duel.playerDuelDialogue());
                        }
                    } while (!Game.responseIsGood);
                    if (Game.responseIsGood) ;
                    break;
                } while (Game.chancePlayer != 0 || Game.chanceCom != 0);
                if (Game.chancePlayer == 0 || Game.chanceCom == 0) {
                    break;
                }
            } while (Game.chancePlayer != 0 || Game.chanceCom != 0);
            if (Game.modeSystem){
                System.out.println(String.format("REPLAY ? [ Y / N ]"));
                Game.replayDevMode = sc.nextLine().charAt(0);
            }
            else {
                Game.replay = JOptionPane.showConfirmDialog(null, String.format("REPLAY ?", JOptionPane.YES_NO_OPTION));
            }
        } while (Game.replay == 0 || Game.replayDevMode == 'y');
    }


////////////////////////////////
//INTERFACE DUEL
///////////////////////////////////////////////


    static String playerDuelDialogue() {

        if (Game.quanticNumber.equals(Game.playerNumber)) {
            Game.dialogueReturn = String.format("QUANTIC CPU: %s WIN",Game.name.toUpperCase());
            Integer.toString(Game.duelChancePlayer = 0);

        } else if (!Game.quanticNumber.equals(Game.playerNumber) && Game.chance == 0) {
            Game.dialogueReturn = String.format("QUANTIC CPU: YOU DONT'T HAVE TRIES ANYMORE.\nYOU LOOSE.\nPADLOCK WAS %s", Game.quanticNumber);

        } else {
            Game.dialogueReturn = String.format("QUANTIC CPU: WRONG ANSWERS");
        }

        return Game.dialogueReturn;
    }


    static String CpuDuelDialogue() {

        if (Game.quanticNumber.equals(Game.computerNumber)) {
            Game.dialogueReturn = String.format("QUANTIC CPU: CPU WIN");
            Integer.toString(Game.duelChanceCom = 0);

        } else if (Game.chance == 0) {
            Game.dialogueReturn = String.format("QUANTIC CPU: YOU DONT'T HAVE TRIES ANYMORE.\nYOU LOOSE.\nPADLOCK WAS %s", Game.quanticNumber);

        } else {
            Game.dialogueReturn = String.format("CPU: 0010010101 !! bip BiP !! ERROR ");
        }

        return Game.dialogueReturn;
    }


    static String playerVsQuanticCpuDuelComparaison(){


        Game.quanticNumber.charAt(0);
        Game.quanticNumber.charAt(1);
        Game.quanticNumber.charAt(2);
        Game.quanticNumber.charAt(3);

        Game.playerNumber.charAt(0);
        Game.playerNumber.charAt(1);
        Game.playerNumber.charAt(2);
        Game.playerNumber.charAt(3);

        if (Game.playerNumber.charAt(0) < Game.quanticNumber.charAt(0)) {
            Game.clueThousand = "+";
            Game.numberWellPositionedThousand = 0;
        } else if (Game.playerNumber.charAt(0) > Game.quanticNumber.charAt(0)) {
            Game.clueThousand = "-";
            Game.numberWellPositionedThousand = 0;
        } else {
            Game.clueThousand = "=";
            Game.numberWellPositionedThousand = 1;
        }

        if (Game.playerNumber.charAt(1) < Game.quanticNumber.charAt(1)) {
            Game.clueHundred = "+";
            Game.numberWellPositionedHundreed = 0;
        } else if (Game.playerNumber.charAt(1) > Game.quanticNumber.charAt(1)) {
            Game.clueHundred = "-";
            Game.numberWellPositionedHundreed = 0;
        } else {
            Game.clueHundred = "=";
            Game.numberWellPositionedHundreed = 1;
        }

        if (Game.playerNumber.charAt(2) < Game.quanticNumber.charAt(2)) {
            Game.clueDecade = "+";
            Game.numberWellPositionedDecade = 0;
        } else if (Game.playerNumber.charAt(2) > Game.quanticNumber.charAt(2)) {
            Game.clueDecade = "-";
            Game.numberWellPositionedDecade = 0;
        } else {
            Game.clueDecade = "=";
            Game.numberWellPositionedDecade = 1;
        }

        if (Game.playerNumber.charAt(3) < Game.quanticNumber.charAt(3)) {
            Game.clueUnit = "+";
            Game.numberWellPositionedUnit = 0;
        } else if (Game.playerNumber.charAt(3) > Game.quanticNumber.charAt(3)) {
            Game.clueUnit = "-";
            Game.numberWellPositionedUnit = 0;
        } else {
            Game.clueUnit = "=";
            Game.numberWellPositionedUnit = 1;
        }

        Game.numberWellPositioned = Game.numberWellPositionedThousand + Game.numberWellPositionedHundreed + Game.numberWellPositionedDecade + Game.numberWellPositionedUnit;


        Game.position0 = Game.quanticNumber.indexOf(Game.playerNumber.charAt(0));
        if (Game.position0 == -1){Game.numberPresentThousand = 0;}
        else if (Game.position0 != -1){Game.numberPresentThousand = 1;}

        Game.position1 = Game.quanticNumber.indexOf(Game.playerNumber.charAt(1));
        if (Game.position1 == -1){Game.numberPresentHundreed = 0;}
        else if (Game.position1 != -1){Game.numberPresentHundreed = 1;}

        Game.position2 = Game.quanticNumber.indexOf(Game.playerNumber.charAt(2));
        if (Game.position2 == -1){Game.numberPresentDecade = 0;}
        else if (Game.position2 != -1){Game.numberPresentDecade = 1;}

        Game.position3 = Game.quanticNumber.indexOf(Game.playerNumber.charAt(3));
        if (Game.position3 == -1){Game.numberPresentUnit = 0;}
        else if (Game.position3 != -1){Game.numberPresentUnit = 1;}

        Game.numberPresent = Game.numberPresentThousand + Game.numberPresentHundreed + Game.numberPresentDecade + Game.numberPresentUnit;

        return Game.playerNumber;
    }


    static String cpuVsQuanticCpuDuelComparaison(){


        Game.quanticNumber.charAt(0);
        Game.quanticNumber.charAt(1);
        Game.quanticNumber.charAt(2);
        Game.quanticNumber.charAt(3);

        Game.computerNumber.charAt(0);
        Game.computerNumber.charAt(1);
        Game.computerNumber.charAt(2);
        Game.computerNumber.charAt(3);

        Game.extentionComputerNumberThousand = Integer.parseInt(String.valueOf(Game.computerNumber.charAt(0)));
        Game.extentionComputerNumberHundreed = Integer.parseInt(String.valueOf(Game.computerNumber.charAt(1)));
        Game.extentionComputerNumberDecade = Integer.parseInt(String.valueOf(Game.computerNumber.charAt(2)));
        Game.extentionComputerNumberUnit = Integer.parseInt(String.valueOf(Game.computerNumber.charAt(3)));

        Game.extensionQuanticNumberThousand = Integer.parseInt(String.valueOf(Game.quanticNumber.charAt(0)));
        Game.extensionQuanticNumberHundreed = Integer.parseInt(String.valueOf(Game.quanticNumber.charAt(1)));
        Game.extensionQuanticNumberDecade = Integer.parseInt(String.valueOf(Game.quanticNumber.charAt(2)));
        Game.extensionQuanticNumberUnit = Integer.parseInt(String.valueOf(Game.quanticNumber.charAt(3)));

        if (Game.extentionComputerNumberThousand < Game.extensionQuanticNumberThousand) {
            Game.extentionComputerNumberThousand ++;
        } else if (Game.extentionComputerNumberThousand > Game.extensionQuanticNumberThousand) {
            Game.extentionComputerNumberThousand --;
        }

        if (Game.extentionComputerNumberHundreed < Game.extensionQuanticNumberHundreed) {
            Game.extentionComputerNumberHundreed ++;
        } else if (Game.extentionComputerNumberHundreed > Game.extensionQuanticNumberHundreed) {
            Game.extentionComputerNumberHundreed --;
        }

        if (Game.extentionComputerNumberDecade < Game.extensionQuanticNumberDecade) {
            Game.extentionComputerNumberDecade ++;
        } else if (Game.extentionComputerNumberDecade > Game.extensionQuanticNumberDecade) {
            Game.extentionComputerNumberDecade --;
        }

        if (Game.extentionComputerNumberUnit < Game.extensionQuanticNumberUnit) {
            Game.extentionComputerNumberUnit ++;
        } else if (Game.extentionComputerNumberUnit > Game.extensionQuanticNumberUnit) {
            Game.extentionComputerNumberUnit --;
        }

        return Game.computerNumber;

*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
     do {
        mastermind.setChance(Integer.parseInt(p.getProperty("chance")));
        mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase")));
        mastermind.setRefereeNumber(mastermind.randomNumber(Integer.parseInt(p.getProperty("numberCase"))));
        System.out.println("referee number is: " + mastermind.getRefereeNumber());
        JOptionPane.showMessageDialog(null, String.format("DIFFICULTY: %s\n\nREFEREE: FIND MY NUMBER\nGOOD LUCK !", p.getProperty("numberCase")));

        do {
            do {
                mastermind.showRresult(mastermind.getMenu(), mastermind.getMode(),mastermind.getChance(), mastermind.getRandomNumber());
                mastermind.dialogue(mastermind.getMode(), mastermind.getPlayerNumber(), mastermind.getRefereeNumber(), mastermind.getName());
                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getPlayerNumber(), mastermind.getRefereeNumber());
                if (challenger.getChance() != 0) { break; }
            } while (challenger.getChance() != 0);

            if (challenger.getChance() == 0) { break; }

            do {
                JOptionPane.showMessageDialog(null, String.format("DIFFICULTY: %s\nCHANCE: %s\n\nCPU: YOU'RE NUMBER IS %s", p.getProperty("numberCase"), mastermind.getChance(), mastermind.getComputerNumber()));
                mastermind.dialogue(mastermind.getMode(), mastermind.getComputerNumber(), mastermind.getRefereeNumber(), mastermind.getName());
                mastermind.logic(mastermind.getMode(), mastermind.getNumberCase(), mastermind.getComputerNumber(), mastermind.getRefereeNumber());
                if (defender.getChance() != 0) { break; }
            } while (defender.getChance() != 0);

            if (defender.getChance() == 0) { break; }

        } while (challenger.getChance() != 0 || defender.getChance() != 0);
        mastermind.setReplay(JOptionPane.showConfirmDialog(null, String.format("REPLAY", JOptionPane.YES_NO_OPTION)));
    } while (mastermind.getReplay() == 0); */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
