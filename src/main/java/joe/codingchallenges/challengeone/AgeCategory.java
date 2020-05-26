package joe.codingchallenges.challengeone;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AgeCategory {

    /**
     * 4. CHALLENGE DESCRIPTION:
     * You're responsible for providing a demographic report for your local school district based on age.
     * To do this, you're going determine which 'category' each person fits into based on their age.
     * The person's age will determine which category they should be in:
     * If they're from 0 to 2 the child should be with parents print : 'Still in Mama's arms'
     * If they're 3 or 4 and should be in preschool print : 'Preschool Maniac'
     * If they're from 5 to 11 and should be in elementary school print : 'Elementary school'
     * From 12 to 14: 'Middle school'
     * From 15 to 18: 'High school'
     * From 19 to 22: 'College'
     * From 23 to 65: 'Working for the man'
     * From 66 to 100: 'The Golden Years'
     * If the age of the person less than 0 or more than 100 - it might be an alien - print: "This program is for humans"
     * <p>
     * INPUT SAMPLE:
     * Your program should accept as its first argument a path to a filename. Each line of input contains one
     * integer - age of the person:
     * 0
     * 19
     * <p>
     * OUTPUT SAMPLE:
     * For each line of input print out where the person is:
     * Still in Mama's arms
     * College
     */

    public static void main(String[] args) throws Exception {
        for (int item : readFile()) {
            System.out.println(checkAge(item));
        }
    }

    public static int[] readFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("src\\main\\resources\\age.txt"));
        List<String> dataString = lines.collect(Collectors.toList());
        int[] data = new int[dataString.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(dataString.get(i));
        }
        return data;
    }

    public static String checkAge(int age) throws Exception {
        String result = "";
        if (age >= 0 && age <= 2) {
            result = "Still in Mama's arms";
        } else if (age >= 3 && age <= 4) {
            result = "Preschool Maniac";
        } else if (age >= 5 && age <= 11) {
            result = "Elementary school";
        } else if (age >= 12 && age <= 14) {
            result = "Middle school";
        } else if (age >= 15 && age <= 18) {
            result = "High school";
        } else if (age >= 19 && age <= 22) {
            result = "college";
        } else if (age >= 23 && age <= 65) {
            result = "Working for the man";
        } else if (age >= 66 && age <= 100) {
            result = "The Golden Years";
        } else {
            throw new Exception(age + " is not acceptable....");
        }
        return result;
    }

}
