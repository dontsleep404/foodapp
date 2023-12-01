package dontsleep.application;

import java.util.ArrayList;

import dontsleep.application.model.Item;
import dontsleep.application.model.ItemType;
import dontsleep.application.model.user.Guest;
import dontsleep.application.packet.PacketManager;
import dontsleep.application.packet.CPacket.CPacketInit;
import dontsleep404.library.DClient;

public class GlobalClient {

    public static Guest user = null;
    public static DClient client = null;

    public static ArrayList<ItemType> itemTypes = new ArrayList<>();
    public static ArrayList<Item> items = new ArrayList<>();
    
    public static boolean initData = false;
    public static boolean connect(){
        if (client != null) {
            client.disconnect();            
        }
        user = null;
        client = new DClient("localhost", 25565);
        client.setEventHandle(new PacketManager());
        if(client.connect()){
            client.listen();

            if (!initData) {
                client.sendPacket(new CPacketInit());
            }
            return true;
        }
        return false;
    }

}
