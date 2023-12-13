package dontsleep.application.component.Tabs;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.model.Item;
import dontsleep.application.model.ItemType;
import dontsleep.application.packet.CPacket.CPacketOrderItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class OrderTab extends SimpleComponent{
    
    @FXML
    private TabPane tabPane;

    @FXML
    private TextField quantity;

    @FXML
    private Label price;

    @FXML
    private Label name;

    private Item currentItem;
    
    private int currentQuantity = 0;

    public OrderTab() throws IOException {
        super();
        updateTab();
    }
    public void updateTab() throws IOException{
        tabPane.getTabs().clear();
        for(ItemType item : GlobalClient.itemTypes){

            Tab tab = new Tab();
            TabContent tabContent = new TabContent(item);
            tab.setText(item.name);
            tab.setContent(tabContent);

            if (tabContent.isHaveItem) {
                tabPane.getTabs().add(tab);
            }
        }
    }
    public void setCurrentItem(Item item){
        currentItem = item;
        currentQuantity = 1;
        update();
    }
    public void update(){
        if (currentItem == null) {
            name.setText("");
            price.setText("");
            quantity.setText("");
            currentQuantity = 0;
            return;            
        }
        name.setText(currentItem.name);

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(0);
        price.setText(numberFormat.format(currentItem.price * currentQuantity));

        quantity.setText(String.valueOf(currentQuantity));
    }
    public void dec(){
        if (currentItem == null) {
            return;            
        }
        if(currentQuantity > 1){
            currentQuantity--;
            update();
        }
    }

    public void inc(){
        if (currentItem == null) {
            return;            
        }
        currentQuantity++;
        update();
    }

    public void add(){
        if (currentItem == null) {
            return;
        }

        CPacketOrderItem packet = new CPacketOrderItem();
        packet.itemID = currentItem.id;
        packet.quantity = currentQuantity;

        GlobalClient.client.sendPacket(packet);

        currentItem = null;
        update();
    }
}
class TabContent extends SimpleComponent{
    @FXML
    private FlowPane flowPane;

    public boolean isHaveItem = false;

    public TabContent(ItemType itemType) throws IOException {
        super();

        for(Item item : GlobalClient.items){
            if(item.type == itemType.id){
                ItemPanel itemPanel = new ItemPanel(item);
                flowPane.getChildren().add(itemPanel);
                isHaveItem = true;
            }
        }
    }

}