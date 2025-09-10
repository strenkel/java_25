/**
 * Scoped Values (JEP 506).
 */

private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
private static ScopedValue<Integer> scopedValue = ScopedValue.newInstance();

void main() {
    
    IO.println("ThreadLocal in main: " + threadLocal.get());
    IO.println("ScopedValue in main: " + scopedValue.isBound());

    Thread.startVirtualThread(() -> {
        threadLocal.set(1);
        ScopedValue.where(scopedValue, 1).run(() -> {
            for (int i = 0; i < 2; i++) {
                print("1");
                wait(10);
            }
        });
    });

    Thread.startVirtualThread(() -> {
        threadLocal.set(2);     
        ScopedValue.where(scopedValue, 2).run(() -> {
            for (int i = 0; i < 2; i++) {
                print("2");
                wait(10);
            }
        });
    });

    wait(1000);

    IO.println("ThreadLocal in main: " + threadLocal.get());
    IO.println("ScopedValue in main: " + scopedValue.isBound());
}

void print(String threadName) {
    IO.println("ThreadLocal in thread " + threadName + ": " + threadLocal.get());
    IO.println("ScopedValue in thread:" + threadName + ": " + scopedValue.get());
}

void wait(int millis) {
    try {
        TimeUnit.MILLISECONDS.sleep(millis);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}