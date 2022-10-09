public class Main {
    public static void main(String[] args) {
        //     Variant 1
//     Реализуйте метод, который получая 3 числа int определяет,
//     есть ли среди них такое, которое равно сумме двух других.
        checkThree (2, 3, 4);
        checkThree (7, 3, 4);
        checkThree (3, 8, 5);
        checkThree (4, 4, 8);
        //     Variant 2
//    Представьте, Вы пишите программу  для расчета штрафов за превышение скорости.
//    В качестве исходных данных у вас: ограничение скорости на данном участке дороги и скорость,
//    с которой двигался автомобиль Таблица штрафов такая:
//    - превышение менее 10% от скоростного ограничения – не штрафуется
//    - 10% - менее 20%   от скоростного ограничения – 50 евро
//    - 20% - менее 30%   от скоростного ограничения – 150 евро
//    - от 30% и выше  - 500 евро плюс
//    Реализуйте программу, которая рассчитывает штраф и выводит соответствующее сообщение на экран.

        penaltyCalc(95, 90);
        penaltyCalc(105, 90);
        penaltyCalc(115, 90);
        penaltyCalc(120, 90);
    }
    public static void checkThree (int a, int b, int c) {
        if (a == (b + c)) {
            System.out.println(a+"="+b+"+"+c);
        } else if (b == (a + c)) {
            System.out.println(b+"="+a+"+"+c);
        } else if (c==(a+b)) {
            System.out.println(c+"="+a+"+"+b);
        } else {
            System.out.println("ни одно из чисел не равно сумме двух других");
        }
    }
    public static void penaltyCalc(double speed, double limit){
        if (speed < limit * 1.1) {
            System.out.println("штрафа нет");
        } else if ((speed >= limit * 1.1) && (speed < limit * 1.2)) {
            System.out.println("штраф: 50 евро");
        } else if ((speed >= limit * 1.2) && (speed < limit * 1.3)) {
            System.out.println("штраф: 150 евро");
        } else {
            System.out.println("штраф: 500 евро");
        }
    }
}