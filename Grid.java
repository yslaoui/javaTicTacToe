package tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    public  Grid() {

    }
    public Parent getGrid() {
//        UI elements
        List<Button> buttons = new ArrayList();
        for (int i=0; i< 9; i++) {
            Button button = new Button(" ");
            button.setFont(Font.font("Monospaced", 40));
            buttons.add(button);
        }

//        Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20,20,20,20));
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                grid.add(buttons.get(3*i+j), i, j);
            }
        }
        return grid;
    }
}
