## Lambda Support Library

This library is used to improve programming experience with Java 8 lambda expression, especially using lambda with exception handling.

The following example shows using lambda with `try-catch` block:

```java
public void cat(Collection<File> files) {
    files.stream().map(file -> {
        try {
            return Files.readString(file.toPath());
        } catch (IOException e) {
            return "";
        }
    }).forEach(System.out::println);
}
```

As we can see, the readability of code getting worse when using `try-catch` in lambda expression, this library is trying to solve this problem with small changes:

```java
public void cat(Collection<File> files) {
    files.stream().map(file -> unchecked(() -> {
        return Files.readString(file.toPath());
    })).forEach(System.out::println);
}
```

## Download

You can download the binary from [Maven Central](https://search.maven.org/search?q=g:io.johnsonlee.lambda).
