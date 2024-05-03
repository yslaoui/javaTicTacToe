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
    private static String player;
    private static Label turnLabel;
    public void init() throws Exception {
        player = "X";
    }

    public static String getPlayer() {
        return player;
    }

    public static void setPlayer(String newPlayer) {
        player = newPlayer;
    }

    public static Label getLabel() {
        return turnLabel;
    }

    public static void setLabel(String newLabel) {
        turnLabel.setText("Turn: " + newLabel);
    }

    @Override
    public void start(Stage window) {
//        UI component
        turnLabel = new Label("Turn: " + player);
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
