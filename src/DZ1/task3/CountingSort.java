package DZ1.task3;

import java.util.Map;
import java.util.TreeMap;

public class CountingSort {


        public static void countLetters(String input) {

            String lowerCaseInput = input.toLowerCase();

            Map<Character, Integer> letterCountMap = new TreeMap<>();

            for (char ch : lowerCaseInput.toCharArray()) {

                if (Character.isLetter(ch)) {

                    letterCountMap.put(ch, letterCountMap.getOrDefault(ch, 0)+1 );
                }
            }

            for (Map.Entry<Character, Integer> entry : letterCountMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

    public static void main(String[] args) {
        String text = "Hello World";
        countLetters(text);
    }
}
