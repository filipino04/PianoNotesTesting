package cz.filipino04.pianonotestesting.view;

import cz.filipino04.pianonotestesting.model.Constants;
import cz.filipino04.pianonotestesting.model.Game;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class GameScene extends Scene {

    public Canvas canvas;


    private final Image heartImage = new Image("heart.png");



    private void renderWhiteKeys(Pane pane,Game game){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 7; j++){
                Rectangle whiteKey = new Rectangle(50,200, Color.WHITE);
                whiteKey.setX(((i * 7) + j) * whiteKey.getWidth());
                whiteKey.setY(600);
                whiteKey.setStroke(Color.BLACK);
                whiteKey.setStrokeWidth(2);
                pane.getChildren().add(whiteKey);
                game.whiteKeysArrayList.addLast(whiteKey);
            }
        }
    }

    private void renderBlackKeys(Pane pane,Game game){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 7; j++){
                if (j != 2 && j != 6){
                    Rectangle blackKey = new Rectangle(25,125,Color.BLACK);
                    blackKey.setY(600);
                    blackKey.setX((((i*7) + j)* 50) + 52 - 15);
                    pane.getChildren().add(blackKey);
                    game.blackKeysArrayList.addLast(blackKey);
                }
            }
        }
    }

    public void renderKeyboard(Pane pane, Game game){
        renderWhiteKeys(pane, game);
        renderBlackKeys(pane, game);
    }

    public void makeKeysButtons(Game game,Stage stage){ //TODO horrible - try to make it nicer
        for (int i = 0; i < 48; i++){
            final int index = i;
            if (i < 28){
                game.whiteKeysArrayList.get(i).setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY){
                        game.setUserAnswer(Constants.whiteKeys.get(index));
                        chooseAndShowAnimation(game,stage);
                        renderHearts(game,this.canvas);
                        game.generateNewQuestion();
                        drawNoteImage(game);
                    }
                });
            }
            else{
                game.blackKeysArrayList.get(index - 28).setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY){
                        game.setUserAnswer(Constants.blackKeys.get(index - 28));
                        chooseAndShowAnimation(game,stage);
                        renderHearts(game,this.canvas);
                        game.generateNewQuestion();
                        drawNoteImage(game);
                    }
                });
            }
        }
    }

     private void answerCheckAnimationCorrect(Game game){
         Rectangle target;
         Color defaultColor;
            if (game.isKeyBlack(game.getUserAnswer())){
                defaultColor = Color.BLACK;
            }
            else{
                defaultColor = Color.WHITE;
            }
         target = game.findKey(game.getUserAnswer());
         target.setFill(Color.GREEN);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> target.setFill(defaultColor));
            pause.play();
        }

        private void answerCheckAnimationFalse(Game game){
        Rectangle user, correct;
        Color correctDefault = Color.WHITE, userDefault = Color.WHITE;
            if (game.isKeyBlack(game.getUserAnswer()) && game.isKeyBlack(game.getCorrectAnswer())){
                correctDefault = userDefault  = Color.BLACK;
            }
            else if (game.isKeyBlack(game.getUserAnswer()) && !game.isKeyBlack(game.getCorrectAnswer())){
                correctDefault = Color.WHITE;
                userDefault = Color.BLACK;
            }
            else if (!game.isKeyBlack(game.getUserAnswer()) && game.isKeyBlack(game.getCorrectAnswer())){
                userDefault = Color.WHITE;
                correctDefault = Color.BLACK;
            }
            else if (!game.isKeyBlack(game.getUserAnswer()) && !game.isKeyBlack(game.getCorrectAnswer())){
                correctDefault = userDefault  = Color.WHITE;
            }
            final Color correctDefaultFinal = correctDefault;
            final Color userDefaultFinal = userDefault;
            user = game.findKey(game.getUserAnswer());
            correct = game.findKey(game.getCorrectAnswer());
            user.setFill(Color.RED);
            correct.setFill(Color.GREEN);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                user.setFill(userDefaultFinal);
                correct.setFill(correctDefaultFinal);
            });
            pause.play();
        }

    private void chooseAndShowAnimation(Game game,Stage stage){
        int result = game.answerCheck();
        if (result == 0){
            answerCheckAnimationCorrect(game);
        }
        else if (result == 1){
            System.out.println(game.getLivesRemaining());
            answerCheckAnimationFalse(game);
        }
        else{
            game.setNewRecordFlag(game.getPlayerScore() > game.getMaxScore());
            if (game.isNewRecordFlag()){
                game.writeNewRecordInFile();
            }
            stage.setScene(new GameOverScene(stage,Constants.OverDim,Constants.OverDim,game));
        }
        renderHearts(game,canvas);
    }
    public void renderHearts (Game game,Canvas canvas){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,800,200);
        for (int i = 0; i < game.getLivesRemaining();i++){
            gc.drawImage(heartImage,50 * (i + 1),10);
        }
    }

    public void drawNoteImage(Game game){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(300,300,2800,800);
        String imageFileName;
        if ((game.getCorrectAnswer().length() == 1 || game.getCorrectAnswer().length()==3) && game.isStringLowercase(game.getCorrectAnswer())){
            imageFileName = game.getCorrectAnswer() + "'" + ".png";
        }
        else{
            imageFileName = game.getCorrectAnswer() + ".png";
        }
        System.out.println(imageFileName);
        gc.drawImage(new Image(imageFileName),300,300);
    }
    public GameScene(Stage stage, double width, double height,Game game) {
        super(new Pane(), width, height);
        Pane pane = (Pane) getRoot();
        canvas = new Canvas(width - 50,height);
        pane.getChildren().add(canvas);
        renderKeyboard(pane,game);
        makeKeysButtons(game,stage);
        game.generateNewQuestion();
        renderHearts(game,canvas);
        System.out.println(game.getLivesRemaining());
        drawNoteImage(game);
    }
}
