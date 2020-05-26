package joe.codingchallenges.challengetwo;

import java.util.*;
import java.util.stream.Collectors;

public class CalculateBeautyOfString {

    public static void main(String[] args) {
        String input = "Ignore punctuation, please :)";
        System.out.println(calculateBeauty(input));
    }

    public static int calculateBeauty(String input) {
        Map<Character, Integer> map = new HashMap<>();

        String noWhiteSpace = input.toLowerCase().replaceAll("[^a-zA-Z]", "");

        char[] array = noWhiteSpace.toCharArray();
        for (char ch: array) {
            int count = 0;
            if (!map.containsKey(ch)) {
                map.put(ch, count+1);
            } else {
                map.put(ch, map.get(ch)+1);
            }
        }

//        Map<Character, Integer> sortedMap = map.entrySet()
//                .stream()
//                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//                .collect(Collectors.toMap(
//                        e -> e.getKey(),
//                        e -> e.getValue(),
//                        (e1, e2) -> e1,
//                        LinkedHashMap::new
//                ));

        return assignBeauty(map);
    }

    public static int assignBeauty(Map map) {
        Collection<Integer> values = map.values();
        List<Integer> result = values.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int max = 26;
        int sum = 0;
        for (Integer number : result) {
            sum += number * max;
            max--;
        }
        return sum;
    }



}
