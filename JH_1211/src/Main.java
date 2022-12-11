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
            map.putIfAbsent(word, 0);
            map.computeIfPresent(word, (key, value) -> value += 1);
        }
        System.out.println(map.toString());
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
}