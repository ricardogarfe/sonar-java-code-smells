/*
 * Copyright (C) 2009-2014 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package org.sonar.java;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;

/**
 * Declare rule metadata in server repository of rules. That allows to list the rules
 * in the page "Rules".
 */
public class CodeSmellsJavaRuesDefinition implements RulesDefinition {

  public static final String REPOSITORY_KEY = "codesmells";

  @Override
  public void define(Context context) {
    NewRepository repo = context.createRepository(REPOSITORY_KEY, "java");
    repo.setName("Java Code Smells");

    // We could use a XML or JSON file to load all rule metadata, but
    // we prefer use annotations in order to have all information in a single place
    RulesDefinitionAnnotationLoader annotationLoader = new RulesDefinitionAnnotationLoader();
    annotationLoader.load(repo, CodeSmellsFileCheckRegistrar.checkClasses());
    repo.done();
  }
}
