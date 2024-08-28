package cz.filipino04.pianonotestesting.view;

import cz.filipino04.pianonotestesting.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuScene extends Scene {

    private GameScene gameScene;

    private void createScene(Stage stage) {
        VBox root = (VBox) getRoot();
        final ComboBox livesOptions = new ComboBox();
        livesOptions.getItems().addAll(1, 3, 5, 7, 10, 20);
        livesOptions.setValue(3);
        Button startGameButton = new Button("Start");
        Button helpButton = new Button("Help");
        root.setSpacing(50);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(livesOptions, startGameButton, helpButton);
        bindTheButtons(startGameButton,helpButton,stage);
    }

    private void bindTheButtons(Button startGameButton, Button helpButton,Stage stage){
        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(gameScene);
            }
        });

    }
    public MainMenuScene(Stage stage, double width, double height) {
        super(new VBox(), width, height);
        Game game = new Game();
        this. gameScene = new GameScene(stage,1400,2800,game);
        createScene(stage);

    }
}
