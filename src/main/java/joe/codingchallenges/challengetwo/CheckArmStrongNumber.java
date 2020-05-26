package joe.codingchallenges.challengetwo;

public class CheckArmStrongNumber {


    public static void main(String[] args) {
        System.out.println(checkArmStrong(6));

    }

    public static boolean checkArmStrong(int number) {

        String str = String.valueOf(number);
        char[] array = str.toCharArray();

        double sum = 0;
        double lastNumber = Integer.parseInt(String.valueOf(array[array.length-1]));
        double multiply = array.length;
        for (char ch : array) {
            sum += Integer.parseInt(String.valueOf(ch));
        }
        if (sum == lastNumber * multiply) {
            return true;
        }

        return false;
    }

}
