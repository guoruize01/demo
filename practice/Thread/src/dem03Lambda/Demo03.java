package dem03Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo03 {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("da",23),
                new Person("dsa",21),
                new Person("gg",88)
        };
//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });
        Arrays.sort(arr,(Person o1,Person o2)->{
            return o1.getAge()-o2.getAge();
        });
        for (Person person : arr) {
            System.out.println(person);
        }

    }
}
