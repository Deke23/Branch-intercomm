package PosteControle;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PosteControle{
    public static void main(String[]args) {
        try {
            Socket posteSoc = new Socket("127.0.0.1", 5000);
            InputStream jRecieve = posteSoc.getInputStream();
            InputStreamReader jRecieveSr = new InputStreamReader(jRecieve);
            BufferedReader bReader = new BufferedReader(jRecieveSr);

            OutputStream jSend = posteSoc.getOutputStream();
            PrintStream ps = new PrintStream(jSend);
            System.out.println("The forwarded message from JSON is:");
            Scanner Sc = new Scanner(System.in);
            String jString = Sc.nextLine();
            ps.print("\t" + jString +"\t");
            // int messagerecu = in.read();
            // System.out.println("le message envoyer au serveur est: "+msg);
            System.out.println("le serveur repond: "+ "\n" +bReader.readLine());
    
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}