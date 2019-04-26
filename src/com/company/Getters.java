package com.company;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Getters extends Mastermind {

    static final Logger logger = LogManager.getLogger();

    public Getters(){
        super();
    }

    public Getters(String name, int chance, String parameter1){
        this.name = name;
        this.chance = chance;
        this.parameter1 = parameter1;
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
        return this.playerNumber;
    }

    public void setPlayerNumber(String playerNumber) throws IOException {

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
                this.showRresult(menu,mode,chance);
            } else this.playerNumber = playerNumber;
        } while (this.playerNumber.length() < Integer.parseInt(p.getProperty("numberCase")) || this.playerNumber.length() > Integer.parseInt(p.getProperty("numberCase")));
    }

    public String getBrainyNumber() { return this.brainyNumber; }

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

    public Boolean getSystemMode() { return this.systemMode; }

    public void setSystemMode(Boolean systemMode) { this.systemMode = systemMode; }

    public String getAnswer() { return answer; }

    public void setAnswer(String answer) { this.answer = answer; }
}
