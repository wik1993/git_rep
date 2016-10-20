package Head5;

/**
 * Created by Family on 20.10.2016.
 */
public class SimpleDotCom {

    int [] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs){
        locationCells = locs;
    }

    public String checkYourself(String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        String result = "Mimo";
        for (int cell : locationCells){
            if(guess == cell){
                result = "Popal";
                numOfHits++;
                break;
            }
        }
        if(numOfHits == locationCells.length){
            result = "Potopil";
        }
        System.out.println(result);
        return result;
    }
}
