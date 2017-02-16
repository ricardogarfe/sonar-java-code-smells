package org.sonar.codesmells;

import org.sonar.plugins.java.api.CheckRegistrar;

/**
 * Provide the "checks" (implementations of rules) classes that are gonna be
 * executed during source code analysis.
 * <p>
 * This class is a batch extension by implementing the
 * {@link org.sonar.plugins.java.api.CheckRegistrar} interface.
 */
public class CodeSmellsFileCheckRegistrar implements CheckRegistrar {

  /**
   * Register the classes that will be used to instantiate checks during analysis.
   */
  @Override
  public void register(RegistrarContext registrarContext) {
    // Call to registerClassesForRepository to associate the classes with the correct repository key
    registrarContext.registerClassesForRepository(CodeSmellsJavaRulesDefinition.REPOSITORY_KEY,
        CodeSmellRulesList.getJavaChecks(),
        CodeSmellRulesList.getJavaTestChecks());
  }
}
