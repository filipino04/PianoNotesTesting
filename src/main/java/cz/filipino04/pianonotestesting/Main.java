package cz.filipino04.pianonotestesting;

import cz.filipino04.pianonotestesting.model.Game;
import cz.filipino04.pianonotestesting.view.GameScene;
import cz.filipino04.pianonotestesting.view.MainMenuScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main (String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage){
        Game game = new Game();
        MainMenuScene mainMenuScene = new MainMenuScene(stage,200,200);
        stage.setTitle("Piano notes testing\n");
        stage.setResizable(false);
        stage.setScene(mainMenuScene);
        stage.show();
    }
}
