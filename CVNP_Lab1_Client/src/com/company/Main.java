package com.company;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void displayOptions() {
        System.out.println("To get my brigade's number press 1");
        System.out.println("To get surnames of my brigade press 2");
        System.out.println("To exit press 4");
    }

    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int readUserInput() {
        displayOptions();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int result;
        while (!"1".equals(input) || (!"2".equals(input)) || (!"4".equals(input))) {
            displayOptions();
            input = in.nextLine();
        }
        return result = Integer.parseInt(input);
    }


    public static void main(String[] args) {

        System.out.println("Input server's IP adress ");
        Scanner in = new Scanner(System.in);
        String IPAdressOfServer = in.nextLine();
        int input = 0;
        Socket socketClient = null;
        try {
            try {
                while (true) {
                    input = readUserInput();
                    if (input == 4) {
                        break;
                    }
                    socketClient = SocketClient.CreateSocketForClient(IPAdressOfServer);
                    SocketClient.sendReceive(socketClient, input);

                }
            } finally {
                socketClient.close();
                System.out.println("client is closed");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
