package joe.codingchallenges.challengetwo;

import java.util.BitSet;

public class CountBits {

    public static void main(String[] args) {
        System.out.println(countBitsFromNumber(22));
    }

    public static int countBitsFromNumber(int number) {
        int count = 0;
        for (char bit : Integer.toBinaryString(number).toCharArray()) {
            if (bit == '1') {
                count++;
            }
        }
        return count;
    }

}
