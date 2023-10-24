import java.io.*;
import java.net.Socket;
import java.nio.charset.CharsetEncoder;

public class Utility implements Runnable {
    private Socket client;


    public Utility(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            System.out.println("connessione ricevuta");
            boolean check = true;
            PrintWriter writer = new PrintWriter(client.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String inputString = "", outputString;

            while (check == true) {
                inputString = reader.readLine();
                System.out.println("messaggio ricevuto: " + inputString);
                try{
                    if (inputString.toLowerCase().equals("fine")) {
                        outputString = "SOCKET SERVER CHIUSA";
                        writer.println(outputString);
                        writer.flush();
                        check = false;
                        client.close();
                        return;
                    } else if (inputString.substring(0,11).equals("PALINDROMO ")) {
                        String [] s = inputString.split("PALINDROMO ");
                        int endIndex = s[1].length();
                        for (int i = 0; i < s[1].length(); i++) {
                            if(s[1].charAt(i) != s[1].charAt(endIndex-1)){
                                outputString = "SI PALINDROMIA";
                                writer.println(outputString);
                                writer.flush();
                            }else{
                                outputString = "NO PALINDROMIA";
                                writer.println(outputString);
                                writer.flush();
                            }
                        }
                    } else {
                        outputString = "ERRORE";
                        writer.println(outputString);
                        writer.flush();
                    }
                }catch (StringIndexOutOfBoundsException ex){
                    outputString = "ERRORE";
                    writer.println(outputString);
                    writer.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}