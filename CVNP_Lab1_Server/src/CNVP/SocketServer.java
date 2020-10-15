package CNVP;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServer {
    public  static ServerSocket CreateSocketServer () throws IOException {
        ServerSocket server;
        server = new ServerSocket(5544);
        System.out.println("Server is running");
        return server;
    }

    public static void SendReceive(ServerSocket server) throws IOException {

        Socket socket = server.accept();
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String input = in.readLine();
            String word = in.readLine();
            System.out.println(word);

            out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
            out.flush(); // выталкиваем все из буфера

        } finally { // в любом случае сокет будет закрыт
            socket.close();
            // потоки тоже хорошо бы закрыть
            in.close();
            out.close();
        }
    }
}


//ctrl+alt+L
//
}
