# UpdateChecker
Simple update checker for plugin using json

## Example
add this to your main class
~~~java
new UpdateChecker (this).init(PluginName, PluginVersion, Url);
~~~

example
~~~java
    @Override
    public void onEnable() {
        new UpdateChecker (this).init("JAntiPlugin", 1.6, "https://raw.githubusercontent.com/josemarcellio/UpdateChecker/master/my-plugin.json");
    }
~~~

example json
~~~json
{
  "Plugin": {
    "JAntiPlugin": {
      "Latest_Version": 1.7,
    "Message": {
      "Update_Message": "§c=============================================================\n\n§cYour {plugin} is outdated, please update your {plugin}!\n§cThere is a new version {latest_version}, you are still using version {version}\n\n§c============================================================="
      }
    }
  }
}
~~~

## Maven

repositories
~~~xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
~~~

dependencies
~~~xml
<dependencies>
    <dependency>
        <groupId>com.github.josemarcellio</groupId>
        <artifactId>UpdateChecker</artifactId>
        <version>version</version>
    </dependency>
</dependencies>
~~~

## Gradle

repositories
~~~gradle
repositories {
    maven { url ('https://jitpack.io/') }
}
  ~~~
  
dependencies
~~~gradle
dependencies {
    implementation('com.github.josemarcellio:UpdateChecker:version')
}
~~~
