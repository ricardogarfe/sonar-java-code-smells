[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=org.sonar%3Asonar-codesmells-plugin&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=org.sonar%3Asonar-codesmells-plugin)

# Java Code Smells

It requires to install the **Java plugin**, at least version **3.6**, which is compatible with SonarQube 4.5.x LTS.

## Switch is evil

[Replace Conditional with Polymorphism](http://www.refactoring.com/catalog/replaceConditionalWithPolymorphism.html)

You have a conditional that chooses different behavior depending on the type of an object.

Move each leg of the conditional to an overriding method in a subclass. Make the original method abstract.
