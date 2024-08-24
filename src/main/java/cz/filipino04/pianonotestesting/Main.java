package cz.filipino04.pianonotestesting;

import cz.filipino04.pianonotestesting.model.Game;
import cz.filipino04.pianonotestesting.view.GameScene;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main (String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game();
        GameScene gameScene = new GameScene(stage,2000,2800,game);
        stage.setTitle("Piano notes testing\n");
        stage.setResizable(false);
        stage.setScene(gameScene);
        stage.show();
    }
}
