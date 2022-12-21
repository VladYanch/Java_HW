import java.util.*;
import java.util.function.BiFunction;

public class Main {

    public static class MergeSum implements BiFunction<Integer, Integer, Integer>{

        @Override
        public Integer apply(Integer int1, Integer int2) {
            return int1 + int2;
        }
    }
    public static void main(String[] args) {
        String text = """
                Не говори мне о толпе безумной
                Она иной раз вдохновение спугнёт
                Избавь меня от этой давки шумной
                Влекущей мощно в свой водоворот
                Нет тишины ищу я многодумный
                Лишь там поэту радость расцветёт
                Там только там божественною властью
                Любовь и дружба нас приводит к счастью""";

        String[] arr = text.split("[\s\n\t\r]+");
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int rand = 0;
            rand = (int) (Math.random() * arr.length);
            list.add(arr[rand].toLowerCase());
        }
        System.out.println(list);
        System.out.println(list.size());

        Map<String, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < list.size(); i++) { // Решение в лоб
//            map.merge(arr[i],count -> )
//            if (!map.containsKey(list.get(i))) {
//                map.put(list.get(i), 1);
//            } else {
//                int count = map.get(list.get(i));
//                map.put(list.get(i), ++count);
//            }

        for (String s : list) {
            map.merge(s, 1, Integer::sum); // Функциональное программирование, где sum это функция класса Integer
        }

        System.out.println(map);

        int sum = 0;


        // Анонимный класс
        BiFunction<Integer, Integer, Integer> mergeSum = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1 + n2;
            }
        };

        //
//        for (String s : list) {
//            map.merge(s, 1, mergeSum);
//        }

//        // Явный класс - обьявили наверху
//        MergeSum mSum = new MergeSum();
//        for (String s : list) {
//            map.merge(s, 1, mSum);
//        }

        for (Integer s : map.values()) {

            sum += s;
        }
        System.out.println(sum);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>(set);
        System.out.println(set);



        String res = "";
        int max = 0;
        list1.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println(list1);
        System.out.println(list1.get(0));




//        Map<String, Integer> wordCounts = new TreeMap<>();
//
//        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
//            int value = entry.getValue();
//
//            if (value > max) {
//                max = value;
//                res = entry.getKey();
//            }
//        }


        System.out.println(res);

    }
//    Из заданного массива слов заполнить ArrayList( 1000 ) случайными словами.
//    Подсчитать сколько каждое слово встречается раз в ArrayList
//    Вывести слово, которое повторяется чаще всего.
//    Если таких слов несколько - вывести наименьшее из них.
//
//    Массив слов получить из строки =
}