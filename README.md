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

With `resource-config.json`, running the image works as follows:

```
% /Users/izeye/IdeaProjects/hello-browscap-java/build/native/nativeCompile/hello-browscap-java 
CapabilitiesImpl [myValues={BROWSER=Chrome, BROWSER_TYPE=Browser, BROWSER_MAJOR_VERSION=108, PLATFORM=macOS, PLATFORM_VERSION=10.15, DEVICE_TYPE=Desktop}]
% 
```
