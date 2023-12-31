package dontsleep.application.component.Tabs;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.model.ItemType;
import dontsleep.application.packet.CPacket.CPacketAddItem;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddItemTab extends SimpleComponent{

    @FXML
    private ComboBox<ItemType> item;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtDesc;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtImage;

    @FXML
    private TextField txtType;

    @FXML
    private Label status;
    
    public AddItemTab() throws IOException {
        super();
        updateComboBox();
    }
    
    public void updateComboBox(){
        item.getItems().clear();
        for(ItemType item : GlobalClient.itemTypes){
            this.item.getItems().add(item);
        }
    }

    public void add(){
        status.setText("");
        ArrayList<String> errors = new ArrayList<>();
        if (txtName.getText().isEmpty()) errors.add("Name cannot be empty");
        if (txtDesc.getText().isEmpty()) errors.add("Description cannot be empty");
        if (txtImage.getText().isEmpty()) errors.add("Image cannot be empty");
        try{
            new URL(txtImage.getText());
        } catch (Exception e){
            errors.add("Image must be a valid URL");
        }
        if (txtPrice.getText().isEmpty()) errors.add("Price cannot be empty");
        try{
            Integer.parseInt(txtPrice.getText());
        }catch(NumberFormatException e){
            errors.add("Price must be a number");
        }
        if (item.getSelectionModel().getSelectedItem() == null && txtType.getText().isEmpty()) errors.add("Item type cannot be empty");

        if (errors.size() > 0){
            error(errors.get(0));
        }else{
            CPacketAddItem packet = new CPacketAddItem();
            packet.name = txtName.getText();
            packet.description = txtDesc.getText();
            packet.price = Integer.parseInt(txtPrice.getText());
            packet.image = txtImage.getText();
            if (item.getSelectionModel().getSelectedItem() != null){
                packet.type = item.getSelectionModel().getSelectedItem().id;
            }
            if (!txtType.getText().isEmpty()){
                packet.n_type = txtType.getText();
            }
            GlobalClient.client.sendPacket(packet);
        }
    }
    public void error(String error){
        status.setText(error);
        status.setStyle("-fx-text-fill: red");
    }
    public void success(String success){
        status.setText(success);
        status.setStyle("-fx-text-fill: green");
    }
    public void clear(){
        status.setText("");
        txtName.clear();
        txtDesc.clear();
        txtPrice.clear();
        txtImage.clear();
        txtType.clear();
        item.getSelectionModel().clearSelection();
    }
}
