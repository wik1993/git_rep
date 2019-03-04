import java.util.Arrays;

public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {
        String[] res = new String[array1.length];
        int i = 0;
        for (String x : array1) {
            for (String y : array2) {
                if (!Arrays.asList(res).contains(x) && y.contains(x)) {
                    res[i] = x;
                }
            }
            i++;
        }
        Arrays.sort(res);
        return res;
    }

    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    public static int snail(int column, int day, int night) {
        return 1 + (column - day) / (day - night);  // your code here
    }

    public static void main(String[] args) {
        String[] par1 = {"live", "arp", "strong"};
        String[] par2 = {"lively", "alive", "harp", "sharp", "armstrong"};
        String[] res = inArray(par1, par2);
        for (String x : res) {
            System.out.println(x);
        }
        isSquare(5);
//        System.out.println(snail(3, 2, 1));
        System.out.println(snail(10, 3, 1));
        System.out.println(snail(10, 3, 2));
        System.out.println(snail(100, 20, 5));

    }
}
