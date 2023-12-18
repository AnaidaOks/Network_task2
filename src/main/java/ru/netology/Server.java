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
            System.out.println("Get new connection!");
            final String conName = reader.readLine();

            System.out.println(String.format("Hi %s, your port is %d", conName, clientSocket.getPort()));
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}