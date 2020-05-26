package joe.codingchallenges.challengetwo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class JollyJumper {

    public static void main(String[] args) throws IOException {

        String path = "src\\main\\resources\\jullyjumper.txt";
        readFile(path);

    }

    public static boolean jollyJmuper(int[] input) {
        LinkedList<Integer> list = new LinkedList<>();
        int difference;
        for (int i = 0; i < input.length-1; i++) {

            difference = Math.abs(input[i] - input[i+1]);

            if (difference == 0 || difference > input.length-1 || list.contains(difference)) {
                return false;
            }

            list.addLast(difference);
        }

        return true;

    }

    public static void readFile(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String data;
        int[] input;
        while ((data = reader.readLine()) != null) {
            input = new int[data.split(" ").length];
            int index = 0;
            for (String elem: data.split(" ")) {
                input[index] = Integer.parseInt(elem);
                index++;
            }
            System.out.println(jollyJmuper(input));
        }
    }


    public static boolean isJolly(int[] input) {

        int length = input.length;

        boolean[] diffSet = new boolean[length];

        for (int i = 0; i < length - 1; i++) {

            int d = Math.abs(input[i] - input[i+1]); // d=3

            if (d == 0 || d > length - 1 || diffSet[d] == true) {
                return false;
            }

            diffSet[d] = true;

        }

        return true;
    }

}
