package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        try(Socket myClientSocket = new Socket("netology.homework",8080);
            PrintWriter writer = new PrintWriter(myClientSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream()))
        ){
            System.out.println(reader.readLine());
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            writer.println(name);

            System.out.println(reader.readLine());
            scanner = new Scanner(System.in);
            String childOrNot = scanner.nextLine();
            writer.println(childOrNot);

           } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
