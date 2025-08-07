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

# Module Import Declarations

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

- Import von ganzen Modulen.
- Vereinfacht jshell und Single Source Files, da dort java.base per default importiert wird.
- Alter Streit: specific vs. wildcard imports.

---