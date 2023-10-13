#   C a t A P I 
 
 ## How to use it?

To use CAT API, you'll need to modify the extends of your Main.java to "CatPlugin".

If you need to use the instance of your plugin, do this:

```java
public static Main getInstance() {
    return (Main) CatPlugin.getInstance();
}
```

To import CAT API, you'll need to add the dependency in your pom.xml:
```xml
<dependency>
  <groupId>fr.unchat</groupId>
  <artifactId>catapi</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```
