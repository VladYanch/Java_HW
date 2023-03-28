import java.lang.reflect.Field;

public class Injector {
    public static void inject(Object instance) {
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(StudentInfo.class)) {
                StudentInfo annotation = field.getAnnotation(StudentInfo.class);
                field.setAccessible(true); // should work on private fields
                try {
//                    if (field.getName().equals("name")) {field.set(instance, annotation.name());}
//                    else if (field.getName().equals("surname")) {field.set(instance, annotation.surname());}
//                    else if (field.getName().equals("age")) {field.set(instance, annotation.age());}
                    field.set(instance, new Student(annotation.name(),annotation.surname(),annotation.age()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}