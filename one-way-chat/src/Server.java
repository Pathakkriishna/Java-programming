import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        System.out.println("Port 12345 is ready for onnection....");
        try {

            ServerSocket serversocket = new ServerSocket(12345);
            Socket socket = serversocket.accept();
            System.out.println("A new client is connected");

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream,true);
            System.out.println("Enter message : ");

            Scanner myObj = new Scanner(System.in);
            while(true) {

                String msg = myObj.nextLine();


                printWriter.println(msg);
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}