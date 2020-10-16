package CNVP;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket server = SocketServer.createServerSocket();
            SocketServer.sendReceive(server);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
