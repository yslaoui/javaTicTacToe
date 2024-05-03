package tictactoe;

import javafx.application.Application;
import javafx.geometry.Pos;
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
    private static Boolean gameOn;

    public void init() throws Exception {
        player = "X";
        gameOn = Boolean.TRUE;
    }

    public static String getPlayer() {
        return player;
    }
    public static void setPlayer(String newPlayer) {
        player = newPlayer;
    }

    public static void setTurnLabel(String newLabel) {
        turnLabel.setText(newLabel);
    }

    public static Boolean getGameOn() {
        return gameOn;
    }
    public static void setGameOn(Boolean gameState) {
        gameOn = gameState;
    }

    @Override
    public void start(Stage window) {
//        UI component
        turnLabel = new Label("Turn: " + player);
        turnLabel.setFont(Font.font("Monospaced", 40));
        turnLabel.setAlignment(Pos.CENTER);


//        Layouts
        Grid gridObject = new Grid();
        Parent grid = gridObject.getGrid();

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(turnLabel);
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
