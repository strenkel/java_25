---
title: Java 25
marp: true
theme: gaia
backgroundColor: white
color: black
footer: Stefan Trenkel | team neusta
style: |
  footer {
    width: 100%;
    text-align: center;
  }
---

<!-- _class: lead --> 
# Java 25

---

# Module Import Declarations (JEP 511)

```java
import module java.base;
```

anstatt

```java
import java.lang.*;
import java.nio.*;
import java.net.*;
import java.time.*;
import java.util.*;
// ...
```

- Import von Modulen.
- Transitives Einbinden
- JShell und Compact Source Files importieren java.base per default
- Best practice: specific vs. wildcard vs. module imports?

---

# Compact Source Files and Instance Main Methods (JEP 512)

```java
void main() {
  IO.println("Hello world!");
}
```

anstatt

```java
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}
```

- Keine Klassendeklaration
- Kein public static
- Keine Argumente
- Vereinfachte Ein-/Ausgabe mit IO.print ..println ..readln
- Impliziter Import von java.base
- Gut zum Lernen
- Java auf dem Weg zu Java_Script (Single-File Programs)

---

