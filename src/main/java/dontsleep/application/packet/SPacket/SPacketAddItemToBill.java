package dontsleep.application.packet.SPacket;

import dontsleep404.library.packet.Packet;

public class SPacketAddItemToBill extends Packet{
    public String tableID;
    public int taskID;
    public String itemName;
    public int quantity;
    public int price;
    public String status;
}
