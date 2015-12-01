/*
 * Copyright (C) 2009-2014 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package org.sonar.java;

import com.google.common.collect.ImmutableList;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.plugins.java.Java;
import org.sonar.squidbridge.annotations.AnnotationBasedRulesDefinition;

import java.util.List;

/**
 * Declare rule metadata in server repository of rules. That allows to list the
 * rules
 * in the page "Rules".
 */
public class CodeSmellsJavaRulesDefinition implements RulesDefinition {

    public static final String REPOSITORY_KEY = "codesmells";
    public static final String REPOSITORY_NAME = "Java Code Smells";

    @Override
    public void define(Context context) {
        final NewRepository repository = context.createRepository(REPOSITORY_KEY, Java.KEY).setName(REPOSITORY_NAME);
        final List<Class> checkClasses = ImmutableList.<Class>builder()
                .addAll(CodeSmellsFileCheckRegistrar.checkClasses()).build();

        AnnotationBasedRulesDefinition.load(repository, Java.KEY, checkClasses);
        for (final NewRule rule : repository.rules()) {
            rule.setInternalKey(rule.key());
        }
        repository.done();
    }
}
