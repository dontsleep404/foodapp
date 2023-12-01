package dontsleep.application.component.Tabs;

import java.io.IOException;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.model.ItemType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class AddItemTab extends SimpleComponent{

    @FXML
    private Spinner<ItemType> type;

    public AddItemTab() throws IOException {
        super();

        ItemType[] itemTypes = GlobalClient.itemTypes.toArray(new ItemType[0]);

        SpinnerValueFactory<ItemType> spinnerValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(FXCollections.observableArrayList(itemTypes));
        type.setValueFactory(spinnerValueFactory);
    }
    
}
