package dontsleep.application.packet.SPacket.process;

import dontsleep.application.GlobalClient;
import dontsleep.application.packet.SPacket.SPacketUpdateMenu;
import dontsleep.application.packet.process.ProcessPacket;
import dontsleep.application.view.MenuView;
import dontsleep404.library.DClient;

public class ProcessSPacketUpdateMenu extends ProcessPacket<SPacketUpdateMenu> {

    public ProcessSPacketUpdateMenu(DClient client, SPacketUpdateMenu packet) {
        super(client, packet);
    }

    @Override
    public void process() {
        GlobalClient.itemTypes = getPacket().itemTypes;
        GlobalClient.items = getPacket().items;
        if (MenuView.getInstance() != null && MenuView.getInstance().cTabPane != null) {
            try {
                if (MenuView.getInstance().cTabPane.orderTab != null) {
                    MenuView.getInstance().cTabPane.orderTab.updateTab();
                    MenuView.getInstance().cTabPane.orderTab.setCurrentItem(null);

                }
                if (MenuView.getInstance().cTabPane.addItemTab != null) {
                    MenuView.getInstance().cTabPane.addItemTab.updateComboBox();                    
                }
                if (MenuView.getInstance().cTabPane.editItemTab != null) {
                    MenuView.getInstance().cTabPane.editItemTab.updateComboBox();                
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
