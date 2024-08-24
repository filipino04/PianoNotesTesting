package cz.filipino04.pianonotestesting.view;

import cz.filipino04.pianonotestesting.model.Constants;
import cz.filipino04.pianonotestesting.model.Game;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameScene extends Scene {

    public Canvas canvas;


    private void renderWhiteKeys(Pane pane){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 7; j++){
                Rectangle whiteKey = new Rectangle(50,200, Color.WHITE);
                whiteKey.setX(((i * 7) + j) * whiteKey.getWidth());
                whiteKey.setY(600);
                whiteKey.setStroke(Color.BLACK);
                whiteKey.setStrokeWidth(2);
                pane.getChildren().add(whiteKey);
            }
        }
    }

    private void renderBlackKeys(Pane pane){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 7; j++){
                if (j != 2 && j != 6){
                    Rectangle blackKey = new Rectangle(25,125,Color.BLACK);
                    blackKey.setY(600);
                    blackKey.setX((((i*7) + j)* 50) + 52 - 15);
                    pane.getChildren().add(blackKey);
                }
            }
        }
    }

    public void renderKeyboard(Pane pane){
        renderWhiteKeys(pane);
        renderBlackKeys(pane);
    }

    public void makeKeysButtons(Pane pane,Game game){
        for (int i = 0; i < 48; i++){
            final int index = i;
            if (i < 28){
                pane.getChildren().get(i).setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY){
                        game.setUserAnswer(Constants.whiteKeys.get(index));
                        game.answerCheck(game.getUserAnswer());
                        System.out.println(game.getUserAnswer());
                    }
                });
            }
            else{
                pane.getChildren().get(i).setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY){
                        game.setUserAnswer(Constants.blackKeys.get(index - 28));
                        game.answerCheck(game.getUserAnswer());
                        System.out.println(game.getUserAnswer());
                    }
                });
            }
        }
    }
    public GameScene(Stage stage, double width, double height,Game game) {
        super(new Pane(), width, height);
        Pane pane = (Pane) getRoot();
        canvas = new Canvas(width - 50,height);
        renderKeyboard(pane);
        makeKeysButtons(pane,game);
    }
}
