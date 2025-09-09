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
    font-size: 32px;
    line-height: 150%;
  }
  h1 {
    font-size: 5em;
  }
  h2 {
     font-size: 1.5em;
     margin-bottom: 1em;
  }

---

<!-- _class: lead --> 
# Java 25

---

## Überblick

- Veröffentlichung: 16.9.2025
- 13 finale JEPs
- 5 Preview / Inkubator JEPs

---

## Sprach-Features

- Module Import Declarations (JEP 511)
- Compact Source Files and Instance Main Methods (JEP 512)
- Flexible Constructor Bodies (JEP 513)
- Scoped Values (JEP 506)

---

## Performance

- Compact Object Headers (JEP 519)
- Generational Shenandoah (JEP 521)
- Ahead-of-Time Command-Line Ergonomics (JEP 514)
- Ahead-of-Time Method Profiling (JEP 515)

---

## Java Flight Recorder (JFR)

- JFR Cooperative Sampling (JEP 518)
- JFR Method Timing & Tracing (JEP 520)
- JFR CPU-Time Profiling (JEP 509 - Experimental)

---

## Sonstiges

- Key Derivation Function API (JEP 510)
- Remove the 32-bit x86 Port (JEP 503)

---

## Preview / Incubator

- Stable Values (Preview) (JEP 502)
- PEM Encodings of Cryptographic Objects (Preview – JEP 470)
- Structured Concurrency (Fifth Preview – JEP 505)
- Primitive Types in Patterns, instanceof, and switch (Third Preview – JEP 507)
- Vector API (Tenth Incubator – JEP 508)

---

## Module Import Declarations

```java
import module java.base;
```

- Import von Modulen
- Transitiv
- JShell & Compact Source Files: java.base Import per Default
- Best practice: specific vs. wildcard vs. module imports?

---

## Compact Source Files and Instance Main Methods

```java
void main() {
    IO.println("Hello world!");
}
```

- Keine Klassendeklaration
- Kein public static
- Keine Argumente
- Vereinfachte Ein-/Ausgabe mit IO.print ..println ..readln
- Impliziter Import von java.base

---

## Flexible Constructor Bodies

- Code vor super(...) und this(...) möglich
- SubClass-Fields können vor super/this-Aufruf initialisiert werden
- Vereinfacht Validierungen und Berechnungen
- Keine inkonsistenten Objekte bei super-Aufruf

---

## Flexible Constructor Bodies

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

---

## Scoped Values (Project Loom - JEP 506)

- Daten (i.d.R Context-Daten wie user, role) über Methodenketten bereitstellen 
- Moderne Variante von ThreadLocal / InheritableThreadLocal
- Weitergabe an Child-Threads über StructuredTaskScope
- Zweites Project Loom-Feature (Virtual Threads, Structured Concurrency, ...)
- Vorteile:
- - Klare Gültigkeit
- - Unveränderlich
- - Performanter / geringerer Speicherverbrauch

---

## Generational Shenandoah (JEP 521)

- Aufteilung des Heaps in Young und Old Space
- Schwache Generationshypothese
- - Entweder lebt ein Objekt sehr kurz oder sehr lang
- Ziel von Shenandoah: Kurze Latenzen von max 10ms.
- Aktivierung: -XX:+UseShenandoahGC -XX:ShenandoahGCMode=generational

---

## Compact Object Headers (Project Lilliput - JEP 519)

- Reduzierung des Object Headers von 12 auf 8 Byte
- 27 unbenutze Bits entfernt
- Class Pointer von 32 auf 22 Bits reduziert
- Ziel: weitere Reduzierung auf 4 Byte
- Aktivierung: XX:+UseCompactObjectHeaders

---

## Ahead-of-Time Command-Line Ergonomics (Project Leyden - JEP 514)

- Erzeugung des Ahead-of-Time Class Loading & Linking Cache wird vereinfacht
- Verkürzt die Start-Zeit von Java-Anwendung um bis zu 40%
- Weiterentwicklung von Application Class Data Sharing (AppCDS)

---

## Ahead-of-Time Method Profiling (Project Leyden - JEP 515)

- Methoden-Profile werden zusätzlich im AOT-Cache gespeichert
- JIT-Komplilierung startet sofort
- Warm-up Phase wird verkürzt
- Bis zu 20% schnellere Start-Zeit

---

## Wichtiges bis Java 25

- Stream Gatherers (Java 24 - JEP 485)
- Markdown Documentation Comments (Java 23 - JEP 467)
- Unnamed Variables & Patterns (Java 22 - JEP 456)
- Launch Multi-File Source-Code Programs (Java 22 - JEP 458)

---

<!-- _class: lead --> 
# Vielen Dank!
