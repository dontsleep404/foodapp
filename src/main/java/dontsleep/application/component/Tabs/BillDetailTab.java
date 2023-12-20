package dontsleep.application.component.Tabs;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.helper.SimpleStage;
import dontsleep.application.model.Task;
import dontsleep.application.packet.CPacket.CPacketUpdateOrder;
import dontsleep.application.view.PayView;
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

        id.setSortable(false);
        itemName.setSortable(false);
        quantity.setSortable(false);
        itemCost.setSortable(false);
        totalCost.setSortable(false);
        status1.setSortable(false);

        table.getColumns().add(id);
        table.getColumns().add(itemName);
        table.getColumns().add(quantity);
        table.getColumns().add(totalCost);
        table.getColumns().add(status1);

        table.setItems(GlobalClient.tasks);
    }   

    public void pay() throws IOException{
        new SimpleStage(new PayView());
    }

    public void accept(){
        if(table.getSelectionModel().getSelectedItem() == null) return;

        CPacketUpdateOrder packet = new CPacketUpdateOrder();
        packet.status = CPacketUpdateOrder.EnumOrderStatus.ACCEPTED;
        packet.taskID = table.getSelectionModel().getSelectedItem().id.get();
        
        GlobalClient.client.sendPacket(packet);
    }
    public void cancle(){
        if(table.getSelectionModel().getSelectedItem() == null) return;

        CPacketUpdateOrder packet = new CPacketUpdateOrder();
        packet.status = CPacketUpdateOrder.EnumOrderStatus.CANCELED;
        packet.taskID = table.getSelectionModel().getSelectedItem().id.get();

        GlobalClient.client.sendPacket(packet);
    }

    public void updateStatus(int id, String status){
        Task task = find(id);
        if(task != null){
            task.status.set(status);
            if (GlobalClient.user.isStaff()){
                GlobalClient.tasks.remove(task);
            }
        }
        int cost = 0;
        for(Task t : GlobalClient.tasks){
           
            if (!GlobalClient.user.isStaff() && t.status.get().equals("ACCEPTED")){
                cost += t.totalCost.get();
            }
        }
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(0);
        txtCost.setText(numberFormat.format(cost));
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
