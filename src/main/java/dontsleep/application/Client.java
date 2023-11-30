package dontsleep.application;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import atlantafx.base.theme.Dracula;
import dontsleep.application.helper.SimpleStage;
import dontsleep.application.view.MenuView;
import dontsleep.application.view.SplashView;

/**
 * JavaFX App
 */
public class Client extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Application.setUserAgentStylesheet(new Dracula().getUserAgentStylesheet());
        // new SimpleStage(new MenuView("Hello", 1));
        new SimpleStage(new SplashView());
    }
    public static void main(String[] args) {
        launch();     
    }
}