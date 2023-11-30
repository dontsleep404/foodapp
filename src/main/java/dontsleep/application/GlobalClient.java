package dontsleep.application;

import dontsleep.application.model.user.Guest;
import dontsleep.application.packet.PacketManager;
import dontsleep404.library.DClient;

public class GlobalClient {

    public static Guest user = null;
    public static DClient client = null;

    public static boolean connect(){
        if (client != null) {
            client.disconnect();            
        }
        user = null;
        client = new DClient("localhost", 25565);
        client.setEventHandle(new PacketManager());
        if(client.connect()){
            client.listen();
            return true;
        }
        return false;
    }

}
