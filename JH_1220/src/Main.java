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

//        it.remove(5); //Remove так и не получился
        while (it.hasNext()) {
            int el = it.next();
            System.out.println(el);
        }

        String[] str = {"a","b","c","d","e"};
        Iterator<String> strIt = new ArrayIterator<>(str);
//        while (strIt.hasNext()) {
//            String el = strIt.next();
//            System.out.println(el);
//        }
    }
}