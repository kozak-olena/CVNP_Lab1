package com.company;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    static int port = 5544;

    public static Socket CreateSocketForClient(String IPAdressOfServer) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", port);
        return clientSocket;
    }

    public static void Receive(Socket clientSocket) {
        try {
            InputStreamReader streamReader = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String inputData = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String DataToSend(int input) {
        String dataToSend = null;
        if (input == 1) {
            dataToSend = "get my brigade's number";
        } else if (input == 2) {
            dataToSend = "get surnames of my brigade";
        } else if (input == 3) {
            dataToSend = "get surnames by brigade's ID";

        } else{

        }

            return dataToSend;
    }

    public static void Send(Socket clientSocket) throws IOException {
        OutputStreamWriter streamWriter = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedWriter writer = new BufferedWriter(streamWriter);
    }

}
