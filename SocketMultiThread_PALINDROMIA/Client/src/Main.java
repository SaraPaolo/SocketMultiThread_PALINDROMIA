import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(System.currentTimeMillis());
        try {
            boolean check = true;
            Socket clientSocket = new Socket("localhost", 5555);
            System.out.println("Server contattato");
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream()); //invio da client
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //ricezione da server
            String inputString;

            while (check == true) {
                System.out.println("INSERIRE LA STRINGA DA INVIARE");
                inputString = sc.nextLine();
                if (inputString.toLowerCase().equals("fine")) {
                    writer.println(inputString);
                    writer.flush();
                    System.out.println("RISPOSTA SERVER: " + reader.readLine());
                    check = false;
                    clientSocket.close();
                } else {
                    writer.println(inputString);
                    writer.flush();
                    System.out.println("RISPOSTA SERVER: " + reader.readLine());
                }
            }
        } catch (Exception e) {
            System.out.println("eccezione " + e.getMessage());
        }
    }
}