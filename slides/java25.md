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
  section {
    font-size: 23px;
  }
  h1 {
    font-size: 5em;
  }
---

<!-- _class: lead --> 
# Java 25

---

## Überblick Sprach-Features

- Java 25
  - Module Import Declarations (JEP 511)
  - Compact Source Files and Instance Main Methods (JEP 512)
  - Flexible Constructor Bodies (JEP 513)
  - Scoped Values (JEP 506)
- Java 24
  - Stream Gatherers (JEP 485)
- Java 23
  - Markdown Documentation Comments (JEP 467)
- Java 22
  - Unnamed Variables & Patterns (JEP 456)
  - Launch Multi-File Source-Code Programs (JEP 458)

---

## Module Import Declarations (JEP 511)

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

- Import von Modulen
- Transitives Einbinden
- JShell und Compact Source Files importieren java.base per default
- Best practice: specific vs. wildcard vs. module imports?

---

## Compact Source Files and Instance Main Methods (JEP 512)

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

---

## Flexible Constructor Bodies (JEP 513)

```java
public class SubClass extends SuperClass {
  int subField;
  public SubClass(int superField, int subField) {
    if (superField > 100) throw new IllegalArgumentException();
    if (subField < 0) throw new IllegalArgumentException();
    this.subField = subField;
    super(superField);
  }
}
```

- Code vor super(...) und this(...) möglich
- SubClass-Fields können vor super/this-Aufruf initialisiert werden
- Vereinfacht Validierungen und Berechnungen
- Keine inkonsistenten Objekte bei super-Aufruf

---

## Scoped Values (JEP 506)

- Unveränderliche Daten innerhalb eines Threads teilen
- Moderne Variante von ThreadLocal / InheritableThreadLocal
- Zugriff durch StructuredTaskScope-Child-Threads 
- Vorteile:
- - Klare Gültigkeit
- - Unveränderlich
- - Performater / geringerer Speicherverbrauch


