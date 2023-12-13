package dontsleep.application.packet.SPacket.process;

import dontsleep.application.packet.SPacket.SPacketUpdateOrder;
import dontsleep.application.packet.process.ProcessPacket;
import dontsleep.application.view.MenuView;
import dontsleep404.library.DClient;

public class ProcessSPacketUpdateOrder extends ProcessPacket<SPacketUpdateOrder>{

    public ProcessSPacketUpdateOrder(DClient client, SPacketUpdateOrder packet) {
        super(client, packet);
    }

    @Override
    public void process() {
        if (MenuView.getInstance().cTabPane.billDetailTab != null) {
            MenuView.getInstance().cTabPane.billDetailTab.updateStatus(getPacket().taskID, getPacket().status.name());          
        }
    }
    
}
