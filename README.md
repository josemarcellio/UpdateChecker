# UpdateChecker
Simple update checker for plugin using json

## How to use
add this to your main class
~~~java
new UpdateChecker ().setJavaPlugin(JavaPlugin).setPluginName ( PluginName ).setPluginVersion ( PluginVersion ).setJsonURL ( URL ).init();
~~~

example
~~~java
    @Override
    public void onEnable() {
        new UpdateChecker ().setJavaPlugin(this).setPluginName ( "JEmoji" ).setPluginVersion ( 1.4 ).setJsonURL ( "https://raw.githubusercontent.com/josemarcellio/my-plugin/master/update.json" ).init();
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
