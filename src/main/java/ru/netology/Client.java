package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {
        try(Socket myClientSocket = new Socket("localhost",8080);
            PrintWriter writer = new PrintWriter(myClientSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream()))
        ){
            writer.println("Anna");
            System.out.println(reader.readLine());

           } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
