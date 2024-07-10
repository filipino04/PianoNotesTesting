module cz.filipino04.pianonotestesting {
    requires javafx.controls;
    requires javafx.fxml;


    opens cz.filipino04.pianonotestesting to javafx.fxml;
    exports cz.filipino04.pianonotestesting;
}