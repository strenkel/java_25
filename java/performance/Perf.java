/**
 * Java 25: 0.110s
 */
class Perf {
    public static void main(String[] args) {
        
        String word = "";

        for (int i = 0; i < 10000; i++) {
            word = word + String.valueOf(i);
        }

        System.out.println(word.length());
    }
}