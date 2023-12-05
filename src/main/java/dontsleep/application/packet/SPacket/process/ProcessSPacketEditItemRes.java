package dontsleep.application.packet.SPacket.process;

import dontsleep.application.packet.SPacket.SPacketEditItemRes;
import dontsleep.application.packet.process.ProcessPacket;
import dontsleep.application.view.MenuView;
import dontsleep404.library.DClient;

public class ProcessSPacketEditItemRes extends ProcessPacket<SPacketEditItemRes> {

    public ProcessSPacketEditItemRes(DClient client, SPacketEditItemRes packet) {
        super(client, packet);
    }

    @Override
    public void process() {
        if (MenuView.getInstance() != null && MenuView.getInstance().cTabPane != null
                && MenuView.getInstance().cTabPane.editItemTab != null) {
            if (getPacket().success) {
                MenuView.getInstance().cTabPane.editItemTab.success(getPacket().message);
            }else{
                MenuView.getInstance().cTabPane.editItemTab.error(getPacket().message);
            }
        }
    }

}
