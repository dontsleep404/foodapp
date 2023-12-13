package dontsleep.application.component.Tabs;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.model.Item;
import dontsleep.application.model.ItemType;
import dontsleep.application.packet.CPacket.CPacketEditItem;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditItemTab extends SimpleComponent{

    @FXML
    private ComboBox<Item> items; 

    @FXML
    private ComboBox<ItemType> itemtypes;

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
    
    public EditItemTab() throws IOException {
        super();
        updateComboBox();
        items.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSelected();
        });
    }
    
    public void updateComboBox(){
        itemtypes.getItems().clear();
        for(ItemType item : GlobalClient.itemTypes){
            this.itemtypes.getItems().add(item);
        }

        items.getItems().clear();
        for(Item item : GlobalClient.items){
            this.items.getItems().add(item);
        }
    }

    public void updateSelected(){
        if (items.getSelectionModel().getSelectedItem() != null){
            txtName.setText(items.getSelectionModel().getSelectedItem().name);
            txtDesc.setText(items.getSelectionModel().getSelectedItem().description);
            txtPrice.setText(Integer.toString(items.getSelectionModel().getSelectedItem().price));
            txtImage.setText(items.getSelectionModel().getSelectedItem().image);
            txtType.clear();
            itemtypes.getSelectionModel().clearSelection();
            for(ItemType item : GlobalClient.itemTypes){
                if (item.id == items.getSelectionModel().getSelectedItem().type){
                    itemtypes.getSelectionModel().select(item);
                    break;
                }
            }
        }else{
            clear();
        }
    }

    public void edit(){
        if (items.getSelectionModel().getSelectedItem() == null) return;
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
        if (itemtypes.getSelectionModel().getSelectedItem() == null && txtType.getText().isEmpty()) errors.add("Item type cannot be empty");

        if (errors.size() > 0){
            error(errors.get(0));
        }else{
            CPacketEditItem packet = new CPacketEditItem();
            packet.isDelete = false;
            packet.id = items.getSelectionModel().getSelectedItem().id;
            packet.name = txtName.getText();
            packet.description = txtDesc.getText();
            packet.price = Integer.parseInt(txtPrice.getText());
            packet.image = txtImage.getText();
            if (itemtypes.getSelectionModel().getSelectedItem() != null){
                packet.type = itemtypes.getSelectionModel().getSelectedItem().id;
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
        itemtypes.getSelectionModel().clearSelection();
    }
    public void delete(){
        status.setText("");
        if (items.getSelectionModel() != null){
            CPacketEditItem packet = new CPacketEditItem();
            packet.isDelete = true;
            packet.id = items.getSelectionModel().getSelectedItem().id;
            GlobalClient.client.sendPacket(packet);
        }
    }
}
