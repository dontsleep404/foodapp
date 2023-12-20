package dontsleep.application.view;

import java.io.IOException;

import dontsleep.application.helper.SimpleComponent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PayView extends SimpleComponent {

    @FXML
    public Text txtStatus;

    private static PayView instance;
    
    public PayView() throws IOException {
        super();
        instance = this;
    }
    public static PayView getInstance(){
        return instance;
    }
    
    @Override
    public void close() {
        super.close();
        instance = null;
    }
}
