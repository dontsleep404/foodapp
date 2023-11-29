package dontsleep.application.packet.SPacket.process;

import java.io.IOException;

import dontsleep.application.helper.SimpleStage;
import dontsleep.application.packet.SPacket.SPacketLogin;
import dontsleep.application.packet.process.ProcessPacket;
import dontsleep.application.view.LoginView;
import dontsleep.application.view.MenuView;
import dontsleep404.library.DClient;

public class ProcessSPacketLogin extends ProcessPacket<SPacketLogin> {

    public ProcessSPacketLogin(DClient client, SPacketLogin packet) {
        super(client, packet);
    }

    @Override
    public void process() {
        if (getPacket().success) {
            LoginView.getInstance().close();
            try {
                new SimpleStage(new MenuView());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            LoginView.getInstance().username.setText("Error Login");
        }
    }
    
}
