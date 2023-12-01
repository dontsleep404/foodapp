package dontsleep.application.component;

import java.io.IOException;

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

    public CTabPane() throws IOException {
        super();
        orderTab = new OrderTab();
        billDetailTab = new BillDetailTab();
        historyTab = new HistoryTab();
        addItemTab = new AddItemTab();

        addTab(orderTab, "Order");
        addTab(billDetailTab, "Bill");
        addTab(historyTab, "History");
        addTab(addItemTab, "Add Item");
    }

    public void addTab(SimpleComponent component, String title) throws IOException {
        Tab tab = new Tab();
        tab.setText(title);
        tab.setContent(component);
        
        tabPane.getTabs().add(tab);
    }
}
