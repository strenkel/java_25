/**
 * Times from 'time java StringConcat':
 * 
 * Java 8:  12s
 * Java 17:  2s
 * Java 25:  2s
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