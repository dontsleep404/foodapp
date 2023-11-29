package dontsleep.application;

import dontsleep.application.model.User;
import dontsleep.application.packet.PacketManager;
import dontsleep404.library.DClient;

public class GlobalClient {

    public static User user = null;
    public static DClient client = null;

    public static boolean connect(){
        client = new DClient("localhost", 25565);
        client.setEventHandle(new PacketManager());
        if(client.connect()){
            client.listen();
            return true;
        }
        return false;
    }

}
