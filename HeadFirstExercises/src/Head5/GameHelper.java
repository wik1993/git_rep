package Head5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

/**
 * Created by Family on 20.10.2016.
 */
public class GameHelper {
    public String getUserInput(String promp){
        String inputLine = null;
        System.out.println(promp + " ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();

            if (inputLine.length() == 0) return null;

        } catch (IOException e){
            System.out.println("IOExecption: " + e);
        }
        return inputLine;
    }
}
