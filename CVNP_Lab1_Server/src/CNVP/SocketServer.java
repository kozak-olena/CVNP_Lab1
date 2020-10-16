package CNVP;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class SocketServer {
    public static ServerSocket createServerSocket() throws IOException {
        ServerSocket server;
        server = new ServerSocket(5544, 50, InetAddress.getByName("192.168.0.104"));
        return server;
    }

    public static String getNumberOfMyBrigade() {
        Integer number = 2;
        String numberOfMyBrigades = number.toString();
        return numberOfMyBrigades;
    }

    public static void sendNumberOfMyBrigadesToClient(BufferedWriter writer) throws IOException {
        String numberOfMyBrigade = getNumberOfMyBrigade();
        writer.write(numberOfMyBrigade + "\n");
        writer.flush();
    }

    public static void sendSurnamesToClient(String inputData, BufferedWriter writer) throws IOException {
        Integer numberOfBrigade = Integer.parseInt(inputData);
        HashMap<Integer, String[]> brigadesAndSurnames = BrigadeRepository.get();
        String[] surnames = brigadesAndSurnames.get(numberOfBrigade);
        StringBuilder builder = new StringBuilder();
        for (String surname : surnames
        ) {
            builder.append(" " + surname + " ");
        }
        String surname = builder.toString();
        writer.write(surname + "\n");
        writer.flush();
    }

    public static void sendData(String inputData, BufferedWriter writer) throws IOException {
        System.out.println("you wrote: " + inputData);
        if (inputData.equals("1")) {
            sendNumberOfMyBrigadesToClient(writer);
        } else if (inputData.equals("2")) {
            sendSurnamesToClient(inputData, writer);
        }
    }

    public static void sendReceive(ServerSocket server) {

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("server is running");
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                try {
                    String inputData = reader.readLine();
                    if (inputData.equals("4")) {
                        break;
                    }
                    sendData(inputData, writer);

                } finally {
                    socket.close();
                    if (reader != null) {
                        reader.close();
                    }
                    if (writer != null) {
                        writer.close();
                    }
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}

