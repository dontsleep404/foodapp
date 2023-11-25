package dontsleep.application.view;

import java.io.IOException;

import dontsleep.application.component.CTabPane;
import dontsleep.application.helper.SimpleComponent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class MenuView extends SimpleComponent{

    @FXML
    private GridPane gr;

    public MenuView() throws IOException {
        super();
        CTabPane cTabPane = new CTabPane();
        gr.add(cTabPane, 1, 0);
    }
    
}
