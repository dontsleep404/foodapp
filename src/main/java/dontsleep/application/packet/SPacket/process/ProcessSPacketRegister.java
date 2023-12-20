package dontsleep.application.packet.SPacket.process;

import java.io.IOException;

import dontsleep.application.GlobalClient;
import dontsleep.application.helper.SimpleStage;
import dontsleep.application.model.user.Guest;
import dontsleep.application.model.user.Staff;
import dontsleep.application.model.user.User;
import dontsleep.application.packet.SPacket.SPacketRegister;
import dontsleep.application.packet.process.ProcessPacket;
import dontsleep.application.view.MenuView;
import dontsleep.application.view.RegisterView;
import dontsleep404.library.DClient;

public class ProcessSPacketRegister extends ProcessPacket<SPacketRegister>{

    public ProcessSPacketRegister(DClient client, SPacketRegister packet) {
        super(client, packet);
    }

    @Override
    public void process() {
        if (getPacket().success) {
            RegisterView.getInstance().close();
            try {
                if (getPacket().role == 0) {
                    GlobalClient.user = new Guest();
                }
                if (getPacket().role == 1) {
                    GlobalClient.user = new User(getPacket().username);                    
                } 
                if (getPacket().role == 2) {
                    GlobalClient.user = new Staff();
                }                
                new SimpleStage(new MenuView());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            RegisterView.getInstance().status.setText(getPacket().error);
        }
    }
    
}
