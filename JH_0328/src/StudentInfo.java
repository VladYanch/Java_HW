import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


//@Retention(value = RetentionPolicy.RUNTIME)
//@Target(value = {METHOD, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {METHOD, FIELD, TYPE})
@interface StudentInfo {
    String name();
    String surname();
    int age();
}
