import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String sentence = "as soon as possible";
        System.out.println(sentence);
        getWordsWithCount(sentence);
        sentence = "Mama washing Rama - Rama washing Mama";
        System.out.println(sentence);
        getWordsWithCount(sentence);

        String str1, str2 = "";
        str1 = "stop";
        str2 = "post";
        System.out.println(checkStringsAnagram(str1, str2));

    }
//    1. Write a Java method to count the number of words in a string
//    Example: "as soon as possible" should return "as: 2, soon: 1, possible: 1"
    public static void getWordsWithCount(String sentence) {
        Map<String,Integer> map = new HashMap<>();
        String[] words = sentence.split(" ");

        for (String word: words) {
//            map.putIfAbsent(word, 0);
//            map.computeIfPresent(word, (key, value) -> value += 1);
            map.merge(word, 1, Integer::sum); //аналог двух предыдущих строк
            //map.merge(word, 1, (oldValue,newValue)-> oldValue+newValue) ); //полный вариант
            // аналог двух предыдущих строк
        }
        System.out.println(map.toString());
        //map.forEach((k, v) -> System.out.print(k + ": " + v + " "));
        // вывод на печать мапы
    }

//   2.  Write a Java method to check if two strings are anagrams of each other or not

    public static boolean checkStringsAnagram(String str1, String str2) {
        //Map<Character, Character> words = new HashMap<>();
        if (str1.length() != str2.length()) return false;
        char[] word1 = new char[str1.length()];
        char[] word2 = new char[str2.length()];
        str1.getChars(0, str1.length(), word1, 0);
        str2.getChars(0, str2.length(), word2, 0);
        Arrays.sort(word1);
        Arrays.sort(word2);
        if (String.valueOf(word1).equals(String.valueOf(word2))) return true;
        return false;
    }

//    public static boolean checkStringsAnagram(String word1, String word2) {
//        if (word1.length() != word2.length()) {
//            return false;
//        }
//
//        Map<Character, Integer> word1ByChars = new HashMap<>();
//        Map<Character, Integer> word2ByChars = new HashMap<>();
//        for (var i = 0; i < word2.length(); i++) {
//            char word1char = word1.charAt(i);
//            char word2char = word2.charAt(i);
//
//            word1ByChars.merge(word1char, 1, Integer::sum);
//            word2ByChars.merge(word2char, 1, Integer::sum);
//        }
//
//        return word1ByChars.equals(word2ByChars);
//    }

//        Это более интересный вариант

//        Map<Character, Integer> wordByChars = new HashMap<>();
//            for (var i = 0; i < word2.length(); i++) {
//            char word1char = word1.charAt(i);
//            char word2char = word2.charAt(i);
//
//            wordByChars.merge(word1char, 1, Integer::sum);
//            wordByChars.merge(word2char, -1, Integer::sum);
//        }
//
//            for (var count : wordByChars.values()) {
//            if (count != 0) {
//                return false;
//            }
//        }
//            return true;



//    Лучший вариант
//    return wordByChars.values().stream().allMatch(v -> v == 0);
//    }
}