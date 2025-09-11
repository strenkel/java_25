///
/// AOT Erzeugung & Nutzung Java 24:
/// 
///     javac Aot.java
///     jar cvf Aot.jar Aot.class
///     java -XX:AOTMode=record -XX:AOTConfiguration=Aot.conf -cp Aot.jar Aot
///     java -XX:AOTMode=create -XX:AOTConfiguration=Aot.conf -XX:AOTCache=Aot.aot -cp Aot.jar
///     java -XX:AOTCache=Aot.aot -cp Aot.jar Aot
/// 
/// AOT Erzeugung Java 25:
/// 
///     java -XX:AOTCacheOutput=Aot.aot -cp Aot.jar Aot
/// 
/// Time without AOT: ~105ms
/// Time with AOT:    ~ 95ms
/// 
void main() {
  var now = LocalDateTime.now();
  var nowString = now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
  IO.println("Hello, it's " + nowString);
}