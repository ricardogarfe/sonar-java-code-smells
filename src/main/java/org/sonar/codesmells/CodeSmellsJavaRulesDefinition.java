/*
 * Copyright (C) 2009-2014 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package org.sonar.codesmells;

import com.google.common.collect.Iterables;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;

import java.util.List;

/**
 * Declare rule metadata in server repository of rules. That allows to list the
 * rules
 * in the page "Rules".
 */
public class CodeSmellsJavaRulesDefinition implements RulesDefinition {

  public static final String REPOSITORY_KEY = "codesmells";
  public static final String REPOSITORY_NAME = "Java Code Smells";
  public static final String LANGUAGE_KEY = "java";

  @Override
  public void define(Context context) {

    NewRepository repository = context.createRepository(REPOSITORY_KEY, LANGUAGE_KEY);
    repository.setName(REPOSITORY_NAME);

    // Load defined rules
    List<Class> checks = CodeSmellRulesList.getChecks();
    RulesDefinitionAnnotationLoader annotationLoader = new RulesDefinitionAnnotationLoader();
    annotationLoader.load(repository, Iterables.toArray(checks, Class.class));
    repository.done();
  }
}
