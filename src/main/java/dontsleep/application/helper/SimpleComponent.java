package dontsleep.application.helper;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleComponent extends VBox{    
    public SimpleComponent() throws IOException{
        super();
        FXMLLoader fxmlLoader = Helper.loadFXMLLoader(getClass(), getClass().getSimpleName());
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        getChildren().add(root);
        VBox.setVgrow(root, Priority.ALWAYS);
    }
    public void close(){
        try {
            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
