package dontsleep.application.view;

import java.io.IOException;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.helper.SimpleStage;
import dontsleep.application.packet.CPacket.CPacketRegister;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegisterView extends SimpleComponent{

    private static RegisterView instance;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    
    @FXML
    public Text status;

    public RegisterView() throws IOException {
        super();
        instance = this;
    }

    public static RegisterView getInstance(){
        return instance;
    }
    
    @Override
    public void close() {
        super.close();
        instance = null;
    }

    public void handleRegister() throws IOException{
        status.setText("");
        
        String username = this.username.getText();
        String password = this.password.getText();

        if (username.isEmpty() || password.isEmpty()) {
            return;
        }

        CPacketRegister packet = new CPacketRegister();
        packet.username = username;
        packet.password = password;

        GlobalClient.client.sendPacket(packet);

    }

    public void handleLogin() throws IOException{
        close();
        new SimpleStage(new LoginView());
    }
    
}
