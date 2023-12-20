package dontsleep.application.component;

import java.io.IOException;

import dontsleep.application.GlobalClient;
import dontsleep.application.component.Tabs.*;
import dontsleep.application.helper.SimpleComponent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class CTabPane extends SimpleComponent{

    @FXML
    private TabPane tabPane;
    
    public OrderTab orderTab;
    public BillDetailTab billDetailTab;
    public HistoryTab historyTab;
    public AddItemTab addItemTab;
    public EditItemTab editItemTab;

    public CTabPane() throws IOException {
        super();
        
        if(GlobalClient.user.canOrder()){
            orderTab = new OrderTab();
            addTab(orderTab, "Order");

            billDetailTab = new BillDetailTab();
            addTab(billDetailTab, "Bill");

            // historyTab = new HistoryTab();
            // addTab(historyTab, "History");
        }
        if (GlobalClient.user.isStaff()) {
            billDetailTab = new BillDetailTab();
            addTab(billDetailTab, "Bill");
        }
        if(GlobalClient.user.canAddItem()){
            addItemTab = new AddItemTab();
            addTab(addItemTab, "Add Item");
        }

        if(GlobalClient.user.canEditItem()){
            editItemTab = new EditItemTab();
            addTab(editItemTab, "Edit Item");
        }


    }

    public void addTab(SimpleComponent component, String title) throws IOException {
        Tab tab = new Tab();
        tab.setText(title);
        tab.setContent(component);
        
        tabPane.getTabs().add(tab);
    }
}
