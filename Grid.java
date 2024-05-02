package tictactoe;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Grid {
    public  Grid() {

    }
    public Parent getGrid() {
//        UI elements
        Button button1 = new Button("X");
        button1.setFont(Font.font("Monospaced", 40));
        Button button2 = new Button("O");
        button2.setFont(Font.font("Monospaced", 40));

//        Layout
        GridPane grid = new GridPane();
        grid.add(button1, 0, 0);
        grid.add(button2, 1, 0);
        return grid;
    }
}
