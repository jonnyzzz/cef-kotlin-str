An experiment with Kotlin/Native, structs and C function pointers


The execution of the project fails as follows on macOS

```bash
./gradlew runDebugExecutableMacosX64

... some text removed ...

> Task :kn:runDebugExecutableMacosX64 FAILED
/opt/teamcity-agent/work/4d622a065c544371/runtime/src/main/cpp/Memory.cpp:1252: runtime assert: Memory leaks found

FAILURE: Build failed with an exception.

```

