import java.sql.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    int pos = 0;
    T[] arr;

    public boolean hasNext() {
        return pos <arr.length;
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        return arr[pos++];
    }

    public ArrayIterator(T[] arr) {
        this.arr = arr;
    }

    public int find(T el) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el) return i;
        }
        return -1;
    }

    public void remove(int index) {
        T[] tmp = (T[]) new Object[arr.length - 1];
        if ( index >= arr.length) return;
//        for (int i = 0; i < index; i++) {
//            arrDop[i] = (T) arr[i];
//        }
//        for (int i = index; i < arr.length-1; i++) arrDop[i] = (T) arr[i+1];

        System.arraycopy(arr, 0, tmp, 0, arr.length-1);
        arr = tmp;
    }

    public void print() {
            int el = (int) next();
            System.out.print(el);
    }
}
