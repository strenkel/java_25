void main() {
    new A();
    new B();
}


class A {

    A() {
        print();
    }

    void print() {
        IO.println("This is A!");
    }

}

class B extends A {

    final String b;

    B() {
        b = "B";
        super();
    }

    void print() {
        IO.println("This is " + b + "!");
    }

}


