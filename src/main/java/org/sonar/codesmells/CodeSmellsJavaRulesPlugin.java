/*
 * Copyright (C) 2009-2014 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package org.sonar.codesmells;

import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

/**
 * Entry point of plugin
 */
public class CodeSmellsJavaRulesPlugin extends SonarPlugin {

    @Override
    public List getExtensions() {
        return Arrays.asList(
                // server extensions -> objects are instantiated during server startup
                CodeSmellsJavaRulesDefinition.class,

                // batch extensions -> objects are instantiated during code analysis
                CodeSmellsFileCheckRegistrar.class);
    }

}
