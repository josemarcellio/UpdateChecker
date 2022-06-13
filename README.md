# UpdateChecker
![[Project-Version]([https://img.shields.io/badge/version-v1.2-blue](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square))  ](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square)
![[Project-Line][[([https://img.shields.io/badge/version-v1.2-blue](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square))  ](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square)](https://img.shields.io/github/languages/top/josemarcellio/updatechecker?style=flat-square)](https://img.shields.io/tokei/lines/github/josemarcellio/updatechecker?style=flat-square)
![[Project-Size][[[([https://img.shields.io/badge/version-v1.2-blue](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square))  ](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square)](https://img.shields.io/github/languages/top/josemarcellio/updatechecker?style=flat-square)](https://img.shields.io/tokei/lines/github/josemarcellio/updatechecker?style=flat-square)](https://img.shields.io/github/languages/code-size/josemarcellio/updatechecker?style=flat-square)

Simple update checker for minecraft plugin using json

## How to use
add this to your main class
~~~java
new UpdateChecker ().setJavaPlugin(JavaPlugin)
.setPluginName ( PluginName )
.setPluginVersion ( PluginVersion )
.setJsonURL ( URL )
.init();
~~~

example
~~~java
    @Override
    public void onEnable() {
        new UpdateChecker ().setJavaPlugin(this)
        .setPluginName ( "JAntiPlugin" )
        .setPluginVersion ( 1.6 )
        .setJsonURL ( "https://raw.githubusercontent.com/josemarcellio/my-plugin/master/update.json" )
        .init();
    }
~~~

example json
~~~json
{
  "Plugin": {
    "JAntiPlugin": {
      "Latest_Version": 1.7,
    "Message": {
      "Update_Message": "§cYour {plugin} version is {version}\n§cplease update your {plugin} to version {latest_version}!"
      }
    }
  }
}
~~~

## Maven

add to your repositories
~~~xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
~~~

add to your dependencies
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

add to your repositories
~~~gradle
repositories {
    maven { url ('https://jitpack.io/') }
}
  ~~~
  
add to your dependencies
~~~gradle
dependencies {
    implementation('com.github.josemarcellio:UpdateChecker:version')
}
~~~
