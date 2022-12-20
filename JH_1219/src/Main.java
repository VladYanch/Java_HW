import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<String> testList = new ArrayList<>();
        testList.add("A");
        testList.add("B");
        testList.add("C");
        testList.add("D");

        for (String el : testList) {
            System.out.println(el);
        }
        System.out.println(" ----------------------- ");
        for (int i = 0; i < testList.size(); i++) {
            System.out.println(testList.get(i));
        }
        System.out.println(" --------------------- ");

        Iterator<String> it = testList.iterator();

        while (it.hasNext()) {
            String el = it.next();
            System.out.println(el);
        }

        System.out.println(" ------------------------- ");

        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            intList.add(i);
        }
        for (Integer el : intList) {
            System.out.print(el + " ");
        }
        System.out.println("\n -------------------- \n ");
    /*     for ( Integer el : intList  ) {
            if ( el %2 != 0 ) {
                intList.remove( el );
            }
        }

        for ( int i = 0; i < intList.size(); i++ ) {
            if ( intList.get(i) % 2 != 0 ) {
                intList.remove( i );
            }
        }
*/

        Iterator<Integer> it1 = intList.iterator();
        while (it1.hasNext()) {
            int el = it1.next();
            if (el % 2 != 0) {
                it1.remove();
            }
        }
    }



}