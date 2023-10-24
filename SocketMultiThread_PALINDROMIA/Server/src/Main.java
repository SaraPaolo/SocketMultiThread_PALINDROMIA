import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server partito, in attesa");
            while (true) {
                new Thread(new Utility(server.accept())).start();
            }
        } catch (IOException e) {
            System.out.println("Eccezione: "+e.getMessage());
        }
    }
}