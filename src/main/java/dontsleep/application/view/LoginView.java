package dontsleep.application.view;

import java.io.IOException;

import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.helper.SimpleStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginView extends SimpleComponent{
    @FXML
    private Button login;

    public LoginView() throws IOException {
        super();
    }

    public void handleLogin() throws IOException{
        ((Stage) getScene().getWindow()).close();
        new SimpleStage(new MenuView());
    }
    public void handleLoginAsGuest(){
        
    }
    
}
