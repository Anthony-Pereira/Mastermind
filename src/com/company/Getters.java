package com.company;

import javax.swing.*;

public class Getters extends Mastermind {


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

    public String getBrainyNumber() {
        return this.brainyNumber;
    }

    public void setBrainyNumber(String computerNumber) {
        this.brainyNumber = computerNumber;
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

    public String getMrCpuNumber() {
        return mrCpuNumber;
    }

    public void setMrCpuNumber(String refereeNumber) { this.mrCpuNumber = refereeNumber; }

    public int getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(int mainMenu) {
        this.mainMenu = mainMenu;
    }

    public Boolean getResponseIsGood() {
        return responseIsGood;
    }

    public void setResponseIsGood(Boolean responseIsGood) {
        this.responseIsGood = responseIsGood;
    }


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

    public Boolean getSystemMode() {
        return systemMode;
    }

    public void setSystemMode(Boolean systemMode) {
        this.systemMode = systemMode;
    }
}
