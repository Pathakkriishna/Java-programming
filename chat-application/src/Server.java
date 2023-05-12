import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Port 12345 is ready for connection.... ");
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket socket = serverSocket.accept();
            System.out.println("connected");

            //asking the input from user
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            //taking the inpput from the socket
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //to send the message i need a pen
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out  = new PrintWriter(outputStream);

            String sendingMessage, receivingMessage;
            while(true){
                sendingMessage = userInput.readLine();
                out.println(sendingMessage);
                out.flush();
                receivingMessage = socketInput.readLine();
                System.out.println("Dalle Dai: " + receivingMessage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}