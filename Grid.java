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

    private List<List<Button>> buttonsGrid = new ArrayList<>();
    private HashMap<Button, Boolean> buttonTicked = new HashMap<>();

    public Boolean checkWinner() {
        // Horizontally
        for (List<Button> row: this.buttonsGrid) {
            if (row.get(0).getText().equals(row.get(1).getText())
                    && row.get(0).getText().equals(row.get(2).getText())
                    && (!row.get(0).getText().equals(" "))) {
                TicTacToeJavaFX.setGameOn(Boolean.FALSE);
                return Boolean.TRUE;
            }
        }
        //  Vertically
        for (int j=0; j<3; j++) {
           if (buttonsGrid.get(0).get(j).getText().equals(buttonsGrid.get(1).get(j).getText())
                   && buttonsGrid.get(0).get(j).getText().equals(buttonsGrid.get(2).get(j).getText())
                   && !buttonsGrid.get(0).get(j).getText().equals(" ")) {
               TicTacToeJavaFX.setGameOn(Boolean.FALSE);
               return Boolean.TRUE;
           }
        }

        // Diagonally
        if (buttonsGrid.get(0).get(0).getText().equals(buttonsGrid.get(1).get(1).getText())
                && buttonsGrid.get(1).get(1).getText().equals(buttonsGrid.get(2).get(2).getText())
                && !buttonsGrid.get(0).get(0).getText().equals(" ")) {
            TicTacToeJavaFX.setGameOn(Boolean.FALSE);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Parent getGrid() {
//        UI elements

        for (int i=0; i<3; i++) {
            List<Button> buttonsRow  = new ArrayList<>();
            for (int j=0; j<3; j++) {
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                buttonsRow.add(button);
                this.buttonTicked.put(button, Boolean.FALSE);
            }
            this.buttonsGrid.add(buttonsRow);
        }

//        Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20,20,20,20));
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                grid.add(this.buttonsGrid.get(i).get(j), j, i);
            }
        }

//        Event listener
        for (List<Button> row: this.buttonsGrid) {
            for (Button button: row) {
                button.setOnMouseClicked((event)->{
                    if (!this.buttonTicked.get(button) && TicTacToeJavaFX.getGameOn()) {
                        if (TicTacToeJavaFX.getPlayer().equals("X")) {
                            button.setText("X");
                            TicTacToeJavaFX.setPlayer("O");
                        }
                        else {
                            button.setText("O");
                            TicTacToeJavaFX.setPlayer("X");
                        }
                        TicTacToeJavaFX.setTurnLabel("Turn: " + TicTacToeJavaFX.getPlayer());
                        this.buttonTicked.put(button, Boolean.TRUE);
                        if (checkWinner()) {
                            String winner;
                            if (TicTacToeJavaFX.getPlayer().equals("X")) {
                                winner = "Y";
                            }
                            else {
                                winner = "X";
                            }
                            TicTacToeJavaFX.setTurnLabel("End of Game. " + winner + " wins");
                            System.out.println("There is a winner");
                        }
                        else {
                            System.out.println("There is not winner yet");
                        }
                    }
                });
            }
        }

        return grid;
    }
}
