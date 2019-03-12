package Head5;

import java.util.ArrayList;

/**
 * Created by Family on 20.10.2016.
 */
public class SimpleDotCom {

    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public String checkYourself(String useInput) {
        String result = "Miss";
        int index = locationCells.indexOf(useInput);
            if (index >= 0) {
                locationCells.remove(index);

                if (locationCells.isEmpty()) {
                    result = "kill";
                } else {
                    result = "hit";
                }
            }
        return result;
    }
}