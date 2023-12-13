package dontsleep.application.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Task {

    public SimpleStringProperty tableId;
    public SimpleIntegerProperty id;
    public SimpleStringProperty itemName;
    public SimpleIntegerProperty quantity;
    public SimpleIntegerProperty itemCost;
    public SimpleIntegerProperty totalCost;
    public SimpleStringProperty status;

    public Task(String tableId, int id, String itemName, int quantity, int itemCost, String status) {
        this.tableId = new SimpleStringProperty(tableId);
        this.id = new SimpleIntegerProperty(id);
        this.itemName = new SimpleStringProperty(itemName);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.itemCost = new SimpleIntegerProperty(itemCost);
        this.totalCost = new SimpleIntegerProperty(itemCost * quantity);
        this.status = new SimpleStringProperty(status);
    }
    
}
