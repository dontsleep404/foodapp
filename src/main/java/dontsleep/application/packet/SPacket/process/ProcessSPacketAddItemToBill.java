package dontsleep.application.packet.SPacket.process;

import dontsleep.application.GlobalClient;
import dontsleep.application.model.Task;
import dontsleep.application.packet.SPacket.SPacketAddItemToBill;
import dontsleep.application.packet.process.ProcessPacket;
import dontsleep404.library.DClient;

public class ProcessSPacketAddItemToBill extends ProcessPacket<SPacketAddItemToBill>{

    public ProcessSPacketAddItemToBill(DClient client, SPacketAddItemToBill packet) {
        super(client, packet);
    }

    @Override
    public void process() {
        Task task = new Task(getPacket().tableID, getPacket().taskID, getPacket().itemName, getPacket().quantity, getPacket().price, getPacket().status);
        GlobalClient.tasks.add(task);
    }
    
}
