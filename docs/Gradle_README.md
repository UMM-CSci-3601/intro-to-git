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
  testImplementation 'org.junit.jupiter:junit-jupiter-api:5.5.2'
  testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.5.2'
}

application {
  mainClassName = 'hellos.Hellos'
}

test {
  useJUnitPlatform()
}
```

The two lines in the opening `plugins` section tell Gradle that this is a Java project
and that we want to build a stand-alone command-line application.
That actually gives us a _bunch_ of Gradle commands we can run that know
how to build, run, test, and deploy a Java application.

The `repositories` section allows us to provide one or more repositories where
Gradle can go to download libraries that our project depends on. We're using
the [JCenter library repository](https://bintray.com/bintray/jcenter);
another common option is [`mavenCentral()`](https://search.maven.org/).

The
`dependencies` section tells Gradle that in order to compile our
_test_ code (i.e., `testImplementation`) we need the specified version
of the JUnit test library. This management of dependencies is
one of the most useful things about Gradle, as project dependency management
can be a real pain.

The `applications` section lets you specify application-specific information. In
this case we use the `mainClassName` entry to tell Gradle which class has the `main()`
method that should be run when we start up our application. This needs to be a fully
qualified path, so in this case `hellos.Hellos` for the class `Hellos` in the package
`hellos`.

In the `test` section we specify (via `useJunitPlatform()`) that we want Gradle to
use JUnit to run our tests. If we were using a different Java test platform like
[TestNG](https://testng.org/doc/) then we would indicate that here.

There are a _lot_ more nifty things you can set up in a `build.gradle` file,
but this is all we need for this lab.

## Running Gradle

This simple setup creates a _lot_ of Gradle commands that we can use to build and
run our application. These can be done through IDEA or on the command line.

### Gradle on the command line

You can run Gradle on the command line, which is extremely useful since
you don't a fancy IDE at your disposal. Worse, if you're
logged in to a server via a terminal, you probably _can't_ run an IDE, so
command line Gradle is a real win there.

If you've got Gradle installed locally, you can use the `gradle` command
to run tasks, e.g., `gradle check`. That makes you dependent on having
(the right version of) Gradle installed locally, which can be a problem.
So instead we're using `gradlew` (Gradle Wrapper), which is a script which
downloads the correct version of `gradle` if necessary and then runs that.
This ensures that you'll always be running the same version of Gradle no
matter which machine you're using.

To run tasks with Gradle Wrapper, use `./gradlew <task>` in the top-level
directory of the project. There are a _lot_ of tasks; some of particular
interest include:

* `./gradlew run` will run your application.
* `./gradlew build` will compile all your files.
* `./gradlew clean` will delete all the generated files (e.g., `.class`
  files), which can be helpful when it looks like you need to force a
  rebuild. It's also a nice thing to do when you're done working on a
  project for a while and want to clean up some disk space.
* `./gradlew jar` will generate a standalone JAR file for your application.
* `./gradlew check` will make sure everything builds and the tests
  all pass.
* etc., etc.

### Gradle in VS Code

"Out of the box", VS Code doesn't give you any way to run Gradle Tasks.
If you install the [Gradle Tasks](https://marketplace.visualstudio.com/items?itemName=richardwillis.vscode-gradle)
extensions then you get a "Gradle Tasks"
view (bottom left in the Explorer, below your file tree).

That will have a "folder" with the name of the repo (`intro-to-git` or
similar in this case). That which will contain many other folders
containing specific tasks. Some of particular interest:

* _application -> run_ will run your application
* _build -> build_ will compile all your files
* _build -> clean_ will delete all the generated files (e.g., `.class`
  files), which can be helpful when it looks like you need to force a
  rebuild. It's also a nice thing to do when you're done working on a
  project for a while and want to clean up some disk space.
* _build -> jar_ will generate a standalone JAR file for your application
* _verification -> check_ will make sure everything builds and the tests
  all pass
