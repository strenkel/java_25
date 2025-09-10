/**
 * Flexible Constructor Bodies (JEP 513).
 */

class A {

    A() {
        print();
    }

    void print() {
        IO.println("I'm A!");
    }
}

class B extends A {

    final String b;

    B() {
        b = "B";
    }

    void print() {
        IO.println("I'm " + b + "!");
    }
}

void main() {
    new A();
    new B();
}


