package SystemeCentrale;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SystemeCentrale {
    public static void main(String[]args){
        try {
            ServerSocket centralSoc = new ServerSocket(5000);
            System.out.println("The Server is active");
            Socket posteconSoc = centralSoc.accept();
            InputStream jRecieve = posteconSoc.getInputStream();
            OutputStream jSend = posteconSoc.getOutputStream();

            InputStreamReader jRecieveSr = new InputStreamReader(jRecieve);
            BufferedReader bReader = new BufferedReader(jRecieveSr);
            PrintStream ps = new PrintStream(jSend);
            String jString = bReader.readLine();
            System.out.println("The recieved messageis: \t" +jString);
            ps.print("\t" + jString + "\n recieved \n");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
