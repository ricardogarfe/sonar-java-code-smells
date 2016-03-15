/*
 * Copyright (C) 2009-2014 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package org.sonar.codesmells;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;

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

        // We could use a XML or JSON file to load all rule metadata, but
        // we prefer use annotations in order to have all information in a single place
        RulesDefinitionAnnotationLoader annotationLoader = new RulesDefinitionAnnotationLoader();
        annotationLoader.load(repository, CodeSmellsFileCheckRegistrar.checkClasses());
        repository.done();

    }
}
