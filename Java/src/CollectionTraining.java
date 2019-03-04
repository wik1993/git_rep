import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CollectionTraining {
    public static void main(String[] args) {
        List peopleList = new ArrayList();
            peopleList.add("Ion");
            peopleList.add("Ion");
            peopleList.add("John");
            peopleList.add(null);
            peopleList.add(null);
        Set peopleSet = new HashSet();
        peopleSet.add("Ion");
        peopleSet.add("Ion");
        peopleSet.add("John");
        peopleSet.add(null);
        peopleSet.add(null);
        System.out.println("done");
    }
}
