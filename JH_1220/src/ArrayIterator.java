import java.sql.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    int pos = 0;
    T[] arr;

    int size;

    public boolean hasNext() {
        return pos <arr.length;
    }

    public int size() {
        size = arr.length;
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i] == null) {
                size--;
            }
        }
        return size;
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

    public void remove() {
//        T[] tmp = (T[]) new Object[arr.length - 1];
//        if ( index >= arr.length) return;
//        int size =
        for (int i = pos; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1]=null;

//        System.out.println("");
//        arr[]
//        for (int i = index; i < arr.length-1; i++) arrDop[i] = (T) arr[i+1];

//        System.arraycopy(arr, , tmp, 0, arr.length-1);
//        arr = tmp;
    }

    public void print() {
            int el = (int) next();

            System.out.print(el);
    }

}
