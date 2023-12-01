package dontsleep.application.component.Tabs;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.model.Item;
import dontsleep.application.view.MenuView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemPanel extends SimpleComponent{

    @FXML
    private ImageView image;

    @FXML
    private Label name;
    
    @FXML
    private Label price;

    private Item item;

    public ItemPanel(Item item) throws IOException {
        super();
        this.item = item;
        name.setText(item.name);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(0);
        price.setText(numberFormat.format(item.price));
        image.setImage(new Image(item.image));
        
    }
    public void onClick(){
        if(MenuView.getInstance() != null){
            MenuView.getInstance().cTabPane.orderTab.setCurrentItem(item);
        }
    }
}
