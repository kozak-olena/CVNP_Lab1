package com.company;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    static int port = 5544;

    public static Socket createSocketForClient(String ipAdressOfServer) throws IOException {
        Socket clientSocket = new Socket(ipAdressOfServer, port);
        if (clientSocket.isConnected()) {
            System.out.println("Connected to server");
        }
        return clientSocket;
    }

    public static void sendDataToServer(Integer input, BufferedWriter writer) throws IOException {
        String dataToSend = input.toString();
        writer.write(dataToSend + "\n");   //send
        writer.flush();
    }

    public static void sendReceive(Socket clientSocket, Integer input) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            try {
                writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                sendDataToServer(input, writer);
                String serverMassage = reader.readLine();
                System.out.println("number of my brigade: " + serverMassage);
            } finally {
                if (reader != null) {
                    reader.close();
                } else {
                    System.out.println("exception");
                }
                if (writer != null) writer.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
