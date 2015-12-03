package org.sonar.codesmells;

import com.google.common.collect.Lists;
import org.sonar.codesmells.checks.AvoidSwitchCheck;
import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.Arrays;
import java.util.List;

/**
 * Provide the "checks" (implementations of rules) classes that are gonna be
 * executed during source code analysis.
 * <p>
 * This class is a batch extension by implementing the
 * {@link org.sonar.plugins.java.api.CheckRegistrar} interface.
 */
public class CodeSmellsFileCheckRegistrar implements CheckRegistrar {

    /**
     * Register the classes that will be used to instantiate checks during
     * analysis.
     */
    @Override
    public void register(RegistrarContext registrarContext) {
        // Call to registerClassesForRepository to associate the classes with the
        // correct repository key
        registrarContext.registerClassesForRepository(CodeSmellsJavaRulesDefinition.REPOSITORY_KEY, Arrays.asList(checkClasses()),
                Arrays.asList(testCheckClasses()));
    }

    /**
     * Lists all the checks provided by the plugin
     */
    public static Class<? extends JavaCheck>[] checkClasses() {
        return new Class[] { AvoidSwitchCheck.class };
    }

    /**
     * Lists all the test checks provided by the plugin
     */
    public static Class<? extends JavaCheck>[] testCheckClasses() {
        return new Class[] {};
    }

}
