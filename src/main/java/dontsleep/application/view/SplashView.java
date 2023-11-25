package dontsleep.application.view;

import java.io.IOException;

import dontsleep.application.helper.SimpleComponent;
import dontsleep.application.helper.SimpleStage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class SplashView extends SimpleComponent{

    @FXML
    public ProgressBar wtf;
    
    public SplashView() throws IOException{
        super();
        run();
    }
    public void run(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                float[] progress = {0};
                for(int i = 0; i < 100; i++){
                    try {
                        Thread.sleep(10);
                        progress[0] += 0.01;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            wtf.setProgress(progress[0]);
                        }
                    });
                }
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        try {
                            ((Stage) wtf.getScene().getWindow() ).close();
                            new SimpleStage(new LoginView());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }).start();
    }
    
}
