import java.util.HashSet;
import java.util.Set;

/**
 * Java 8:  12.0s
 * Java 17:  2.0s
 * Java 25:  2.0s
 */
class StringConcat {
    public static void main(String[] args) {
        
        String word = "";

        for (int i = 0; i < 100000; i++) {
            word = word + String.valueOf(i);
        }

        System.out.println(word.length());
    }
}