package cz.filipino04.pianonotestesting.model;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private Random random = new Random();
    private int playerScore;

    private int livesRemaining = 3;

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
        return 0;
    }

    /*public String getEnharmonicEquivalent(String note) {
        String newNote = note.substring(0,3);
        String octave = note.substring(3);
        String ret = Constants.enharmonicEquivavlents.get(newNote) + octave;
        if (Character.isUpperCase(newNote.charAt(0))){
            Character.toUpperCase(ret.charAt(0));
        }
        return ret;
    }*/

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
}



