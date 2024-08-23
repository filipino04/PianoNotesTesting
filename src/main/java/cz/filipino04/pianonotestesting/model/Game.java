package cz.filipino04.pianonotestesting.model;
import cz.filipino04.pianonotestesting.model.Constants;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private Random random = new Random();
    private int playerScore;

    private int maxScore;

    private String correctAnswer;

    private String userAnswer;

    private int lastUsedNoteIndex = 1000;

    public boolean answerCheck(String userAnswer) {
        return (this.userAnswer.equals(this.correctAnswer));
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
}



