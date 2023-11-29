package dontsleep.application.view;

import java.io.IOException;

import dontsleep.application.component.CTabPane;
import dontsleep.application.helper.SimpleComponent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class MenuView extends SimpleComponent{
    
    @FXML
    private GridPane gr;

    private static MenuView instance;

    public MenuView() throws IOException {
        super();
        CTabPane cTabPane = new CTabPane();
        gr.add(cTabPane, 1, 0);
        instance = this;
    }
    public static MenuView getInstance(){
        return instance;
    }
    
    @Override
    public void close() {
        super.close();
        instance = null;
    }
}
