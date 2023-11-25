package dontsleep.application.helper;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Helper {
    public static Parent loadFXML(Class<?> _class, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(_class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static FXMLLoader loadFXMLLoader(Class<?> _class, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(_class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    public static void setRoot(Scene scene, Class<?> _class, String fxml) throws IOException {
        scene.setRoot(loadFXML(_class, fxml));
    }
}
