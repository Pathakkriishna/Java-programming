import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Port 12345 is ready for connection....");
        try {
            ServerSocket serversocket = new ServerSocket(12345);
            serversocket.accept();
            System.out.println("A new client is connected");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}