import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        //все очень странно работает - задача выполнена неполностью


        try(BufferedReader readFile = new BufferedReader(new FileReader("input_business_card.txt"))) {
//            try(BufferedReader readFile = new BufferedReader(new FileReader("input_business_card.txt"));
//            BufferedWriter writeFile = new BufferedWriter(new FileWriter("output_business_card.txt"))) {

            List<Contact> contacts = new ArrayList<>();
            List<String> list = readFile.lines().toList();

            String line = "";
            for (int i = 0; i < list.size(); i++) {
                line = list.get(i);
                if (line.length() == 0) continue;
                if (line.indexOf("FN:")!=0) continue;
                String[] name = line.substring(line.indexOf("FN:") + 3).split(" ", 2);

                i++;
                line = list.get(i);
                String tel = ":+";
                Pattern pTel = Pattern.compile(tel);
                Matcher mTel = pTel.matcher(line);
                mTel.find();
                tel = line.substring(mTel.start()+1);

                i++;
                line = list.get(i);
                String email = "INTERNET:";
                Pattern pEmail = Pattern.compile(email);
                Matcher mEmail = pEmail.matcher(line);
                mEmail.find();
                email = line.substring(mEmail.end());

                String address = "STREET:";
                i++;
                line = list.get(i);
                if (line.indexOf("END:VCARD") == 0) {
                    address = "";
                    contacts.add(new Contact(name[0],name[1],tel,email,address));
                    continue;
                }

                Pattern pAddress = Pattern.compile(address);
                Matcher mAddress = pAddress.matcher(line);
                mAddress.find();
                address = line.substring(mAddress.end());

                contacts.add(new Contact(name[0],name[1],tel,email,address));

                while (line.indexOf("END:VCARD") != 0) {
                    i++;
                    line = list.get(i);
//                    System.out.println(i);
                }


                }
//            System.out.println(contacts.sort((x,y)->x.getTel().compareTo(y.getTel())));
            System.out.println(contacts);

        }

            catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}

//        распарсить файл inputbuisnesscard.txt
//        создать класс типа Contact и сопутствующие классы при необходимости
//        заполнить обьекты типа Contact данными из файла(
//        Имя \ Фамилия
//        Телефон
//        Адрес
//        Емэйл
//        Вебсайт
//        )
//        вывести в консоль список контактов отсортированных по № телефона