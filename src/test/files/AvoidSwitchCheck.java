/**
 * This file is the sample code against we run our unit test. It is placed
 * src/test/files in order to not be part of the maven compilation.
 **/

class AvoidSwitchCheck { 
  void foo(){ 
      switch (1) { // Noncompliant 
        case 1: // Noncompliant 
          System.out.println("plop"); // Noncompliant 
          break; // Noncompliant 
        case 2: // Noncompliant 
          System.out.println("bar"); //Compliant
          break; // Noncompliant 
      }
    }
}