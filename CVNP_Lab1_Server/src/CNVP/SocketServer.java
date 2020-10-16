package CNVP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class SocketServer {
    public static ServerSocket createServerSocket() throws IOException {
        ServerSocket server;
        server = new ServerSocket(5544);
        return server;
    }

    public static void operation(String inputData, BufferedWriter writer) throws IOException {
        HashMap<Integer, String[]> brigadesAndSurnames = BrigadeRepository.get();

        System.out.println("you wrote: " + inputData);
        if (inputData.equals("1")) {
            Integer numberOfMyBrigade = 2;
            numberOfMyBrigade.toString();
            writer.write(numberOfMyBrigade + "\n");
            writer.flush();
        } else if (inputData.equals("2")) {
            Integer numberOfBrigade = Integer.parseInt(inputData);
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

    }

    public static void sendReceive(ServerSocket server) throws IOException {


        while (true) {
            Socket socket = server.accept();
            System.out.println("server is running");
            BufferedReader reader = null;
            BufferedWriter writer = null;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String inputData = reader.readLine();
                operation(inputData, writer);

            } finally { // в любом случае сокет будет закрыт
                socket.close();
                // потоки тоже хорошо бы закрыть
                reader.close();
                writer.close();
            }
        }
    }
}

