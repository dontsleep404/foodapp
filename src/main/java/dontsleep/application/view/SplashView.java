package dontsleep.application.view;

import java.io.IOException;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.helper.SimpleStage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class SplashView extends SimpleComponent {

    @FXML
    public Text txtStatus;

    private static SplashView instance;
    
    public SplashView() throws IOException {
        super();
        instance = this;
        run();
    }
    public static SplashView getInstance(){
        return instance;
    }
    
    @Override
    public void close() {
        super.close();
        instance = null;
    }
    public void run() throws IOException {
        if (GlobalClient.connect()) {
            txtStatus.setText("Connect Success!");
            Platform.runLater(() -> {
                close();
            });
            new SimpleStage(new LoginView());
        } else {
            txtStatus.setText("Connect Failed!");
        }
    }
}
