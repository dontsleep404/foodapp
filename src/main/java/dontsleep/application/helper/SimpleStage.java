package dontsleep.application.helper;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleStage extends Stage{
    public SimpleStage(SimpleComponent component) throws IOException{
        super();
        this.setOnCloseRequest(e->{
            System.out.println("Close");
            System.exit(0);
        });
        Scene scene = new Scene(component);
        setScene(scene);
        centerOnScreen();
        show();
    }
}
