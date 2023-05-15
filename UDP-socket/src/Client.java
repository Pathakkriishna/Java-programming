import java.awt.image.DataBuffer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client");
        DatagramSocket socket = new DatagramSocket(12345);
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data,data.length);


        //receive the message
        socket.receive(packet);
        String message = new String(packet.getData(),0,packet.getLength());
        System.out.println(message);
        socket.close();
    }
}
