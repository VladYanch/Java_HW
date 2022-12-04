public class Main {
    /*
    На основании созданного во время занятия связанного списка, создайте двунаправленный связанный список и реализуйте методы:
    - public boolean add(Type elem) {…}
    - public void add(int index, Type elem) {…}
    - public Type remove (int index) {…}
     */
    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.add(0, 0);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}