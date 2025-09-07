import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * Java 8:  12.0s
 * Java 17:  2.0s
 * Java 25:  2.0s
 */
class Hash {

    public static void main(String[] args) {
        
        String word = "";
        int sum = 0;

        for (int i = 0; i < 100000; i++) {
            var x = String.valueOf(i);
            word = word + x;
        }

        for (int i = 0; i < 100000; i++) {
            var x = String.valueOf(i);
            int index = word.indexOf(x);
            sum = sum + index;
        }


        System.out.println(word.length() + " - " + sum);
    }
}