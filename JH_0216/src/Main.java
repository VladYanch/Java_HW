import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input login: ");
//        String login = scanner.next();
//        System.out.print("Input password: ");
//        String password = scanner.next();
//        System.out.print("Confirm password: ");
//        String confirmPassword = scanner.next();

// false
        String login = "log1";
        String        password = "12345678901234567890";
        String confirmPassword = "12345678901234567890";

//true
//        String login = "log_1";
//        String        password = "pass_1";
//        String confirmPassword = "pass_1";



        System.out.println("Validation is : " + loginValidation(login,password,confirmPassword));
    }
    public static Boolean loginValidation(String login, String password, String confirmPassword) {
        Pattern pattern = Pattern.compile("\\W");
        Matcher wrong = pattern.matcher(login);
        if ((login.length() >= 20) || wrong.find()) try {
            throw new WrongLoginException("Incorrect login");
        } catch (WrongLoginException e) {
            System.out.println("Incorrect login");
            return false;
        }
        wrong = pattern.matcher(password);
        if ((password.length() >= 20) ||
                wrong.find() ||
                        !password.equals(confirmPassword)) try {
            throw new WrongPasswordException("Incorrect password");
        } catch (WrongPasswordException e) {
            System.out.println("Incorrect password");
            return false;
        }
        return true;
    }
}


//    Exceptions. Проверка логина и пароля
//    Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
//    Login должен содержать только латинские буквы, цифры и знак подчеркивания.
//    Длина login должна быть меньше 20 символов.
//    Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
//    Password должен содержать только латинские буквы, цифры и знак подчеркивания.
//    Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
//    Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//    WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию,
//    второй принимает сообщение исключения и передает его в конструктор класса Exception.
//    Обработка исключений проводится внутри метода.
//    Используем multi-catch block. Метод возвращает true, если значения верны или false в другом случае.