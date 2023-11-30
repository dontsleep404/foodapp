package dontsleep.application.view;

import java.io.IOException;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.packet.CPacket.CPacketLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginView extends SimpleComponent{

    private static LoginView instance;

    @FXML
    private Button login;

    @FXML
    public TextField username;

    @FXML
    private PasswordField password;

    public LoginView() throws IOException {
        super();
        instance = this;
    }

    public static LoginView getInstance(){
        return instance;
    }
    
    @Override
    public void close() {
        super.close();
        instance = null;
    }

    public void handleLogin() throws IOException{
        String username = this.username.getText();
        String password = this.password.getText();

        if (username.isEmpty() || password.isEmpty()) {
            return;
        }

        CPacketLogin packet = new CPacketLogin();
        packet.username = username;
        packet.password = password;

        GlobalClient.client.sendPacket(packet);

    }
    public void handleLoginAsGuest() throws IOException{
        CPacketLogin packet = new CPacketLogin();
        packet.isGuest = true;
        
        GlobalClient.client.sendPacket(packet);
    }
    
}
