package cz.filipino04.pianonotestesting.view;

import cz.filipino04.pianonotestesting.model.Constants;
import cz.filipino04.pianonotestesting.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuScene extends Scene {


    final ComboBox<Integer> livesOptions = new ComboBox<>();

    private void createScene(Stage stage) {
        VBox root = (VBox) getRoot();
        livesOptions.getItems().addAll(1, 3, 5, 7, 10, 20);
        livesOptions.setValue(3);
        Tooltip tooltip = new Tooltip("Vyber si počet životů");
        Tooltip.install(livesOptions,tooltip);
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
                Game game = new Game();
                System.out.println(livesOptions.getValue());
                game.setLivesRemaining(livesOptions.getValue());
                stage.setScene(new GameScene(stage,Constants.GameWidth,Constants.GameHeight,game));
            }
        });

      helpButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
              stage.setScene(new HelpScene(stage,Constants.HelpWidth,Constants.HelpHeight));
          }
      });

    }
    public MainMenuScene(Stage stage, double width, double height) {
        super(new VBox(), width, height);
        createScene(stage);

    }
}
