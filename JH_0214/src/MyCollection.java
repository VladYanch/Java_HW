import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCollection <T> {
    public java.lang.System System;
    private T element;
    private List<T> list = new ArrayList<>();
//    int size;
    private int limit = 3;

    public void addElement(T element) {
        list.add(element);
        //this.element = element;
    }

    public MyCollection() {
        if (list.size() < limit) {
//        if (size < limit) {
//            addElement(element);
//            this.element = element;
            this.list.add(element);
        }
    }

    @Override
//    public void printMy() {
//        list.forEach(x-> System.out.println((String) x));
//    }

    public void printMy(List<T> list) {
        list.forEach(x-> System.out.println((String) x));
    }
}
