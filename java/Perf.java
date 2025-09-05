class Perf {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        String word = "";

        // Simulate some work with a loop
        for (int i = 0; i < 100000; i++) {
            word = word + String.valueOf(i);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println(word.length());
        System.out.println("Execution time in nanoseconds: " + duration);
    }
}