import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            //asking the input from user
            BufferedReader userInputBuffer = new BufferedReader(new InputStreamReader(System.in));

            //taking stata from socket buffer
            BufferedReader socketBuffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //to send the message i need a pen
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out  = new PrintWriter(outputStream);

            String sendingMessage, receivingMessage;
            while(true){
                receivingMessage = socketBuffer.readLine();
                System.out.println("Pathak Dai: " + receivingMessage);
                sendingMessage = userInputBuffer.readLine();
                out.println(sendingMessage);
                out.flush();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
