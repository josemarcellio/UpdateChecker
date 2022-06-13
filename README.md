# UpdateChecker
![[Project-Version]([https://img.shields.io/badge/version-v1.2-blue](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square))  ](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square)
![[Project-Line][[([https://img.shields.io/badge/version-v1.2-blue](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square))  ](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square)](https://img.shields.io/github/languages/top/josemarcellio/updatechecker?style=flat-square)](https://img.shields.io/tokei/lines/github/josemarcellio/updatechecker?style=flat-square)
![[Project-Size][[[([https://img.shields.io/badge/version-v1.2-blue](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square))  ](https://img.shields.io/github/v/release/josemarcellio/updatechecker?style=flat-square)](https://img.shields.io/github/languages/top/josemarcellio/updatechecker?style=flat-square)](https://img.shields.io/tokei/lines/github/josemarcellio/updatechecker?style=flat-square)](https://img.shields.io/github/languages/code-size/josemarcellio/updatechecker?style=flat-square)

Simple update checker for minecraft plugin using json

## How to use
add this to your main class
~~~java
new UpdateChecker ().setJavaPlugin(JavaPlugin)
.setResourceId(ResourceID)
.setMessage(Messages)
.init();
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
