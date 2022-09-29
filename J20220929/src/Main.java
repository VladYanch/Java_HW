public class Main {
    public static void main(String[] args) {
        //     Variant 1
//        Необходимо написать метод, которая печатает все целые нечетные числа
//        в диапазоне  между num1 и num2.
//        Учтите, num1 может быть как меньше, так больше или равно  num2.
        printNotEven(19, 19);
        printNotEven(-3, 19);
        printNotEven(5, 19);
        System.out.println("  ");
        System.out.println("Variant 2");

        //     Variant 2
//        Необходимо написать метод, которая печатает все целые числа в диапазоне
//        между num1 и num2. Для каждого числа, которое делится на 2
//        выводить надпись «делиться на 2».
//        Для каждого числа, которое делится на 3 выводить надпись «делится на 3»
        printEvenHard(5, 19);
    }
    public static void printNotEven (int num1, int num2) {
        if ((num1 >= num2) || (num1 < 0)) {
            System.out.println("Out of range");
        } else {
            for (int i = num1 ; i < num2; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                    i++;
                }
            }
        }
    }

    //     Variant 2
    public static void printEvenHard (int num1, int num2) {
        if ((num1 >= num2) || (num1 < 0)) {
            System.out.println("Out of range");
        } else {
            for (int i = num1 ; i < num2; i++) {
                if (i % 2 == 0) {
                        System.out.println(i+" делиться на 2");
                }
                if (i % 3 == 0) {
                        System.out.println(i+" делиться на 3");
                }
            }
        }
    }
}