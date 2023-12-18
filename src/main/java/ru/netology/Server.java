package ru.netology;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket mySocket = new ServerSocket(8080);
            Socket clientSocket = mySocket.accept();
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ){
            System.out.println("Hello!");
            writer.println("Write your name:");
            final String name = reader.readLine();
            System.out.println(String.format("Hi %s", name));
            writer.println("Are you child? (yes/no)");

            final String answer = reader.readLine();
            if("yes".equals(answer)) {
                System.out.println(String.format("Welcome to the kids area, %s%! Let's play!", name));
            } else {
                System.out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}