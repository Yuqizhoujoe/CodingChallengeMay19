package joe.codingchallenges.challengeone;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EscapeFromPrison {

    /*
    * Third CHALLENGE
    * Alfie was a prisoner in mythland. Though Alfie was a witty and intelligent guy.He was confident of escaping prison.After few days of observation,He figured out that the prison consists of (N×N
    ) cells.i.e The shape of prison was (N×N
    ) matrix. Few of the cells of the prison contained motion detectors.So Alfie planned that while escaping the prison he will avoid those cells containing motion detectors.Yet before executing his plan,Alfie wants to know the total number of unique possible paths which he can take to escape the prison.Initially Alfie is in cell
    (1,1
    ) while the exit of the cell (N,N
    ).
    note:->Alfie can move in all four direction{ if his current location is (X,Y
    ), he can move to either
    (X+1,Y
    ), (X−1,Y
    ), (X,Y+1
    ), (X,Y−1
    ) }. If the first cell (1,1
    ) and the last cell(N,N
    ) contain motion detectors,then Alfie can’t break out of the prison.
    INPUT:
    The first line contain number of test cases “T”.T test cases follow.The first line of each test case contains an integer “N”,(i.e the size of the (N×N
    ) matrix).The next n lines contain N space separated values either 0 or 1.“1” represents a cell containing motion detectors.
    OUTPUT:
    output total number of unique possible paths which he can take to escape the prison.
    Constraint:
    1≤T≤20
    1≤N≤20
    SAMPLE INPUT
* */

    public static void main(String[] args) throws IOException {
        int[][] matrix = readFile("src\\main\\resources\\grid-four.txt");
        int paths = solution(matrix);
        System.out.println(paths);
    }

    public static Integer solution(int[][] matrix) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            if (i == 0) {
                for (int j = 1; j < row.length; j++) {
                    if (row[j] == 0 && row[j-1] == 0) {
                        result[j] = 1;
                    } else if (row[j] == 1) {
                        result[j] = 0;
                    }
                }
            } else {
                if (row[0] == 0) {
                    result[0] = 1;
                } else {
                    result[0] = 0;
                }
                for (int j = 1; j < row.length; j++) {
                    if (row[j] == 1) {
                        result[j] = 0;
                    } else {
                        result[j] = result[j-1] + result[j];
                    }
                }
            }
        }
        return result[result.length-1];
    }

    public static int[][] readFile(String path) throws IOException {
        File file = new File(path);
        Scanner in = new Scanner(file);

        int rowNumber = 0;
        String[] string = in.nextLine().trim().split("\\s+");
        for (int i = 0; i < string.length; i++) {
            rowNumber++;
        }

        in.close();

        int[][] matrix = new int[rowNumber][rowNumber];
        in = new Scanner(file);

        int row = 0;
        while (in.hasNextLine()) {
            String[] column = in.nextLine().trim().split("\\s+");
            for (int i = 0; i < column.length; i++) {
                matrix[row][i] = Integer.parseInt(column[i]);
            }
            row++;
        }

        return matrix;

        /*for (int[] elem: matrix) {
            for (int item : elem) {
                System.out.print(item + " ");
            }
            System.out.println();
        }*/
    }

}
