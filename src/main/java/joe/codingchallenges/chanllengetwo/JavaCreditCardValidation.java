package joe.codingchallenges.chanllengetwo;

public class JavaCreditCardValidation {

    /*
    * second CHALLENGE Java Credit Card Validation
    Any credit card number should pass following test:
    1.   From the rightmost digit, we should double every second digit. If the double is greater than 9, then add the both digits so that final number is of single digit.
    2.   Now sum all the digits in the number, the unchanged numbers and the doubled numbers.
    3.   The final sum should be multiple of 10 or mod 10 of the number should be 0. If it’s not then its not a valid credit card number.
    Let’s check it with an example credit card number 12345678903555.
    Digits are : 1,2,3,4,5,6,7,8,9,0,3,5,5,5
    After doubling : 2,2,6,4,1,6,5,8,9,0,6,5,1,5
    Sum of digits : 2+2+6+4+1+6+5+8+9+0+6+5+1+5 = 60 = 6*10 and hence a valid credit card number.
    * */

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 3, 5, 5, 5};
        solution(input);
    }

    public static void solution(int[] oldArray) {
        int[] newArray = oldArray;
        for (int i = newArray.length - 2; i >= 0; i = i - 2) {
            int doubleNum = newArray[i] * 2;
            if (doubleNum > 9) {
                int sum = 0;
                String doubleString = String.valueOf(doubleNum);
                for (Character c : doubleString.toCharArray()) {
                    sum += Integer.parseInt(c.toString());
                }
                newArray[i] = sum;
            } else {
                newArray[i] = doubleNum;
            }
        }
        int sum = 0;
        for (int i = 0; i < newArray.length; i++) {
            sum = newArray[i] + oldArray[i];
        }
        if (sum % 5 == 0 && sum % 2 == 0) {
            System.out.println("valid credit card number");
        } else {
            System.out.println("invalid credit card number");
        }

    }


}
