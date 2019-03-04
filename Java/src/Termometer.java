import java.util.Arrays;

public class Termometer {
    public static void main(String[] args) {
        int[] temp = new int[]{4, 2, -1, 6, -6, 3, -5, -8};
        int a = getLowestTemp(temp);
        System.out.println(a);
    }

    public static int getLowestTemp(int[] arr) {
        int[] positive = new int[4];
        int[] negative = new int[4];
        int min = 0;
        int incPos = 0;
        int incNeg = 0;
        for (int i : arr) {
            if (i > 0) {
                positive[incPos] = i;
                incPos++;
            } else {
                negative[incNeg] = i;
                incNeg++;
            }
        }
        Arrays.sort(positive);
        Arrays.sort(negative);
        int minPositive = positive[0];
        int minNegative = negative[negative.length - 1];

        if (minPositive <= minNegative * -1) {
            min = minPositive;
        } else {
            min = minNegative;
        }
        return min;
    }
}
