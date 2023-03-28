//Сделать по аналогии с примером с аннотацией  @MyName (см. код в репозитории)
//Имеется класс Student с полями name, surname, age. Создать аннотацию @StudentInfo
//и соответствующий инжектор через рефлексию, чтобы с их помощью иметь возможность
//инициализировать переменные типа Student.

public class Main {
    public static void main(String[] args) {
        School school = new School();
        System.out.println(school);
        Injector.inject(school);
        school.print();
    }
}