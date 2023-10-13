# Cat API

## How to use it?

To use Cat API, you'll need to modify the extends of your Main.java to `CatPlugin`.

If you need to get the instance of your plugin, do this:

```java
import fr.unchat.catapi.plugin.CatPlugin;

class Main extends CatPlugin
{
    public static Main getInstance() {
        return (Main) CatPlugin.getInstance();
    }
}
```

To import Cat API in your plugin, you'll need to add the dependency in your `pom.xml`:
```xml
<dependency>
    <groupId>fr.unchat</groupId>
    <artifactId>catapi</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```