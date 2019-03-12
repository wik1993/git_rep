package Head5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Family on 20.10.2016.
 */
public class GameHelper {
    public static void main(String[] args) {
        int numOfGuess = 0;
        GameHelper helper = new GameHelper();

        SimpleDotCom theDotCom = new SimpleDotCom();


        ArrayList <String> locations = new ArrayList<>();
        locations.add("2");
        locations.add("3");
        locations.add("4");
        theDotCom.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive == true){
            String guess = helper.getUserInput("enter a number");
            String result = theDotCom.checkYourself(guess);
            numOfGuess++;
            if (result.equals("Kill")){
                isAlive = false;
                System.out.println("You took " + numOfGuess + "guesses");
            }
        }
    }
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
