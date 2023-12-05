package dontsleep.application.packet.SPacket.process;

import dontsleep.application.packet.SPacket.SPacketAddItemRes;
import dontsleep.application.packet.process.ProcessPacket;
import dontsleep.application.view.MenuView;
import dontsleep404.library.DClient;

public class ProcessSPacketAddItemRes extends ProcessPacket<SPacketAddItemRes> {

    public ProcessSPacketAddItemRes(DClient client, SPacketAddItemRes packet) {
        super(client, packet);
    }

    @Override
    public void process() {
        if (MenuView.getInstance() != null && MenuView.getInstance().cTabPane != null
                && MenuView.getInstance().cTabPane.addItemTab != null) {
            if (getPacket().success) {
                MenuView.getInstance().cTabPane.addItemTab.success("Add success");
            }else{
                MenuView.getInstance().cTabPane.addItemTab.error(getPacket().message);
            }
        }
    }

}
