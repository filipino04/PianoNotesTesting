package cz.filipino04.pianonotestesting;

import cz.filipino04.pianonotestesting.model.Constants;
import cz.filipino04.pianonotestesting.view.MainMenuScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main (String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage){
        MainMenuScene mainMenuScene = new MainMenuScene(stage, Constants.MenuWidth,Constants.MenuHeight);
        stage.setTitle("Piano notes testing\n");
        stage.setResizable(false);
        stage.setScene(mainMenuScene);
        stage.show();
    }
}
