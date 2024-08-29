package cz.filipino04.pianonotestesting.view;

import cz.filipino04.pianonotestesting.model.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelpScene extends Scene {

    public HelpScene(Stage stage, double width, double height) {
        super(new VBox(), width, height);
        VBox root = (VBox) getRoot();
        Text heading1 = new Text("Jak hrát?");
        heading1.setFont(Font.font("Arial", FontWeight.BOLD, 24)); // Bold and larger font for headings
        heading1.setFill(Color.DARKBLUE); // Dark blue color for headings

        // Create and style the body text
        Text body1 = new Text(
                "Je to snadné...na obrazovce se ti objeví nota ve standardní notaci,\n" +
                        "a ty musíš akorát zmáčknout správnou klávesu, která té notě odpovídá.\n" +
                        "Hra ti dá okamžitě feedback - správná odpověď se obarví zeleně,\n" +
                        "případná špatná volba červeně."
        );
        body1.setFont(Font.font("Arial", FontWeight.NORMAL, 16)); // Regular font for body text

        // Create and style the second heading
        Text heading2 = new Text("Jak se hra boduje?");
        heading2.setFont(Font.font("Arial", FontWeight.BOLD, 24)); // Bold and larger font for headings
        heading2.setFill(Color.DARKBLUE); // Dark blue color for headings

        // Create and style the body text
        Text body2 = new Text(
                "Opět velmi snadně...za každou správnou odpověď máš bod,\n" +
                        "za každou špatnou ztratíš život (životy reprezentují srdíčka\n" +
                        "v levém horním rohu, v menu před začátkem hry si můžeš\n" +
                        "zvolit s kolika budeš začínat).\n" +
                        "Když ti dojdou životy, prohráváš a tvé výsledné skóre se\n" +
                        "rovná počtu správně určených kláves."
        );
        body2.setFont(Font.font("Arial", FontWeight.NORMAL, 16)); // Regular font for body text

        // Center the text
        root.setStyle("-fx-alignment: center;");

        Button backButton = new Button("<-");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(new MainMenuScene(stage, Constants.MenuWidth,Constants.MenuHeight));
            }
        });

        // Add all text elements to the VBox
        root.getChildren().addAll(heading1, body1, heading2, body2,backButton);
        root.setSpacing(20);
    }
}
