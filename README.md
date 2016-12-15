[![Build Status](https://travis-ci.org/ricardogarfe/sonar-java-code-smells.svg)](https://travis-ci.org/ricardogarfe/sonar-java-code-smells)
[![Build Status](https://snap-ci.com/ricardogarfe/sonar-java-code-smells/branch/master/build_image)](https://snap-ci.com/ricardogarfe/sonar-java-code-smells/branch/master)

# Java Code Smells

It requires to install the **Java plugin**, at least version **3.6**, which is compatible with SonarQube 4.5.x LTS.

## Switch is evil

[Replace Conditional with Polymorphism](http://www.refactoring.com/catalog/replaceConditionalWithPolymorphism.html)

You have a conditional that chooses different behavior depending on the type of an object.

Move each leg of the conditional to an overriding method in a subclass. Make the original method abstract.

## Create a docker container

You can now build, package and run this microservice using Docker.

Now you can build your docker image by entering from a terminal where
you have access to Docker, execute the following command:

```sh
$ ./mvnw clean package docker:build
```

Even push it to a repository of your choice:

```sh
$ ./mvnw clean package docker:build -DpushImage
```
