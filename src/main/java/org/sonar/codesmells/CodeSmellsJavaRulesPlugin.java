/*
 * Copyright (C) 2009-2014 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package org.sonar.codesmells;

import org.sonar.api.Plugin;

/**
 * Entry point of plugin
 */
public class CodeSmellsJavaRulesPlugin implements Plugin {

    @Override
    public void define (Context context) {

      // server extensions -> objects are instantiated during server startup
      context.addExtension(CodeSmellsJavaRulesDefinition.class);

      // batch extensions -> objects are instantiated during code analysis
      context.addExtension(CodeSmellsFileCheckRegistrar.class);
    }

}
