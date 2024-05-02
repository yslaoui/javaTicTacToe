package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.awt.*;

public class TicTacToeJavaFX extends Application {
    @Override
    public void start(Stage window) {
//        UI component
        Label turnLabel = new Label("Turn: X");
        turnLabel.setFont(Font.font("Monospaced", 40));

        Label endLabel = new Label("Game End. X wins.");
        endLabel.setFont(Font.font("Monospaced", 40));

//        Layouts
        Grid gridObject = new Grid();
        Parent grid = gridObject.getGrid();

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(turnLabel);
        mainLayout.setBottom(endLabel);
        mainLayout.setCenter(grid);

//        Scene
        Scene scene = new Scene(mainLayout);

//        Window
        window.setScene(scene);
        window.setTitle("TicTacToe");
        window.show();

    }
    public static void main(String[] args) {
        launch(TicTacToeJavaFX.class);
    }
}
