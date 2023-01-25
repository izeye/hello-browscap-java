# hello-browscap-java

## How To Create a GraalVM Native Image

Run the following command with a GraalVM JDK:

```
% ./gradlew clean nativeCompile
...
------------------------------------------------------------------------------------------------------------------------
Produced artifacts:
 /Users/izeye/IdeaProjects/hello-browscap-java/build/native/nativeCompile/hello-browscap-java (executable)
 /Users/izeye/IdeaProjects/hello-browscap-java/build/native/nativeCompile/hello-browscap-java.build_artifacts.txt (txt)
========================================================================================================================
...
%
```

## How To Run a GraalVM Native Image

Unfortunately, running the image throws the following exception:

```
% /Users/izeye/IdeaProjects/hello-browscap-java/build/native/nativeCompile/hello-browscap-java
Exception in thread "main" java.lang.NullPointerException: in is null
        at java.base@17.0.5/java.util.zip.ZipInputStream.<init>(ZipInputStream.java:103)
        at java.base@17.0.5/java.util.zip.ZipInputStream.<init>(ZipInputStream.java:82)
        at com.blueconic.browscap.UserAgentService.createParserWithFields(UserAgentService.java:77)
        at com.blueconic.browscap.UserAgentService.loadParser(UserAgentService.java:61)
        at com.izeye.helloworld.Main.main(Main.java:17)
%
```

Since 1.4.0, it works as follows:

```
% /Users/izeye/IdeaProjects/hello-browscap-java/build/native/nativeCompile/hello-browscap-java
CapabilitiesImpl [myValues={BROWSER=Chrome, BROWSER_TYPE=Browser, BROWSER_MAJOR_VERSION=108, PLATFORM=macOS, PLATFORM_VERSION=10.15, DEVICE_TYPE=Desktop}]
%
```
