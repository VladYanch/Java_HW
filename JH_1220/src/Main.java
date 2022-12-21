import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr= {1,2,3,4,5,6,7,8,9};
        Iterator<Integer> it = new ArrayIterator<Integer>(arr);
        while (it.hasNext()) {
            int el = it.next();
            System.out.println(el);
        }
//        ((ArrayIterator<Integer>) it).print();

        System.out.println("----------------------");

        int sim = 5;

        System.out.println("Символ " + sim + " найден в позиции: "+((ArrayIterator<Integer>) it).find(sim));
//        System.out.println("");

        System.out.println("----------------------");

        ArrayIterator<Integer> it1 = new ArrayIterator<Integer>(arr);
        it1.next();
        it1.next();
        it1.next();
        it1.next();
        it1.remove();
//        while (it.hasNext()) {
//            int el = it.next();
//            System.out.println(el);
//        }
        System.out.println(Arrays.toString(arr));
        it1.remove();
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        System.out.println(it1.size());



        String[] str = {"a","b","c","d","e"};
        Iterator<String> strIt = new ArrayIterator<>(str);
//        while (strIt.hasNext()) {
//            String el = strIt.next();
//            System.out.println(el);
//        }
    }
}