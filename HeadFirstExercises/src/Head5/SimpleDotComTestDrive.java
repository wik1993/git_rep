package Head5;

/**
 * Created by Family on 20.10.2016.
 */
public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        int [] locations = {2,3,4};
        dot.setLocationCells(locations);
        String userGuess = "4";
        String result = dot.checkYourself(userGuess);
    }
}
