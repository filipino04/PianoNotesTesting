package cz.filipino04.pianonotestesting.view;

import cz.filipino04.pianonotestesting.model.Constants;
import cz.filipino04.pianonotestesting.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class GameOverScene extends Scene {

    private void setGameOver(Pane root,Game game,Stage stage){
        Text lostMessage = new Text("Konec hry");
        Text scoreMessage = new Text("Tvoje skóre bylo " + game.getPlayerScore() + "...");
        Text newRecordMessage = new Text("...což je tvůj nový rekord, super :) !");
        Button playAgainButton = new Button("Play again");
        root.getChildren().addAll(lostMessage,scoreMessage,newRecordMessage,playAgainButton);
        lostMessage.setTextAlignment(TextAlignment.CENTER);
        lostMessage.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        lostMessage.setX(150);
        lostMessage.setY(200);
        scoreMessage.setX(150);
        scoreMessage.setY(250);
        scoreMessage.setTextAlignment(TextAlignment.CENTER);
        lostMessage.setTextAlignment(TextAlignment.CENTER);
        if (game.isNewRecordFlag()){
            newRecordMessage.setX(150);
            newRecordMessage.setY(300);
            newRecordMessage.setTextAlignment(TextAlignment.CENTER);
        }

        playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(new MainMenuScene(stage, Constants.MenuWidth,Constants.MenuHeight));
            }
        });
    }
    public GameOverScene(Stage stage, double width, double height, Game game) {
        super(new Pane(), width, height);
        Pane root = (Pane) getRoot();
        setGameOver(root,game,stage);
    }
}
