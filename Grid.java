package tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grid {

    public Boolean checkWinner() {

//        Horizontally
        return Boolean.FALSE;
    }

    public Parent getGrid() {
//        UI elements
        List<List<Button>> buttonsGrid = new ArrayList<>();
        HashMap<Button, Boolean> buttonTicked = new HashMap<>();

        for (int i=0; i<3; i++) {
            List<Button> buttonsRow  = new ArrayList<>();
            for (int j=0; j<3; j++) {
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                buttonsRow.add(button);
                buttonTicked.put(button, Boolean.FALSE);
            }
            buttonsGrid.add(buttonsRow);
        }

//        Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20,20,20,20));
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                grid.add(buttonsGrid.get(i).get(j), i, j);
            }
        }

//        Event listener
        for (List<Button> row: buttonsGrid) {
            for (Button button: row) {
                button.setOnMouseClicked((event)->{
                    if (!buttonTicked.get(button)) {
                        if (TicTacToeJavaFX.getPlayer().equals("X")) {
                            button.setText("X");
                            TicTacToeJavaFX.setPlayer("O");
                        }
                        else {
                            button.setText("O");
                            TicTacToeJavaFX.setPlayer("X");
                        }
                        TicTacToeJavaFX.setLabel(TicTacToeJavaFX.getPlayer());
                        buttonTicked.put(button, Boolean.TRUE);

                    }
                });
            }
        }

//        for (Button button: buttons) {
//            button.setOnMouseClicked((event)->{
//                if (!buttonTicked.get(button)) {
//                    if (TicTacToeJavaFX.getPlayer().equals("X")) {
//                        button.setText("X");
//                        TicTacToeJavaFX.setPlayer("O");
//                    }
//                    else {
//                        button.setText("O");
//                        TicTacToeJavaFX.setPlayer("X");
//                    }
//                    TicTacToeJavaFX.setLabel(TicTacToeJavaFX.getPlayer());
//                    buttonTicked.put(button, Boolean.TRUE);
//
//                }
//            });
//        }
        return grid;
    }
}
