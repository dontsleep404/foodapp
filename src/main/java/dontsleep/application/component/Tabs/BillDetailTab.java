package dontsleep.application.component.Tabs;

import java.io.IOException;

import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class BillDetailTab extends SimpleComponent{
    
    public BillDetailTab() throws IOException {
        super();
    }

    
    
}

class TaskPanel extends SimpleComponent{

    public Task task;

    @FXML
    private Text txt;

    @FXML
    private Text price;

    @FXML
    private Button status;

    @FXML
    private Button cancel;

    public TaskPanel(Task task) throws IOException {
        super();
    }

    public void cancel(){
        System.out.println("cancel");
    }

}