# How we're using Gradle

We're using [the Gradle build tool](https://gradle.org/) to help automate
building, testing, and deploying our projects throughout this class. 

## Setting up Gradle

To enable the use of Gradle you need to have a `build.gradle` file at the
top level of your project. 
[The `build.gradle` file for this project](../build.gradle) looks
like (minus all the comments):

```groovy
plugins {
    id 'java'
    id 'application'
}

repositories {
    jcenter()
}

dependencies {
    testCompile 'junit:junit:4.12'
}

mainClassName = 'Hellos'
```

The first two `apply plugin` lines tell Gradle that this is a Java project
and that we want to build a stand-alone command-line application.

That actually gives us a _bunch_ of Gradle commands we can run that know
how to build, run, test, and deploy a Java application.

The `repositories` entry allows us to provide one or more repositories where
Gradle can go to download libraries that our project depends on. We're using
the [JCenter library repository](https://bintray.com/bintray/jcenter); 
another common option is [`mavenCentral()`](https://search.maven.org/).

The
`dependencies` entry below that tells Gradle that in order to compile our
_test_ code (i.e., `testCompile`) we need version 4.12 of the JUnit test
library.

This management of dependencies is
one of the most useful things about Gradle, as project dependency management
can be a real pain.

The `mainClassName` entry at the end tells Gradle which class has the `main()`
method that should be run when we start up our application.

There are a _lot_ more nifty things you can set up in a `build.gradle` file,
but this is all we need for this lab.

## Running Gradle

This simple setup creates a _lot_ of Gradle commands that we can use to build and
run our application. These can be done through IDEA or on the command line.

### Gradle in IDEA

In IDEA you get ...

### Gradle on the command line

...
