package dontsleep.application.component.Tabs;

import java.io.IOException;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BillDetailTab extends SimpleComponent {

    @FXML
    public TableView<Task> table;

    @FXML
    public Button btnPay;

    @FXML
    public Button btnAccept;

    @FXML
    public Button btnCancle;

    @FXML
    public Label txtCost;

    public BillDetailTab() throws IOException {
        super();
       
        if(GlobalClient.user.isStaff()){
            TableColumn<Task, String> tableId = new TableColumn<>("Table");
            tableId.setCellValueFactory(cellData -> cellData.getValue().tableId);
            table.getColumns().add(tableId);
            btnPay.setVisible(false);
            btnPay.setManaged(false);
            txtCost.setVisible(false);
            txtCost.setManaged(false);
        }else{
            btnAccept.setVisible(false);
            btnAccept.setManaged(false);
            btnCancle.setVisible(false);
            btnCancle.setManaged(false);
        }

        TableColumn<Task, Number> id = new TableColumn<>("Id");
        id.setCellValueFactory(cellData -> cellData.getValue().id);

        TableColumn<Task, String> itemName = new TableColumn<>("Name");
        itemName.setCellValueFactory(cellData -> cellData.getValue().itemName);
        
        TableColumn<Task, Number> quantity = new TableColumn<>("Quantity");
        quantity.setCellValueFactory(cellData -> cellData.getValue().quantity);

        TableColumn<Task, Number> itemCost = new TableColumn<>("Cost");
        itemCost.setCellValueFactory(cellData -> cellData.getValue().itemCost);

        TableColumn<Task, Number> totalCost = new TableColumn<>("Total");
        totalCost.setCellValueFactory(cellData -> cellData.getValue().totalCost);

        TableColumn<Task, String> status1 = new TableColumn<>("Status");
        status1.setCellValueFactory(cellData -> cellData.getValue().status);

        table.getColumns().add(id);
        table.getColumns().add(itemName);
        table.getColumns().add(quantity);
        table.getColumns().add(totalCost);
        table.getColumns().add(status1);

        table.setItems(GlobalClient.tasks);
    }   

    public void pay(){}

    public void accept(){

    }
    public void cancle(){

    }

    public void updateStatus(int id, String status){
        Task task = find(id);
        if(task != null){
            task.status.set(status);
        }
    }
    public Task find(int id){
        Task task = null;
        for(Task t : GlobalClient.tasks){
            if(t.id.get() == id){
                task = t;
                break;
            }
        }
        return task;
    }

}
