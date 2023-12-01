package dontsleep.application.packet;

import java.util.ArrayList;

import dontsleep.application.packet.CPacket.*;
import dontsleep.application.packet.SPacket.*;
import dontsleep404.library.DClient;
import dontsleep404.library.event.EventHandle;
import dontsleep404.library.event.EventPacket;
import dontsleep404.library.packet.Packet;

public class PacketManager extends EventHandle{
  
    public PacketManager() {
        super(new ArrayList<Class<? extends Packet>>(){
            {
                add(CPacketLogin.class);
                add(SPacketLogin.class);
                add(CPacketInit.class);
                add(SPacketInit.class);

            }
        });
    }

    @Override
    public void onConnect(EventPacket arg0) {
        System.out.println(arg0.getClient().hashCode() + " connected");
    }

    @Override
    public void onDisconnect(EventPacket arg0) {
        System.out.println(arg0.getClient().hashCode() + " disconnected");
    }

    @Override
    public void onPacketReceived(DClient arg0, Packet arg1) {
        System.out.println(arg0.hashCode() + " received " + arg1);
        String proc = arg1.getClass().getPackageName() + ".process.Process" + arg1.getClass().getSimpleName();
        try{
            Class<?> c = Class.forName(proc);
            c.getConstructor(DClient.class, arg1.getClass()).newInstance(arg0, arg1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}