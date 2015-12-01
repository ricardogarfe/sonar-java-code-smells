/*
 * Copyright (C) 2009-2014 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package org.sonar.java;

import com.google.common.collect.ImmutableList;
import org.sonar.api.SonarPlugin;

import java.util.List;

/**
 * Entry point of plugin
 */
public class CodeSmellsJavaRulesPlugin extends SonarPlugin {

    @Override
    public List getExtensions() {
        return ImmutableList.builder()
                // server extensions -> objects are instantiated during server startup
                .add(CodeSmellsJavaRulesDefinition.class)

                // batch extensions -> objects are instantiated during code analysis
                .add(CodeSmellsFileCheckRegistrar.class).build();
    }

}
