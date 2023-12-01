package dontsleep.application.packet.SPacket.process;

import dontsleep.application.GlobalClient;
import dontsleep.application.packet.SPacket.SPacketInit;
import dontsleep.application.packet.process.ProcessPacket;
import dontsleep404.library.DClient;

public class ProcessSPacketInit extends ProcessPacket<SPacketInit>{

    public ProcessSPacketInit(DClient client, SPacketInit packet) {
        super(client, packet);
    }

    @Override
    public void process() {
        GlobalClient.initData = true;
        GlobalClient.itemTypes = getPacket().itemTypes;
        GlobalClient.items = getPacket().items;
    }
    
}
