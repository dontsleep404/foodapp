package dontsleep.application.view;

import java.io.IOException;

import dontsleep.application.GlobalClient;
import dontsleep.application.component.CTabPane;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.helper.SimpleStage;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class MenuView extends SimpleComponent{
    
    @FXML
    private GridPane gr;

    @FXML
    private Text txtID;

    @FXML
    private Text txtUser;
    
    @FXML
    private Text txtRole;
    
    private static MenuView instance;

    public CTabPane cTabPane;

    public MenuView() throws IOException {
        super();
        this.txtUser.setText("User : " + GlobalClient.user.getUsername());
        this.txtRole.setText("Role : " + GlobalClient.user.getClass().getSimpleName().toUpperCase());
        cTabPane = new CTabPane();
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

    public void handleLogout() throws IOException{
        close();
        new SimpleStage(new SplashView());
    }
}
