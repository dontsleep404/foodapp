package dontsleep.application.view;

import java.io.IOException;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.helper.SimpleStage;
import dontsleep.application.packet.CPacket.CPacketLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginView extends SimpleComponent{

    private static LoginView instance;

    @FXML
    private Button login;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    
    @FXML
    public Text status;

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
        status.setText("");
        
        String username = this.username.getText();
        String password = this.password.getText();

        if (username.isEmpty() || password.isEmpty()) {
            return;
        }

        CPacketLogin packet = new CPacketLogin();
        packet.username = username;
        packet.password = password;
        packet.tableId = GlobalClient.tableId;

        GlobalClient.client.sendPacket(packet);

    }
    public void handleLoginAsGuest() throws IOException{
        CPacketLogin packet = new CPacketLogin();
        packet.isGuest = true;        
        packet.tableId = GlobalClient.tableId;
        
        GlobalClient.client.sendPacket(packet);
    }

    public void handleRegister() throws IOException{
        close();
        new SimpleStage(new RegisterView());
    }
    
}
