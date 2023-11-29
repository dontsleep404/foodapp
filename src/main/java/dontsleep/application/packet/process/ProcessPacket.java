package dontsleep.application.packet.process;

import dontsleep404.library.DClient;
import dontsleep404.library.packet.Packet;
import javafx.application.Platform;

public abstract class ProcessPacket<T extends Packet> {
    private T packet;
    private DClient client;
    public ProcessPacket(DClient client, T packet) {
        this.packet = packet;
        this.client = client;
        Platform.runLater(this::process);
    }
    public abstract void process();
    public T getPacket() {
        return packet;
    }
    public DClient getClient() {
        return client;
    }
}
