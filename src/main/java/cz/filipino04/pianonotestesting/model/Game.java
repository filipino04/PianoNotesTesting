package cz.filipino04.pianonotestesting.model;

import javafx.scene.shape.Rectangle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private  final Random random = new Random();
    private int playerScore;

    private int livesRemaining;

    private int maxScore;

    private String correctAnswer;

    private String userAnswer;

    public ArrayList<Rectangle> whiteKeysArrayList = new ArrayList<>();

    public ArrayList<Rectangle> blackKeysArrayList = new ArrayList<>();

    private boolean newRecordFlag = false;


    public int answerCheck() {
        if (!(this.userAnswer.equals(this.correctAnswer))){
            System.out.println("WRONG");
            setLivesRemaining(getLivesRemaining()-1);
            if (hasGameEnded()){
                return 2;
            }
            return 1;
        }
        setPlayerScore(getPlayerScore()+1);
        return 0;
    }


    public void generateNewQuestion() {
        int blackOrWhite = random.nextInt(10);
        ArrayList<String> toPickFrom;
        if (blackOrWhite > 3) {
            toPickFrom = Constants.whiteKeys;
        } else {
            toPickFrom = Constants.blackKeys;
        }
            int index = random.nextInt(toPickFrom.size() - 1);
            String newAnswer = toPickFrom.get(index);
            setCorrectAnswer(newAnswer);
            System.err.println("New correct answer is " + newAnswer);
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getLivesRemaining() {
        return livesRemaining;
    }

    public void setLivesRemaining(int livesRemaining) {
        this.livesRemaining = livesRemaining;
    }

    public boolean isKeyBlack(String keyName){
        return (keyName.length() > 2);
    }

    public Rectangle findKey(String keyName){
        if (isKeyBlack(keyName)){
            return blackKeysArrayList.get(Constants.blackKeys.indexOf(keyName));
        }
        else{
            return whiteKeysArrayList.get(Constants.whiteKeys.indexOf(keyName));
        }
    }

    private boolean hasGameEnded(){
        return (this.livesRemaining <= 0);
    }

    public boolean isNewRecordFlag() {
        return newRecordFlag;
    }

    public void setNewRecordFlag(boolean newRecordFlag) {
        this.newRecordFlag = newRecordFlag;
    }

    public boolean isStringLowercase(String string){
        for (int i = 0; i <string.length(); i++){
            if (!Character.isLowerCase(string.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public void writeNewRecordInFile(){
        String fileName = "/Users/filipchyska/Programování moje/PianoNotesTesting/PianoNotesTesting/src/main/resources/bestScore.txt";
        try {
            FileWriter fw = new FileWriter(fileName, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(getPlayerScore()));
            bw.close();
        }
        catch (IOException e){
            System.err.println("ERROR while writing to file" + e.getMessage());
        }
    }

    public Game() {
        try {
            File file = new File("/Users/filipchyska/Programování moje/PianoNotesTesting/PianoNotesTesting/src/main/resources/bestScore.txt");
            Scanner scanner = new Scanner(file);
            setMaxScore(scanner.nextInt());
        }
        catch (Exception e ){
            System.out.println(e.getMessage());
        }
        System.out.println("High score is " +getMaxScore());
    }
}



