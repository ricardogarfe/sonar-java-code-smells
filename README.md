[![Build Status](https://travis-ci.org/ricardogarfe/sonar-java-code-smells.svg)](https://travis-ci.org/ricardogarfe/sonar-java-code-smells)
[![Build Status](https://snap-ci.com/ricardogarfe/sonar-java-code-smells/branch/master/build_image)](https://snap-ci.com/ricardogarfe/sonar-java-code-smells/branch/master)
[![Build Status](https://travis-ci.org/ricardogarfe/sonar-java-code-smells.svg?branch=master)](https://travis-ci.org/ricardogarfe/sonar-java-code-smells)

# Java Code Smells

It requires to install the **Java plugin**, at least version **3.6**, which is compatible with SonarQube 4.5.x LTS.

## Switch is evil

[Replace Conditional with Polymorphism](http://www.refactoring.com/catalog/replaceConditionalWithPolymorphism.html)

You have a conditional that chooses different behavior depending on the type of an object.

Move each leg of the conditional to an overriding method in a subclass. Make the original method abstract.
