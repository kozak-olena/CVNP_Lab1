package com.company;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    static int port = 5544;

    public static Socket CreateSocketForClient(String IPAdressOfServer) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", port);
        if (clientSocket.isConnected()) {
            System.out.println("Connected to server");
        }
        return clientSocket;
    }

    public static void sendReceive(Socket clientSocket, Integer input) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            try {
                InputStreamReader streamReader = new InputStreamReader(clientSocket.getInputStream());
                OutputStreamWriter streamWriter = new OutputStreamWriter(clientSocket.getOutputStream());
                writer = new BufferedWriter(streamWriter);
                reader = new BufferedReader(streamReader);

                String dataToSend = input.toString();
                writer.write(dataToSend + "\n");   //send
                writer.flush();
                streamWriter.flush();

                String serverMassage = reader.readLine();
                System.out.println("number of my brigade: " + serverMassage);

            } finally {
                reader.close();
                writer.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
